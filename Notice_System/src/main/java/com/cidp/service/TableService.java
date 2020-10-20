package com.cidp.service;

import com.cidp.mapper.InformsMapper;
import com.cidp.mapper.TablesMapper;
import com.cidp.mapper.TzggMapper;
import com.cidp.mapper.XyxwMapper;
import com.cidp.pojo.Tables;
import com.cidp.pojo.Tzgg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableService {
    @Autowired
    TablesMapper tablesMapper;
    @Autowired
    TzggMapper tzggMapper;
    @Autowired
    XyxwMapper xyxwMapper;
    @Autowired
    InformsMapper informsMapper;
    public void AddTable(String tableName) {
        tablesMapper.AddTables(tableName);
    }

    public int SelectTableId(String tableName) {
        return tablesMapper.selectIdByName(tableName);
    }


    public void ChangeTable(String tableName, String tableNewName) {
        tablesMapper.ChangeTable(tableName,tableNewName);
    }

    public void DeleteTable(String tableName) {
        tablesMapper.DeleteTable(tableName);
    }


    public int CheckExist(String tableName) {
        return tablesMapper.CheckExist(tableName);
    }




    public List<Tables> selectAll2() {
        return tablesMapper.selectTables2();
    }


    public int SelectExit(String tableName) {
        return tablesMapper.CheckExist(tableName);
    }

    public Integer Update(Integer tablesId, int newTablesId, String tableNewName) {
        return tablesMapper.Update(tablesId,newTablesId,tableNewName);
    }




}
