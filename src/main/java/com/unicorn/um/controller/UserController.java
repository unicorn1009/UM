package com.unicorn.um.controller;


import com.unicorn.um.common.R;
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
 * @since 2020-12-18
 */
@RestController     // 组合注解，可返回json数据
@RequestMapping("/um/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("allUser")
    public R findAllUser()
    {

        // 调用Service中的方法
        List<User> userList = userService.list(null);

        return R.ok().data("Users", userList);
    }

    // 传参方式
    @DeleteMapping("{id}")
    public R DeleteUser(@PathVariable String id) {
        User user = new User();
        user.setId(id);
        user.setIsEnable(0);


        return userService.updateById(user) ? R.ok().message("删除成功"): R.error().message("删除失败");
    }

}

