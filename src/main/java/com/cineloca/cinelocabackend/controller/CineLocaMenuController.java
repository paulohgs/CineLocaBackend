package com.cineloca.cinelocabackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CineLocaMenuController {
    @GetMapping("/")
    public String menu() {
        return "Aplicação funcionando";
    }
}
