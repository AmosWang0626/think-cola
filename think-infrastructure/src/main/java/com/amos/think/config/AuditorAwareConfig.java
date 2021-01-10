package com.amos.think.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

/**
 * 模块描述: 当前用户
 *
 * @author amos.wang
 * @date 2020/12/19 13:11
 */
@Configuration
public class AuditorAwareConfig implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {

        return Optional.of("anonymous");
    }

}
