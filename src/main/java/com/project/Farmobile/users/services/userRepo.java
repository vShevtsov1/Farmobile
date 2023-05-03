package com.project.Farmobile.users.services;

import com.project.Farmobile.users.data.users;
import org.springframework.data.repository.CrudRepository;

public interface userRepo extends CrudRepository<users,Long> {
    users findByEmail(String email);
}
