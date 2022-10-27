package com.amos.think.user.command;

import com.amos.think.common.exception.ThinkBizException;
import com.amos.think.domain.gateway.UserGateway;
import com.amos.think.domain.user.UserEntity;
import com.amos.think.dto.UserModifyCmd;
import com.amos.think.dto.data.ErrorCode;
import com.amos.think.dto.data.UserVO;
import com.amos.think.user.assembler.UserAssembler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * UserAddCmdExe
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/1/10
 */
@Component
public class UserModifyCmdExe {

    @Resource
    private UserGateway userGateway;

    public UserVO execute(UserModifyCmd cmd) {
        // check 用户名是否重复
        if (userGateway.checkByUsername(cmd.getId(), cmd.getUsername())) {
            throw new ThinkBizException(ErrorCode.B_USER_USERNAME_REPEAT);
        }

        UserEntity userEntity = userGateway.save(UserAssembler.toEntity(cmd));
        return UserAssembler.toValueObject(userEntity);
    }

}
