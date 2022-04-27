package com.springers.techevents.entity;


import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;


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
    @JoinColumn(name = "")
    private Events events;

}
