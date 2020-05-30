package com.servyou.gswork;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@MapperScan("com.servyou.gswork.mapper")
public class GsworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(GsworkApplication.class, args);
    }

}
