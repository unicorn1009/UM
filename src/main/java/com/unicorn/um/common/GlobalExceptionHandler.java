package com.unicorn.um.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理类
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    // 使用注解指定出现什么异常会执行这个方法
    @ExceptionHandler(Exception.class)
    @ResponseBody   // 为了返回json格式数据
    public R error(Exception e) {
        e.printStackTrace();
        return R.error().message(e.getMessage());
    }

    // 自定义异常
    @ExceptionHandler(UmeException.class)
    @ResponseBody   // 为了返回json格式数据
    public R error(UmeException e) {
        e.printStackTrace();
        return R.error().code(e.getCode()).message(e.getMsg());
    }
}
