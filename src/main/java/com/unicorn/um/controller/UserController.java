package com.unicorn.um.controller;


import com.unicorn.um.entity.User;
import com.unicorn.um.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author unicorn
 * @since 2020-12-17
 */
@RestController     // 组合注解，可返回json数据
@RequestMapping("/um/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("allUser")
    public List<User> findAllUser()
    {
        // 调用Service中的方法
        List<User> userList = userService.list(null);
        return userList;
    }

    // 传参方式
    @DeleteMapping("{id}")
    public boolean DeleteUser(@PathVariable Long id) {
        User user = new User();
        user.setId(id);
        user.setIsEnable(0);

        return userService.updateById(user);
    }

}

