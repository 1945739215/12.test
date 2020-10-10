package com.cidp.service;

import com.cidp.mapper.VisitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitService {
    @Autowired
    VisitMapper visitMapper;



    public Integer updateCount(Integer c) {
        return visitMapper.updateCount1(c);
    }

    public Integer selectCount() {
        return visitMapper.selectCount2();
    }
}
