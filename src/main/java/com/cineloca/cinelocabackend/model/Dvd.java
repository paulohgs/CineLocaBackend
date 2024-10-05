package com.cineloca.cinelocabackend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="dvds")
@Getter
@Setter
public class Dvd {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String titulo;
    @Column(nullable = false)
    private String genero;
    @Column(nullable = false)
    private String ano_lancamento;
    @Column(nullable = false)
    private long quantidade_disponivel;

    public Dvd() {

    }

    public Dvd(String titulo, String genero, String ano_lancamento, long quantidade_disponivel) {
        this.titulo = titulo;
        this.genero = genero;
        this.ano_lancamento = ano_lancamento;
        this.quantidade_disponivel = quantidade_disponivel;
    }
}
