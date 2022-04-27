package com.springers.techevents.entity;


import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "")
public class Users {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String usuario;
    private String contraseña;

    @ManyToMany
    private Events events;

    public Long getId (){return id;}

    public String getEmail(){return email;}

    public String getUser(){return usuario;}

    public String getPassword(){return contraseña;}
}
