package bjsubway02.gov.info.manager.domain;

import java.io.Serializable;

public class Subway implements Serializable {
    private String subNum;
    private String subName;
    private String subLine;

    @Override
    public String toString() {
        return subNum + "," + subName + "," + subLine;
    }

    public Subway() {
    }

    public Subway(String subNum, String subName, String subLine) {
        this.subNum = subNum;
        this.subName = subName;
        this.subLine = subLine;
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

    public String getSubLine() {
        return subLine;
    }

    public void setSubLine(String subLine) {
        this.subLine = subLine;
    }
}
