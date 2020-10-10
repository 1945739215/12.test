package com.cidp.controller;

import com.cidp.pojo.*;
import com.cidp.pojo.result.Result;
import com.cidp.service.TitlesService;
import com.cidp.service.TzggService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class InformController {

    TzggService tzggService;

    @Autowired
    public InformController(TzggService tzggService){
        this.tzggService=tzggService;
    }

    @Autowired
    TitlesService titlesService;


    //返给前端发布时模块信息
    @RequestMapping(value = "/showParts",method = RequestMethod.POST)
    public Result showParts() {
        System.out.println("fabu");
        List<Titles> titlesList = new ArrayList<>();
        //titlesList = titlesService.selectTitlesNameByTablesId(tablesName);
        titlesList = titlesService.selectAllTitlesName();
        System.out.println(titlesList);
        return Result.SuccesswithObject("success", titlesList);
    }

    //发布
    //@RequestMapping(value = "/Fabu", method = RequestMethod.GET)
    //public Result Inform(@RequestParam String informName) {
    @RequestMapping(value = "/Fabu", method = RequestMethod.POST)
    public Result Inform(@RequestBody Inform Inform) {

        //接收发布通知
        boolean isSuccess = true;
        String Id=Inform.getTitlesId();
        String Url=Inform.getInformUrl();
        System.out.println("接收");
        System.out.println(Inform);

        //判断传过来的是否为空
        if ("".equals(Inform.getInformName())  || "".equals(Inform.getInform()) || "".equals(Inform.getInformDate()) ||
                Inform.getInformName() == null ||  Inform.getInform() == null || Inform.getInformDate() == null) {
            isSuccess = false;
            System.out.println("传值为空");
        }
        else {
            System.out.println("传值不为空");

            //首页两个的titlesId为空，其他发布的InformUrl为informs
            //String Name=tzggService.selectByInformName(Inform.getInformName(),Inform.getInformUrl());

            if(Id==null&&Url==null){
                isSuccess = false;
               return Result.error1("id和url都为空");
            }else if (Id!=null && Url!=null){
                isSuccess = false;
                return Result.error2("id和url都为有值");
            }else {
                //判断是编辑(修改) 还是发布
                //if(Name == null||"".equals(Id)){
                if( Id== null||"".equals(Id)){
                    System.out.println("进入原有发布");
                    //不存在titlesId，则原有发布 （通知公告，学院新闻）
                    tzggService.insertinfo(Inform.getInformName(), Inform.getInformUrl(), Inform.getInform(), Inform.getInformDate());
                }else {
                    //存在titlesId，则其他发布
                    System.out.println("进入其他发布");
                    tzggService.insertinfo2(Inform.getTitlesId(),Inform.getInformName(),  Inform.getInform(), Inform.getInformDate());
                }
           /* }else {
                //存在默认数据，则是编辑
                System.out.println("进入编辑");
                //tzggService.AlterTzgg(Inform.getInformName(), Inform.getInform(), Inform.getInformDate(),Inform.getInformUrl());
                tzggService.AlterTzgg(Inform.getId(), Inform.getInformName(), Inform.getInform(), Inform.getInformDate(), Inform.getInformUrl());
            }*/

            }

        }
        System.out.println("结束");
        return isSuccess ? Result.success() : Result.error("错误");
    }

    @RequestMapping(value = "/Delete", method = RequestMethod.POST)
    public Result Delete(@RequestBody Inform inform) {
        System.out.println("删除");
        System.out.println(inform);
        tzggService.DeleteById(inform.getId(),inform.getInformUrl());
        return Result.success();

    }

    @RequestMapping(value = "/Alter", method = RequestMethod.POST)
    public Result Alter(@RequestBody Inform inform2) {

        System.out.println("进入编辑");
        System.out.println(inform2);
        //如果informurl为空，则进入首页编辑
        if (inform2.getTitlesId()==null){
            System.out.println("进入shouye编辑");
            tzggService.AlterTzgg(inform2.getId(), inform2.getInformName(), inform2.getInform(),
                    inform2.getInformDate(), inform2.getInformUrl());
        }else{
        //如果titlesId为空，则进入其他编辑
      /*  if (inform2.getInformUrl()==null||"".equals(inform2.getInformUrl())){ */
            System.out.println("进入qita编辑");
            tzggService.AlterTzgg2(inform2.getId(), inform2.getInformName(), inform2.getInform(),
                    inform2.getInformDate());
        }
        return Result.success();
    }



}



