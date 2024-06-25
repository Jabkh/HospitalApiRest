package org.example.hospitalrest.repository;

import org.example.hospitalrest.model.entity.User;

public interface UserRepository extends Repository<User> {
    User findByUsername(String username);
}