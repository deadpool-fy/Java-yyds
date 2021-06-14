package com.bjsubway.gov.info.manager.dao;

import com.bjsubway.gov.info.manager.domain.Subway;

import java.io.*;
import java.util.ArrayList;

public class SubwayDao {

    private static ArrayList<Subway> subList = new ArrayList<>();

    static {
        read();
    }

    public void add(String num, String name, String line) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("bjsubway-gov-info-manager\\subways.txt"));
            Subway sub = new Subway(num,name,line);
            subList.add(sub);
            bw.write(sub.getSubNum()+","+sub.getSubName()+","+sub.getLine());
            bw.close();
        } catch (IOException e) {
        }

    }
    public static void read(){
        try {
            BufferedReader fr = new BufferedReader(new FileReader("bjsubway-gov-info-manager\\subways.txt"));
            String line = fr.readLine();
            String[] split = line.split(",");
            Subway sub = new Subway(split[0],split[1],split[2]);
            subList.add(sub);
            fr.close();
        } catch (IOException e) {

        }
    }
    public ArrayList<Subway> check(){
        return subList;
    }
}
