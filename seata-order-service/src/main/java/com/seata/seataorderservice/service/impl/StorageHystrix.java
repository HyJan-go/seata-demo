package com.seata.seataorderservice.service.impl;

import com.seata.common.Result;
import com.seata.seataorderservice.service.IStorageRemote;
import org.springframework.stereotype.Component;

/**
 * @description: 服务降低处理
 * @author: HyJan
 * @create: 2020-08-02 18:25
 **/
@Component
public class StorageHystrix implements IStorageRemote {
    @Override
    public Result decrease(Long productId, Integer count) {
        return Result.error("更新库存失败 >>> 服务发生降级");
    }
}
