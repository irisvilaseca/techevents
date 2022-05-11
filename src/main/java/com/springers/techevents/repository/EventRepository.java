package com.springers.techevents.repository;

import com.springers.techevents.entity.Events;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EventRepository extends JpaRepository <Events, Long> {

}
