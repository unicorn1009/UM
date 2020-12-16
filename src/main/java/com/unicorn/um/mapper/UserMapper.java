package com.unicorn.um.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.unicorn.um.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
