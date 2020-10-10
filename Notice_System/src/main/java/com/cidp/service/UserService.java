package com.cidp.service;

import com.cidp.mapper.UserMapper;
import com.cidp.pojo.Teacher;
import com.cidp.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public int checkUser(String username, String password) {
        return userMapper.checkUser(username, password);
    }

    public User SeclectuserbyUsername(String username) {
        return userMapper.SeclectuserbyUsername(username);
    }

    public Teacher getTeacher(String Teaname) {
        return userMapper.SeclectTeacherbyUsername(Teaname);
    }

    public String Success(String username, String password) {
        return userMapper.SeclectSuccess(username, password);
    }

    public User getAdmin(String Adminname) {
        return userMapper.SelectAdminbyUsername(Adminname);
    }

    public void AddTeacher(String username, String password, String realName, Integer sex, Integer deptId, String email, Integer type) {
        userMapper.AddTeacherToUser(username, password, realName, sex, deptId, email, type);
    }

    public void AddAdmin(String username, String password, String realName, Integer sex, Integer deptId, String email, Integer type) {
        userMapper.AddAdminToUser(username, password, realName, sex, deptId, email, type);
    }
}
