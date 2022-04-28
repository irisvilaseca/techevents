package com.springers.techevents.service;

import com.springers.techevents.entity.Users;
import com.springers.techevents.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements IUserService
{
    private final UserRepository repo;

    @Autowired
    public UserService(UserRepository repo)
    {
        this.repo = repo;
    }

    @Override
    public List<Users> all()
    {
        return (List<Users>) repo.findAll();
    }

    @Override
    public void set(Users user)
    {
        repo.save(user);
    }

    @Override
    public Users get(Long id)
    {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id)
    {
        repo.deleteById(id);
    }
}
