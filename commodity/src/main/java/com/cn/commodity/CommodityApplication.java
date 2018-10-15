package com.cn.commodity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@MapperScan("com.cn.commodity.dao")
@SpringBootApplication
public class CommodityApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(CommodityApplication.class, args);
    }
}
