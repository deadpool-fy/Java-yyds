package com.itheima.service;

import org.springframework.transaction.annotation.Transactional;

public interface AccountService {
    @Transactional
    public void transfer(String in,String out,Double money);
}
