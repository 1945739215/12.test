package com.cidp.controller;

import com.cidp.pojo.Tzgg;
import com.cidp.pojo.Xyxw;
import com.cidp.pojo.result.Result;
import com.cidp.pojo.result.tableTabData;
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
        List<tableTabData>tableTabData=new ArrayList<>();
        showTzgg=tzggService.Selectall();
        // System.out.println(showTzgg.size());
        for(int i=0;i<showTzgg.size();i++)
        {
            com.cidp.pojo.result.tableTabData threeList=new tableTabData();
            if(i==0)
            {
                tzggService.updateCount();
                threeList.setObject1(null);
                threeList.setObject2(showTzgg.get(i));
                threeList.setObject3(showTzgg.get(i+1));
                tableTabData.add(threeList);
            }
            else if (i==showTzgg.size()-1)
            {
                //System.out.println(i);
                tzggService.updateCount();
                threeList.setObject1(showTzgg.get(i-1));
                threeList.setObject2(showTzgg.get(i));
                threeList.setObject3(null);
                tableTabData.add(threeList);
            }
            else
            {
                //System.out.println(i);
                tzggService.updateCount();
                threeList.setObject1(showTzgg.get(i-1));
                threeList.setObject2(showTzgg.get(i));
                threeList.setObject3(showTzgg.get(i+1));
                tableTabData.add(threeList);
            }


        }
        //System.out.println(tableTabData.size());

        return Result.SuccesswithObject("success",tableTabData);
    }


    @RequestMapping(value = "/xyxw",method = RequestMethod.POST)//显示学院新闻
    public Result showXyxw()
    {
        List<Xyxw> showXyxw=new ArrayList<>();//接收学院新闻
        showXyxw=xyxwService.Selectall();
        List<tableTabData>threeXyxw=new ArrayList<>();
        //System.out.println(showXyxw.size());
        for (int i=0;i<showXyxw.size();i++)
        {
            com.cidp.pojo.result.tableTabData threeList=new tableTabData();
            if(i==0)
            {
                threeList.setObject1(null);
                xyxwService.updateCount();
                threeList.setObject2(showXyxw.get(i));
                threeList.setObject3(showXyxw.get(i+1));
                threeXyxw.add(threeList);
            }
            else if (i==showXyxw.size()-1)
            {
                xyxwService.updateCount();
                threeList.setObject1(showXyxw.get(i-1));
                threeList.setObject2(showXyxw.get(i));
                threeList.setObject3(null);
                threeXyxw.add(threeList);
                System.out.println(threeXyxw.get(i));
            }
            else
            {
                //System.out.println(i);
                xyxwService.updateCount();
                threeList.setObject1(showXyxw.get(i-1));
                threeList.setObject2(showXyxw.get(i));
                threeList.setObject3(showXyxw.get(i+1));
                threeXyxw.add(threeList);
            }
        }
        System.out.println(threeXyxw.size());
        return Result.SuccesswithObject("success",threeXyxw);
    }







}
