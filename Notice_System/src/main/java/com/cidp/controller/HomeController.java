package com.cidp.controller;

import com.cidp.pojo.Tzgg;
import com.cidp.pojo.Xyxw;
import com.cidp.pojo.result.Result;
import com.cidp.service.TzggService;
import com.cidp.service.XyxwService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class HomeController {
    @Autowired
    TzggService tzggService;
    @Autowired
    XyxwService xyxwService;

//浏览次数   下载次数   上，下一篇    GitHub     部署项目linux(改)

    @RequestMapping(value = "/tzgg",method = RequestMethod.POST)//显示通知公告
    public Result showTzgg()
    {
        List<Tzgg> showTzgg=new ArrayList<>();//接收通知公告
        showTzgg=tzggService.Selectall();
        System.out.println(showTzgg);
        return Result.SuccesswithObject("success",showTzgg);
    }
    @RequestMapping(value = "/xyxw",method = RequestMethod.POST)//显示学院新闻
    public Result showXyxw()
    {
        List<Xyxw> showXyxw=new ArrayList<>();//接收学院新闻
        showXyxw=xyxwService.Selectall();
        System.out.println(showXyxw);
        return Result.SuccesswithObject("success",showXyxw);
    }




}
