package bjsubway02.gov.info.manager.controller;

import bjsubway02.gov.info.manager.service.ManagerService;

import java.util.Scanner;

public class ManagerController {
    ManagerService ms = new ManagerService();
    SubwayController con = new SubwayController();
    Scanner sc = new Scanner(System.in);

    public void login() {
        while (true) {
            System.out.println("请输入您的工号:");
            String id = sc.next();
            System.out.println("请输入您的姓名:");
            String name = sc.next();
            boolean result = ms.login(id, name);

            if (result) {
                System.out.println("登录成功,欢迎回来");
                open();
                break;
            } else {
                System.out.println("您输入的信息有误,有核对后再输!");
            }
        }
    }

    public void open() {
        while (true) {
            System.out.println("请选择您要进行的操作:(1.查看地铁站 2.添加地铁站)");
            String choice = sc.next();
            switch(choice){
                case "1":
                    con.check();
                    System.exit(0);
                case "2":
                    con.add();
                    System.exit(0);
                default:
                    System.out.println("您的输入有误,请重新输入!");
            }
        }
    }
}
