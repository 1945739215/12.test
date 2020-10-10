package com.cidp.pojo;

import javax.persistence.Table;

@Table(name = "teacher")
public class Teacher {
    private String username;
    private String department;
    private Integer department_number;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getDepartment_number() {
        return department_number;
    }

    public void setDepartment_number(Integer department_number) {
        this.department_number = department_number;
    }

    @Override
    public String toString()
    {
        return "Teacher{" +
                "username=" + username +
                ", department='" + department + '\'' +
                ", department_number='" + department_number + '\'' +
                ", departments='" + department_number + '\'' +
                '}';
    }
}
