package com.springers.techevents.controller;

import com.springers.techevents.entity.Events;
import com.springers.techevents.entity.Users;
import com.springers.techevents.repository.EventRepository;
import com.springers.techevents.service.EventServiceImpl;
import com.springers.techevents.service.IEventService;
import com.springers.techevents.service.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
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
    private EventRepository eventRepository;

    @GetMapping("/events/{eventId}")
    public String loadById(@PathVariable Long eventId, Model model) {
        Events evento1 = eventService.buscarPorId(eventId);
        model.addAttribute("eventoPrueba", evento1);
        model.addAttribute("evento",new Events());
        return "views/events/singleEvent";
    }


    @GetMapping("/events")
    public String loadAllEvents(Model model) {
        List<Events> events = eventService.listarTodos();
        model.addAttribute("events", events);
        return "home";

    }

    @PostMapping("/events/create")
    public String guardar(@ModelAttribute Events event, BindingResult result, Model model) {
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
    }
    /*
    @GetMapping("/event/{id}/edit")
    public String edit(@PathVariable Long id){
        Events evento=eventService.buscarPorId(id);
        evento.setDate();
        evento.setName();
        evento.setDescription();
        evento.setImage();
        evento.setMax_participants();
        evento.setFeatured();
        return "redirect:/event/"+id.toString();
    }*/

    @PutMapping("/event/{id}/book")
    public Events updateEventsreturn(@PathVariable Long id, @RequestParam(value = "events") String Events) {
        Events events = eventRepository.findById(id).orElseThrow(RuntimeException::new);
        return eventRepository.save(events);

    }

    @PutMapping("/movies/{id}/return")
    public void clearEventsExpired(@PathVariable Long id) {
        eventRepository.deleteById(id);
    }
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
}