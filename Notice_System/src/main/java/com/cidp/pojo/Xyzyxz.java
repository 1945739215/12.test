package com.cidp.pojo;

import javax.persistence.Id;
import javax.persistence.Table;


@Table(name = "Xyzyxz")
public class Xyzyxz {
    @Id
    private Integer fileId;
    private String fileTitle;
    private String fileName;
    private String fileUrl;
    private String fileDate;
    private String parts;

    public String getParts() {
        return parts;
    }

    public void setParts(String parts) {
        this.parts = parts;
    }

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getFileDate() {
        return fileDate;
    }

    public void setFileDate(String fileDate) {
        this.fileDate = fileDate;
    }

    public String getFileTitle() {
        return fileTitle;
    }

    public void setFileTitle(String fileTitle) {
        this.fileTitle = fileTitle;
    }


    @Override
    public String toString() {
        return "学院资源上传文件{" +
                "fileId=" + fileId +
                ", fileTitle ='" + fileTitle  + '\'' +
                ", fileName='" + fileName + '\'' +
                ", fileUrl='" + fileUrl + '\'' +
                ", fileDate='" + fileDate + '\'' +
                ", parts='" + parts + '\'' +
                '}';
    }
}
