package bjsubway02.gov.info.manager.dao;


import bjsubway02.gov.info.manager.domain.Subway;

import java.io.*;
import java.util.ArrayList;

public class SubwayDao {
    private static ArrayList<Subway> subList = new ArrayList<>();

    static {
        load();
    }

    public ArrayList<Subway> check() {
        return subList;
    }

    public static void load() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("bjsubway-gov-info-manager\\subways.txt"));
            subList = (ArrayList<Subway>) ois.readObject();
            ois.close();
        } catch (Exception e) {

        }
    }

    public static void add(String num, String name, String line) {
        try {
            Subway s = new Subway(num, name, line);
            subList.add(s);
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("bjsubway-gov-info-manager\\subways.txt"));
            oos.writeObject(subList);
            oos.close();
        } catch (IOException e) {
        }
    }
}
