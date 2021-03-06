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
  /*  @Select("SELECT titlesId FROM titles WHERE tablesId=#{tablesId}")
    int SelectIdById(Integer tablesId);*/
  @Select("SELECT titlesId FROM titles WHERE tablesId=#{tablesId}")
  List<Titles> SelectIdById(Integer tablesId);

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

    @Update("update titles set tablesId =#{newTablesId} and tableName =#{tableNewName} where titlesId=#{titlesId}")
    Integer Update(@Param("titlesId")int titlesId, @Param("newTablesId")int newTablesId,
                   @Param("tableNewName")String tableNewName);

    @Update("update titles set titlesId =#{newTitlesId} and titleName =#{titleNewName}" +
            "and tableName=#{tableNewName} and tablesId=#{tablesId} where titlesId=#{titlesId}")
    Integer UpdateTitles(@Param("titlesId")int titlesId,@Param("newTitlesId") int newTitlesId,
                         @Param("titleNewName")String titleNewName, @Param("tableNewName")String tableNewName,
                         @Param("newTablesId")int newTablesId );

    @Update("update informs set titlesId =#{newTitlesId} where titlesId=#{titlesId}")
    Integer UpdateInforms(Integer titlesId, int newTitlesId);

    @Select("select tablesId from titles where titlesID=#{titlesId}")
  int SelectTablesidByTitlesid(Integer titlesId);

  @Select("select tablesId from titles where table=#{titlesId}")
  int SelectTitlesidBytableNewName(String tableNewName);

  @Select("select titlesId from titles where titleNewName=#{titleNewName}")
  Integer SelectTitlesidByTitleNewName(String titleNewName);

  @Select("select titleName from titles where titleNewName=#{titleNewName}")
  Integer SelectTitleNewName(String titleNewName);
}
