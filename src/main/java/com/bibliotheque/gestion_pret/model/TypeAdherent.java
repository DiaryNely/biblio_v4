package com.bibliotheque.gestion_pret.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data // Génère les getters, setters, toString, etc.
@Entity
@Table(name = "types_adherents")
public class TypeAdherent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false, unique = true)
    private String nom;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "max_livres_emprunt")
    private Integer maxLivresEmprunt;

    @Column(name = "duree_pret_jours")
    private Integer dureePretJours;

    private Boolean actif;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
}