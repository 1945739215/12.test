package com.cidp.mapper;

import com.cidp.pojo.Xyzyxz;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface XyzyxzMapper extends  SysMapper<Xyzyxz>  {

    @Select("select * from  Xyzyxz  order by fileDate desc ")
    List<Xyzyxz> SelectInforms();
}
