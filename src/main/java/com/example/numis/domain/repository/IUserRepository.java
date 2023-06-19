package com.example.numis.domain.repository;

import com.example.numis.domain.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<User, Long> {
    @Query("SELECT u FROM User u where u.username = :name")
    User findByName(String name);

    @Query("SELECT u FROM User u where u.email = :email")
    User findByEmail(String email);
}
