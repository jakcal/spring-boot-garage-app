package com.example.springboot_garage.model;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Facture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;
    private LocalDate dateEmission;
    private Double montantHT;
    private Double montantTVA;
    private Double montantTTC;
    private String statut; // Payée, En attente, Annulée
    private String modePaiement; // Carte bancaire, Espèces, Chèque, Virement
    
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    
    @OneToOne
    @JoinColumn(name = "rendez_vous_id")
    private RendezVous rendezVous;
    
    @ManyToMany
    @JoinTable(
        name = "facture_services",
        joinColumns = @JoinColumn(name = "facture_id"),
        inverseJoinColumns = @JoinColumn(name = "service_id")
    )
    private List<Service> services;
    
    @ManyToMany
    @JoinTable(
        name = "facture_pieces",
        joinColumns = @JoinColumn(name = "facture_id"),
        inverseJoinColumns = @JoinColumn(name = "stock_id")
    )
    private List<Stock> piecesUtilisees;
}