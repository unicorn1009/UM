package com.unicorn.um.service.impl;

import com.unicorn.um.entity.User;
import com.unicorn.um.mapper.UserMapper;
import com.unicorn.um.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author unicorn
 * @since 2020-12-18
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
