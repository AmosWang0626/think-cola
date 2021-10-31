package com.amos.think.domain.user.gateway;

import com.amos.think.domain.user.model.UserEntity;
import com.amos.think.dto.query.UserListByNameQuery;

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
     */
    void save(UserEntity userEntity);

    /**
     * 获取密码信息
     *
     * @param username 用户名
     * @return 密码、密码盐
     */
    UserEntity findPasswordInfo(String username);

    /**
     * 获取用户信息
     *
     * @param username 用户名
     * @return 用户实体
     */
    UserEntity findByUsername(String username);

    /**
     * 根据条件查询
     *
     * @param query 用户名等
     * @return List 用户实体
     */
    List<UserEntity> findByName(UserListByNameQuery query);

    /**
     * 判断用户名是否已存在
     *
     * @param userId   用户ID
     * @param username 用户名
     * @return true-已存在
     */
    Boolean checkByUsername(Long userId, String username);

}
