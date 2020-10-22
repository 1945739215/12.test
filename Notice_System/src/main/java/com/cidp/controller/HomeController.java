package com.cidp.controller;

import com.cidp.pojo.Informs;
import com.cidp.pojo.Tzgg;
import com.cidp.pojo.Xyxw;
import com.cidp.pojo.Xyzyxz;
import com.cidp.pojo.result.Result;
import com.cidp.pojo.result.tableTabData;
import com.cidp.service.LoadService;
import com.cidp.service.ShowService;
import com.cidp.service.TzggService;
import com.cidp.service.XyxwService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/homePage")
public class HomeController {
    @Autowired
    TzggService tzggService;
    @Autowired
    XyxwService xyxwService;
    @Autowired
    ShowService showService;
    @Autowired
    LoadService loadService;


    //浏览次数   下载次数   上，下一篇(显示object2的informname)   GitHub
    //下载，上传分区，挪位置，合并，搜索
    //权限  部署项目linux(改)

    //浏览次数 ，上传多加一个parts，显示的时候传值 parts
    //导航栏合并 多选传多个tablesid的数组，和新的tablesname
    //侧边栏合并 多选传多个titlesId数组，和（复选框，已有的）合并到的tableNewName，和（新的或者原来的  自己打字）titleNewName，


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
    @RequestMapping(value = "/SelectByName",method =RequestMethod.POST)//主页面进行模糊查询
    public Result SelectByName(@RequestParam String name)
    {
        System.out.println(name);
        List<Tzgg>tzgzList=new ArrayList<>();
        List<Xyxw>xyxwList=new ArrayList<>();
        List<Informs>informsList=new ArrayList<>();
        List<Object>finalList=new ArrayList<>();
        tzgzList=tzggService.SelectByName(name);
        xyxwList=xyxwService.SelectByName(name);
        informsList=showService.SelectByName(name);
        /*List集合无法直接强转，可消除泛型在赋值(如下方方式则不会报错)
        List test=tzgzList;////
        List<Object> testChange=test;
        System.out.println(testChange.size());*/
        finalList.addAll(tzgzList);//多个不同类型list集合整合也可用addAll方法到一个Object类型List
        finalList.addAll(xyxwList);
        finalList.addAll(informsList);

        return Result.SuccesswithObject("success",finalList);

    }

    //显示上传的文件   （url:学院资源下载）
    @RequestMapping(value = "/xyzyxzfile",method = RequestMethod.POST)
    public Result showXyzyxz( String parts)
    {
        System.out.println(parts);
        List<Xyzyxz> showXyzyxz=new ArrayList<>();
        showXyzyxz = loadService.SelectByParts(parts);
        System.out.println(showXyzyxz);
        return Result.SuccesswithObject("success",showXyzyxz);
    }
}
