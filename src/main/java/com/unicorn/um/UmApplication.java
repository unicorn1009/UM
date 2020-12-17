package com.unicorn.um;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.unicorn.um.mapper")        // 挪到了配置类上
public class UmApplication {

    public static void main(String[] args) {
        SpringApplication.run(UmApplication.class, args);
    }

}
