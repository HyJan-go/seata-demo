package com.seata.seatastorageservice.controller;

import com.seata.common.Result;
import com.seata.seatastorageservice.service.IStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: TODO
 * @author: HyJan
 * @create: 2020-08-02 16:10
 **/
@RestController
@RequestMapping("/storage")
public class StorageController {

    @Autowired
    private IStorageService storageService;

    /**
     * 扣减库存
     * @param productId
     * @param count
     * @return
     */
    @RequestMapping("/decrease")
    public Result decrease(Long productId, Integer count){
        storageService.decrease(productId,count);
        return Result.success(null);
    }

}
