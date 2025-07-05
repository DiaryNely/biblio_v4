package com.bibliotheque.gestion_pret.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.bibliotheque.gestion_pret.enums.StatutReservation;

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
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "livre_id", nullable = false)
    private Livre livre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "adherent_id", nullable = false)
    private Adherent adherent;

    @Column(name = "date_reservation")
    private LocalDate dateReservation;

    @Column(name = "date_expiration")
    private LocalDate dateExpiration;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private StatutReservation statut;

    @Column(columnDefinition = "TEXT")
    private String notes;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
}
