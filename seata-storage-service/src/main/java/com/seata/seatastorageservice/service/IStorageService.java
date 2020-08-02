package com.seata.seatastorageservice.service;

/**
 * @description: TODO
 * @author: HyJan
 * @create: 2020-08-02 16:01
 **/
public interface IStorageService {

    void decrease(Long productId,Integer count);
}
