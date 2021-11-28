package com.amos.think.user.command.query;

import com.alibaba.cola.dto.MultiResponse;
import com.amos.think.domain.gateway.UserGateway;
import com.amos.think.domain.user.UserEntity;
import com.amos.think.dto.data.UserVO;
import com.amos.think.dto.query.UserListByParamQuery;
import com.amos.think.user.assembler.UserAssembler;
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
public class UserListByParamQueryExe {

    @Resource
    private UserGateway userGateway;

    public MultiResponse<UserVO> execute(UserListByParamQuery query) {
        List<UserEntity> userEntities = userGateway.findByParam(query);
        List<UserVO> userVOList = userEntities.stream()
                .map(UserAssembler::toValueObject)
                .collect(Collectors.toList());

        return MultiResponse.of(userVOList);
    }

}
