package com.cidp.mapper;

import com.cidp.pojo.Informs;
import com.cidp.pojo.Tzgg;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface InformsMapper extends  SysMapper<Informs>  {
    @Select("select * from Informs where titlesId = #{titlesId} order by informDate desc ")
    List<Informs> selectall(Integer titlesId);

    @Select("SELECT * FROM informs WHERE titlesId=#{id} ORDER BY informDate DESC")
    List<Informs> SelectInforms(@Param("id") int id);
    @Delete("DELETE FROM informs WHERE titlesId=#{titleId}")
    void deleteByID(@Param("titleId") int titleId);



}
