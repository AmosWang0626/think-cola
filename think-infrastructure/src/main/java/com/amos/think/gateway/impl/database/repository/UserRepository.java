package com.amos.think.gateway.impl.database.repository;

import com.amos.think.gateway.impl.database.dataobject.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * DESCRIPTION: UserRepository
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/1/8
 */
@Repository
public interface UserRepository extends JpaRepository<UserDO, String> {
}
