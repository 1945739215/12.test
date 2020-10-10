package com.cidp.controller;


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
        int ID=tableService.SelectTableId(responBean.getTableName());
        List<Titles> titlesList=new ArrayList<>();
        titlesList=titlesService.selectAllTitlesNameById(ID);
        for (int i=0;i<titlesList.size();i++)
        {
           // String name=titlesList.get(i)
            System.out.println(titlesList.get(i).toString());
            int TitleId=titlesService.SelectIdByname(titlesList.get(i).getTitleName());

            showService.deleteinformByTitleId(TitleId);
            titlesService.DeleteTitleByName(titlesList.get(i).getTitleName());
        }
        tableService.DeleteTable(responBean.getTableName());
        return Result.success();


    }
    @RequestMapping(value = "/deletetitle",method = RequestMethod.POST)
    public Result deletetitle(@RequestBody ResponBean responBean)
    {
        System.out.println("删除侧边栏"+responBean.getTitleName());
        titlesService.DeleteTitleByName(responBean.getTitleName());
        return Result.success();
    }




}

