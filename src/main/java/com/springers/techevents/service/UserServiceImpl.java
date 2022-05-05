package com.springers.techevents.service;

import com.springers.techevents.entity.Users;
import com.springers.techevents.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements IUserService
{
    private final UserRepository repo;

    @Autowired
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
}
