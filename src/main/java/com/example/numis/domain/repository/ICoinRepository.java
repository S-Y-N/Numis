package com.example.numis.domain.repository;

import com.example.numis.domain.models.Coin;
import com.example.numis.domain.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ICoinRepository extends JpaRepository<Coin, Long> {
    @Query("SELECT u FROM Coin u where u.name = :name")
    Optional<Coin> findByName(String name);
}
