package com.unicorn.um.controller;


import com.unicorn.um.common.R;
import com.unicorn.um.common.UmeException;
import com.unicorn.um.entity.User;
import com.unicorn.um.service.impl.UserServiceImpl;
import com.unicorn.um.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
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
@CrossOrigin
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("allUser")
    public R findAllUser() {

        // 调用Service中的方法
        try {
            List<User> userList = userService.list(null);
            return R.ok().data("Users", userList);

        } catch (Exception e) {
            throw new UmeException(20001, "获取失败");
        }

    }

    // 传参方式
    @DeleteMapping("{id}")
    public R DeleteUser(@PathVariable Long id) {
        User user = new User();
        user.setId(id);
        user.setIsDeleted(true);
        return userService.updateById(user) ? R.ok().message("删除成功") : R.error().message("删除失败");
    }


    // 添加用户
    @PostMapping("addUser")
    public R addUser(@RequestBody User user) {
        user.setGmtCreate(new Date());
        user.setGmtModified(new Date());
        return userService.save(user) ? R.ok().message("添加成功").data("user", user) : R.error().message("添加失败");
    }

    /**
     * 根据前端传来的请求获取已登录用户的信息
     *
     * @param request
     * @return 当前登录的用户信息
     */
    @GetMapping("getUserInfo")
    public R getUserInfo(HttpServletRequest request) {
        String userId = JwtUtils.getUserIdByJwtToken(request);
        // 查数据库
        User user = userService.getById(userId);
        return R.ok().data("userInfo", user);
    }

}

