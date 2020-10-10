package com.cidp.pojo;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="tables")
public class Tables {
    @Id
    private Integer tablesId;
    private String tableName;

    public Integer getTablesId() {
        return tablesId;
    }

    public void setTablesId(Integer tablesId) {
        this.tablesId = tablesId;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
    @Override
    public String toString()
    {
        return "导航栏{" +
                "tablesId'"+tablesId+'\''+
                " tableName='" + tableName + '\'' +
                '}';
    }
}
