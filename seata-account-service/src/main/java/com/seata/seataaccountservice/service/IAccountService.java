package com.seata.seataaccountservice.service;

import java.math.BigDecimal;

/**
 * @author: HyJan
 * @create: 2020-08-02 17:47
 **/
public interface IAccountService {

    void decrease(Long userId, BigDecimal money);

}
