package com.unicorn.um.service;

import com.unicorn.um.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author unicorn
 * @since 2020-12-24
 */
public interface IUserService extends IService<User> {

    String login(User user);

    void register(User registerUser);
}
