package com.amos.think.dto;

import com.alibaba.cola.dto.Command;
import com.amos.think.dto.clientobject.UserModifyCO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
 * DESCRIPTION: 新增用户请求
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/1/8
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserModifyCmd extends Command {

    @NotNull
    private UserModifyCO userModify;

}
