package com.itheima;

import com.itheima.config.SpringConfig;
import com.itheima.service.ResourceService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Aop {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        ResourceService service = context.getBean(ResourceService.class);
        boolean res = service.openUrl("http://pan.baidu.com/haha", "     root      ");
        System.out.println(res);
    }
}
