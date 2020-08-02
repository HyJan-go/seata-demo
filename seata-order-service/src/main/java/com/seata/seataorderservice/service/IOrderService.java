package com.seata.seataorderservice.service;

import com.seata.seataorderservice.model.Order;

/**
 * @description: 订单服务
 * @author: HyJan
 * @create: 2020-08-02 15:13
 **/
public interface IOrderService {

    void create(Order order);

}
