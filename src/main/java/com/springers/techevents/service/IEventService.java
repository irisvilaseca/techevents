package com.springers.techevents.service;


import java.util.List;
import com.springers.techevents.entity.Events;

public interface IEventService {


    public List<Events> listarTodos();
    public void guardar(Events event);
    public Events bucarPorId(Long id);
    public void eliminar(Long id);
}
