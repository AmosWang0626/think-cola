package com.amos.think.gateway.impl.database.mapper;

import com.amos.think.dto.query.UserListByNameQuery;
import com.amos.think.gateway.impl.database.dataobject.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * DESCRIPTION: User Mapper
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/1/8
 */
@Mapper
public interface UserMapper {

    UserDO getByUserName(String username);

    List<UserDO> listByName(UserListByNameQuery query);

    Boolean existUsername(@Param("userId") String userId, @Param("username") String username);

}
