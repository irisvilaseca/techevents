package com.springers.techevents.service;

import com.springers.techevents.entity.Users;
import com.springers.techevents.repository.UserRepository;
import com.springers.techevents.security.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService, UserDetailsService
{
    private final UserRepository repo;

    public UserServiceImpl(UserRepository repo)
    {
        this.repo = repo;
    }

    @Override
    public List<Users> listarTodos()
    {
        return (List<Users>) repo.findAll();
    }

    @Override
    public void guardar(Users user)
    {
        repo.save(user);
    }

    @Override
    public Users buscarPorId(Long id)
    {
        return (Users) repo.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id)
    {
        repo.deleteById(id);
    }


    public void editar(Users user) {
    
    }

    public boolean exists(Role role)
    {
        List<Users> users = listarTodos();
        for(Users u : users)
            if(u.getRole() == Role.ROLE_ADMIN)
                return true;
        return false;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        List<Users> users = listarTodos();
        for (Users u : users)
            if(u.getUser().equals(username) || u.getEmail().equals(username))
                return u;
        throw new UsernameNotFoundException("No hay ningun usuario con el nombre o email " + username);

    }
}
