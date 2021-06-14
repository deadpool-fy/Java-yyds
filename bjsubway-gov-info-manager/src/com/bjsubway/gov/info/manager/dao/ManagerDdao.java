package com.bjsubway.gov.info.manager.dao;

import com.bjsubway.gov.info.manager.domain.Manager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ManagerDdao {
    private static ArrayList<Manager> manList = new ArrayList<>();

    static {
        save();
    }

    public ArrayList<Manager> login() {
        return manList;
    }

    public static void save(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("bjsubway-gov-info-manager\\managers.txt"));
            String line;
            while ((line = br.readLine())!=null){
                String[] split = line.split(",");
                Manager man = new Manager(split[0],split[1],split[2],split[3]);
                manList.add(man);
            }
            br.close();
        } catch (IOException e) {

        }
    }
}
