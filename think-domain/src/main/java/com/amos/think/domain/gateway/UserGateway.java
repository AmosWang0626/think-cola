package com.amos.think.domain.gateway;

import com.amos.think.domain.user.UserEntity;
import com.amos.think.dto.query.UserListByParamQuery;

import java.util.List;

/**
 * User Gateway
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/1/8
 */
public interface UserGateway {

    /**
     * 保存用户
     *
     * @param userEntity User Domain
     * @return 用户实体
     */
    UserEntity save(UserEntity userEntity);

    /**
     * 获取用户信息
     *
     * @param id 用户ID
     * @return 用户实体
     */
    UserEntity findById(Long id);

    /**
     * 根据条件查询
     *
     * @param query 用户名等
     * @return List 用户实体
     */
    List<UserEntity> findByParam(UserListByParamQuery query);

    /**
     * 获取密码信息
     *
     * @param username 用户名
     * @return 密码
     */
    UserEntity findPasswordInfo(String username);

    /**
     * 判断用户名是否已存在
     *
     * @param userId   用户ID
     * @param username 用户名
     * @return true-已存在
     */
    Boolean checkByUsername(Long userId, String username);

}
