package com.bibliotheque.gestion_pret.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.bibliotheque.gestion_pret.enums.StatutProlongation;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "prolongations")
public class Prolongation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pret_id", nullable = false)
    private Pret pret;

    @Column(name = "ancienne_date_retour", nullable = false)
    private LocalDate ancienneDateRetour;

    @Column(name = "nouvelle_date_retour", nullable = false)
    private LocalDate nouvelleDateRetour;

    @Column(columnDefinition = "TEXT")
    private String motif;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "demande_par")
    private Adherent demandePar;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "approuve_par")
    private Adherent approuvePar;

    @Column(name = "date_demande")
    private LocalDate dateDemande;

    @Column(name = "date_approbation")
    private LocalDate dateApprobation;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private StatutProlongation statut;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
}