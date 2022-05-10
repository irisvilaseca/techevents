package com.springers.techevents.controller;

import com.springers.techevents.entity.NewUser;
import com.springers.techevents.entity.Users;
import com.springers.techevents.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController
{
    private UserServiceImpl servicio;

    @GetMapping("/register")
    public String load(Model model)
    {
        model.addAttribute("registrarse", new NewUser());
        return "";//agregar el html
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("registrarse") NewUser user, Model model)
    {
        if(user.getUsuario().length() < 4)
        {
            model.addAttribute("Error","El nombre de usuario debe tener por lo menos 4 carácteres");//mandar error
        //Falta poner un label de error en el html
        }
        else
        {
            Users u = new Users();
            u.setEmail(user.getEmail());
            u.setPassword(user.getContrasena());
            u.setUser(user.getUsuario());
            servicio.guardar(u);
        }
        return "views/event"; //Falta completar ruta
    }


}