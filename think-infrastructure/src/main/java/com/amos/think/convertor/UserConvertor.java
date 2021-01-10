package com.amos.think.convertor;

import com.amos.think.domain.user.model.User;
import com.amos.think.dto.data.UserDTO;
import com.amos.think.dto.form.UserRegisterForm;
import com.amos.think.tunnel.database.user.UserDO;

/**
 * DESCRIPTION: UserConvertor
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/1/9
 */
public class UserConvertor {

    public static User toDomain(UserRegisterForm form) {
        User user = new User();
        user.setId(form.getId());
        user.setUsername(form.getUsername());
        user.setPassword(form.getPassword());
        user.setName(form.getName());
        user.setPhoneNo(form.getPhoneNo());
        user.setGender(form.getGender());
        user.setBirthday(form.getBirthday());
        user.setDescription(form.getDescription());

        return user;
    }

    public static UserDO toDataObject(User user) {
        UserDO userDO = new UserDO();
        userDO.setId(user.getId());
        userDO.setUsername(user.getUsername());
        userDO.setPassword(user.getPassword());
        userDO.setSalt(user.getSalt());
        userDO.setName(user.getName());
        userDO.setPhoneNo(user.getPhoneNo());
        userDO.setGender(user.getGender());
        userDO.setBirthday(user.getBirthday());
        userDO.setDescription(user.getDescription());

        return userDO;
    }

    public static void merge(User user, UserDO userDO) {
        userDO.setUsername(user.getUsername());
        userDO.setName(user.getName());
        userDO.setPhoneNo(user.getPhoneNo());
        userDO.setGender(user.getGender());
        userDO.setBirthday(user.getBirthday());
        userDO.setDescription(user.getDescription());
    }

    public static UserDTO convert(UserDO userDO) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userDO.getId());
        userDTO.setUsername(userDO.getUsername());
        userDTO.setName(userDO.getName());
        userDTO.setPhoneNo(userDO.getPhoneNo());
        userDTO.setGender(userDO.getGender());
        userDTO.setBirthday(userDO.getBirthday());
        userDTO.setDescription(userDO.getDescription());

        return userDTO;
    }

}
