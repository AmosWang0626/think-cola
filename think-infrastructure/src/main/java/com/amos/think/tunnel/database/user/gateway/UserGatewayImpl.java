package com.amos.think.tunnel.database.user.gateway;

import com.amos.think.common.util.DesSecretUtil;
import com.amos.think.common.util.RandomUtil;
import com.amos.think.convertor.UserConvertor;
import com.amos.think.domain.user.gateway.UserGateway;
import com.amos.think.domain.user.model.User;
import com.amos.think.tunnel.database.user.UserDO;
import com.amos.think.tunnel.database.user.repository.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * DESCRIPTION: UserGatewayImpl
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/1/8
 */
@Component("userGateway")
public class UserGatewayImpl implements UserGateway {

    @Resource
    private UserRepository userRepository;

    @Override
    public void save(User user) {
        UserDO userDO = null;
        if (StringUtils.isNotBlank(user.getId())) {
            Optional<UserDO> byId = userRepository.findById(user.getId());
            if (byId.isPresent()) {

                // 更新
                userDO = byId.get();
                UserConvertor.merge(user, userDO);
            }
        }

        if (userDO == null) {
            // 生成密码盐
            String salt = RandomUtil.generateLetterString(8);
            String encryptPassword = DesSecretUtil.encrypt(user.getPassword(), salt);
            user.setSalt(salt);
            user.setPassword(encryptPassword);

            // 新增
            userDO = UserConvertor.toDataObject(user);
        }

        userRepository.save(userDO);
    }

}
