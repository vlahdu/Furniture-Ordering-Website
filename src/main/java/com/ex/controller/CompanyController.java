package com.ex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/company")
=======

@Controller("/company")
>>>>>>> IonToncu
public class CompanyController {

    @GetMapping("/registration")
    String registration(){
        return "company/registration";
    }
    @GetMapping("/login")
    String login(){ return "company/login";}
    @GetMapping("/{id}")
    String profile(@PathVariable String id){return "company/profile";  }
    @GetMapping("/customers")
    String ownCustomers(){return "company/customers";}
    @GetMapping("/designers")
    String collaboratingDesigners(){return "company/designers";}
    @GetMapping("/all_designers")
    String allDesigners(){return "company/all_designers";}

    //todo write post methods, and add edit controller for profile

}
