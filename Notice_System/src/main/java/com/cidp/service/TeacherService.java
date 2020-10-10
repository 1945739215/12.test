package com.cidp.service;

import com.cidp.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    @Autowired
    TeacherMapper teacherMapper;
    public void AddTeacher(String username, Integer deptId) {
        teacherMapper.AddTeacher(username, deptId);
    }

}
