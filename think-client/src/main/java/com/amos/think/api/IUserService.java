package com.amos.think.api;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.amos.think.dto.UserLoginCmd;
import com.amos.think.dto.UserRegisterCmd;
import com.amos.think.dto.data.UserDTO;
import com.amos.think.dto.query.UserListByNameQuery;

/**
 * DESCRIPTION: 用户相关
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/1/8
 */
public interface IUserService {

    /**
     * 注册用户
     *
     * @param cmd 用户注册请求
     * @return Response
     */
    Response register(UserRegisterCmd cmd);

    /**
     * 用户登录
     *
     * @param cmd 用户登录请求
     * @return Response
     */
    SingleResponse<UserDTO> login(UserLoginCmd cmd);

    /**
     * 根据用户名称查询
     *
     * @param query 用户查询请求
     * @return MultiResponse
     */
    MultiResponse<UserDTO> listByName(UserListByNameQuery query);

}
