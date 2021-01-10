package com.amos.think.dto.clientobject;

import com.amos.think.dto.data.UserVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * DESCRIPTION: User Register Client Object
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/1/8
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserRegisterCO extends UserVO {

    private String password;

}
