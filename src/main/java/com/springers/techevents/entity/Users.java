package com.springers.techevents.entity;


import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;


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
    @JoinColumn(name = "")
    private Events events;

}
