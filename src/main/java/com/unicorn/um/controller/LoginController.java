package com.unicorn.um.controller;

import com.unicorn.um.common.R;
import com.unicorn.um.entity.User;
import com.unicorn.um.mapper.UserMapper;
import com.unicorn.um.service.IUserService;
import com.unicorn.um.service.impl.UserServiceImpl;
import com.unicorn.um.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.Locale;

@RestController
@CrossOrigin
public class LoginController {

    @Autowired
    private IUserService userService;


    @PostMapping("/login")
    public R login(@RequestBody User user) {

        String token = userService.login(user);
        return R.ok().data("token",token);

    }

}
