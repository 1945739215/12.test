package com.cidp.mapper;

import com.cidp.pojo.UserManage;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserManageMapper extends SysMapper<UserManage>{

    @Select("SELECT * FROM usermanege WHERE userName=#{userName}")
    List<UserManage> SelectByID(@Param("userName") Object userName);
    @Insert("INSERT INTO usermanege VALUE (#{username},#{id})")
    void AddNewTables(String username, int id);
    @Delete("DELETE FROM usermanege WHERE tableId=#{id}")
    void DeleteByTableId(int id);
    @Delete("DELETE FROM usermanege WHERE userName=#{userName}")
    void DeleteByUser(String userName);
}
