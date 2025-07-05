package com.bibliotheque.gestion_pret.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "langues")
public class Langue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false, unique = true)
    private String nom;

    @Column(name = "code_iso", length = 3, nullable = false, unique = true)
    private String codeIso;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
}