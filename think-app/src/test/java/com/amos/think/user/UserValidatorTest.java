package com.amos.think.user;

import com.amos.think.dto.clientobject.UserRegisterCO;
import com.amos.think.user.validator.UserValidator;
import org.junit.Test;

public class UserValidatorTest {

    @Test
    public void testValidation() {
        UserRegisterCO userRegisterCO = new UserRegisterCO();
        userRegisterCO.setId("123456");
        userRegisterCO.setUsername("amos");
        userRegisterCO.setPassword("");

        UserValidator.checkUserRegister(userRegisterCO);
    }
}
