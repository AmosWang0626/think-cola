package com.amos.think.gateway.impl.database.mapper;

import com.amos.think.gateway.impl.database.dataobject.UserInfoDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * User Info Mapper
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/10/30
 */
@Mapper
public interface UserInfoMapper {

    int insert(UserInfoDO userInfoDO);

    int update(UserInfoDO userInfoDO);

    UserInfoDO findById(Long id);

}
