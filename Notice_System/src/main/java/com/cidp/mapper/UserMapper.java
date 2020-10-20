package com.cidp.mapper;

import com.cidp.pojo.Teacher;
import com.cidp.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Mapper
public interface UserMapper extends SysMapper<User> {
    @Select("SELECT COUNT(*) FROM USER WHERE username=#{username}AND PASSWORD=#{password}" )
    int checkUser(@Param("username") String username, @Param("password") String password);
    @Select("SELECT * FROM USER WHERE username=#{username}")
    User SeclectuserbyUsername(String username);
    @Select("   SELECT * FROM USER WHERE username=#{Adminname}")
    User SelectAdminbyUsername(String Adminname);
    @Select("SELECT * FROM teacher WHERE username=#{Teaname}")
    Teacher SeclectTeacherbyUsername(String Teaname);
    @Select("SELECT username,PASSWORD FROM USER WHERE username=#{username}")
    String SeclectSuccess(@Param("username") String username, @Param("password") String password);

    @Insert("INSERT INTO USER(username,PASSWORD,real_name,sex,dept_id,email,TYPE)VALUES(#{username},#{password},#{realName},#{sex},{depId},#{email},#{type})")
    void AddTeacherToUser(String username, String password, String realName, Integer sex, Integer deptId, String email, Integer type);

    @Insert("INSERT INTO USER(username,PASSWORD,real_name,sex,dept_id,email,TYPE)VALUES(#{username},#{password},#{realName},#{sex},{depId},#{email},#{type})")
    void AddAdminToUser(String username, String password, String realName, Integer sex, Integer deptId, String email, Integer type,String token);
    @Select("SELECT token FROM USER WHERE username=#{username}AND PASSWORD=#{password}")
    String getToken(String username, String password);
    @Select("SELECT * FROM USER WHERE token=#{token}")
    User SelectByToken(@Param("token") String token);
    @Select("select username from user where type='1'")
    List<User> SelectByType();
}
