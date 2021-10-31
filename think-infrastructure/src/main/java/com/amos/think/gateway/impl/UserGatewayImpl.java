package com.amos.think.gateway.impl;

import com.amos.think.common.util.DesSecretUtil;
import com.amos.think.common.util.RandomUtil;
import com.amos.think.convertor.UserConvertor;
import com.amos.think.domain.user.gateway.UserGateway;
import com.amos.think.domain.user.model.UserEntity;
import com.amos.think.dto.query.UserListByNameQuery;
import com.amos.think.gateway.impl.database.dataobject.UserDO;
import com.amos.think.gateway.impl.database.dataobject.UserInfoDO;
import com.amos.think.gateway.impl.database.mapper.UserInfoMapper;
import com.amos.think.gateway.impl.database.mapper.UserMapper;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
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
    public void save(UserEntity userEntity) {
        // 新增
        if (Objects.isNull(userEntity.getId())) {
            addUser(userEntity);
            return;
        }

        // 修改
        modifyUser(userEntity);
    }

    @Override
    public UserEntity findPasswordInfo(String username) {
        return UserConvertor.toEntity(userMapper.findPasswordInfo(username));
    }

    @Override
    public UserEntity findByUsername(String username) {
        UserDO userDO = userMapper.findByUsername(username);
        UserInfoDO userInfoDO = null;
        if (Objects.nonNull(userDO)) {
            userInfoDO = userInfoMapper.findById(userDO.getInfoId());
        }

        return UserConvertor.toEntity(userDO, userInfoDO);
    }

    @Override
    public List<UserEntity> findByName(UserListByNameQuery query) {
        return userMapper.findByName(query);
    }

    @Override
    public Boolean checkByUsername(Long userId, String username) {
        return userMapper.existByUsername(userId, username);
    }

    /**
     * 新增用户
     */
    private void addUser(UserEntity userEntity) {
        // 生成密码盐
        String salt = RandomUtil.generateLetterString(8);
        String encryptPassword = DesSecretUtil.encrypt(userEntity.getPassword(), salt);
        userEntity.setSalt(salt);
        userEntity.setPassword(encryptPassword);

        // 初始化用户信息
        ImmutablePair<UserDO, UserInfoDO> pair = UserConvertor.toAddUserDO(userEntity);
        UserDO userDO = pair.getLeft();
        UserInfoDO userInfoDO = pair.getRight();

        // 1. 先保存用户信息
        userInfoMapper.insert(userInfoDO);

        // 2. 获取 userInfoId 关联 userDO
        userDO.setInfoId(userInfoDO.getId());
        userDO.setDeleteFlag(false);
        userDO.setGmtCreate(LocalDateTime.now());
        userMapper.insert(userDO);
    }

    /**
     * 修改用户
     */
    private void modifyUser(UserEntity userEntity) {
        Optional<UserDO> findById = userMapper.findById(userEntity.getId());
        if (!findById.isPresent()) {
            throw new RuntimeException("用户ID错误!");
        }

        UserDO userDO = findById.get();
        UserInfoDO userInfoDO = userInfoMapper.findById(userDO.getInfoId());

        // 更新用户信息
        UserConvertor.toModifyUserDO(userEntity, userDO, userInfoDO);

        // 1. 先保存userInfoDO
        userInfoMapper.update(userInfoDO);

        // 2. 再保存userDO
        userDO.setGmtModify(LocalDateTime.now());
        userMapper.update(userDO);
    }

}
