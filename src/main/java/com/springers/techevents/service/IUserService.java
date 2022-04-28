package com.springers.techevents.service;



import java.util.List;
import com.springers.techevents.entity.Users;

public interface IUserService {


    public List<Users> listarTodos();
    public void guardar(Users user);
    public Users buscarPorId(Long id);
    public void eliminar(Long id);

}
