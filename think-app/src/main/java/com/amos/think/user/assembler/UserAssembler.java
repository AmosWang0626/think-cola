package com.amos.think.user.assembler;

import com.amos.think.domain.user.UserEntity;
import com.amos.think.domain.user.UserName;
import com.amos.think.domain.user.UserPassword;
import com.amos.think.dto.UserModifyCmd;
import com.amos.think.dto.UserRegisterCmd;
import com.amos.think.dto.data.UserVO;

/**
 * User Application层 转换器
 * 用于DTO与实体之间的互转
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/11/27
 */
public class UserAssembler {

    public static UserEntity toEntity(UserRegisterCmd co) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(new UserName(co.getUsername()));
        userEntity.setPassword(new UserPassword(co.getPassword()));
        userEntity.setName(co.getName());
        userEntity.setPhoneNo(co.getPhoneNo());
        userEntity.setGender(co.getGender());
        userEntity.setBirthday(co.getBirthday());
        userEntity.setDescription(co.getDescription());

        return userEntity;
    }

    public static UserEntity toEntity(UserModifyCmd co) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(co.getId());
        userEntity.setUsername(new UserName(co.getUsername()));
        userEntity.setName(co.getName());
        userEntity.setPhoneNo(co.getPhoneNo());
        userEntity.setGender(co.getGender());
        userEntity.setBirthday(co.getBirthday());
        userEntity.setDescription(co.getDescription());

        return userEntity;
    }

    public static UserVO toValueObject(UserEntity userEntity) {
        UserVO userVO = new UserVO();
        userVO.setId(userEntity.getId());
        userVO.setName(userEntity.getName());
        userVO.setUsername(userEntity.getUsername().getName());
        userVO.setPhoneNo(userEntity.getPhoneNo());
        userVO.setGender(userEntity.getGender());
        userVO.setBirthday(userEntity.getBirthday());
        userVO.setDescription(userEntity.getDescription());

        return userVO;
    }

}
