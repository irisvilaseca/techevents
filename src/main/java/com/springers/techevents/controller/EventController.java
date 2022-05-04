package com.springers.techevents.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EventController {
    @GetMapping("/views/events")
    public String load()
    {
        return "";
    }
}
