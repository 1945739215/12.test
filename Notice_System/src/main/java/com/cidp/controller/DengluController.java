package com.cidp.controller;

import com.cidp.pojo.User;
import com.cidp.pojo.result.Result;
import com.cidp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "")
@CrossOrigin
public class DengluController {
    @Autowired
    UserService userService;


    @RequestMapping(value = "/login", method = RequestMethod.POST)//登录验证
    public Result Denglu(@RequestBody User user, HttpSession session)
    {
        session.setAttribute("user",user);
        session.setMaxInactiveInterval(360000);
        System.out.println(user);
        System.out.println(session.getAttribute(user.getUsername()));
        System.out.println(userService.checkUser(user.getUsername(),user.getPassword()));
        if (userService.checkUser(user.getUsername(),user.getPassword())==1)
        {
            String token=userService.getToken(user.getUsername(),user.getPassword());
            System.out.println("存在");
            System.out.println(token);
            return Result.Success(token);
            }
            else
            {
                return Result.Error();
            }
    }
    @PostMapping(value = "/getinfo")
    public Result getinfo(@RequestBody User user)
    {
        System.out.println(user.getToken());
        User successUser=new User();
        successUser=userService.SelectByToken(user.getToken());
        return Result.SuccesswithObject("success",successUser);
    }


}
