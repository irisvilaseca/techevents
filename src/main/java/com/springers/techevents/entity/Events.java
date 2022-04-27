package com.springers.techevents.entity;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity
public class Events implements Serializable
{
    @Serial
    private final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean featured;

    private int max_participants;

    private String name, date, description, image;

    @ManyToMany(mappedBy = "events")
    private List<Users> users;
}