package com.amos.think.gateway.impl.database.mapper;

import com.amos.think.domain.user.model.UserEntity;
import com.amos.think.dto.query.UserListByNameQuery;
import com.amos.think.gateway.impl.database.dataobject.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

/**
 * User Mapper
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/1/8
 */
@Mapper
public interface UserMapper {

    int insert(UserDO userDO);

    int update(UserDO userDO);

    Optional<UserDO> findById(Long id);

    UserDO findPasswordInfo(String username);

    UserDO findByUsername(String username);

    List<UserEntity> findByName(UserListByNameQuery query);

    Boolean existByUsername(@Param("userId") Long userId, @Param("username") String username);

}
