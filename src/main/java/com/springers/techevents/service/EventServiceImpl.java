package com.springers.techevents.service;

import com.springers.techevents.entity.Events;
import com.springers.techevents.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements IEventService {

    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }


    @Override
    public List<Events> listarTodos() {

        return (List<Events>) eventRepository.findAll();
    }

    @Override
    public void guardar(Events event) {
         eventRepository.save(event);
    }


    @Override
    public Events buscarPorId(Long id) {

        return eventRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public void eliminar(Long id) {

        eventRepository.deleteById(id);
    }


    public void editar(Events event) {
    }

}
