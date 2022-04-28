package com.springers.techevents.service;

import com.springers.techevents.entity.Events;
import com.springers.techevents.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements IEventService{

    private final EventRepository eventRepository;

    @Autowired
    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }


    @Override
    public List<Events> listarTodos() {
        return null;
    }

    @Override
    public void guardar(Events event) {

    }

    @Override
    public Events buscarPorId(Long id) {
        return null;
    }

    @Override
    public void eliminar(Long id) {

    }
}
