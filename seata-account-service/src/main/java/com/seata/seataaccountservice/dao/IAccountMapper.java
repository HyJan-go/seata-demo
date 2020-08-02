package com.seata.seataaccountservice.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
 * @author: HyJan
 * @create: 2020-08-02 17:43
 **/
@Repository
public interface IAccountMapper {

    /**
     * 扣减账户余额
     */
    int decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);

}
