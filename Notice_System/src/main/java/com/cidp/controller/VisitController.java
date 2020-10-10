package com.cidp.controller;

import com.cidp.pojo.Visit;
import com.cidp.pojo.result.Result;
import com.cidp.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.Map;

@RestController
@CrossOrigin
public class VisitController {
    @Autowired
    VisitService visitService;

    @PostMapping("/visit")
    public Result Index(Integer c){
        //Visit visit=new Visit();
        //传过来c为1，打开一次网站，数据库count次数加一
        visitService.updateCount(c);
        Integer count1=visitService.selectCount();
        return Result.SuccesswithObject("浏览次数",count1);

    }


}
