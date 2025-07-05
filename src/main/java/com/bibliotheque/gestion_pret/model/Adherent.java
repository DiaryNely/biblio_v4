package com.bibliotheque.gestion_pret.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.bibliotheque.gestion_pret.enums.AbonnementType;
import com.bibliotheque.gestion_pret.enums.StatutPaiementAdherent;

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
@Table(name = "adherents")
public class Adherent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String nom;

    @Column(length = 100, nullable = false)
    private String prenom;

    @Column(name = "adresse_postale", columnDefinition = "TEXT")
    private String adressePostale;

    @Column(length = 255, unique = true)
    private String email;

    @Column(length = 20)
    private String telephone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_adherent_id", nullable = false)
    private TypeAdherent typeAdherent;

    @Column(name = "date_inscription")
    private LocalDate dateInscription;

    @Enumerated(EnumType.STRING)
    @Column(name = "abonnement_type", length = 20)
    private AbonnementType abonnementType;

    @Column(name = "abonnement_debut")
    private LocalDate abonnementDebut;

    @Column(name = "abonnement_fin")
    private LocalDate abonnementFin;

    @Enumerated(EnumType.STRING)
    @Column(name = "statut_paiement", length = 20)
    private StatutPaiementAdherent statutPaiement;

    @Column(name = "mot_de_passe", length = 255)
    private String motDePasse; // Stockera le mot de passe hashé

    private Boolean actif;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
}