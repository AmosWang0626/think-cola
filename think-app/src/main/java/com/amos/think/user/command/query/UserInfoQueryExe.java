package com.amos.think.user.command.query;

import com.alibaba.cola.dto.SingleResponse;
import com.amos.think.common.exception.ThinkBizException;
import com.amos.think.domain.gateway.UserGateway;
import com.amos.think.domain.user.UserEntity;
import com.amos.think.dto.data.ErrorCode;
import com.amos.think.dto.data.UserVO;
import com.amos.think.user.assembler.UserAssembler;
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

    public SingleResponse<UserVO> execute(Long id) {
        UserEntity userEntity = userGateway.findById(id);
        if (Objects.isNull(userEntity)) {
            throw new ThinkBizException(ErrorCode.B_USER_UNDEFINED);
        }

        return SingleResponse.of(UserAssembler.toValueObject(userEntity));
    }

}
