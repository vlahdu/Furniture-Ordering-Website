package com.fow.demo.controller;

import com.fow.demo.model.actors.Company;
import com.fow.demo.model.actors.Customer;
import com.fow.demo.model.actors.Designer;
import com.fow.demo.model.projects.Project;
import com.fow.demo.service.CompanyService;
import com.fow.demo.service.CustomerService;
import com.fow.demo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;


@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ProjectService projectService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CompanyService companyService;

    @GetMapping("/profile")
    public String profile(Model model, Principal principal){
        String name =principal.getName();
        Customer customer=customerService.findByUsername(name);
        model.addAttribute("customer",customer);
        return "customer/profile";
    }

    @RequestMapping("/like/{id}")
    public String projectId(@PathVariable("id") long id,Model model, Principal principal){
        Customer customer =customerService.findByUsername(principal.getName());
        Project project =projectService.findById(id);
        System.out.println("************************");
        System.out.println(project);
        System.out.println("************************");
        if(customer.getLikedProjects().contains(project)){
            return "/home";
        }
        customer.addLikedProject(project);
        System.out.println(customer.getLikedProjects());
        System.out.println("************************");
        customerService.saveCustomer(customer);
        List<Project> projects=projectService.findAllBy();
        System.out.println("**************");
        projects.forEach((x)-> System.out.println(x));
        model.addAttribute("projects", projects);
        return "/home";
    }
    @RequestMapping("/buy/{id}")
    public  String buyProjectById(@PathVariable("id") long id,Model model, Principal principal){
//        Customer customer =customerService.findByUsername(principal.getName());
//        Project project =projectService.findById(id);
        List<Company> companyList =companyService.findAll();
        model.addAttribute("companies",companyList);
        return "customer/available_company";
    }
}
