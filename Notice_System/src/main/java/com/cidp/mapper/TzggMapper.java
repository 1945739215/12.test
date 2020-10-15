package com.cidp.mapper;

import com.cidp.pojo.*;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface TzggMapper extends  SysMapper<Tzgg> {
    @Select("select * from  Tzgg  order by informDate desc ")
    List<Tzgg> selectall();


    @Insert(" INSERT into ${informUrl}(informName,informUrl,inform,informDate) " +
            "values(#{informName},#{informUrl},#{inform},#{informDate})  ")
    int insertinfo(@Param("informName") String informName, @Param("informUrl") String informUrl,
                   @Param("inform") String inform, @Param("informDate") String informDate);



    @Update("UPDATE ${informUrl} SET inform = #{inform},informName = #{informName}," +
            "informDate = #{informDate},informUrl = #{informUrl} where id = #{id}")
    int alterTzgg(@Param("id") Integer id,@Param("informName") String informName,@Param("inform") String inform,
                  @Param("informDate") String informDate,@Param("informUrl") String informUrl);

    @Update("UPDATE informs SET inform = #{inform},informName = #{informName}," +
            "informDate = #{informDate} where id = #{id}")
    int AlterTzgg2(@Param("id") Integer id,@Param("informName") String informName,@Param("inform") String inform,
                   @Param("informDate") String informDate);
    /*@Update("UPDATE ${informUrl} SET inform = #{inform}," +
            "informDate = #{informDate},informUrl = #{informUrl} where informName = #{informName}")
    int alterTzgg(@Param("informName") String informName,@Param("inform") String inform,
                  @Param("informDate") String informDate,@Param("informUrl") String informUrl);*/

    @Delete("DELETE FROM ${informUrl} WHERE id=#{id}")
    int deletebyid(@Param("id") Integer id,@Param("informUrl") String informUrl);

    @Select("select informName from  ${informUrl} WHERE informName= #{informName}")
    String selectByInformName(@Param("informName") String informName, @Param("informUrl") String informUrl);

    @Select("select informName from ${informUrl} ")
    List<String> selectByInformName2( @Param("informUrl") String informUrl);

    @Select("select * from  ${informUrl} WHERE informName=#{informName}")
    String Show(@Param("informName") String informName, @Param("informUrl") String informUrl);


    @Insert(" INSERT into informs(titlesId,informName,informUrl,inform,informDate) " +
            "values(#{titlesId},#{informName},'null',#{inform},#{informDate})  ")
    int insertinfo2(@Param("titlesId")String titlesId,@Param("informName") String informName,
                    @Param("inform")String inform,
                    @Param("informDate")String informDate);


    @Update("update tzgg set count =count+1 ")
    Integer updateCount1();
    @Select("SELECT * FROM tzgg WHERE informName LIKE '%${informName}%'")
    List<Tzgg> SelectByName(@Param("informName") String informName);
}
