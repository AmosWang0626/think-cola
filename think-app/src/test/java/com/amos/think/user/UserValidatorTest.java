package com.amos.think.user;

import com.amos.think.dto.UserRegisterCmd;
import org.junit.Test;

public class UserValidatorTest {

    @Test
    public void testValidation() {
        new UserRegisterCmd("amos", "");
    }
}
