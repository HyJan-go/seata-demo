package com.seata.seataaccountservice;

import io.seata.spring.boot.autoconfigure.SeataAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude = SeataAutoConfiguration.class)
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.seata.seataaccountservice.dao")
public class SeataAccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeataAccountServiceApplication.class, args);
    }

}
