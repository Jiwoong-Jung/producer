package net.rabbitmq.springboot.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

    @GetMapping("/")
    String main() {
        return "main";
    }

    @GetMapping("/test")
    String test() {
        return "test";
    }
}
