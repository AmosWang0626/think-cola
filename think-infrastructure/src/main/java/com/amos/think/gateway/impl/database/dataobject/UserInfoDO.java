package com.amos.think.gateway.impl.database.dataobject;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * 模块名称: think
 * 模块描述: UserInfoDO
 *
 * @author amos.wang
 * @date 2021/2/5 13:48
 */
@Data
@Entity
@Table(name = "org_user_info")
public class UserInfoDO {

    @Id
    @GeneratedValue(generator = "uuid-self")
    @GenericGenerator(name = "uuid-self", strategy = "uuid2")
    private String id;

    @JSONField(serialize = false)
    @OneToOne(mappedBy = "userInfoDO")
    private UserDO userDO;

    private String phoneNo;

    private Integer gender;

    private LocalDate birthday;

    private String description;

}
