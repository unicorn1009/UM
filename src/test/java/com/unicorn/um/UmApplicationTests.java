package com.unicorn.um;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.unicorn.um.entity.User;
import com.unicorn.um.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@SpringBootTest
class UmApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        List<User> userList = userMapper.selectList(null);
        System.out.println(userList);

    }

    @Test
    void findAllUser()
    {
        List<User> userList = userMapper.selectList(null);
        System.out.println(userList);
    }


    @Test
    void addUser()
    {
        User user = new User();
        user.setAge(10);
        user.setPhone("123");
        user.setPassword("12345");
        user.setCreateTime(new Date());
        int insert = userMapper.insert(user);
        System.out.println("insert:"+insert);

    }

    @Test
    void updateUser()
    {
        User user = new User();
        user.setAge(100);
        user.setPhone("1234567901");
        user.setUpdateTime(new Date());
        int insert = userMapper.updateById(user);
        System.out.println("insert:"+insert);

    }

    @Test
    void SearchByConditions()
    {
        // 使用QueryWrapper构建条件
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        // ge: 大于等于， le: 小于等于， gt: 大于， lt: 小于
        // eq: 等于， ne: 不等于
        // between: 指定数值范围，notBetween
        // like: 模糊查询，返回map集合
        // orderByDesc: 降序， orderByAsc: 升序
        // last: 在查询语句的最后拼接上自己写的语句
        // select: 查询出指定的列(字段)
        queryWrapper.gt("age", 30).like("email", "qq.com").select("username","age","email");
        List<User> userList = userMapper.selectList(queryWrapper);
        System.out.println(userList);


    }

}
