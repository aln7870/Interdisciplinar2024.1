package com.api.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "instrutor")
public class InstrutorModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idInstrutor;
    @Column(nullable = false, length = 100)
    private String name;
    @Column(nullable = false, length = 100)
    private String horarioDisponivel;
    @Column(nullable = false, length = 15)
    private String telefone;
    @Column(nullable = false, length = 1)
    private String status;



}
