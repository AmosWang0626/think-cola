package com.amos.think.dto;

import com.alibaba.cola.dto.Command;
import com.amos.think.dto.form.UserRegisterForm;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
 * DESCRIPTION: 新增用户请求
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/1/8
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserRegisterCmd extends Command {

    /**
     * 为什么加这个 Form，Java对象单继承，Form继承自 UserDTO，就这。
     * UserLoginCmd就不需要单独定义一个 Form。
     */
    @NotNull
    private UserRegisterForm form;

}
