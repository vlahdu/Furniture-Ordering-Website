package com.ex;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

/**
 * @author IonToncu
 *
 */
@Controller
public class HelloController {
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
    public String createObject(@ModelAttribute("a") A a ,Model model){
        model.addAttribute("a",a);
        System.out.println(a);
       System.out.println("ceva");
        return  "redirect:/test";
    }
}
