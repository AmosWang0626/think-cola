package com.amos.think.domain.user;

import lombok.Data;

import java.time.LocalDate;

/**
 * User Domain
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/1/8
 */
@Data
public class UserEntity {

    private Long id;

    /**
     * 用户名
     */
    private UserName username;
    /**
     * 密码
     */
    private UserPassword password;

    /**
     * 姓名
     */
    private String name;

    /**
     * 手机号
     */
    private String phoneNo;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 生日
     */
    private LocalDate birthday;

    /**
     * 描述
     */
    private String description;
}
