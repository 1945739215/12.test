package com.cidp.pojo.result;

import java.util.Arrays;
import java.util.List;

public class UserManageVO {
   private String userName;
   private String[] tableNames;

    @Override
    public String toString() {
        return "UserManageVO{" +
                "userName='" + userName + '\'' +
                ", tableNames=" + Arrays.toString(tableNames) +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String[] getTableNames() {
        return tableNames;
    }

    public void setTableNames(String[] tableNames) {
        this.tableNames = tableNames;
    }
}




