package com.springers.techevents.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogInController
{
    @GetMapping("/login")
    public String load()
    {
        return "views/login";
    }
}