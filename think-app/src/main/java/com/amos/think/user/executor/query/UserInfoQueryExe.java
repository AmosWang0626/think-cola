package com.amos.think.user.executor.query;

import com.alibaba.cola.dto.SingleResponse;
import com.amos.think.convertor.UserConvertor;
import com.amos.think.dto.data.ErrorCode;
import com.amos.think.dto.data.UserVO;
import com.amos.think.gateway.impl.database.dataobject.UserDO;
import com.amos.think.gateway.impl.database.mapper.UserMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * PROJECT: think
 * DESCRIPTION: 用户信息查询
 *
 * @author daoyuan
 * @date 2021/2/14 23:27
 */
@Component
public class UserInfoQueryExe {

    @Resource
    private UserMapper userMapper;

    public SingleResponse<UserVO> execute(String username) {
        UserDO userDO = userMapper.getUserInfo(username);
        if (Objects.isNull(userDO)) {
            return SingleResponse.buildFailure(
                    ErrorCode.B_USER_usernameError.getErrCode(), ErrorCode.B_USER_usernameError.getErrDesc());
        }

        return SingleResponse.of(UserConvertor.toValueObject(userDO));
    }

}
