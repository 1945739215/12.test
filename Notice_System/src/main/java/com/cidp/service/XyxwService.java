package com.cidp.service;

import com.cidp.mapper.XyxwMapper;
import com.cidp.pojo.Tzgg;
import com.cidp.pojo.Xyxw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class XyxwService {
    @Autowired
    XyxwMapper xyxwMapper;

    public List<Xyxw> Selectall() {
        List<Xyxw> xyxwList=new ArrayList<>();
        xyxwList=xyxwMapper.selectall();
        return xyxwList;
    }
}
