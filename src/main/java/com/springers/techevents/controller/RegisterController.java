package com.springers.techevents.controller;

import com.springers.techevents.entity.Events;
import com.springers.techevents.entity.NewUser;
import com.springers.techevents.entity.Users;
import com.springers.techevents.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
        return "/templates/user/frmCrearUser";
    }
    @GetMapping("/register/delete/{id}")
    public String eliminar(@PathVariable("id") Long idUser) {

        servicio.eliminar(idUser);
        System.out.println("Usuario eliminado con exito");

        return "redirect:/views/events/"; //falta acabar la ruta
    }
    @GetMapping("/register/edit/{id}")
    public String editar(@PathVariable("id") Long idUser, @ModelAttribute Users user, Model model){

        model.addAttribute("name","Formulario: Editar usuario");
        model.addAttribute("date");
        model.addAttribute("description");
        model.addAttribute("image");
        System.out.println("Hubo errores en el formulario");
        servicio.editar(user);
      System.out.println("Usuario editado con éxito!");
        return "redirect:/clientes/"; // falta agregar ruta
    }
}