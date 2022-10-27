package com.amos.think.test;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.fastjson.JSON;
import com.amos.think.api.IUserService;
import com.amos.think.common.exception.ThinkBizException;
import com.amos.think.dto.UserModifyCmd;
import com.amos.think.dto.UserRegisterCmd;
import com.amos.think.dto.data.ErrorCode;
import com.amos.think.dto.data.UserVO;
import com.amos.think.dto.query.UserListByParamQuery;
import com.amos.think.dto.query.UserLoginQuery;
import lombok.extern.slf4j.Slf4j;
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
import java.util.Objects;
import java.util.UUID;

/**
 * UserServiceTest
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/1/9
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserServiceTest {

    @Autowired
    private IUserService userService;

    private static final String username = "AMOS_" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    private static final String password = "666666";
    private static Long id = null;

    @Before
    public void setUp() {
        log.info("test username is [" + username + "]");
    }

    @Test
    public void user_1_Register() {
        //1.prepare
        UserRegisterCmd registerCmd = new UserRegisterCmd(username, password);
        registerCmd.setName("amos.wang");
        registerCmd.setPhoneNo("18907378888");
        registerCmd.setGender(1);
        registerCmd.setBirthday(LocalDate.of(2000, 1, 1));
        registerCmd.setDescription("https://amos.wang/");

        //2.execute
        UserVO register = userService.register(registerCmd);

        //3.assert
        Assert.assertTrue(Objects.nonNull(register.getId()));

        id = register.getId();
    }

    @Test
    public void user_2_RegisterByRepeatUsername() {
        //1.prepare
        UserRegisterCmd registerCmd = new UserRegisterCmd(username, password);

        //2.execute
        try {
            userService.register(registerCmd);
        } catch (ThinkBizException e) {
            Assert.assertEquals(ErrorCode.B_USER_USERNAME_REPEAT.getErrCode(), e.getErrCode());
        }
    }

    @Test
    public void user_3_Login() {
        //1.prepare
        UserLoginQuery userLoginQuery = new UserLoginQuery();
        userLoginQuery.setUsername(username);
        userLoginQuery.setPassword(password);

        //2.execute
        userService.login(userLoginQuery);
    }

    @Test
    public void user_4_Modify() {
        //1.prepare
        UserModifyCmd userModify = new UserModifyCmd(id, username);
        userModify.setName("小道远");
        userModify.setPhoneNo("189****8888");
        userModify.setGender(0);
        userModify.setBirthday(LocalDate.of(2000, 6, 26));
        userModify.setDescription("https://github.com/AmosWang0626");

        //2.execute
        UserVO userVO = userService.modify(userModify);

        //3.assert error
        Assert.assertTrue(Objects.nonNull(userVO));
    }

    @Test
    public void user_5_listByName() {
        //1.prepare
        UserListByParamQuery query = UserListByParamQuery.builder().build();

        //2.execute
        MultiResponse<UserVO> response = userService.listByName(query);

        System.out.println(JSON.toJSONString(response));

        //3.assert error
        Assert.assertTrue(response.isSuccess());
    }

}
