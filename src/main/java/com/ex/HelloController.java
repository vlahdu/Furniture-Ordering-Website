package com.ex;

import com.ex.module.entities.actors.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Map;

/*
 * @IonToncu
 *
 * */
@Controller
public class HelloController {

    private UserService userService = new UserService();

    @GetMapping("/hello")
    public  String sayHello(){
        return "hello";
    }
    @GetMapping("/ceva")
    public  String sayCeva(){
        return "ceva";
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
