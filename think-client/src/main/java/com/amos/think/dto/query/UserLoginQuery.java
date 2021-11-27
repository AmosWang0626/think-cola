package com.amos.think.dto.query;

import com.alibaba.cola.dto.Query;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

/**
 * 用户登录请求
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/1/8
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserLoginQuery extends Query {

    private static final long serialVersionUID = 5180182193190154824L;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

}
