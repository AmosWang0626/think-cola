package com.amos.think.user.validator;

import com.alibaba.cola.exception.Assert;
import com.amos.think.dto.clientobject.UserModifyCO;
import com.amos.think.dto.clientobject.UserRegisterCO;
import com.amos.think.dto.data.UserVO;
import org.apache.commons.lang3.StringUtils;

/**
 * DESCRIPTION: UserValidator
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/1/10
 */
public class UserValidator {

    /**
     * 用户注册，用户名、密码都不能为空
     */
    public static void checkUserRegister(UserRegisterCO co) {
        checkUsername(co);
        checkPassword(co);
    }

    /**
     * 用户信息修改用户名不能为空
     */
    public static void checkUserModify(UserModifyCO co) {
        checkUsername(co);
    }

    private static void checkUsername(UserVO co) {
        Assert.isFalse(StringUtils.isBlank(co.getUsername()), "用户名不能为空");
    }

    private static void checkPassword(UserRegisterCO co) {
        Assert.isFalse(StringUtils.isBlank(co.getId()) && StringUtils.isBlank(co.getPassword()), "密码不能为空");
    }

}
