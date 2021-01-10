package com.amos.think.user;

import com.alibaba.cola.catchlog.CatchAndLog;
import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.amos.think.api.IUserService;
import com.amos.think.dto.UserModifyCmd;
import com.amos.think.dto.UserRegisterCmd;
import com.amos.think.dto.data.UserVO;
import com.amos.think.dto.query.UserListByNameQuery;
import com.amos.think.dto.query.UserLoginQuery;
import com.amos.think.user.executor.UserModifyCmdExe;
import com.amos.think.user.executor.UserRegisterCmdExe;
import com.amos.think.user.executor.query.UserListByNameQueryExe;
import com.amos.think.user.executor.query.UserLoginQueryExe;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
    private UserRegisterCmdExe userRegisterCmdExe;
    @Resource
    private UserModifyCmdExe userModifyCmdExe;
    @Resource
    private UserLoginQueryExe userLoginQueryExe;
    @Resource
    private UserListByNameQueryExe userListByNameQueryExe;

    @Override
    public Response register(UserRegisterCmd cmd) {

        return userRegisterCmdExe.execute(cmd);
    }

    @Override
    public Response modify(UserModifyCmd cmd) {

        return userModifyCmdExe.execute(cmd);
    }

    @Override
    public SingleResponse<UserVO> login(UserLoginQuery query) {

        return userLoginQueryExe.execute(query);
    }

    @Override
    public MultiResponse<UserVO> listByName(UserListByNameQuery query) {

        return userListByNameQueryExe.execute(query);
    }

}
