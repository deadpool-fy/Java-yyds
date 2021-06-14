package bjsubway02.gov.info.manager.entry;

import bjsubway02.gov.info.manager.controller.ManagerController;

public class InfoManagerEntry {
    public static void main(String[] args) {
        ManagerController mc = new ManagerController();


        System.out.println("----------欢迎来到北京地铁信息系统----------");

        mc.login();
    }
}
