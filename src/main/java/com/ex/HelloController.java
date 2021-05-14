package com.ex;

import com.ex.module.entities.actors.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @author IonToncu
 *
 */
@Controller
public class HelloController {

    private UserService userService = new UserService();

    @GetMapping("/hello")
    public  String sayHello(){
        return "hello";
    }
    @GetMapping()
    public String index(Model model) {
        model.addAttribute("people", new A());
        return "ceva";
    }

    @GetMapping("/ceva")
    public  String sayCeva(HttpServletRequest request,Model model){
        String name=request.getParameter("name");
        System.out.println(name);
        model.addAttribute("name",name);
        return "ceva";
    }

    @GetMapping("/test")
    public String sayTest(@RequestParam(value = "ceva",required = false) String ceva,Model model){
        model.addAttribute("ceva",ceva);
        model.addAttribute("a",new A());

        return "test";
    }
    @GetMapping("/new")
    public String newA(@ModelAttribute("a") A a) {
        return "new";
    }
    @PostMapping()
    public String createObject(@ModelAttribute("a") A a ,Model model) {
        model.addAttribute("a", a);
        System.out.println(a);
        System.out.println("ceva");
        return "redirect:/test";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }
    @GetMapping("/test")
    public String test(Model model) {
        model.addAttribute("a", new A());
        return "test";
    }

    @PostMapping("/test")
    public String printTest(@ModelAttribute("str") A str) {
        System.out.println(str.getStr());
        return "redirect:/";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("userForm") @Valid User userForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        System.out.println(userForm.getRole());
        System.out.println(userForm.getPassword());


        if (!userService.saveUser(userForm)){
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "registration";
        }

        return "redirect:/";

    }
}
