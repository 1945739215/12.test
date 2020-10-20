package com.cidp.pojo;

import javax.persistence.Table;
@Table(name = "usermanege")
public class UserManage {
    private String userName;
    private Integer tableId;

    public String getUserToken() {
        return userName;
    }

    public void setUserToken(String userToken) {
        this.userName = userToken;
    }

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    @Override
    public String toString()
    {
        return
                "UserManage" +
                        "userName" +userName+
                        "tableId" +tableId;
    }
}
