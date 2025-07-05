package com.bibliotheque.gestion_pret.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.bibliotheque.gestion_pret.enums.StatutPaiementPenalite;

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
@Table(name = "penalites")
public class Penalite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pret_id", nullable = false)
    private Pret pret;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "adherent_id", nullable = false)
    private Adherent adherent;

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal montant;

    @Column(name = "jours_retard", nullable = false)
    private Integer joursRetard;

    @Column(name = "date_calcul")
    private LocalDate dateCalcul;

    @Enumerated(EnumType.STRING)
    @Column(name = "statut_paiement", length = 20)
    private StatutPaiementPenalite statutPaiement;

    @Column(name = "date_paiement")
    private LocalDate datePaiement;

    @Column(columnDefinition = "TEXT")
    private String notes;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
}