package com.springers.techevents.controller;

import com.springers.techevents.entity.Users;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String load()
    {
        return "home";
    }
}