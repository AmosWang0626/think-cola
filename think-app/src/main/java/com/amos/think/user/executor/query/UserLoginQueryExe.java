package com.amos.think.user.executor.query;

import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.amos.think.common.util.DesSecretUtil;
import com.amos.think.domain.user.gateway.UserGateway;
import com.amos.think.domain.user.model.UserEntity;
import com.amos.think.dto.data.ErrorCode;
import com.amos.think.dto.query.UserLoginQuery;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

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

    public Response execute(UserLoginQuery query) {
        UserEntity byUserName = userGateway.findPasswordInfo(query.getUsername());
        if (byUserName == null) {
            return SingleResponse.buildFailure(ErrorCode.B_USER_passwordError.getErrCode(), ErrorCode.B_USER_passwordError.getErrDesc());
        }

        String encryptPwd = DesSecretUtil.encrypt(query.getPassword(), byUserName.getSalt());
        if (!byUserName.getPassword().equals(encryptPwd)) {
            return SingleResponse.buildFailure(ErrorCode.B_USER_passwordError.getErrCode(), ErrorCode.B_USER_passwordError.getErrDesc());
        }

        return Response.buildSuccess();
    }

}
