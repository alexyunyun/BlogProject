package com.yunyun.blog.repository;

import com.yunyun.blog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 旋木頵頵
 * @date 2021/2/10 13:34
 */
public interface UserRepository extends JpaRepository<User,Integer> {
}
