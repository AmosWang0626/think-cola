package com.amos.think.web;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.amos.think.api.IUserService;
import com.amos.think.dto.UserLoginCmd;
import com.amos.think.dto.UserRegisterCmd;
import com.amos.think.dto.data.UserVO;
import com.amos.think.dto.query.UserListByNameQuery;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * DESCRIPTION: 用户相关
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/1/8
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private IUserService userService;


    @GetMapping(value = "/hello")
    public String hello() {
        return "Hello, welcome to COLA world!";
    }

    @PostMapping(value = "/register")
    public Response register(@RequestBody UserRegisterCmd userRegisterCmd) {

        return userService.register(userRegisterCmd);
    }

    @PostMapping(value = "/login")
    public Response register(@RequestBody UserLoginCmd userLoginCmd) {

        return userService.login(userLoginCmd);
    }

    @GetMapping(value = "/list")
    public MultiResponse<UserVO> list(@RequestParam(required = false) String name) {
        UserListByNameQuery query = new UserListByNameQuery();
        query.setName(name);

        return userService.listByName(query);
    }

}

