package com.unicorn.um.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author unicorn
 * @since 2020-12-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_common_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    private String username;

    private String password;

    private Integer age;

    private Integer gender;

    private String phone;

    private String email;

    private Date createTime;

    private Date updateTime;

    /**
     * 0:禁用，1：正常，2：删除
     */
    private Integer isEnable;


}
