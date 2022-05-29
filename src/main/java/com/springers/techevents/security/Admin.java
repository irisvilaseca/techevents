package com.springers.techevents.security;

import com.springers.techevents.entity.Users;
import com.springers.techevents.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class Admin implements CommandLineRunner
{
    private UserServiceImpl users;

    public Admin(UserServiceImpl users)
    {
        this.users = users;
    }

    @Override
    public void run(String... args)
    {
        if(!users.exists(Role.ROLE_ADMIN))
        {
            String adminp = UUID.randomUUID().toString();
            Users admin = new Users();
            admin.setEmail("sardevcpp@gmail.com");
            admin.setPassword(new BCryptPasswordEncoder().encode(adminp));
            admin.setUser("Administrator");
            admin.setRole(Role.ROLE_ADMIN);
            users.guardar(admin);
            System.out.println("Admin decoded password: " + adminp + "\nAdmin info: " + admin.toString());
        }
        List<Users> userss = users.listarTodos();
        for(Users u : userss)
            System.out.println(u.getUser() + ", " + u.getEmail());
    }
}