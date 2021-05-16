package com.fow.demo.controller;

import com.fow.demo.model.actors.Company;
import com.fow.demo.model.actors.User;
import com.fow.demo.model.projects.Project;
import com.fow.demo.service.CompanyService;
import com.fow.demo.service.ProjectService;
import com.fow.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;
@Controller
@RequestMapping("/buy")
public class BuyController {
    @Autowired
    private ProjectService projectService;
    @Autowired
    private UserService userService;
    @Autowired
    private CompanyService companyService;

    @RequestMapping("/{id}")
    public String projectId(@PathVariable("id") long id,Model model){
        //User user = userService.findUserByUserName(principal.getName());
        Project project =projectService.findById(id);
        System.out.println("**************************");
        System.out.println("Role is"+ project);
        System.out.println("**************************");
        List<Company> companyList=companyService.findAll();
        model.addAttribute("companies",companyList);
        return "/company";
    }
}
