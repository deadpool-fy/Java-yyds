package bjsubway02.gov.info.manager.domain;

import java.io.Serializable;

public class Manager implements Serializable {
    private String id;
    private String name;
    private String gender;
    private String telNum;

    @Override
    public String toString() {
        return id + "," +name + "," +gender + "," + telNum;
    }

    public Manager() {
    }

    public Manager(String id, String name, String gender, String telNum) {
        this.id = id;
        this.name = name;
        this.gender = gender;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTelNum() {
        return telNum;
    }

    public void setTelNum(String telNum) {
        this.telNum = telNum;
    }
}
