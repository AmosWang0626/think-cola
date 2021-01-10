package com.amos.think.validator;

import com.alibaba.cola.exception.Assert;
import com.amos.think.dto.co.UserRegisterCO;
import org.apache.commons.lang3.StringUtils;

/**
 * DESCRIPTION: UserValidator
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/1/9
 */
public class UserValidator {

    public static void checkUserRegister(UserRegisterCO co) {
        checkUsername(co);
        checkPassword(co);
    }

    private static void checkUsername(UserRegisterCO co) {
        Assert.isFalse(StringUtils.isBlank(co.getUsername()), "用户名不能为空");
    }

    private static void checkPassword(UserRegisterCO co) {
        Assert.isFalse(StringUtils.isBlank(co.getId()) && StringUtils.isBlank(co.getPassword()), "密码不能为空");
    }

}
