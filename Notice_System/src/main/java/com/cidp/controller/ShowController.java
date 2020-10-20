package com.cidp.controller;


import com.cidp.pojo.*;
import com.cidp.pojo.result.Result;
import com.cidp.pojo.result.tableTabData;
import com.cidp.service.ShowService;
import com.cidp.service.TableService;
import com.cidp.service.UserManageService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class ShowController {

    @Autowired
    ShowService showService;
    @Autowired
    TableService tableService;
    @Autowired
    UserManageService userManageService;

    //分页
    @GetMapping("/page")
    public Result page( @RequestParam(value = "titlesId") int titlesId,
                       @RequestParam(value = "InformsPagenum", defaultValue = "1") int InformsPagenum){
        System.out.println("分页");
        List<Informs> InformsList = new ArrayList<Informs>();

        //分页核心代码
        PageHelper.startPage(InformsPagenum, 12);
        InformsList = showService.Selectall3(titlesId);
        PageInfo<Informs> pageInforms = new PageInfo<Informs>(InformsList);
        System.out.println(InformsList);

        System.out.println(pageInforms);
        return Result.SuccesswithObject("分页",pageInforms);
    }

//首页分页
    @GetMapping("/homepage")
    public Result pageHome(  String informUrl,
                            @RequestParam(value = "XyxwPagenum", defaultValue = "1") int XyxwPagenum,
                        @RequestParam(value = "TzggPagenum", defaultValue = "1") int TzggPagenum) {
        System.out.println(informUrl);
        System.out.println(TzggPagenum);
        System.out.println("分页");
        List<Xyxw> XyxwList = new ArrayList<>();
        List<Tzgg> TzggList = new ArrayList<Tzgg>();

        //分页核心代码
        if (informUrl.equals("xyxw")) {
            System.out.println(111);

            PageHelper.startPage(XyxwPagenum, 12);
            XyxwList = showService.Selectall1();
            PageInfo<Xyxw> pageInforms = new PageInfo<Xyxw>(XyxwList);
            System.out.println(XyxwList);

            return Result.SuccesswithObject("分页", pageInforms);
        } else if (informUrl.equals("tzgg")) {
            System.out.println(222);

            PageHelper.startPage(TzggPagenum, 12);
            TzggList = showService.Selectall0();
            PageInfo<Tzgg> Informs = new PageInfo<Tzgg>(TzggList);
            System.out.println(TzggList);

            return Result.SuccesswithObject("分页", Informs);
        } else {
            System.out.println(333);
            return Result.error("error");
        }
    }

    //下载分页
    @GetMapping("/downloadpage")
    public Result page( //@RequestParam(value = "titlesId") int titlesId,
                        @RequestParam(value = "Pagenum", defaultValue = "1") int Pagenum){
        System.out.println("分页");
        List<Xyzyxz> InformsList = new ArrayList<Xyzyxz>();

        //分页核心代码
        PageHelper.startPage(Pagenum, 12);
        InformsList = showService.Selectall2();
        PageInfo<Xyzyxz> pageInforms = new PageInfo<Xyzyxz>(InformsList);
        System.out.println(InformsList);

        System.out.println(pageInforms);
        return Result.SuccesswithObject("分页",pageInforms);
    }

    //显示导航栏
    @RequestMapping(value = "/showTables",method = RequestMethod.POST)
    public Result showTables(HttpSession session)
    {
        System.out.println(session.getAttribute("user."));
        List<tableTabData>tableTabData=new ArrayList<>();
        User user=(User) session.getAttribute("user");
        String userName=user.getUsername();
        List<UserManage>tableIdList=new ArrayList<>();
        tableIdList=userManageService.GettableIdList(userName);
        for (int i=0;i<tableIdList.size();i++)
        {
            com.cidp.pojo.result.tableTabData tableTabData1=new com.cidp.pojo.result.tableTabData();
            tableTabData1.setTabName(showService.SelectNameByID(tableIdList.get(i).getTableId()));
            tableTabData1.setTableSidebarData(showService.SelectTitlesByID(tableIdList.get(i).getTableId()));
            tableTabData.add(tableTabData1);
        }
        System.out.println(tableTabData);
        return Result.SuccesswithObject("success",tableTabData);

    }

    //显示侧边栏
    @RequestMapping(value = "/showTitles",method = RequestMethod.POST)
    public Result showTitles(@RequestBody Tables tables)//需要前端传回模块名字
    {
        System.out.println(tables.getTableName());
        List<Titles> titlesArrayList=new ArrayList<>();
        int ID=showService.SelectIdByName(tables.getTableName());//根据名字查找id，外键id返回侧边栏
        titlesArrayList=showService.SelectTitlesByID(ID) ;
        System.out.println("到这了");
        System.out.println(titlesArrayList);

        return Result.SuccesswithObject("success",titlesArrayList);

    }
    //显示inform
    @RequestMapping(value ="/showInforms",method = RequestMethod.POST)
    public Result showInforms(@RequestBody Titles titles)
    {
        System.out.println(titles.getTitleName());
        List<Informs> informsList=new ArrayList<>();
        List<tableTabData> threeInforms=new ArrayList<>();
        int ID=showService.SelectIdByTitle(titles.getTitleName());
        informsList=showService.SelectInformsById(ID);
        for (int i=0;i<informsList.size();i++)
        {
            com.cidp.pojo.result.tableTabData threeList=new tableTabData();
            if (i==0)
            {
                showService.updateCount();
                threeList.setObject1(null);
                threeList.setObject2(informsList.get(i));
                threeList.setObject3(informsList.get(i+1));
                threeInforms.add(threeList);
            }
            else if (i==informsList.size()-1)
            {
                showService.updateCount();
                threeList.setObject1(informsList.get(i-1));
                threeList.setObject2(informsList.get(i));
                threeList.setObject3(null);
                threeInforms.add(threeList);
            }
            else
            {
                showService.updateCount();
                threeList.setObject1(informsList.get(i-1));
                threeList.setObject2(informsList.get(i));
                threeList.setObject3(informsList.get(i+1));
                threeInforms.add(threeList);
            }

        }
        return Result.SuccesswithObject("success",threeInforms);
    }

    @RequestMapping(value = "/showFirstPage",method = RequestMethod.POST)
    public Result showFirstPage() {
        System.out.println("首页显示导航栏");
        List<Tables> tablesList = new ArrayList<>();
        tablesList = tableService.selectAll2();
        return Result.SuccesswithObject("success", tablesList);
    }


    @RequestMapping(value = "/showTop",method = RequestMethod.POST)
    public Result showTop() {
        System.out.println("顶部显示导航栏");

        List<Tables> tablesList = new ArrayList<>();
        tablesList = tableService.selectAll2();
        System.out.println(tablesList);
        return Result.SuccesswithObject("success", tablesList);
    }



}
