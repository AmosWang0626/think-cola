package com.amos.think.dto.query;

import com.alibaba.cola.dto.Query;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 查询用户列表
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/1/8
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class UserListByParamQuery extends Query {

    private static final long serialVersionUID = -2794036665910524477L;

    private String name;

    private String username;

}
