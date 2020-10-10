package com.cidp.pojo;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "visit")
public class Visit {
    @Id
    private Integer count;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
    @Override
    public String toString()
    {
        return "次数：{" +
                "count='" + count +'\''+
                '}';}
}
