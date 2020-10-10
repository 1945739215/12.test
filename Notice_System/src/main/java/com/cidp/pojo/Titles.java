package com.cidp.pojo;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="titles")
public class Titles {

        @Id
        private Integer titlesId;
        private Integer tablesId;
        private String titleName;

    public Integer getTitlesId() {
        return titlesId;
    }

    public void setTitlesId(Integer titlesId) {
        this.titlesId = titlesId;
    }

    public Integer getTablesId() {
        return tablesId;
    }

    public void setTablesId(Integer tablesId) {
        this.tablesId = tablesId;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    @Override
        public String toString()
        {
            return "副标题{" +
                    "titlesId'"+titlesId+'\''+
                    "tablesId'"+tablesId+'\''+
                    " titleName='" + titleName + '\'' +
                    '}';
        }
}
