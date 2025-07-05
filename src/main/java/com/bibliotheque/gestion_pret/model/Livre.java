package com.bibliotheque.gestion_pret.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "livres")
public class Livre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255, nullable = false)
    private String titre;

    @Column(length = 255, nullable = false)
    private String auteur;

    @Column(name = "date_edition")
    private LocalDate dateEdition;

    @Column(name = "nombre_exemplaires")
    private Integer nombreExemplaires;

    @Column(name = "mots_cles", columnDefinition = "TEXT")
    private String motsCles;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "langue_id")
    private Langue langue;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id")
    private GenreLitteraire genre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emplacement_id")
    private Emplacement emplacement;

    @Column(length = 20)
    private String isbn;

    @Column(length = 255)
    private String editeur;

    private Integer pages;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restriction_type_adherent")
    private TypeAdherent restrictionTypeAdherent;

    private Boolean actif;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
}