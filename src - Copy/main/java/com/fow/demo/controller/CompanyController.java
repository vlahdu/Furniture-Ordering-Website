package com.fow.demo.controller;

import com.fow.demo.model.actors.Company;
import com.fow.demo.model.actors.Customer;
import com.fow.demo.model.projects.Project;
import com.fow.demo.service.CompanyService;
import com.fow.demo.service.CustomerService;
import com.fow.demo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.Map;

@Controller
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private ProjectService projectService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CompanyService companyService;

    @GetMapping("/profile")
    public String profile(Model model, Principal principal){
        String name =principal.getName();
        Company company =companyService.findByUsername(name);
        Map<Customer, Project> customers=company.getWantBuyProject();
        model.addAttribute("customers",customers);
        return "company/profile";
    }

}
