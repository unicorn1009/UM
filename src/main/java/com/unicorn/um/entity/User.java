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
 * @since 2020-12-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("common_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 头像地址
     */
    private String avatar;

    /**
     * 手机号
     */
    private String phoneNumber;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 用户签名
     */
    private String sign;

    /**
     * 逻辑删除
     */
    private Boolean isDeleted;

    /**
     * 是否禁用
     */
    private Boolean isDisabled;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 更新时间
     */
    private Date gmtModified;


}
