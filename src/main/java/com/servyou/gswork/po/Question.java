package com.servyou.gswork.po;

import java.util.Date;

public class Question {
    private Integer id;

    private String imNumber;

    private String rmNumber;

    private String title;

    private String lrry;

    private Date lrrq;

    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImNumber() {
        return imNumber;
    }

    public void setImNumber(String imNumber) {
        this.imNumber = imNumber == null ? null : imNumber.trim();
    }

    public String getRmNumber() {
        return rmNumber;
    }

    public void setRmNumber(String rmNumber) {
        this.rmNumber = rmNumber == null ? null : rmNumber.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getLrry() {
        return lrry;
    }

    public void setLrry(String lrry) {
        this.lrry = lrry == null ? null : lrry.trim();
    }

    public Date getLrrq() {
        return lrrq;
    }

    public void setLrrq(Date lrrq) {
        this.lrrq = lrrq;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}