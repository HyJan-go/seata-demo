package com.seata.seataaccountservice.service.impl;

import com.seata.seataaccountservice.dao.IAccountMapper;
import com.seata.seataaccountservice.service.IAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @description: 业务实现类
 * @author: HyJan
 * @create: 2020-08-02 17:48
 **/
@Service
public class AccountServiceImpl implements IAccountService {

    private static final Logger log = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Autowired
    private IAccountMapper accountMapper;

    /**
     * 更新账户钱包
     * @param userId
     * @param money
     */
    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("-------------> 更新账户资金开始");
        if (accountMapper.decrease(userId,money) < 1){
            log.error("---------------> 更新账户资金信息失败，数据库更新失败");
        }
        log.info("-------------> 更新账户资金结束");
    }
}
