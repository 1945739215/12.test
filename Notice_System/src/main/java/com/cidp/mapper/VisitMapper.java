package com.cidp.mapper;

import com.cidp.pojo.Visit;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface VisitMapper extends SysMapper<Visit> {

    @Update("update visit set count =count+#{c} ")
    Integer updateCount1(Integer c);

    @Select("select * from visit ")
    Integer selectCount2();


}
