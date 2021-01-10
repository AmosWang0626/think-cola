package com.amos.think.app;

import com.amos.think.dto.co.UserRegisterCO;
import com.amos.think.validator.UserValidator;
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
