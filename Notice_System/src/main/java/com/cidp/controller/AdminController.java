package com.cidp.controller;

import com.cidp.pojo.User;
import com.cidp.pojo.result.Result;
import com.cidp.service.TeacherService;
import com.cidp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
public class AdminController {
    @Autowired
    UserService userService;
    @Autowired
    TeacherService teacherService;

    @RequestMapping(value = "/addTea")//增加教师
    public Result addTea(@RequestBody User user) {
        System.out.println(user);
        if (user.getType() == 1 && user.getUsername() != null) {
            userService.AddTeacher(user.getUsername(), user.getPassword(), user.getRealName(), user.getSex(), user.getDeptId(), user.getEmail(), user.getType());
            teacherService.AddTeacher(user.getUsername(), user.getDeptId());
            return Result.success();
        } else
            return Result.error("请检查输入信息后重试");

    }



    @RequestMapping(value = "/addAdmin")//增加管理
        public Result addAdmin(@RequestBody User user) {
        System.out.println(user);
        if (user.getType() == 2 && user.getUsername() != null) {
            userService.AddAdmin(user.getUsername(), user.getPassword(), user.getRealName(), user.getSex(), user.getDeptId(), user.getEmail(), user.getType());
            return Result.success();
        } else
            return Result.error("请检查输入信息后重试");

    }
}
