package com.cidp.service;

import com.cidp.mapper.UserMapper;
import com.cidp.pojo.Teacher;
import com.cidp.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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



    public String getToken(String username, String password) {
        return userMapper.getToken(username,password);
    }

    public User SelectByToken(String token) {
        return userMapper.SelectByToken(token);
    }

    public List<User> SelectByType() {
        return userMapper.SelectByType();
    }

    public void AddTeacher(String username, String password, String realName, Integer sex, Integer deptId, String email, Integer type, String token) {
        userMapper.AddAdminToUser(username,password,realName,sex,deptId,email,type,token);
    }
}
