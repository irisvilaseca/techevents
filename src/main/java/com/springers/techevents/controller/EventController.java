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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EventController {
    @Autowired
    private EventServiceImpl eventService;
    private UserServiceImpl service;
    @GetMapping("/events/{eventId}")
    public String load(@PathVariable Long eventId, Model model)
    {
        Events evento1 = eventService.buscarPorId(eventId);
        System.out.println(evento1.toString());
        model.addAttribute("eventoPrueba",evento1);
        return "views/events/singleEvent";
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
    }

    @GetMapping("/events/delete/{id}")
    public String eliminar(@PathVariable("id") Long idEvents) {

        eventService.eliminar(idEvents);
        System.out.println("Evento eliminado con exito");
        return null;
    }

    @GetMapping("/events/edit/{id}")
    public String editar(@PathVariable("id") Long idEvents,@ModelAttribute Events event, Model model){

        model.addAttribute("name","Formulario: Editar Evento");
        model.addAttribute("date");
        model.addAttribute("description");
        model.addAttribute("image");
        System.out.println("Hubo errores en el formulario");
        eventService.editar(event);
        System.out.println("Evento guardado con éxito!");
        return "redirect:/clientes/"; // falta agregar ruta
    }
}
