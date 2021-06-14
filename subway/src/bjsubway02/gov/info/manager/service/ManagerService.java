package bjsubway02.gov.info.manager.service;

import bjsubway02.gov.info.manager.dao.ManagerDao;
import bjsubway02.gov.info.manager.domain.Manager;

import java.util.ArrayList;

public class ManagerService {
    ManagerDao dao = new ManagerDao();

    public boolean login(String id, String name) {
        ArrayList<Manager> list = dao.login();
        boolean flag = false;
        for (Manager m : list) {
            if(id.equals(m.getId())&&name.equals(m.getName())){
                flag = true;
            }
        }
        return flag;
    }
}
