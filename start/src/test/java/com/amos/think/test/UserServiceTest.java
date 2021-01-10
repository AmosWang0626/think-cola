package com.amos.think.test;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.alibaba.fastjson.JSON;
import com.amos.think.api.IUserService;
import com.amos.think.dto.UserLoginCmd;
import com.amos.think.dto.query.UserListByNameQuery;
import com.amos.think.dto.UserRegisterCmd;
import com.amos.think.dto.data.ErrorCode;
import com.amos.think.dto.data.UserDTO;
import com.amos.think.dto.form.UserRegisterForm;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

/**
 * DESCRIPTION: UserServiceTest
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/1/9
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private IUserService userService;


    @Before
    public void setUp() {

    }

    @Test
    public void userRegister() {
        //1.prepare
        UserRegisterCmd registerCmd = new UserRegisterCmd();

        UserRegisterForm registerForm = new UserRegisterForm();
        registerForm.setId("58c32da2-b69b-44b5-8e65-63d0adbedcf3");
        registerForm.setName("小道远");
        registerForm.setUsername("amos");
        registerForm.setPassword("666666");
        registerForm.setPhoneNo("189****8861");
        registerForm.setGender(1);
        registerForm.setBirthday(LocalDate.of(1996, 6, 26));
        registerForm.setDescription("https://amos.wang/");

        registerCmd.setForm(registerForm);

        //2.execute
        Response response = userService.register(registerCmd);

        //3.assert
        Assert.assertTrue(response.isSuccess());
    }

    @Test
    public void userRegisterByRepeatUsername() {
        //1.prepare
        UserRegisterCmd registerCmd = new UserRegisterCmd();

        UserRegisterForm registerForm = new UserRegisterForm();
        registerForm.setUsername("amos");
        registerForm.setPassword("000000");

        registerCmd.setForm(registerForm);

        //2.execute
        Response response = userService.register(registerCmd);

        //3.assert error
        Assert.assertEquals(ErrorCode.B_USER_usernameRepeat.getErrCode(), response.getErrCode());
    }

    @Test
    public void userLogin() {
        //1.prepare
        UserLoginCmd userLoginCmd = new UserLoginCmd();
        userLoginCmd.setUsername("amos");
        userLoginCmd.setPassword("666666");

        //2.execute
        SingleResponse<UserDTO> response = userService.login(userLoginCmd);

        System.out.println(JSON.toJSONString(response));

        //3.assert success
        Assert.assertTrue(response.isSuccess());
    }

    @Test
    public void listByName() {
        //1.prepare
        UserListByNameQuery query = new UserListByNameQuery();
        query.setName("");

        //2.execute
        MultiResponse<UserDTO> response = userService.listByName(query);

        System.out.println(JSON.toJSONString(response));

        //3.assert error
        Assert.assertTrue(response.isSuccess());
    }

}
