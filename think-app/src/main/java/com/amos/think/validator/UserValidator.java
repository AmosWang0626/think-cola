package com.amos.think.validator;

import com.alibaba.cola.exception.Assert;
import com.amos.think.dto.form.UserRegisterForm;
import org.apache.commons.lang3.StringUtils;

/**
 * DESCRIPTION: UserValidator
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/1/9
 */
public class UserValidator {

    public static void checkUserForm(UserRegisterForm form) {
        checkUsername(form);
        checkPassword(form);
    }

    private static void checkUsername(UserRegisterForm form) {
        Assert.isFalse(StringUtils.isBlank(form.getUsername()), "用户名不能为空");
    }

    private static void checkPassword(UserRegisterForm form) {
        Assert.isFalse(StringUtils.isBlank(form.getId()) && StringUtils.isBlank(form.getPassword()), "密码不能为空");
    }

}
