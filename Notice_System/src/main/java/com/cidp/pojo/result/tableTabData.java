package com.cidp.pojo.result;

import com.cidp.pojo.Titles;

import java.util.List;

public class tableTabData {

    private String tabName;
    private List<Titles> tableSidebarData;

    private String titName;
    private List<Titles> titleSidebarData;




    public String getTitName() {
        return titName;
    }

    public void setTitName(String titName) {
        this.titName = titName;
    }

    public List<Titles> getTitleSidebarData() {
        return titleSidebarData;
    }

    public void setTitleSidebarData(List<Titles> titleSidebarData) {
        this.titleSidebarData = titleSidebarData;
    }

    public String getTabName() {
        return tabName;
    }

    public void setTabName(String tabName) {
        this.tabName = tabName;
    }

    public List<Titles> getTableSidebarData() {
        return tableSidebarData;
    }

    public void setTableSidebarData(List<Titles> tableSidebarData) {
        this.tableSidebarData = tableSidebarData;
    }


    @Override
    public String toString()
    {
        return "tabName:"+tabName;
    }

}
