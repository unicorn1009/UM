package com.unicorn.um;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@MapperScan("com.unicorn.um.mapper")        // 挪到了配置类上
@SpringBootApplication
//@EnableDiscoveryClient  // 开启nacos服务发现
public class UmApplication {

    public static void main(String[] args) {
        SpringApplication.run(UmApplication.class, args);
    }

}
