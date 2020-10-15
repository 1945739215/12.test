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



    public Integer Update(int titlesId, int newTablesId, String tableNewName) {
        return titlesMapper.Update(titlesId,newTablesId,tableNewName);
    }

    public List<Titles> SelectIdByid(Integer tablesId) {
        return titlesMapper.SelectIdById(tablesId);
    }

    public Integer UpdateTitles(int titlesId, int newTitlesId, String titleNewName,String tableNewName,int newTablesId) {
        return titlesMapper.UpdateTitles(titlesId,newTitlesId,titleNewName,tableNewName,newTablesId);
    }

    public Integer UpdateInforms(Integer titlesId, int newTitlesId) {
        return titlesMapper.UpdateInforms(titlesId,newTitlesId);
    }

    public int SelectTablesidByTitlesid(Integer titlesId) {
        return titlesMapper.SelectTablesidByTitlesid(titlesId);
    }

    public int SelectTitlesidBytableNewName(String tableNewName) {
        return titlesMapper.SelectTitlesidBytableNewName(tableNewName);
    }

    public Integer SelectTitlesidByTitleNewName(String titleNewName) {
        return titlesMapper.SelectTitlesidByTitleNewName(titleNewName);
    }

    public Integer SelectTitleNewName(String titleNewName) {
        return titlesMapper.SelectTitleNewName(titleNewName);
    }
}
