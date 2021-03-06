package com.yunyun.blog.controller;

import com.yunyun.blog.entity.Project;
import com.yunyun.blog.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 旋木頵頵
 * @date 2021/3/6 8:25
 */

@RestController
@RequestMapping("/project")
public class ProjectHandler {

    private ProjectRepository projectRepository;

    @Autowired
    public void setProjectRepository(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @GetMapping("/findAll")
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @GetMapping("/findProject/{page}/{size}")
    public Page<Project> findAllByPage(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        System.out.println("执行了查找项目方法");
        return projectRepository.findAll(pageable);
    }

    @GetMapping("/findById/{id}")
    public Project findById(@PathVariable("id") Integer id) {
        if (projectRepository.findById(id).isPresent()){
            return projectRepository.findById(id).get();
        }
        return null;
    }

    @PostMapping("/save")
    public String save(@RequestBody Project project) {
        Project result = projectRepository.save(project);
        if (result != null) {
            return "success";
        }
        return "fail";
    }

    @PostMapping("/update")
    public String update(@RequestBody Project project) {
        if (save(project) != null) {
            return "success";
        }
        return "fail";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        projectRepository.deleteById(id);
        if (projectRepository.findById(id).isPresent()) {
            return "fail";
        }
        return "success";
    }
}

