package com.seata.seataorderservice.service;

import com.seata.common.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: HyJan
 * @create: 2020-08-02 18:20
 **/
@FeignClient(value = "seata-storage-service",path = "/storage")
public interface IStorageRemote {

    /**
     * 更新库存
     * @param productId
     * @param count
     * @return
     */
    @RequestMapping(value = "/decrease",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Result decrease(@RequestParam("productId") Long productId, Integer count);
}
