package com.cidp.service;


import com.cidp.mapper.*;
import com.cidp.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {
    @Autowired
    TzggMapper tzggMapper;

    @Autowired
    XyxwMapper xyxwMapper;

    @Autowired
    InformsMapper informsMapper;

    @Autowired
    TablesMapper tablesMapper;

    @Autowired
    TitlesMapper titlesMapper;

    @Autowired
    XyzyxzMapper xyzyxzMapper;



    public List<Tzgg> Selectall0() {
        List<Tzgg> tzggList = tzggMapper.selectall();
        return tzggList;
    }

    public List<Xyxw> Selectall1() {
        List<Xyxw> XyxwList = xyxwMapper.selectall();
        return XyxwList;
    }

    public List<Informs> Selectall3(Integer titlesId) {
        List<Informs> informsList = informsMapper.selectall(titlesId);
        return informsList;
    }

    public List<Tables> SelectTables() {
        return tablesMapper.selectTables();
    }

    public int SelectIdByName(String tableName) {
        return tablesMapper.selectIdByName(tableName);
    }

    public List<Titles> SelectTitlesByID(int id) {
        List<Titles> titlesList =  titlesMapper.SelectTitlesById(id);
        return titlesList;

    }


    public int SelectIdByTitle(String titleName) {
        return titlesMapper.SelectIdByName(titleName);
    }


    public List<Informs> SelectInformsById(int id) {
        List<Informs> informsList = new ArrayList<>();
        informsList = informsMapper.SelectInforms(id);
        return informsList;
    }


  /*  public void AddTitle(int id, String titleName) {
        titlesMapper.AddTitle(id, titleName);
    }
*/

    public void AddnewTitle(int id, String titleName,String tableName) {
        titlesMapper.AddTitle(id, titleName,tableName);
    }

    public String SelectNameByID(int i) {
        return tablesMapper.selectNameByid(i);
    }

    public void deleteinformByTitleId(int titleId) {
        informsMapper.deleteByID(titleId);
    }


    public List<Xyzyxz> Selectall2() {
        List<Xyzyxz> informsList = new ArrayList<>();
        informsList = xyzyxzMapper.SelectInforms();
        return informsList;
    }

    public Integer updateCount() {
        return informsMapper.updateCount1();
    }
}
