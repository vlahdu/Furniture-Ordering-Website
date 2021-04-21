package com.ex;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
/*
 * @IonToncu
 *
 * */
@Controller
public class HelloController {
    @GetMapping("/hello")
    public  String sayHello(){
        return "hello";
    }
    @GetMapping("/ceva")
    public  String sayCeva(){
        return "ceva";
    }
}
