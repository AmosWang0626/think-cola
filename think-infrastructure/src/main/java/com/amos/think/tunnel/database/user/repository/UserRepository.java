package com.amos.think.tunnel.database.user.repository;

import com.amos.think.tunnel.database.user.UserDO;
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
