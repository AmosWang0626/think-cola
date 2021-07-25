package com.amos.think.dto;

import com.alibaba.cola.dto.Command;
import com.amos.think.dto.clientobject.UserRegisterCO;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
 * 新增用户请求
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/1/8
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class UserRegisterCmd extends Command {

    /**
     * 为什么加这个 xxxCO ?
     * 首先，可以不加。这里比较特殊，Java对象单继承，xxxCO 继承自 UserVO。
     *
     * @see com.amos.think.dto.query.UserLoginQuery 就不需要单独定义一个 xxxCO
     */
    @NotNull
    private UserRegisterCO userRegister;

}
