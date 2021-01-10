package com.amos.think.domain.user.gateway;

import com.amos.think.domain.user.model.User;

/**
 * DESCRIPTION: User Gateway
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/1/8
 */
public interface UserGateway {

    /**
     * 保存用户
     *
     * @param user User Domain
     */
    void save(User user);

}
