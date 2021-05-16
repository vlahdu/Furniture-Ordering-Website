package com.fow.demo.controller;

import com.fow.demo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @RequestMapping("/{id}")
    public String projectId(@PathVariable("id") long id, Model model){
        model.addAttribute("project",projectService.findById(id));
        return "/project/show";
    }
}
