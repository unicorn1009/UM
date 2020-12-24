package com.unicorn.um.mapper;

import com.unicorn.um.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author unicorn
 * @since 2020-12-24
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
