package com.cineloca.cinelocabackend.controller;

import com.cineloca.cinelocabackend.model.User;
import com.cineloca.cinelocabackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository _repository;

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User usuario) {
        if(_repository.findByEmail(usuario.getEmail()).isPresent()) {
            return new ResponseEntity<>("Usuário já criado.", HttpStatus.BAD_REQUEST);
        }
        User novoUsuario = new User(usuario.getNome(), usuario.getEmail(), usuario.getSenha());
        _repository.save(novoUsuario);
        return new ResponseEntity<>("Usuário criado com sucesso", HttpStatus.CREATED);
    }

}
