package com.amos.think.common.api;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * DESCRIPTION: BaseEntity
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/1/9
 */
@Getter
@Setter
@MappedSuperclass
@Accessors(chain = true)
@Where(clause = "DELETE_FLAG=0")
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseDO {

    @Id
    @GeneratedValue(generator = "uuid-self")
    @GenericGenerator(name = "uuid-self", strategy = "uuid2")
    private String id;

    @CreatedDate
    private LocalDateTime createTime;

    @CreatedBy
    private String creator;

    @LastModifiedDate
    private LocalDateTime modifyTime;

    @LastModifiedBy
    private String modifier;

    @Column(name = "DELETE_FLAG", nullable = false)
    private Boolean deleteFlag;

    @PrePersist
    public void prePersist() {
        deleteFlag = false;
    }

    @PreUpdate
    public void preUpdate() {
        if (deleteFlag == null) {
            deleteFlag = false;
        }
    }

}