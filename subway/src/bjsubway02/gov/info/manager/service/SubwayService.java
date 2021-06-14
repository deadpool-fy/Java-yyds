package bjsubway02.gov.info.manager.service;


import bjsubway02.gov.info.manager.dao.SubwayDao;
import bjsubway02.gov.info.manager.domain.Subway;

import java.util.ArrayList;

public class SubwayService {
    SubwayDao dao = new SubwayDao();

    public void check() {
        ArrayList<Subway> list = dao.check();
        if (!list.isEmpty()) {
            System.out.println("编号\t\t名称\t\t路线");
            for (Subway sub : list) {
                System.out.println(sub.getSubNum() + "\t\t" + sub.getSubName() + "\t\t" + sub.getSubLine());
            }
        } else {
            System.out.println("暂无数据,请添加后重试");
        }
    }

    public void add(String num, String name, String line) {
        dao.add(num, name, line);
    }
}
