package com.example.numis.domain.repository;

import com.example.numis.domain.models.Coin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPictureRepository extends JpaRepository<Coin, Long> {

}
