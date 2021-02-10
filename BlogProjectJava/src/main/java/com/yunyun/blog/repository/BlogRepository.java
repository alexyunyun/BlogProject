package com.yunyun.blog.repository;

import com.yunyun.blog.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 旋木頵頵
 * @date 2021/2/10 13:22
 */
public interface BlogRepository extends JpaRepository<Blog,Integer> {
}
