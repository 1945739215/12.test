package com.cidp.pojo;

import javax.persistence.Id;
import javax.persistence.Table;


@Table(name = "informs")
public class Informs {
    @Id
    private Integer titlesId;
    private String informName;
    private String informUrl;
    private String inform;
    private String informDate;
    private Integer id;

    public Integer getTitlesId() {
        return titlesId;
    }

    public Integer setTitlesId(Integer titlesId) {
        this.titlesId = titlesId;
        return titlesId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInformName() {
        return informName;
    }

    public void setInformName(String informName) {
        this.informName = informName;
    }

    public String getInformUrl() {
        return informUrl;
    }

    public void setInformUrl(String informUrl) {
        this.informUrl = informUrl;
    }

    public String getInform() {
        return inform;
    }

    public void setInform(String inform) {
        this.inform = inform;
    }

    public String getInformDate() {
        return informDate;
    }

    public void setInformDate(String informDate) {
        this.informDate = informDate;
    }

    @Override
    public String toString()
    {
        return "Informs{" +
                "id='" + id +'\''+
                ",titlesId='"+titlesId+'\''+
                ", informName='" + informName + '\'' +
                ", informUrl='" + informUrl + '\'' +
                ", inform='" + inform + '\'' +
                ", informDate='" + informDate + '\'' +
                '}';
    }

}
