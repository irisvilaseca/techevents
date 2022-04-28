package com.springers.techevents.service;

import com.springers.techevents.entity.Events;
import com.springers.techevents.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements IEventService{

    @Autowired
    private EventRepository eventRepository;

    @Override
    public List<Events> listaEventos() {
        return (List<Events>) eventRepository.findAll();
    }

}
