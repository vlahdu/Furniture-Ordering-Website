package com.fow.demo.controller;

import com.fow.demo.model.actors.Company;
import com.fow.demo.model.actors.Designer;
import com.fow.demo.model.projects.Project;
import com.fow.demo.service.CompanyService;
import com.fow.demo.service.DesignerService;
import com.fow.demo.service.ProjectService;
import com.fow.demo.service.detail.DesignerDetailService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/designer")
public class DesignerController {
    @Autowired
    DesignerService designerService;
    @Autowired
    ProjectService projectService;
    @Autowired
    CompanyService companyService;


     @GetMapping("/profile")
     public String profile(Model model, Principal principal){
         String name =principal.getName();
         Designer designer=designerService.findByUsername(name);
         List<Project> projectList= projectService.findByDesigner(designer);
         List<Company> companyList= new LinkedList<>();
         designer.getCompanyCollaboration().forEach((x)-> companyList.add(x));
         System.out.println("********************");
         System.out.println(companyList);
         System.out.println("********************");
         designer.getOwnProjects().forEach((x)-> projectList.add(x));
         model.addAttribute("projects",projectList);
         model.addAttribute("companies",companyList);
         model.addAttribute("str",designer.getUserName());
         return "designer/profile";
     }
     @GetMapping("/add_project")
    public String addProject(Model model, Principal principal){
         Project project = new Project();
         model.addAttribute("project",project);
         return  "designer/add_project";
     }

    @PostMapping(value = "/add_project")
    public String createNewUser(@ModelAttribute("project")@Valid Project project,Principal principal) {

        System.out.println("************************");
        System.out.println(project);
        System.out.println("************************");
        String name =principal.getName();
        Designer designer=designerService.findByUsername(name);
        System.out.println("************************");
        System.out.println(designer);
        System.out.println("************************");
        project.setDesigner(designer);
        projectService.saveProject(project);
        return "designer/add_project";
    }

    @GetMapping("want_to_collaborate")
    public String wantToCollaborate(Model model ){
         List<Company> companies = companyService.findAll();
         model.addAttribute("companies",companies);
         return "/designer/companies";
    }
    @GetMapping("/send_request/{id}")
    public String sendRequestToCompany(@PathVariable("id") long id,Model model,Principal principal){
         Designer designer= designerService.findByUsername(principal.getName());
         Company company=companyService.findById(id);
         designer.sendRequestToCompany(company);
         List<Company> companies= new LinkedList<>();
        System.out.println("I was here");
        companyService.findAll().stream()
                        .filter(p -> !p.getWantToCollaborate().contains(designer))
                        .forEach((x)->companies.add(x));
        companyService.saveCompany(company);
        model.addAttribute("companies",companies);
        return "/designer/companies";
    }

}
