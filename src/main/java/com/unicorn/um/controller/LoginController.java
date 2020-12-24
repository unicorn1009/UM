package com.unicorn.um.controller;

import com.unicorn.um.common.R;
import com.unicorn.um.mapper.UserMapper;
import com.unicorn.um.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Locale;

@RestController
@CrossOrigin
public class LoginController {


    @PostMapping("/login")
    public R login(@RequestBody Object obj) {
        Object username = ((LinkedHashMap) obj).get("username");
        Object pwd = ((LinkedHashMap) obj).get("password");
        if (username.toString().toLowerCase().equals("admin") && pwd.toString().toLowerCase().equals("123"))
            return R.ok().message("登陆成功").data("abc", "我是返回的数据");
        else
            return R.error().message("登录失败");
    }
}
