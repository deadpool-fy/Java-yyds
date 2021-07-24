package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.service.AccountService;
import com.itheima.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    @Autowired
    private LogService logService;
    @Override
    public void transfer(String in, String out, Double money) {
        try {
            accountDao.inMoney(in, money);
            int i = 1 / 0;
            accountDao.outMoney(out, money);
        } finally {
            logService.log(in,out,money);
        }
    }
}
