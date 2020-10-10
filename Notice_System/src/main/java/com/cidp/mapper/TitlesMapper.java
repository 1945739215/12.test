package com.cidp.mapper;

import com.cidp.pojo.Titles;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TitlesMapper  extends SysMapper<Titles>{
    @Select("SELECT * FROM titles WHERE tablesId=#{id}")
    List<Titles> SelectTitlesById(@Param("id") int id);

    @Select("SELECT titlesId FROM titles WHERE titleName=#{titleName}")
    int SelectIdByName(@Param("titleName") String titleName);

    @Insert("INSERT INTO titles(tablesId,titleName,tableName)VALUES(#{id},#{titleName},#{tableName})")
    void AddTitle(@Param("id") int id, @Param("titleName") String titleName,@Param("tableName") String tableName);

    @Update("UPDATE titles SET titleName=#{titleNewName} WHERE titleName=#{titleName}")
    void ChangeTitle(@Param("titleName") String titleName, @Param("titleNewName") String titleNewName);

    @Delete("DELETE FROM titles WHERE tablesId=#{id}")
    void DeleteTitleByTablesId(@Param("id") int id);
    @Delete("DELETE FROM titles WHERE titleName=#{titleName}")
    void DeleteTitleByName(@Param("titleName") String titleName);


    @Select("select TitleName from titles where tablesName=#{tablesName}")
    List<Titles> selectTitlesNameByTablesId(String tablesName);

    @Select("select TitleName,titlesId from titles ")
    List<Titles> selectAllTitlesName();
    @Select("SELECT titleName FROM titles WHERE tablesId=#{id}")
    List<Titles> selectAllTitlesNameByid(@Param("id") int id);
}
