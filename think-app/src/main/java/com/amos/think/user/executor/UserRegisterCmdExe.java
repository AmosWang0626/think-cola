package com.amos.think.user.executor;

import com.alibaba.cola.dto.Response;
import com.amos.think.convertor.UserConvertor;
import com.amos.think.domain.user.gateway.UserGateway;
import com.amos.think.dto.UserRegisterCmd;
import com.amos.think.dto.clientobject.UserRegisterCO;
import com.amos.think.dto.data.ErrorCode;
import com.amos.think.user.validator.UserValidator;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * UserAddCmdExe
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/1/10
 */
@Component
public class UserRegisterCmdExe {

    @Resource
    private UserGateway userGateway;

    public Response execute(UserRegisterCmd cmd) {
        UserRegisterCO userRegister = cmd.getUserRegister();

        UserValidator.checkUserRegister(userRegister);

        // check 用户名是否重复
        if (userGateway.checkByUsername(userRegister.getId(), userRegister.getUsername())) {
            return Response.buildFailure(ErrorCode.B_USER_usernameRepeat.getErrCode(),
                    ErrorCode.B_USER_usernameRepeat.getErrDesc());
        }

        userGateway.save(UserConvertor.toEntity(userRegister));

        return Response.buildSuccess();
    }

}
