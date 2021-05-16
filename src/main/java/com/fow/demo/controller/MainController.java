package com.fow.demo.controller;

import com.fow.demo.model.actors.Company;
import com.fow.demo.model.actors.Customer;
import com.fow.demo.model.actors.Designer;
import com.fow.demo.model.projects.Project;
import com.fow.demo.service.CompanyService;
import com.fow.demo.service.CustomerService;
import com.fow.demo.service.DesignerService;
import com.fow.demo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/")
public class MainController {
    @Autowired
    private DesignerService designerService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ProjectService projectService;
    /******************************************************************
     * Home page
     * For login to any User
     *******************************************************************/
    @GetMapping(value="/")
    public String home(Model model){
        List<Project> projects=projectService.findAllBy();
        System.out.println("**************");
        projects.forEach((x)-> System.out.println(x));
        model.addAttribute("projects", projects);
        return "/home";
    }


    @GetMapping(value="/login")
    public ModelAndView loginDesigner(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        System.out.println("<<I was here log_des>>");
        return modelAndView;
    }
    /******************************************************************
     * Designer
     * For login and registration
     *******************************************************************/

    @GetMapping(value="/registration_des")
    public ModelAndView registrationDesigner(){
        ModelAndView modelAndView = new ModelAndView();
        Designer designer = new Designer();
        modelAndView.addObject("designer", designer);
        modelAndView.setViewName("registration_des");
        return modelAndView;
    }

    @PostMapping(value = "/registration_des")
    public ModelAndView createNewDesigner(@Valid  Designer designer, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        Designer designerExists = designerService.findByUsername(designer.getUserName());
        if (designerExists != null) {
            bindingResult
                    .rejectValue("userName", "error.user",
                            "There is already a user registered with the user name provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration_des");
        } else {
            designerService.saveDesigner(designer);
            modelAndView.addObject("successMessage", "Designer has been registered successfully");
            modelAndView.addObject("designer", new Designer());
            modelAndView.setViewName("registration_des");

        }
        return modelAndView;
    }
    @GetMapping(value="/designer/home")
    public ModelAndView homeDesigner(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Designer user = designerService.findByUsername(auth.getName());
        modelAndView.addObject("userName", "Welcome " + user.getUserName() + "/" + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")("+user.getRole()+")");
        modelAndView.addObject("adminMessage","Content Available Only for Users with Designer Role");
        modelAndView.setViewName("designer/home");
        return modelAndView;
    }
    /******************************************************************
     * Customer
     * For login and registration
     *******************************************************************/

    @GetMapping(value="/registration_cu")
    public ModelAndView registrationCustomer(){
        ModelAndView modelAndView = new ModelAndView();
        Customer customer = new Customer();
        modelAndView.addObject("customer", customer);
        modelAndView.setViewName("registration_cu");
        return modelAndView;
    }

    @PostMapping(value = "/registration_cu")
    public ModelAndView createNewCustomer(@Valid  Customer customer, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        Customer customerExists = customerService.findByUsername(customer.getUserName());
        if (customerExists != null) {
            bindingResult
                    .rejectValue("userName", "error.user",
                            "There is already a customer registered with the user name provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration_cu");
        } else {
            customerService.saveCustomer(customer);
            modelAndView.addObject("successMessage", "Customer has been registered successfully");
            modelAndView.addObject("customer", new Customer());
            modelAndView.setViewName("registration_cu");

        }
        return modelAndView;
    }
    @GetMapping(value="/customer/home")
    public ModelAndView homeCustomer(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Customer user = customerService.findByUsername(auth.getName());
        modelAndView.addObject("userName", "Welcome " + user.getUserName() + "/" + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")("+user.getRole()+")");
        modelAndView.addObject("adminMessage","Content Available Only for Users with Customer Role");
        modelAndView.setViewName("customer/home");
        return modelAndView;
    }
    /******************************************************************
     * Company
     * For login and registration
     *******************************************************************/

    @GetMapping(value="registration_co")
    public ModelAndView registrationCompany(){
        ModelAndView modelAndView = new ModelAndView();
        Company company = new Company();
        modelAndView.addObject("company", company);
        modelAndView.setViewName("registration_co");
        return modelAndView;
    }

    @PostMapping(value = "/registration_co")
    public ModelAndView createNewCompany(@Valid  Company company, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        Company companyExists = companyService.findByUsername(company.getUserName());
        if (companyExists != null) {
            bindingResult
                    .rejectValue("companyName", "error.company",
                            "There is already a Company registered with the user name provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration_co");
        } else {
            companyService.saveCompany(company);
            modelAndView.addObject("successMessage", "Company has been registered successfully");
            modelAndView.addObject("company", new Company());
            modelAndView.setViewName("registration_co");

        }
        return modelAndView;
    }
    @GetMapping(value="/company/home")
    public ModelAndView homeCompany(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Company user = companyService.findByUsername(auth.getName());
        modelAndView.addObject("userName", "Welcome " + user.getUserName() + "/" + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")("+user.getRole()+")");
        modelAndView.addObject("adminMessage","Content Available Only for Users with Designer Role");
        modelAndView.setViewName("company/home");
        return modelAndView;
    }
}
