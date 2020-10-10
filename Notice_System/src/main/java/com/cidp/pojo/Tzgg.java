package com.cidp.pojo;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "Tzgg")
public class Tzgg {
    @Id
    private String titlesId;


    private Integer id;
    private String informName;
    private String inform;
    private String informUrl;
    private String informDate;
    private Integer infoTableId;

    public String getTitlesId() {
        return titlesId;
    }

    public void setTitlesId(String titlesId) {
        this.titlesId = titlesId;
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

    public String getInform() {
        return inform;
    }

    public void setInform(String inform) {
        this.inform = inform;
    }

    public String getInformUrl() {
        return informUrl;
    }

    public void setInformUrl(String informUrl) {
        this.informUrl = informUrl;
    }

    public String getInformDate() {
        return informDate;
    }

    public void setInformDate(String informDate) {
        this.informDate = informDate;
    }

    public Integer getInfoTableId() {
        return infoTableId;
    }

    public void setInfoTableId(Integer infoTableId) {
        this.infoTableId = infoTableId;
    }




    @Override
    public String toString() {
        return "通知公告{" +
                "id='" + id + '\'' +
                ",titlesId='" + titlesId + '\'' +
                ", informName='" + informName + '\'' +
                ", informUrl='" + informUrl + '\'' +
                ", inform='" + inform + '\'' +
                ", informDate='" + informDate + '\'' +
                '}';
    }

}
