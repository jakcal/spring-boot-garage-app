package com.example.springboot_garage.model;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RendezVous {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateHeure;
    private String description;
    private String statut; // Confirmé, En attente, Annulé, Terminé
    
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    
    @ManyToOne
    @JoinColumn(name = "employe_id")
    private Employe mecanicien;
    
    @ManyToMany
    @JoinTable(
        name = "rendez_vous_services",
        joinColumns = @JoinColumn(name = "rendez_vous_id"),
        inverseJoinColumns = @JoinColumn(name = "service_id")
    )
    private List<Service> services;
    
    @OneToOne(mappedBy = "rendezVous", cascade = CascadeType.ALL)
    private Facture facture;
}