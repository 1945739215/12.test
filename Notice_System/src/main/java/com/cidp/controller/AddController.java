package com.cidp.controller;


import com.cidp.pojo.Tables;
import com.cidp.pojo.Titles;
import com.cidp.pojo.result.ResponBean;
import com.cidp.pojo.result.Result;
import com.cidp.service.ShowService;
import com.cidp.service.TableService;
import com.cidp.service.TitlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    //发布新模块
    @RequestMapping(value = "/CreateTable",method = RequestMethod.POST)
    public Result CreateTable(@RequestBody ResponBean responBean)
    {
        if(tableService.SelectExit(responBean.getTableName())==1)
        {
            return Result.error("已经存在");
        }
        else
        {
            tableService.AddTable(responBean.getTableName());
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
            //根据导航栏id 修改导航栏id和名字
            tableService.Update(tablesId.get(i).getTablesId(),newTablesId,tableNewName);
        }
        return Result.success();
    }




}

