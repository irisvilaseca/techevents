package com.springers.techevents.entity;


import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;


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

    public String getPassword(){return contrasena;}

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUser(String usuario) {
        this.usuario = usuario;
    }

    public void setPassword(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", usuario='" + usuario + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", events=" + events +
                '}';
    }
}


