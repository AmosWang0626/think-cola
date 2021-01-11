package com.amos.think.test;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.alibaba.fastjson.JSON;
import com.amos.think.api.IUserService;
import com.amos.think.dto.UserModifyCmd;
import com.amos.think.dto.UserRegisterCmd;
import com.amos.think.dto.clientobject.UserModifyCO;
import com.amos.think.dto.clientobject.UserRegisterCO;
import com.amos.think.dto.data.ErrorCode;
import com.amos.think.dto.data.UserVO;
import com.amos.think.dto.query.UserListByNameQuery;
import com.amos.think.dto.query.UserLoginQuery;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.UUID;

/**
 * DESCRIPTION: UserServiceTest
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/1/9
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserServiceTest {

    @Autowired
    private IUserService userService;

    private static final String username = UUID.randomUUID().toString();
    private static final String password = "666666";

    @Before
    public void setUp() {
        System.out.println("test username is [" + username + "]");
    }

    @Test
    public void user_1_Register() {
        //1.prepare
        UserRegisterCmd registerCmd = new UserRegisterCmd();

        UserRegisterCO registerCO = new UserRegisterCO();
        registerCO.setName("amos.wang");
        registerCO.setUsername(username);
        registerCO.setPassword(password);
        registerCO.setPhoneNo("189****8861");
        registerCO.setGender(1);
        registerCO.setBirthday(LocalDate.of(1996, 6, 26));
        registerCO.setDescription("https://amos.wang/");

        registerCmd.setUserRegister(registerCO);

        //2.execute
        Response response = userService.register(registerCmd);

        //3.assert
        Assert.assertTrue(response.isSuccess());
    }

    @Test
    public void user_2_RegisterByRepeatUsername() {
        //1.prepare
        UserRegisterCmd registerCmd = new UserRegisterCmd();

        UserRegisterCO registerCO = new UserRegisterCO();
        registerCO.setUsername(username);
        registerCO.setPassword(password);

        registerCmd.setUserRegister(registerCO);

        //2.execute
        Response response = userService.register(registerCmd);

        //3.assert error
        Assert.assertEquals(ErrorCode.B_USER_usernameRepeat.getErrCode(), response.getErrCode());
    }

    @Test
    public void user_3_Modify() {
        login();
    }

    private String login() {
        //1.prepare
        UserLoginQuery userLoginQuery = new UserLoginQuery();
        userLoginQuery.setUsername(username);
        userLoginQuery.setPassword(password);

        //2.execute
        SingleResponse<UserVO> response = userService.login(userLoginQuery);

        System.out.println(JSON.toJSONString(response));

        //3.assert success
        Assert.assertTrue(response.isSuccess());

        return response.getData().getId();
    }

    @Test
    public void user_4_Modify() {
        //1.prepare
        String userId = login();

        UserModifyCmd userModify = new UserModifyCmd();

        UserModifyCO userModifyCO = new UserModifyCO();
        userModifyCO.setId(userId);
        userModifyCO.setName("小道远");
        userModifyCO.setUsername(username);
        userModifyCO.setPhoneNo("189----8861");
        userModifyCO.setGender(0);
        userModifyCO.setBirthday(LocalDate.of(1996, 5, 11));
        userModifyCO.setDescription("https://github.com/AmosWang0626");

        userModify.setUserModify(userModifyCO);

        //2.execute
        Response response = userService.modify(userModify);

        //3.assert
        Assert.assertTrue(response.isSuccess());
    }

    @Test
    public void user_5_listByName() {
        //1.prepare
        UserListByNameQuery query = new UserListByNameQuery();
        query.setName(null);

        //2.execute
        MultiResponse<UserVO> response = userService.listByName(query);

        System.out.println(JSON.toJSONString(response));

        //3.assert error
        Assert.assertTrue(response.isSuccess());
    }

}
