package com.cidp.controller;


import cn.hutool.json.JSONObject;
import com.cidp.pojo.result.UserManageVO;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Test {

    public static void main(String[] args)  {

        UserManageVO userManageVO=new UserManageVO();
        String [] a={"a","b","c"};
        userManageVO.setUserName("180000");
        userManageVO.setTableNames(a);
        System.out.println(userManageVO);

    }
}




