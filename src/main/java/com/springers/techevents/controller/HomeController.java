package com.springers.techevents.controller;

import com.springers.techevents.entity.Events;
import com.springers.techevents.service.EventServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController
{
    private EventServiceImpl service;

    public HomeController(EventServiceImpl service)
    {
        this.service = service;
    }

    @GetMapping("/home")
    public String load(Model model)
    {
        List<Events> _events = service.listarTodos(), featured = new ArrayList<>(3);
        Events ee = new Events(), eee = new Events(), eeee = new Events();
        eeee.setDate("26/07 13:30");
        eeee.setImage("https://eikonos.com/wp-content/uploads/2019/11/G2J_Eikonos_nov2019_consejos_diseño_para_eventos.jpg");
        eeee.setFeatured(true);
        eee.setDate("20/05 19:00");
        eee.setImage("https://www.venuesplace.com/ficheros/DECORAR-BLOG.jpg");
        ee.setDate("14/05 12:00");
        ee.setImage("https://www.gl-events.com/sites/glevents2022/files/styles/max_2600x2600/public/2019-03/about_us.jpg");
        ee.setFeatured(true);
        _events.add(ee);
        _events.add(eee);
        _events.add(eeee);
        for(Events e : _events)
            if(e.getFeatured())
                featured.add(e);
        model.addAttribute("nfEvents", featured.size());
        model.addAttribute("fEvents", featured);
        model.addAttribute("aEvents", _events);
        model.addAttribute("raEvents", Math.ceil((float)_events.size() / 4.f));
        return "home";
    }
}