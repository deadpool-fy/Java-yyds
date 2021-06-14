package bjsubway02.gov.info.manager.dao;

import bjsubway02.gov.info.manager.domain.Manager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ManagerDao {
    private static ArrayList<Manager> manList = new ArrayList<>();

    static{
        load();
    }

    public ArrayList<Manager> login() {
        return manList;
    }


    public static void load(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("bjsubway-gov-info-manager\\managers.txt"));
           String line;
            while((line = br.readLine())!=null){
                String[] split = line.split(",");
                Manager m = new Manager(split[0],split[1],split[2],split[3]);
                manList.add(m);
            }
            br.close();
        } catch (Exception e) {
        }
    }
}
