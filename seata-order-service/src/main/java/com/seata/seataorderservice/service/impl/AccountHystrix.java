package com.seata.seataorderservice.service.impl;

import com.seata.common.Result;
import com.seata.seataorderservice.service.IAccountRemote;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author: HyJan
 * @create: 2020-08-02 18:18
 **/
@Component
public class AccountHystrix implements IAccountRemote {
    @Override
    public Result decrease(Long userId, BigDecimal money) {
        return Result.error("账号服务远程调用失败 >>> 服务降低");
    }
}
