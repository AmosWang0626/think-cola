package com.amos.think.convertor;

import com.amos.think.domain.user.model.UserEntity;
import com.amos.think.dto.clientobject.UserModifyCO;
import com.amos.think.dto.clientobject.UserRegisterCO;
import com.amos.think.dto.data.UserVO;
import com.amos.think.gateway.impl.database.dataobject.UserDO;
import com.amos.think.gateway.impl.database.dataobject.UserInfoDO;
import org.apache.commons.lang3.tuple.ImmutablePair;

/**
 * UserConvertor
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/1/9
 */
public class UserConvertor {

    public static UserEntity toEntity(UserRegisterCO co) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(co.getId());
        userEntity.setUsername(co.getUsername());
        userEntity.setPassword(co.getPassword());
        userEntity.setName(co.getName());
        userEntity.setPhoneNo(co.getPhoneNo());
        userEntity.setGender(co.getGender());
        userEntity.setBirthday(co.getBirthday());
        userEntity.setDescription(co.getDescription());

        return userEntity;
    }

    public static UserEntity toEntity(UserModifyCO co) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(co.getId());
        userEntity.setUsername(co.getUsername());
        userEntity.setName(co.getName());
        userEntity.setPhoneNo(co.getPhoneNo());
        userEntity.setGender(co.getGender());
        userEntity.setBirthday(co.getBirthday());
        userEntity.setDescription(co.getDescription());

        return userEntity;
    }

    public static UserEntity toEntity(UserDO userDO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userDO.getId());
        userEntity.setUsername(userDO.getUsername());
        userEntity.setPassword(userDO.getPassword());
        userEntity.setSalt(userDO.getSalt());
        userEntity.setName(userDO.getName());

        return userEntity;
    }

    public static UserEntity toEntity(UserDO userDO, UserInfoDO userInfoDO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userDO.getId());
        userEntity.setUsername(userDO.getUsername());
        userEntity.setPassword(userDO.getPassword());
        userEntity.setSalt(userDO.getSalt());
        userEntity.setName(userDO.getName());

        if (userInfoDO != null) {
            userEntity.setPhoneNo(userInfoDO.getPhoneNo());
            userEntity.setGender(userInfoDO.getGender());
            userEntity.setBirthday(userInfoDO.getBirthday());
            userEntity.setDescription(userInfoDO.getDescription());
        }

        return userEntity;
    }

    public static ImmutablePair<UserDO, UserInfoDO> toAddUserDO(UserEntity userEntity) {
        UserDO userDO = new UserDO();
        userDO.setId(userEntity.getId());
        userDO.setUsername(userEntity.getUsername());
        userDO.setPassword(userEntity.getPassword());
        userDO.setSalt(userEntity.getSalt());
        userDO.setName(userEntity.getName());

        // user info
        UserInfoDO userInfoDO = new UserInfoDO();
        userInfoDO.setPhoneNo(userEntity.getPhoneNo());
        userInfoDO.setGender(userEntity.getGender());
        userInfoDO.setBirthday(userEntity.getBirthday());
        userInfoDO.setDescription(userEntity.getDescription());

        return new ImmutablePair<>(userDO, userInfoDO);
    }

    public static void toModifyUserDO(UserEntity userEntity, UserDO userDO, UserInfoDO userInfoDO) {
        userDO.setName(userEntity.getName());
        userDO.setUsername(userEntity.getUsername());

        userInfoDO.setPhoneNo(userEntity.getPhoneNo());
        userInfoDO.setGender(userEntity.getGender());
        userInfoDO.setBirthday(userEntity.getBirthday());
        userInfoDO.setDescription(userEntity.getDescription());
    }

    public static UserVO toValueObject(UserEntity userEntity) {
        UserVO userVO = new UserVO();
        userVO.setId(userEntity.getId());
        userVO.setName(userEntity.getName());
        userVO.setUsername(userEntity.getUsername());
        userVO.setPhoneNo(userEntity.getPhoneNo());
        userVO.setGender(userEntity.getGender());
        userVO.setBirthday(userEntity.getBirthday());
        userVO.setDescription(userEntity.getDescription());

        return userVO;
    }

}
