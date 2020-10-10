package com.cidp.pojo.result;

public class ResponBean {
    private String filename;
    private String change;
    private String tableName;
    private String titleName;
    private String tableNewName;
    private String titleNewName;

    public String getTableNewName() {
        return tableNewName;
    }

    public void setTableNewName(String tableNewName) {
        this.tableNewName = tableNewName;
    }

    public String getTitleNewName() {
        return titleNewName;
    }

    public void setTitleNewName(String titleNewName) {
        this.titleNewName = titleNewName;
    }

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
