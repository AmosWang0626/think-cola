package com.amos.think.dto.form;

import com.amos.think.dto.data.UserDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * DESCRIPTION: User Register Form
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/1/8
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserRegisterForm extends UserDTO {

    private String password;

}
