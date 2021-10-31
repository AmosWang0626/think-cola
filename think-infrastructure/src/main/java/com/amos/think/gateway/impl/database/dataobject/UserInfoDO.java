package com.amos.think.gateway.impl.database.dataobject;

import lombok.Data;

import java.time.LocalDate;

/**
 * 模块名称: think
 * 模块描述: UserInfoDO
 *
 * @author amos.wang
 * @date 2021/2/5 13:48
 */
@Data
public class UserInfoDO {

    private Long id;

    private String phoneNo;

    private Integer gender;

    private LocalDate birthday;

    private String description;

}
