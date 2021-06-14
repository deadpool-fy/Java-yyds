package bjsubway02.gov.info.manager.controller;

import bjsubway02.gov.info.manager.service.SubwayService;

import java.util.Scanner;

public class SubwayController {
    SubwayService ss = new SubwayService();
    Scanner sc = new Scanner(System.in);

    public void check() {
        ss.check();
    }

    public void add() {
        System.out.println("请输入地铁站编号:");
        String num = sc.next();
        System.out.println("请输入地铁站名称:");
        String name = sc.next();
        System.out.println("请输入地铁站所属路线:");
        String line = sc.next();
        ss.add(num,name,line);
        System.out.println("添加成功");
    }
}
