package com.seata.seatastorageservice.service.impl;

import com.seata.seatastorageservice.dao.IStorageMapper;
import com.seata.seatastorageservice.service.IStorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: TODO
 * @author: HyJan
 * @create: 2020-08-02 16:02
 **/
@Service
public class StorageServiceImpl implements IStorageService {

    private static final Logger log = LoggerFactory.getLogger(StorageServiceImpl.class);

    @Autowired
    private IStorageMapper storageMapper;


    /**
     * 扣减库存
     * @param productId
     * @param count
     */
    @Override
    public void decrease(Long productId, Integer count) {
        log.info("------------->  扣减库存开始");
        if (storageMapper.decrease(productId,count) < 1){
            log.error("--------------> 扣减库存时更新数据库失败");
        }
        log.info("------------->  扣减库存结束");
    }
}
