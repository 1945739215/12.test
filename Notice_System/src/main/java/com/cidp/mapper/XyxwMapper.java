package com.cidp.mapper;

import com.cidp.pojo.Xyxw;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface XyxwMapper extends SysMapper<Xyxw> {
    @Select("select * from Xyxw  order by informDate desc ")
    List<Xyxw> selectall();


}
