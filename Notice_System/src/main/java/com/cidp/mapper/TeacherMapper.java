package com.cidp.mapper;

import com.cidp.pojo.Teacher;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeacherMapper extends SysMapper<Teacher> {
    @Insert("INSERT INTO teacher(username,department,dept_id)VALUES(#{username},'信息工程学院',#{depId}")
    void AddTeacher(String username, Integer deptId);
}
