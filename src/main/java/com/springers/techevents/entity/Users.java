package com.springers.techevents.entity;


import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
<<<<<<< HEAD
=======
import java.util.List;
>>>>>>> 8d2644607906abf0d0315742437493c4fbd48a00


@Entity
@Table(name = "")
public class Users implements Serializable {

    @Serial private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String usuario;
    private String contrasena;

    @ManyToMany
    private Events events;

    public Long getId (){return id;}

    public String getEmail(){return email;}

    public String getUser(){return usuario;}

    public String getPassword(){return contraseña;}
}
