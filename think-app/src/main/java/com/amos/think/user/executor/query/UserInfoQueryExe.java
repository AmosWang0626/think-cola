package com.amos.think.user.executor.query;

import com.alibaba.cola.dto.SingleResponse;
import com.amos.think.convertor.UserConvertor;
import com.amos.think.domain.user.gateway.UserGateway;
import com.amos.think.domain.user.model.UserEntity;
import com.amos.think.dto.data.ErrorCode;
import com.amos.think.dto.data.UserVO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * 用户信息查询
 *
 * @author daoyuan
 * @date 2021/2/14 23:27
 */
@Component
public class UserInfoQueryExe {

    @Resource
    private UserGateway userGateway;

    public SingleResponse<UserVO> execute(String username) {
        UserEntity userEntity = userGateway.findByUsername(username);
        if (Objects.isNull(userEntity)) {
            return SingleResponse.buildFailure(
                    ErrorCode.B_USER_usernameError.getErrCode(), ErrorCode.B_USER_usernameError.getErrDesc());
        }

        return SingleResponse.of(UserConvertor.toValueObject(userEntity));
    }

}
