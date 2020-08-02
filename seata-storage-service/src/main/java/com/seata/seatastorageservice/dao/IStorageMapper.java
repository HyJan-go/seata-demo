package com.seata.seatastorageservice.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @description: TODO
 * @author: HyJan
 * @create: 2020-08-02 15:52
 **/
@Repository
public interface IStorageMapper {

    /**
     * 扣减库存
     * @param productId
     * @param count
     * @return
     */
    int decrease(@Param("productId")Long productId,@Param("count")Integer count);

}
