package com.amos.think.convertor;

import com.amos.think.domain.user.model.UserEntity;
import com.amos.think.dto.co.UserRegisterCO;
import com.amos.think.dto.data.UserVO;
import com.amos.think.gateway.impl.database.UserDO;

/**
 * DESCRIPTION: UserConvertor
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

    public static UserDO toDataObject(UserEntity userEntity) {
        UserDO userDO = new UserDO();
        userDO.setId(userEntity.getId());
        userDO.setUsername(userEntity.getUsername());
        userDO.setPassword(userEntity.getPassword());
        userDO.setSalt(userEntity.getSalt());
        userDO.setName(userEntity.getName());
        userDO.setPhoneNo(userEntity.getPhoneNo());
        userDO.setGender(userEntity.getGender());
        userDO.setBirthday(userEntity.getBirthday());
        userDO.setDescription(userEntity.getDescription());

        return userDO;
    }

    public static void mergeDataObject(UserEntity userEntity, UserDO userDO) {
        userDO.setUsername(userEntity.getUsername());
        userDO.setName(userEntity.getName());
        userDO.setPhoneNo(userEntity.getPhoneNo());
        userDO.setGender(userEntity.getGender());
        userDO.setBirthday(userEntity.getBirthday());
        userDO.setDescription(userEntity.getDescription());
    }

    public static UserVO toValueObject(UserDO userDO) {
        UserVO userVO = new UserVO();
        userVO.setId(userDO.getId());
        userVO.setUsername(userDO.getUsername());
        userVO.setName(userDO.getName());
        userVO.setPhoneNo(userDO.getPhoneNo());
        userVO.setGender(userDO.getGender());
        userVO.setBirthday(userDO.getBirthday());
        userVO.setDescription(userDO.getDescription());

        return userVO;
    }

}
