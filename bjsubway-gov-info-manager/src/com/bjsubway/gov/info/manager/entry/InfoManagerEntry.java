package com.bjsubway.gov.info.manager.entry;

import com.bjsubway.gov.info.manager.controller.ManagerController;

public class InfoManagerEntry {
    public static void main(String[] args) {
        ManagerController mc = new ManagerController();

        System.out.println("--------北京市地铁管理信息系统--------");

        mc.login();


    }
}
