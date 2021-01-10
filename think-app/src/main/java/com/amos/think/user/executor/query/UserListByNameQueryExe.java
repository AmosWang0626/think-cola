package com.amos.think.user.executor.query;

import com.alibaba.cola.dto.MultiResponse;
import com.amos.think.convertor.UserConvertor;
import com.amos.think.dto.data.UserVO;
import com.amos.think.dto.query.UserListByNameQuery;
import com.amos.think.gateway.impl.database.dataobject.UserDO;
import com.amos.think.gateway.impl.database.mapper.UserMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * DESCRIPTION: UserListByNameQueryExe
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/1/10
 */
@Component
public class UserListByNameQueryExe {

    @Resource
    private UserMapper userMapper;

    public MultiResponse<UserVO> execute(UserListByNameQuery query) {
        List<UserDO> userDOList = userMapper.listByName(query);
        List<UserVO> userVOList = userDOList.stream()
                .map(UserConvertor::toValueObject)
                .collect(Collectors.toList());

        return MultiResponse.of(userVOList);
    }

}
