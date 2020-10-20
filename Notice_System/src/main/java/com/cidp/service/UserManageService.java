package com.cidp.service;

import com.cidp.mapper.UserManageMapper;
import com.cidp.pojo.User;
import com.cidp.pojo.UserManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service


public class UserManageService {
    @Autowired
    UserManageMapper userManageMapper;
    public List<UserManage> GettableIdList(String userName) {
        return userManageMapper.SelectByID(userName);
    }




    public void AddNewTables(String username, int id) {
        userManageMapper.AddNewTables(username,id);
    }

    public void DeleteByTableId(int id) {
        userManageMapper.DeleteByTableId(id);
    }

    public void DeleteByUser(String userName) {userManageMapper.DeleteByUser(userName);
    }
}
