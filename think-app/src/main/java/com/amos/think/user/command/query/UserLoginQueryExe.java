package com.amos.think.user.command.query;

import com.amos.think.common.exception.ThinkBizException;
import com.amos.think.domain.gateway.UserGateway;
import com.amos.think.domain.user.UserEntity;
import com.amos.think.dto.data.ErrorCode;
import com.amos.think.dto.query.UserLoginQuery;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * UserListByNameQueryExe
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/1/10
 */
@Component
public class UserLoginQueryExe {

    @Resource
    private UserGateway userGateway;

    public void execute(UserLoginQuery query) {
        UserEntity userEntity = userGateway.findPasswordInfo(query.getUsername());
        if (Objects.isNull(userEntity)) {
            throw new ThinkBizException(ErrorCode.B_USER_PASSWORD_ERROR);
        }

        // 校验密码是否正确
        if (!userEntity.getPassword().isCorrect(query.getPassword())) {
            throw new ThinkBizException(ErrorCode.B_USER_PASSWORD_ERROR);
        }
    }

}
