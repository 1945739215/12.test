package com.cidp.mapper;

import com.cidp.pojo.Tables;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TablesMapper extends SysMapper<Tables> {
    @Select("SELECT tablesId FROM TABLES WHERE tableName=#{tableName}")
    int selectIdByName(@Param("tableName") String tableName);
    @Select("SELECT * FROM TABLES")
    //@Select("SELECT * FROM TABLES where tablesId between 1  and  8")
    List<Tables> selectTables2();
    @Select("SELECT * FROM TABLES")
    List<Tables> selectTables();

    @Insert("INSERT INTO TABLES (tableName)VALUES(#{tableName})")
    void AddTables(@Param("tableName") String tableName);

    @Update("UPDATE TABLES SET tableName=#{tableNewName} WHERE tableName=#{tableName}")
    void ChangeTable(@Param("tableName") String tableName, @Param("tableNewName") String tableNewName);
    @Delete("DELETE FROM TABLES WHERE tableName=#{tableName}")
    void DeleteTable(@Param("tableName") String tableName);
    @Select("SELECT COUNT(*) FROM TABLES WHERE tableName=#{tableName}")
    int CheckExist(@Param("tableName") String tableName);
    @Select("SELECT tableName FROM TABLES WHERE tablesId =#{i}")
    String selectNameByid(@Param("i") int i);


}
