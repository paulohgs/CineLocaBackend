package com.cineloca.cinelocabackend.repository;

import com.cineloca.cinelocabackend.model.Dvd;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DvdRepository extends JpaRepository<Dvd, Long> {
    Optional<Dvd> findByTitulo(String titulo);
}
