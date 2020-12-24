package com.unicorn.um.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
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
     * 性别（0：女，1：男）
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
     * 逻辑删除（0:正常，1：删除）
     */
    @TableLogic     // 逻辑删除注解
    private Boolean isDeleted;

    /**
     * 是否禁用（0:正常，1：禁用）
     */
    private Boolean isDisabled;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;


}
