package com.springers.techevents.controller;

import com.springers.techevents.entity.Events;
import com.springers.techevents.entity.Users;
import com.springers.techevents.service.EventServiceImpl;
import com.springers.techevents.service.IEventService;
import com.springers.techevents.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EventController {
    @Autowired
    private EventServiceImpl eventService;
    private UserServiceImpl service;
    @GetMapping("/events")
    public String load()
    {
        return "";
    }
    @PostMapping("/events/create")
    public String guardar(@ModelAttribute Events event, BindingResult result, Model model){
        List<Users> listUsers = service.listarTodos();

            model.addAttribute("name","Formulario: Nuevo Evento");
            model.addAttribute("max_participants",listUsers);
            model.addAttribute("date");
            model.addAttribute("description");
            model.addAttribute("image");
            System.out.println("Hubo errores en el formulario");
        eventService.guardar(event);
        System.out.println("Evento guardado con éxito!");
        return "redirect:/clientes/";
    };
}
