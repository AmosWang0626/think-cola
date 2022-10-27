package com.amos.think.gateway.impl;

import com.amos.think.common.exception.ThinkBizException;
import com.amos.think.convertor.UserConvertor;
import com.amos.think.domain.gateway.UserGateway;
import com.amos.think.domain.user.UserEntity;
import com.amos.think.domain.user.UserPassword;
import com.amos.think.dto.data.ErrorCode;
import com.amos.think.dto.query.UserListByParamQuery;
import com.amos.think.gateway.impl.database.dataobject.UserDO;
import com.amos.think.gateway.impl.database.dataobject.UserInfoDO;
import com.amos.think.gateway.impl.database.mapper.UserInfoMapper;
import com.amos.think.gateway.impl.database.mapper.UserMapper;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * UserGatewayImpl
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/1/8
 */
@Component("userGateway")
public class UserGatewayImpl implements UserGateway {

    @Resource
    private UserMapper userMapper;
    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public UserEntity save(UserEntity userEntity) {
        // 新增
        if (Objects.isNull(userEntity.getId())) {
            return addUser(userEntity);
        }

        // 修改
        return modifyUser(userEntity);
    }

    @Override
    public UserEntity findById(Long id) {
        Optional<UserDO> findById = userMapper.selectById(id);
        if (!findById.isPresent()) {
            throw new ThinkBizException(ErrorCode.B_USER_UNDEFINED);
        }

        UserDO userDO = findById.get();
        UserInfoDO userInfoDO = userInfoMapper.findById(userDO.getInfoId());

        return UserConvertor.toEntity(userDO, userInfoDO);
    }

    @Override
    public List<UserEntity> findByParam(UserListByParamQuery query) {
        List<UserEntity> entities = new ArrayList<>();
        userMapper.selectByParam(query).forEach(userDO -> {
            UserInfoDO userInfoDO = userInfoMapper.findById(userDO.getInfoId());
            entities.add(UserConvertor.toEntity(userDO, userInfoDO));
        });
        return entities;
    }

    @Override
    public UserEntity findPasswordInfo(String username) {
        String password = userMapper.selectPassword(username);
        if (Objects.isNull(password)) {
            return null;
        }

        UserEntity userEntity = new UserEntity();
        userEntity.setPassword(new UserPassword(new UserPassword.EncryptPassword(password)));
        return userEntity;
    }

    @Override
    public Boolean checkByUsername(Long userId, String username) {
        return userMapper.existByUsername(userId, username);
    }

    /**
     * 新增用户
     */
    private UserEntity addUser(UserEntity userEntity) {
        // 初始化用户信息
        ImmutablePair<UserDO, UserInfoDO> pair = UserConvertor.toAddUserDO(userEntity);
        UserDO userDO = pair.getLeft();
        UserInfoDO userInfoDO = pair.getRight();

        // 1. 先保存用户信息
        int insert = userInfoMapper.insert(userInfoDO);
        if (insert < 1) {
            throw new PersistenceException("保存用户信息异常");
        }

        // 2. 获取 userInfoId 关联 userDO
        userDO.setInfoId(userInfoDO.getId());
        insert = userMapper.insert(userDO);
        if (insert < 1) {
            throw new PersistenceException("保存用户异常");
        }

        return UserConvertor.toEntity(userDO, userInfoDO);
    }

    /**
     * 修改用户
     */
    private UserEntity modifyUser(UserEntity userEntity) {
        Optional<UserDO> findById = userMapper.selectById(userEntity.getId());
        if (!findById.isPresent()) {
            throw new ThinkBizException(ErrorCode.B_USER_UNDEFINED);
        }

        UserDO userDO = findById.get();
        UserInfoDO userInfoDO = userInfoMapper.findById(userDO.getInfoId());

        // 更新用户信息
        UserConvertor.toModifyUserDO(userEntity, userDO, userInfoDO);

        // 1. 先保存userInfoDO
        int update = userInfoMapper.update(userInfoDO);
        if (update < 1) {
            throw new PersistenceException("更新用户信息异常");
        }

        // 2. 再保存userDO
        userDO.setGmtModify(LocalDateTime.now());
        update = userMapper.update(userDO);
        if (update < 1) {
            throw new PersistenceException("更新用户异常");
        }

        return UserConvertor.toEntity(userDO, userInfoDO);
    }

}
