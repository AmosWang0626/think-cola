package com.amos.think.user.executor;

import com.alibaba.cola.dto.Response;
import com.amos.think.convertor.UserConvertor;
import com.amos.think.domain.user.gateway.UserGateway;
import com.amos.think.dto.UserModifyCmd;
import com.amos.think.dto.clientobject.UserModifyCO;
import com.amos.think.dto.data.ErrorCode;
import com.amos.think.gateway.impl.database.mapper.UserMapper;
import com.amos.think.user.validator.UserValidator;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * DESCRIPTION: UserAddCmdExe
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/1/10
 */
@Component
public class UserModifyCmdExe {

    @Resource
    private UserMapper userMapper;
    @Resource
    private UserGateway userGateway;

    public Response execute(UserModifyCmd cmd) {
        UserModifyCO userModify = cmd.getUserModify();

        UserValidator.checkUserModify(userModify);

        // check 用户名是否重复
        if (userMapper.existUsername(userModify.getId(), userModify.getUsername())) {
            return Response.buildFailure(ErrorCode.B_USER_usernameRepeat.getErrCode(),
                    ErrorCode.B_USER_usernameRepeat.getErrDesc());
        }

        userGateway.save(UserConvertor.toEntity(userModify));

        return Response.buildSuccess();
    }

}
