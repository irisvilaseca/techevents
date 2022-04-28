package com.springers.techevents.repository;

import com.springers.techevents.entity.Users;
import org.apache.catalina.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users, Long> {
}
