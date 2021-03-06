package com.cidp.controller;


import com.cidp.pojo.Tables;
import com.cidp.pojo.Titles;
import com.cidp.pojo.User;
import com.cidp.pojo.result.ResponBean;
import com.cidp.pojo.result.Result;
import com.cidp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class AddController {
    @Autowired
    TableService tableService;
    @Autowired
    TitlesService titlesService;
    @Autowired
    ShowService showService;
    @Autowired
    UserManageService userManageService;
    @Autowired
    UserService userService;


    //发布新模块
    @RequestMapping(value = "/CreateTable",method = RequestMethod.POST)//总管理员发布新模块
    public Result CreateTable(@RequestBody ResponBean responBean)
    {
        if(tableService.SelectExit(responBean.getTableName())==1)
        {
            return Result.error("已经存在");
        }
        else
        {
            tableService.AddTable(responBean.getTableName());
            int Id=tableService.SelectTableId(responBean.getTableName());
            List<User> users=userService.SelectByType();
            for (User username :users)
            {
                userManageService.AddNewTables(username.getUsername(),Id);
                System.out.println(username.getUsername());
            }

            return Result.success();
        }


    }
    @RequestMapping(value = "/CreateTitle",method = RequestMethod.POST)//新增侧边栏标题
    public Result CreateTitle(@RequestBody ResponBean responBean)
    {
        System.out.println(responBean.getTableName()+responBean.getTitleName());
        int ID=tableService.SelectTableId(responBean.getTableName());
        titlesService.AddnewTitle(ID,responBean.getTitleName(),responBean.getTableName());
        return Result.success();
    }
    //修改模块
    @RequestMapping(value = "/changeTables",method = RequestMethod.POST)
    public Result changeTables(@RequestBody ResponBean responBean)
    {

        tableService.ChangeTable(responBean.getTableName(),responBean.getTableNewName());
        return Result.success();



    }
    //修改侧边栏

    @RequestMapping(value = "/changetitles",method = RequestMethod.POST)
    public Result changetitles(@RequestBody ResponBean responBean)
    {
        System.out.println("11111");
        System.out.println(responBean.getTitleName()+responBean.getTitleNewName());
        titlesService.ChangeTitle(responBean.getTitleName(),responBean.getTitleNewName());
        return Result.success();
    }

    //删除模块
    @RequestMapping(value = "/deleteTable",method = RequestMethod.POST)
    public Result deleteTable(@RequestBody ResponBean responBean)
    {
        System.out.println("删除导航栏："+responBean.getTableName());
        int ID=tableService.SelectTableId(responBean.getTableName());//获取导航栏id
        userManageService.DeleteByTableId(ID);
        List<Titles> titlesList=new ArrayList<>();
        titlesList=titlesService.selectAllTitlesNameById(ID);//获取所有侧边栏名字
        for (int i=0;i<titlesList.size();i++)
        {
           // String name=titlesList.get(i)
            System.out.println(titlesList.get(i).toString());
            int TitleId=titlesService.SelectIdByname(titlesList.get(i).getTitleName());//根据侧边栏名字 获取侧边栏id

            showService.deleteinformByTitleId(TitleId);  //根据侧边栏id  删除  inform
            titlesService.DeleteTitleByName(titlesList.get(i).getTitleName());//根据侧边栏名字删除 侧边栏
        }
        tableService.DeleteTable(responBean.getTableName());//获取导航栏名字  删除导航栏
        return Result.success();


    }
    @RequestMapping(value = "/deletetitle",method = RequestMethod.POST)
    public Result deletetitle(@RequestBody ResponBean responBean)
    {
        System.out.println("删除侧边栏"+responBean.getTitleName());
        titlesService.DeleteTitleByName(responBean.getTitleName());
        return Result.success();
    }


    //合并导航栏
        @RequestMapping(value = "/merge",method = RequestMethod.POST)
    public Result merge(@RequestBody  List<Titles>  tablesId,String tableNewName)
    {
        System.out.println("合并导航栏");
        for (int i=0;i<tablesId.size();i++)
        {
            List<Titles> titlesIdList=new ArrayList<>();
            //根据导航栏的id 获取多个侧边栏id
            titlesIdList= titlesService.SelectIdByid(tablesId.get(i).getTablesId());
            //获取最大的那个导航栏id
            int newTablesId = tablesId.get(i = tablesId.size() - 1).getTablesId();
            for(int j=0;j<titlesIdList.size();j++) {
                //根据侧边栏id  修改导航栏id和名字
                titlesService.Update(titlesIdList.get(j).getTitlesId(), newTablesId, tableNewName);
            }
            //根据导航栏id 修改导航栏id和名字    tables
            tableService.Update(tablesId.get(i).getTablesId(),newTablesId,tableNewName);
        }
        return Result.success();
    }

    //合并侧边栏    注意可以跨导航栏合并,所以要改导航栏id和name
    @RequestMapping(value = "/mergeSide",method = RequestMethod.POST)
    public Result mergeSide(@RequestBody  List<Titles>  titlesId,String tableNewName,String titleNewName)
    {
        System.out.println("合并侧边栏");
        for (int i=0;i<titlesId.size();i++)
        {
                //获取最大的那个侧边栏id
                int newTitlesId = titlesId.get(i = titlesId.size() - 1).getTitlesId();
                //根据新的导航栏名字  查找导航栏id
                int newTablesId= titlesService.SelectTablesidByTitlesid(titlesId.get(i).getTitlesId());
                //判断是否存在
                Integer titleNewName11=titlesService.SelectTitleNewName(titleNewName);


                if(titleNewName11!=null) {//如果titleNewName存在，则获取titlesId
                    //根据titleNewName获取 titlesId
                    Integer OrionTitlesId=titlesService.SelectTitlesidByTitleNewName(titleNewName);
                    //根据侧边栏id  修改侧边栏id和名字   导航栏id和名字
                    titlesService.UpdateTitles(titlesId.get(i).getTitlesId(), OrionTitlesId, titleNewName, tableNewName, newTablesId);
                    //根据侧边栏id 修改侧边栏id
                    titlesService.UpdateInforms(titlesId.get(i).getTitlesId(), OrionTitlesId);
                }else {//如果不存在，新写侧边栏名字，则获取最大的titlesId
                    //根据侧边栏id  修改侧边栏id和名字   导航栏id和名字
                    titlesService.UpdateTitles(titlesId.get(i).getTitlesId(), newTitlesId, titleNewName, tableNewName, newTablesId);
                    //根据侧边栏id 修改侧边栏id
                    titlesService.UpdateInforms(titlesId.get(i).getTitlesId(), newTitlesId);
                }
        }
        return Result.success();
    }




}

