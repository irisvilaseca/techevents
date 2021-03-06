package com.springers.techevents.controller;

import com.springers.techevents.entity.NewUser;
import com.springers.techevents.entity.Users;
import com.springers.techevents.security.Role;
import com.springers.techevents.service.UserServiceImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController
{
    private UserServiceImpl servicio;

    public RegisterController(UserServiceImpl users){
        servicio=users;
    }

    @GetMapping("/register")
    public String load(Model model)
    {
        model.addAttribute("registrarse", new NewUser());
        return "views/signup";//agregar el html
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("registrarse") NewUser user, Model model)
    {
        if(user.getUsuario().length() < 4)
        {
            model.addAttribute("error","El nombre de usuario debe tener por lo menos 4 carácteres");//mandar error
        //Falta poner un label de error en el html
        }
        else
        {
            Users u = new Users();
            u.setEmail(user.getEmail());
            u.setPassword(new BCryptPasswordEncoder().encode(user.getContrasena()));
            u.setUser(user.getUsuario());
            u.setRole(Role.ROLE_USER);
            servicio.guardar(u);
            return "redirect:/login";
        }
        model.addAttribute("registrarse",new NewUser());
        return "views/signup";

    }


}