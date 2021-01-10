package com.amos.think.service.user;

import com.alibaba.cola.catchlog.CatchAndLog;
import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.amos.think.api.IUserService;
import com.amos.think.common.util.DesSecretUtil;
import com.amos.think.convertor.UserConvertor;
import com.amos.think.domain.user.gateway.UserGateway;
import com.amos.think.dto.UserLoginCmd;
import com.amos.think.dto.UserRegisterCmd;
import com.amos.think.dto.data.ErrorCode;
import com.amos.think.dto.data.UserDTO;
import com.amos.think.dto.form.UserRegisterForm;
import com.amos.think.dto.query.UserListByNameQuery;
import com.amos.think.tunnel.database.user.UserDO;
import com.amos.think.tunnel.database.user.mapper.UserMapper;
import com.amos.think.validator.UserValidator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * DESCRIPTION: 用户相关
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/1/8
 */
@Service("userService")
@CatchAndLog
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private UserGateway userGateway;

    @Override
    public Response register(UserRegisterCmd cmd) {
        UserRegisterForm form = cmd.getForm();

        UserValidator.checkUserForm(cmd.getForm());

        // check 用户名是否重复
        if (userMapper.existUsername(form.getId(), form.getUsername())) {
            return Response.buildFailure(ErrorCode.B_USER_usernameRepeat.getErrCode(),
                    ErrorCode.B_USER_usernameRepeat.getErrDesc());
        }

        userGateway.save(UserConvertor.toDomain(form));

        return Response.buildSuccess();
    }

    @Override
    public SingleResponse<UserDTO> login(UserLoginCmd cmd) {
        UserDO byUserName = userMapper.findByUserName(cmd.getUsername());
        if (byUserName == null) {
            return SingleResponse.buildFailure(ErrorCode.B_USER_passwordError.getErrCode(), ErrorCode.B_USER_passwordError.getErrDesc());
        }

        String encryptPwd = DesSecretUtil.encrypt(cmd.getPassword(), byUserName.getSalt());
        if (!byUserName.getPassword().equals(encryptPwd)) {
            return SingleResponse.buildFailure(ErrorCode.B_USER_passwordError.getErrCode(), ErrorCode.B_USER_passwordError.getErrDesc());
        }

        return SingleResponse.of(UserConvertor.convert(byUserName));
    }

    @Override
    public MultiResponse<UserDTO> listByName(UserListByNameQuery query) {
        List<UserDO> userDOList = userMapper.listByName(query);
        List<UserDTO> userDTOList = userDOList.stream()
                .map(UserConvertor::convert)
                .collect(Collectors.toList());

        return MultiResponse.of(userDTOList);
    }

}
