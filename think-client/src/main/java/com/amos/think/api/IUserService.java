package com.amos.think.api;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.amos.think.dto.UserModifyCmd;
import com.amos.think.dto.UserRegisterCmd;
import com.amos.think.dto.data.UserVO;
import com.amos.think.dto.query.UserListByNameQuery;
import com.amos.think.dto.query.UserLoginQuery;

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
     * 用户信息修改
     *
     * @param cmd 用户信息修改请求
     * @return Response
     */
    Response modify(UserModifyCmd cmd);

    /**
     * 用户登录
     *
     * @param query 用户登录请求
     * @return Response
     */
    Response login(UserLoginQuery query);

    /**
     * 获取用户信息
     *
     * @param username 用户名
     * @return 用户信息
     */
    SingleResponse<UserVO> getUserInfo(String username);

    /**
     * 根据用户名称查询
     *
     * @param query 用户查询请求
     * @return MultiResponse
     */
    MultiResponse<UserVO> listByName(UserListByNameQuery query);

}
