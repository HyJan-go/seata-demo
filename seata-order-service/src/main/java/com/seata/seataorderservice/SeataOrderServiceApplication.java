package com.seata.seataorderservice;

import io.seata.spring.boot.autoconfigure.SeataAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 *  SeataAutoConfiguration这个类在spring cloud alibaba 2.1.2才有 2.1.0没有
 *  这里是一个坑，如果不排除自动装配，启动会报错
 *  https://juejin.im/post/6844904001528397831#heading-21
 *  使用 https://start.aliyun.com 生成的配置文件里面不要随便改，不然可能启动报错，还不是太熟悉，后面还得再熟悉熟悉
 */
@SpringBootApplication(exclude = SeataAutoConfiguration.class)
@EnableFeignClients
@EnableDiscoveryClient
@MapperScan("com.seata.seataorderservice.dao")
public class SeataOrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeataOrderServiceApplication.class, args);
    }

}
