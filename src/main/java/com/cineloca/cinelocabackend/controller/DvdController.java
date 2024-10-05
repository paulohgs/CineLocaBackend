package com.cineloca.cinelocabackend.controller;

import com.cineloca.cinelocabackend.model.Dvd;
import com.cineloca.cinelocabackend.repository.DvdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dvd")
public class DvdController {
    @Autowired
    private DvdRepository _repository;

    @GetMapping
    public List<Dvd> getAllDvd() {
        return _repository.findAll();
    }

    @GetMapping("/titulo")
    public Dvd getByTitulo(@RequestParam String titulo) {
        if (_repository.findByTitulo(titulo).isPresent()) {
            return _repository.findByTitulo(titulo).get();
        }
        return new Dvd("", "", "", 0);
    }

}
