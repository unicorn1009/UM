package com.unicorn.um.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.unicorn.um.common.UmeException;
import com.unicorn.um.entity.User;
import com.unicorn.um.mapper.UserMapper;
import com.unicorn.um.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.unicorn.um.util.JwtUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author unicorn
 * @since 2020-12-24
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    // 用户登录的方法
    @Override
    public String login(User user) {
        // 获取登录用户名和密码
        String username = user.getUsername();
        String password = user.getPassword();
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
            throw new IllegalArgumentException("用户名或密码为空");
        }

        // 判断用户名和密码是否正确
        // 判断用户是否存在
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        User queryUser = baseMapper.selectOne(wrapper);
        if (queryUser == null)
            throw new IllegalArgumentException("登录失败：用户名不存在");


        // 用户存在，判断密码
        //TODO 密码MD5加密后再与数据库中密码对比（注册时也需要加密后存储到数据库）
        if (!password.equals(queryUser.getPassword()))
            throw new IllegalArgumentException("登录失败：密码错误");

        // 密码正确，判断用户是否禁用
        if (queryUser.getIsDisabled())
            throw new IllegalArgumentException("登录失败：该账户被禁用");

        // 验证完毕，完成登录
        // 生成token
        String jwtToken = JwtUtils.getJwtToken(queryUser.getId().toString(), queryUser.getUsername());

        return jwtToken;
    }

    @Override
    public void register(User registerUser) {
        String username = registerUser.getUsername();
        String phoneNumber = registerUser.getPhoneNumber();
        String password = registerUser.getPassword();

        // 判断信息是否为空
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(phoneNumber) || StringUtils.isEmpty(password))
            throw new UmeException(20001, "注册失败：信息为空");

        // 手机号不可与数据库中已注册的手机号重复
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("phone_number", phoneNumber);
        if (baseMapper.selectOne(queryWrapper) != null)
            throw new UmeException(20001, "注册失败：该手机号已被注册！");

        // 用户名不可与数据库中已注册的用户名重复
        queryWrapper.clear();
        queryWrapper.eq("username", username);
        if (baseMapper.selectOne(queryWrapper) != null)
            throw new UmeException(20001, "注册失败：该用户名已被注册！");

        // 可注册，存数据库
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setPhoneNumber(phoneNumber);
        user.setAvatar("https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png");  // 默认头像
        baseMapper.insert(user);
    }


}
