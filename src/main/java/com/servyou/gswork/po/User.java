package com.servyou.gswork.po;

public class User {
    private Integer id;

    private String username;

    private String zwxm;

    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getZwxm() {
        return zwxm;
    }

    public void setZwxm(String zwxm) {
        this.zwxm = zwxm == null ? null : zwxm.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}