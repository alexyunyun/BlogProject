package com.yunyun.blog.controller;

import com.yunyun.blog.entity.Blog;
import com.yunyun.blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 旋木頵頵
 * @date 2021/2/22 13:34
 */

@RestController
@RequestMapping("/blog")
public class BlogHandler {
    private BlogRepository blogRepository;

    @Autowired
    public void setBlogRepository(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @GetMapping("/findAll")
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @GetMapping("/findBlog/{page}/{size}")
    public Page<Blog> findAllByPage(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        System.out.println("执行了查找博客方法");
        return blogRepository.findAll(pageable);
    }

    @GetMapping("/findById/{id}")
    public Blog findById(@PathVariable("id") Integer id) {
        return blogRepository.findById(id).get();
    }
    @PostMapping("/save")
    public String save(@RequestBody Blog blog) {
        Blog result = blogRepository.save(blog);
        if (result != null) {
            return "success";
        }
        return "fail";
    }
    @PostMapping("/update")
    public String update(@RequestBody Blog blog) {
        if (save(blog) != null){
            return "success";
        }
        return "fail";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
         blogRepository.deleteById(id);
        if (blogRepository.findById(id).isPresent()) {
            return "fail";
        }
        return "success";
    }
}
