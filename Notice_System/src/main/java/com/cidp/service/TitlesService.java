package com.cidp.service;

import com.cidp.mapper.TitlesMapper;
import com.cidp.pojo.Titles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class TitlesService {
    @Autowired
    TitlesMapper titlesMapper;

  /*  public void AddTitle(int id, String titleName) {
        titlesMapper.AddTitle(id,titleName);
    }*/

    public void AddnewTitle(int id, String titleName,String tableName) {
        titlesMapper.AddTitle(id,titleName,tableName);
    }

    public void ChangeTitle(String titleName, String titleNewName) {
        titlesMapper.ChangeTitle(titleName,titleNewName);
    }

    public void DeleteTitleByTablesId(int id) {
        titlesMapper.DeleteTitleByTablesId(id);
    }

    public void DeleteTitleByName(String titleName) {
        titlesMapper.DeleteTitleByName(titleName);
    }

    public List<Titles> selectTitlesNameByTablesId(String  tablesName) {
        return titlesMapper.selectTitlesNameByTablesId(tablesName);
    }

    public List<Titles> selectAllTitlesName() {
        return titlesMapper.selectAllTitlesName();
    }

    public List<Titles> selectAllTitlesNameById(int id) {
        return titlesMapper.selectAllTitlesNameByid(id);
    }

    public int SelectIdByname(String titleName) {
        return titlesMapper.SelectIdByName(titleName);
    }
}
