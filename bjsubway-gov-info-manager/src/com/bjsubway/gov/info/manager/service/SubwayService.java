package com.bjsubway.gov.info.manager.service;

import com.bjsubway.gov.info.manager.dao.SubwayDao;
import com.bjsubway.gov.info.manager.domain.Subway;

import java.util.ArrayList;

public class SubwayService {
    SubwayDao dao = new SubwayDao();

    public void add(String num, String name, String line) {
        dao.add(num,name,line);
    }

    public void check() {
        ArrayList<Subway> list = dao.check();
        if(list.isEmpty()){
            System.out.println("暂无信息,请添加后重试");
        }else{
            System.out.println("编号"+"\t\t"+"名称"+"\t\t"+"所属线路");
            for (Subway subway : list) {
                System.out.println(subway.getSubNum()+"\t\t"+subway.getSubName()+"\t\t"+subway.getLine());
            }
        }
    }
}
