package com.cidp.mapper;

import com.cidp.pojo.Xyxw;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface XyxwMapper extends SysMapper<Xyxw> {
    @Select("select * from Xyxw  order by informDate desc ")
    List<Xyxw> selectall();


    @Update("update xyxw set count =count+1 ")
    Integer updateCount1();

    @Select("SELECT * FROM xyxw WHERE informName LIKE '%${informName}%'")
    List<Xyxw> SelectByName(@Param("informName") String informName);
}
