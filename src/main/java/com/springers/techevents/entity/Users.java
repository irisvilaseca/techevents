package com.springers.techevents.entity;


import com.springers.techevents.security.Role;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


@Entity
@Table(name = "")
public class Users implements Serializable, UserDetails {

    @Serial private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String email;
    private String usuario;
    private String contrasena;

    @ManyToMany
    private List<Events> events;

    public static Users save(Users events) {
        return null;
    }

    public Long getId (){return id;}

    public String getEmail(){return email;}

    public String getUser(){return usuario;}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(role.name()));
    }

    public String getPassword(){return contrasena;}

    @Override
    public String getUsername() {
        return usuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

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

    public Role getRole(){return role;}

    public void setRole(Role role){this.role = role;}

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

    public void setBook(boolean b) {
    }

    public void setRenter(String renter) {
    }
}


