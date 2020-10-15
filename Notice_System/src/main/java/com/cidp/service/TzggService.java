package com.cidp.service;

import com.cidp.mapper.TitlesMapper;
import com.cidp.mapper.TzggMapper;
import com.cidp.pojo.Inform;
import com.cidp.pojo.Informs;
import com.cidp.pojo.Titles;
import com.cidp.pojo.Tzgg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TzggService {
    @Autowired
    TzggMapper tzggMapper;
    @Autowired
    TitlesMapper titlesMapper;



    public List<Tzgg> Selectall() {
        List<Tzgg> tzggList=new ArrayList<>();
        tzggList=tzggMapper.selectall();
        return tzggList;
    }


    public int insertinfo( String informName, String informUrl, String inform, String informDate ) {
        return  tzggMapper.insertinfo( informName, informUrl,  inform, informDate);
    }

    public int AlterTzgg(Integer id,String informName, String inform, String informDate,String informUrl) {
        return tzggMapper.alterTzgg(id,informName,inform,informDate,informUrl);
    }

    public int AlterTzgg2(Integer id, String informName, String inform, String informDate) {
        return tzggMapper.AlterTzgg2(id,informName,inform,informDate);
    }

    public int DeleteById(Integer id,String informUrl) {
        return tzggMapper.deletebyid(id,informUrl);
    }


    public String selectByInformName(String informName,String informUrl) {
        return tzggMapper.selectByInformName(informName,informUrl);
    }




    public String  Show(String informName,String informUrl) {
        return tzggMapper.Show(informName, informUrl);
    }

    public int insertinfo2(String titlesId, String informName, String inform, String informDate) {
        return  tzggMapper.insertinfo2(titlesId, informName,   inform, informDate);
    }


    public Integer updateCount() {
        return tzggMapper.updateCount1();
    }
    public  List<Tzgg> SelectByName(String informName) {
        return tzggMapper.SelectByName(informName);
    }
}
