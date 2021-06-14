package com.bjsubway.gov.info.manager.service;

import com.bjsubway.gov.info.manager.dao.ManagerDdao;
import com.bjsubway.gov.info.manager.domain.Manager;

import java.util.ArrayList;

public class ManagerService {
    ManagerDdao dao = new ManagerDdao();

    public boolean login(String id, String name) {
        ArrayList<Manager> list = dao.login();
        boolean flag = false;
        for (Manager man : list) {
            if(id.equals(man.getId())&&name.equals(man.getName())){
                flag = true;
            }
        }
        return flag;
    }
}
