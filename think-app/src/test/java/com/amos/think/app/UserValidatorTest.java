package com.amos.think.app;

import com.amos.think.dto.form.UserRegisterForm;
import com.amos.think.validator.UserValidator;
import org.junit.Test;

public class UserValidatorTest {

    @Test
    public void testValidation() {
        UserRegisterForm userRegisterForm = new UserRegisterForm();
        userRegisterForm.setId("123456");
        userRegisterForm.setUsername("amos");
        userRegisterForm.setPassword("");

        UserValidator.checkUserForm(userRegisterForm);
    }
}
