package com.amos.think.user.executor.query;

import com.alibaba.cola.dto.SingleResponse;
import com.amos.think.common.util.DesSecretUtil;
import com.amos.think.convertor.UserConvertor;
import com.amos.think.dto.query.UserLoginQuery;
import com.amos.think.dto.data.ErrorCode;
import com.amos.think.dto.data.UserVO;
import com.amos.think.gateway.impl.database.dataobject.UserDO;
import com.amos.think.gateway.impl.database.mapper.UserMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * DESCRIPTION: UserListByNameQueryExe
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/1/10
 */
@Component
public class UserLoginQueryExe {

    @Resource
    private UserMapper userMapper;

    public SingleResponse<UserVO> execute(UserLoginQuery query) {
        UserDO byUserName = userMapper.getByUserName(query.getUsername());
        if (byUserName == null) {
            return SingleResponse.buildFailure(ErrorCode.B_USER_passwordError.getErrCode(), ErrorCode.B_USER_passwordError.getErrDesc());
        }

        String encryptPwd = DesSecretUtil.encrypt(query.getPassword(), byUserName.getSalt());
        if (!byUserName.getPassword().equals(encryptPwd)) {
            return SingleResponse.buildFailure(ErrorCode.B_USER_passwordError.getErrCode(), ErrorCode.B_USER_passwordError.getErrDesc());
        }

        return SingleResponse.of(UserConvertor.toValueObject(byUserName));
    }

}
