package com.seata.seataorderservice.service;

import com.seata.common.Result;
import com.seata.seataorderservice.service.impl.AccountHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @description: 账号服务远程调用
 * feign 远程调用目前发现的三个坑
 * 1. 如果是非对象的接收，一定要使用@RequestParam("userId")，并且括号里面的名称都不能省略
 * 2. 返回的结果类，就算跟远程返回的结果一样，如果不是同一个类，就算是从远程项目复制过来的类，也会转换失败而报错，但是远程调用其实是成功的
 * 3. 返回的结果中一定要有一个默认的无参数构造函数，否则有可能报转换不了异常。（json反序列化需要无参构造函数） https://blog.csdn.net/weixin_39827145/article/details/89314433
 * @author: HyJan
 * @create: 2020-08-02 18:13
 **/
@FeignClient(value = "seata-account-service",path = "/account",fallback = AccountHystrix.class)
public interface IAccountRemote {

    /**
     * 更新账户资金
     * 注意feign的坑，如果是非对象的接收，一定要使用@RequestParam("userId")，并且括号里面的名称都不能省略，或者不要用这个注解
     * @param userId
     * @param money
     * @return
     */
    @RequestMapping(value = "/decrease", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Result decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);

}
