package com.seata.seataorderservice.service.impl;

import com.alibaba.fastjson.JSON;
import com.seata.common.Result;
import com.seata.seataorderservice.dao.IOrderMapper;
import com.seata.seataorderservice.model.Order;
import com.seata.seataorderservice.service.IAccountRemote;
import com.seata.seataorderservice.service.IOrderService;
import com.seata.seataorderservice.service.IStorageRemote;
import io.seata.spring.annotation.GlobalTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description: 订单业务实现类
 * @author: HyJan
 * @create: 2020-08-02 15:15
 **/
@Service
public class OrderServiceImpl implements IOrderService {

    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private IOrderMapper orderMapper;

    @Resource
    private IAccountRemote accountRemote;

    @Resource
    private IStorageRemote storageRemote;

    /**
     * 创建订单->调用库存服务扣减库存->调用账户服务扣减账户余额->修改订单状态
     *
     * @param order
     * @return
     * @GlobalTransactional 开启全局事务注解
     * 这里想到一个点，知道返回不成功，就手动进行抛异常达到回滚效果，每次判断返回结果
     */
    @Override
    @GlobalTransactional(name = "fsp-create-order", rollbackFor = Exception.class)
    public void create(Order order) {
        logger.info("------------> 下单开始");

        // 本应用创建订单
        orderMapper.insert(order);

        // 远程调用库存服务扣减库存(正常逻辑是先判断库存够不够的)
        logger.info("--------------> 调用减库存开始");
        Result result = storageRemote.decrease(order.getProductId(), order.getCount());
        logger.info("----------> 减少库存结束, 执行结果为 {}", JSON.toJSONString(result));

        // 远程调用账户服务扣减余额
        logger.info("-------------> 扣除账户余额开始");
//        Result result1 = accountRemote.decrease(order.getUserId(), order.getMoney());
//        logger.info("----------> 扣除账户结束，执行结果为 {}", JSON.toJSONString(result1));

        // 修改订单状态为已完成
        logger.info("----------> 修改订单状态开始...");
        orderMapper.update(order);
        logger.info("--------------------------> 修改订单状态完成");

        logger.info("------------------->  订单业务完成  <-----------------------");
    }

}
