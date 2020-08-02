package com.seata.seatastorageservice;

import io.seata.spring.boot.autoconfigure.SeataAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 这个是坑之一，要手动去除自动配置，否则启动就会报错
 */
@SpringBootApplication(exclude = SeataAutoConfiguration.class)
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan(value = "com.seata.seatastorageservice.dao")
public class SeataStorageServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeataStorageServiceApplication.class, args);
    }

}
