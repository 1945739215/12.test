package com.cidp.controller;

import com.cidp.pojo.Teacher;
import com.cidp.pojo.User;
import com.cidp.pojo.result.Result;
import com.cidp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin
public class DengluController {
    @Autowired
    UserService userService;


    @RequestMapping(value = "/login", method = RequestMethod.POST)//登录验证
    public Result Denglu(@RequestBody User user, HttpSession session)
    {
        session.setAttribute("username",user.getUsername());
        System.out.println(userService.checkUser(user.getUsername(),user.getPassword()));
        System.out.println("here");
        if (userService.checkUser(user.getUsername(),user.getPassword())==1)
        {
            System.out.println("存在");
            User user1=userService.SeclectuserbyUsername(user.getUsername());
            if (user1.getType()==1)
            {
                Teacher teacher=userService.getTeacher(user1.getUsername());
                System.out.println("打印teacher");
                System.out.println(teacher);
                return Result.SuccesswithObject("登录成功",teacher);
            }
            else if (user1.getType()==2)
            {
                User user2=userService.getAdmin(user.getUsername());
                System.out.println("打印admin");
                System.out.println(user2);
                return Result.SuccesswithObject("登陆成功",user2);
            }
            else
            {
                return Result.error("未知错误");
            }
        }
        else
        {
            return Result.error("账号或密码错误，请重新输入");
        }
    }

}
