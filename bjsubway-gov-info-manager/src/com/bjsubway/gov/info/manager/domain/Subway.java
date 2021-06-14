package com.bjsubway.gov.info.manager.domain;

import java.io.Serializable;

public class Subway implements Serializable {
    //地铁站（地铁站编号，地铁站名称，所属路线）
    private String subNum;
    private String subName;
    private String line;

    @Override
    public String toString() {
        return subNum + "," + subName + "," + line;
    }

    public Subway() {
    }

    public Subway(String subNum, String subName, String line) {
        this.subNum = subNum;
        this.subName = subName;
        this.line = line;
    }

    public String getSubNum() {
        return subNum;
    }

    public void setSubNum(String subNum) {
        this.subNum = subNum;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }
}
