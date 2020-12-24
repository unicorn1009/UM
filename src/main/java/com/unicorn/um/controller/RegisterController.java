package com.unicorn.um.controller;

import com.unicorn.um.common.R;
import com.unicorn.um.entity.User;
import com.unicorn.um.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class RegisterController {

    @Autowired
    private IUserService userService;

    @PostMapping("/register")
    public R register(@RequestBody User registerInfo){
        userService.register(registerInfo);
        return R.ok().message("注册成功！");
    }
}
