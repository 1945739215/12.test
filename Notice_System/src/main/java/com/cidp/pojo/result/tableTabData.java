package com.cidp.pojo.result;

import com.cidp.pojo.Informs;
import com.cidp.pojo.Titles;
import com.cidp.pojo.Tzgg;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;

public class tableTabData {

    private String tabName;
    private Object object1;
    private Object object2;
    private Object object3;
    private List<Titles> tableSidebarData;

    private String titName;
    private List<Titles> titleSidebarData;

    private List<Informs> threeInformData;
    private List<Tzgg> threeTzgz;




    public Object getObject1() {
        return object1;
    }

    public void setObject1(Object object1) {
        this.object1 = object1;
    }

    public Object getObject2() {
        return object2;
    }

    public void setObject2(Object object2) {
        this.object2 = object2;
    }

    public Object getObject3() {
        return object3;
    }

    public void setObject3(Object object3) {
        this.object3 = object3;
    }



    public List<Tzgg> getThreeTzgz() {
        return threeTzgz;
    }

    public void setThreeTzgz(List<Tzgg> threeTzgz) {
        this.threeTzgz = threeTzgz;
    }

    public List<Informs> getThreeInformData() {
        return threeInformData;
    }

    public void setThreeInformData(List<Informs> threeInformData) {
        this.threeInformData = threeInformData;
    }

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
