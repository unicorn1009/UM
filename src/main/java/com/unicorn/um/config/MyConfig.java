package com.unicorn.um.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.unicorn.um.mapper")
public class MyConfig {
}
