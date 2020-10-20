package com.cidp.pojo.result;

import java.util.List;

public class UserManageVO {
    private List userManageList;
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String usreName) {
        this.userName = usreName;
    }

    public List getUserManageList() {
        return userManageList;
    }

    public void setUserManageList(List userManageList) {
        this.userManageList = userManageList;
    }
}
