package com.amos.think.service;

import com.alibaba.cola.catchlog.CatchAndLog;
import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.SingleResponse;
import com.amos.think.api.IUserService;
import com.amos.think.dto.UserModifyCmd;
import com.amos.think.dto.UserRegisterCmd;
import com.amos.think.dto.data.UserVO;
import com.amos.think.dto.query.UserListByParamQuery;
import com.amos.think.dto.query.UserLoginQuery;
import com.amos.think.user.command.UserModifyCmdExe;
import com.amos.think.user.command.UserRegisterCmdExe;
import com.amos.think.user.command.query.UserInfoQueryExe;
import com.amos.think.user.command.query.UserListByParamQueryExe;
import com.amos.think.user.command.query.UserLoginQueryExe;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户相关
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/1/8
 */
@Service
@CatchAndLog
public class UserServiceImpl implements IUserService {

    /**
     * xxxExe 避免 Service 膨胀利器
     */
    @Resource
    private UserRegisterCmdExe userRegisterCmdExe;
    @Resource
    private UserModifyCmdExe userModifyCmdExe;
    @Resource
    private UserLoginQueryExe userLoginQueryExe;
    @Resource
    private UserInfoQueryExe userInfoQueryExe;
    @Resource
    private UserListByParamQueryExe userListByParamQueryExe;

    @Override
    public UserVO register(UserRegisterCmd cmd) {
        return userRegisterCmdExe.execute(cmd);
    }

    @Override
    public UserVO modify(UserModifyCmd cmd) {
        return userModifyCmdExe.execute(cmd);
    }

    @Override
    public void login(UserLoginQuery query) {
        userLoginQueryExe.execute(query);
    }

    @Override
    public SingleResponse<UserVO> getUserInfo(Long id) {
        return userInfoQueryExe.execute(id);
    }

    @Override
    public MultiResponse<UserVO> listByName(UserListByParamQuery query) {
        return userListByParamQueryExe.execute(query);
    }

}
