package com.amos.think.gateway.impl.database.dataobject;

import com.amos.think.common.api.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * DESCRIPTION: UserDO
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/1/8
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "org_user", indexes = {
        @Index(columnList = "username")
})
public class UserDO extends BaseDO {

    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 密码盐
     */
    private String salt;

    /**
     * 姓名（较常用，故放在用户主表）
     */
    private String name;

    private String phoneNo;

    private Integer gender;

    private LocalDate birthday;

    private String description;

}
