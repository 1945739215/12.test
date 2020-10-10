package com.cidp.service;


import com.cidp.mapper.LoadMapper;
import com.cidp.pojo.Xyzyxz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class LoadService {
    @Autowired
    LoadMapper loadMapper;


    public int insertfile(String fileName, String fileUrl, String fileDate,String fileTitle) {
        return  loadMapper.insertfile(fileName, fileUrl,fileDate,fileTitle);
    }

    public Integer selectByFileName(String fileName) {
        return loadMapper.selectByFileName(fileName);
    }

    public List<Xyzyxz> Selectall() {
        List<Xyzyxz> xyzyList=new ArrayList<>();
        xyzyList= (List<Xyzyxz>) loadMapper.selectall();
        return xyzyList;
    }

    public int DeleteById(Integer id) {
        return loadMapper.deletebyid(id);
    }

    public  Xyzyxz selectByFileId(Integer fileId) {
        return loadMapper.selectByPrimaryKey(fileId);
    }
    public  Xyzyxz selectByFileId1(Integer fileId) {
        return loadMapper.selectByKey(fileId);
    }
    public String selectByFileUrl(Integer fileId){ return loadMapper.selectByFileUrl(fileId);}

    public Integer selectByFileTitle(String fileTitle) {
        return loadMapper.selectByFileTitle(fileTitle);
    }
}
