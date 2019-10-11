package com.plus.batis.entity;

public class QueryParam extends BaseParam {
    private String userName ;
    private Integer state ;
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public Integer getState() {
        return state;
    }
    public void setState(Integer state) {
        this.state = state;
    }
}
