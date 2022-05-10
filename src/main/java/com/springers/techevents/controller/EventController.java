package com.springers.techevents.controller;

import com.springers.techevents.entity.Events;
import com.springers.techevents.entity.Users;
import com.springers.techevents.repository.EventRepository;
import com.springers.techevents.service.EventServiceImpl;
import com.springers.techevents.service.UserServiceImpl;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EventController {
    @Autowired
    private EventServiceImpl eventService;
    private UserServiceImpl service;
    private Object EventsNotFoundException;

    @GetMapping("/events")
    public String loadAllEvents(Model model) {
        List<Events> events = eventService.listarTodos();
        model.addAttribute("events", events);
        return "home";
    }

    @PostMapping("/events/create")
    public String guardar(@ModelAttribute Events event, BindingResult result, Model model) {
        List<Users> listUsers = service.listarTodos();

        model.addAttribute("name", "Formulario: Nuevo Evento");
        model.addAttribute("max_participants", listUsers);
        model.addAttribute("date");
        model.addAttribute("description");
        model.addAttribute("image");
        System.out.println("Hubo errores en el formulario");
        eventService.guardar(event);
        System.out.println("Evento guardado con éxito!");
        return "redirect:/clientes/";
    }

    @PutMapping("/event/{id}/book")
    public Events updateEventsreturn(@PathVariable Long id, @RequestParam(value = "events") String Events) {
        Events events = eventRepository.findById(id).orElseThrow(eventsNotFoundException::new);
        return eventRepository.save(events);

    }

    @PutMapping("/movies/{id}/return")
    public Events clearEventsExpired(@PathVariable Long id) {
        Events events = eventRepository.findById(id).orElseThrow(eventsNotFoundException::new);
        return eventRepository.deleteAll(events);
    }
}