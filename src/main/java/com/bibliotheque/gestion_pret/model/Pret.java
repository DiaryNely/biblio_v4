package com.bibliotheque.gestion_pret.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "prets")
public class Pret {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "livre_id", nullable = false)
    private Livre livre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "adherent_id", nullable = false)
    private Adherent adherent;

    @Column(name = "date_emprunt")
    private LocalDate dateEmprunt;

    @Column(name = "date_retour_prevue", nullable = false)
    private LocalDate dateRetourPrevue;

    @Column(name = "date_retour_reelle")
    private LocalDate dateRetourReelle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_pret_id", nullable = false)
    private TypePret typePret;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "statut_pret_id", nullable = false)
    private StatutPret statutPret;

    @Column(columnDefinition = "TEXT")
    private String notes;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
}
