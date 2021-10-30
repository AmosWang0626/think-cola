package com.amos.think.user.executor.query;

import com.alibaba.cola.dto.MultiResponse;
import com.amos.think.convertor.UserConvertor;
import com.amos.think.domain.user.gateway.UserGateway;
import com.amos.think.domain.user.model.UserEntity;
import com.amos.think.dto.data.UserVO;
import com.amos.think.dto.query.UserListByNameQuery;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * UserListByNameQueryExe
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/1/10
 */
@Component
public class UserListByNameQueryExe {

    @Resource
    private UserGateway userGateway;

    public MultiResponse<UserVO> execute(UserListByNameQuery query) {
        List<UserEntity> userEntities = userGateway.findByName(query);
        List<UserVO> userVOList = userEntities.stream()
                .map(UserConvertor::toValueObject)
                .collect(Collectors.toList());

        return MultiResponse.of(userVOList);
    }

}
