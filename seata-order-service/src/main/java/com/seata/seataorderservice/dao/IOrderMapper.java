package com.seata.seataorderservice.dao;

import com.seata.seataorderservice.model.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @description: Order DAO
 * @author: HyJan
 * @create: 2020-08-02 15:09
 **/
@Repository
public interface IOrderMapper {

    int insert(@Param("param")Order order);

    int update(@Param("param")Order order);
}
