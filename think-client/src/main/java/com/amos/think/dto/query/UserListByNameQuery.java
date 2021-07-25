package com.amos.think.dto.query;

import com.alibaba.cola.dto.Query;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 根据用户名称查询用户
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/1/8
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class UserListByNameQuery extends Query {

    private String name;

}
