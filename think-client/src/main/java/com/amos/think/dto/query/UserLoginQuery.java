package com.amos.think.dto.query;

import com.alibaba.cola.dto.Query;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

/**
 * DESCRIPTION: 用户登录请求
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/1/8
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserLoginQuery extends Query {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

}
