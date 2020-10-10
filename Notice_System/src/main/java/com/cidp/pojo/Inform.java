package com.cidp.pojo;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
//@Entity
@Table(name = "inform")
public class Inform {
    @Id
    private String titlesId;
    private String informName;
    private String informUrl;
    private String inform;
    private String informDate;
    private Integer id;



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
        return "Inform{" +
                "id='" + id +'\''+
                ",titlesId='"+titlesId+'\''+
                ", informName='" + informName + '\'' +
                ", informUrl='" + informUrl + '\'' +
                ", inform='" + inform + '\'' +
                ", informDate='" + informDate + '\'' +
                '}';
    }

}
