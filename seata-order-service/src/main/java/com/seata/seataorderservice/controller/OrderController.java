package com.seata.seataorderservice.controller;

import com.alibaba.fastjson.JSON;
import com.seata.common.Result;
import com.seata.seataorderservice.service.IAccountRemote;
import com.seata.seataorderservice.service.IOrderService;
import com.seata.seataorderservice.service.IStorageRemote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author: HyJan
 * @create: 2020-08-02 18:30
 **/
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @Autowired
    private IAccountRemote accountRemote;

    @Autowired
    private IStorageRemote storageRemote;

    private static final Logger log = LoggerFactory.getLogger(OrderController.class);

    @RequestMapping("/account")
    public Result updateAccount(Long userId, BigDecimal money) {
        Result result = accountRemote.decrease(userId, money);
        log.info("the result is {}", JSON.toJSONString(result));
        return accountRemote.decrease(userId, money);
    }

    @RequestMapping("/storage")
    public Result updateStorage(Long productId, Integer count) {
        return storageRemote.decrease(productId, count);
    }


}
