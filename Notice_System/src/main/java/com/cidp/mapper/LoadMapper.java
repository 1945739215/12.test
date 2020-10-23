package com.cidp.mapper;

import com.cidp.pojo.Xyzyxz;
import org.apache.ibatis.annotations.*;

import java.util.List;



@Mapper
public interface LoadMapper extends  SysMapper<Xyzyxz>{

    @Insert(" INSERT into Xyzyxz(fileName,fileDate,fileUrl,fileTitle,parts) values(#{fileName}," +
            "#{fileDate},#{fileUrl},#{fileTitle},#{parts}) ")
    Integer insertfile(@Param("fileName")String fileName,@Param("fileDate")String fileDate,
                       @Param("fileUrl") String fileUrl,@Param("fileTitle")String fileTitle,
                       @Param("parts")String parts);

    @Select("select * from  Xyzyxz WHERE fileName=#{fileName}")
    Integer selectByFileName(String fileName);



    @Select("select * from  Xyzyxz  order by fileDate desc ")
    public List<Xyzyxz> selectall();

    @Select("select * from  Xyzyxz where parts=#{parts} order by fileDate desc ")
    public List<Xyzyxz> SelectByParts(String parts);





    @Delete("DELETE FROM Xyzyxz WHERE fileId=#{id}")
    Integer deletebyid(@Param("id") Integer id);

    //通过fileId获取fileURl
    @Select("select fileUrl from Xyzyxz WHERE fileId=#{fileId}")
    String selectByFileUrl(Integer fileId);

    @Select("select * from Xyzyxz WHERE fileId=#{fileId}")
    Xyzyxz selectByKey(Integer fileId);

    @Select("select * from Xyzyxz WHERE fileTitle=#{fileTitle}")
    Integer selectByFileTitle(String fileTitle);


}
