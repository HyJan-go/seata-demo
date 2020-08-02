package com.seata.seataaccountservice.config;


import com.alibaba.druid.pool.DruidDataSource;
import io.seata.rm.datasource.DataSourceProxy;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.transaction.SpringManagedTransactionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @description: 使用seata来代理数据源
 * @author: HyJan
 * @create: 2020-08-02 14:17
 **/
@Configuration
public class DataSourceProxyConfig {

    @Value("${mybatis.mapperLocations}")
    private String mapperLocations;

    /**
     * @ConfigurationProperties 用来读取配置文件，然后注入到相应的类的同名属性中，进行赋值
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }

    /**
     * 这里要注意，用到的是seata的代理类，不是druid的
     * @return
     */
    @Bean
    public DataSourceProxy dataSourceProxy(DataSource dataSource){
        return new DataSourceProxy(dataSource);
    }

    /**
     * 配置sqlSessionFactory
     * @param dataSourceProxy
     * @return
     * @throws Exception
     */
    @Bean
    public SqlSessionFactory sqlSessionFactoryBean(DataSourceProxy dataSourceProxy)throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        // 把代理的DataSource设置进去
        sqlSessionFactoryBean.setDataSource(dataSourceProxy);
        // 把xml文件设置进去，使用xml的路径找到xml并使用提供的解析类进行解析，然后设置进sqlSession中
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocations));
        // 配置事务
        sqlSessionFactoryBean.setTransactionFactory(new SpringManagedTransactionFactory());
        // 然后返回工厂的一个实例（此方法返回设置好了配置之后的sqlSession）
        return sqlSessionFactoryBean.getObject();
    }
}
