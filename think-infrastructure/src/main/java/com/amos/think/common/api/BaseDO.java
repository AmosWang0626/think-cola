package com.amos.think.common.api;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * BaseEntity
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/1/9
 */
@Getter
@Setter
@Accessors(chain = true)
public abstract class BaseDO {

    private Long id;

    private String creator;

    private LocalDateTime gmtCreate;

    private String modifier;

    private LocalDateTime gmtModify;

    private Boolean deleteFlag;

}