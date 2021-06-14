package com.bjsubway.gov.info.manager.domain;

public class Manager {
    //管理人员（工号，姓名，性别，手机号）
    private String id;
    private String name;
    private String sex;
    private String telNum;

    @Override
    public String toString() {
        return id + "," + name + "," + sex + "," + telNum;
    }

    public Manager() {
    }

    public Manager(String id, String name, String sex, String telNum) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.telNum = telNum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTelNum() {
        return telNum;
    }

    public void setTelNum(String telNum) {
        this.telNum = telNum;
    }
}
