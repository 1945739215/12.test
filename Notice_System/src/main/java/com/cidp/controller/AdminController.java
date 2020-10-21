package com.cidp.controller;

import com.cidp.pojo.Tables;
import com.cidp.pojo.User;
import com.cidp.pojo.result.Result;
import com.cidp.pojo.result.UserManageVO;
import com.cidp.service.TableService;
import com.cidp.service.TeacherService;
import com.cidp.service.UserManageService;
import com.cidp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Table;
import javax.servlet.http.HttpSession;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping(value = "/AdminPage")
@CrossOrigin
public class AdminController {
    @Autowired
    UserService userService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    UserManageService userManageService;
    @Autowired
    TableService tableService;

    @RequestMapping(value = "/addTea",method = RequestMethod.POST)//增加教师
    public Result addTea(@RequestBody User user) {
        System.out.println(user);
       /* if (user.getType() == 1 && user.getUsername() != null) {
            userService.AddTeacher(user.getUsername(), user.getPassword(), user.getRealName(), user.getSex(), user.getDeptId(), user.getEmail(), user.getType());
            teacherService.AddTeacher(user.getUsername(), user.getDeptId());
            return Result.success();
        } else
            return Result.error("请检查输入信息后重试");*/
       if(user!=null&&user.getUsername()!="")
        {
            user.setToken( UUID.randomUUID()+"");
            user.setType(2);
            userService.AddTeacher(user.getUsername(), user.getPassword(), user.getRealName(), user.getSex(), user.getDeptId(), user.getEmail(), user.getType(),user.getToken());
            return Result.success();
        }
       else
           return Result.error("请检查输入信息后重试");

    }



   /* @RequestMapping(value = "/addAdmin")//增加管理
        public Result addAdmin(@RequestBody User user) {
        System.out.println(user);
        if (user.getType() == 2 && user.getUsername() != null) {
            userService.AddAdmin(user.getUsername(), user.getPassword(), user.getRealName(), user.getSex(), user.getDeptId(), user.getEmail(), user.getType());
            return Result.success();
        } else
            return Result.error("请检查输入信息后重试");

    }*/

   /*@RequestMapping(value = "/UpdateTea",method = RequestMethod.POST)//修改二级管理员管理模块
    public Result UpdateTea(UserManageVO userManageVO)
   {

       System.out.println(userManageVO);
       System.out.println(userManageVO.getUserManageList());
        userManageService.DeleteByUser(userManageVO.getUserName());
        for (int i=0;i<userManageVO.getUserManageList().size();i++)
        {
            String name= userManageVO.getUserManageList().get(i);
            int ID=tableService.SelectTableId(name);
            userManageService.AddNewTables(userManageVO.getUserName(),ID);
        }
        *//*for(Object list:userManageVO.getUserManageList()) {
            int Tid = tableService.SelectTableId((String) list);
            System.out.println((String) list);
            userManageService.AddNewTables(userManageVO.getUserName(), Tid);
        }*//*

        return Result.Success(userManageVO);
   }
*/
}
