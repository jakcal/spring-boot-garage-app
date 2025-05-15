package com.example.springboot_garage.model;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reference;
    private String designation;
    private String categorie; // Pièces détachées, Pneus, Huiles, etc.
    private Integer quantite;
    private Double prixUnitaire;
    private String fournisseur;
    private Integer seuilAlerte; // Seuil minimal avant réapprovisionnement
    
    @ManyToOne
    @JoinColumn(name = "garage_id")
    private Garage garage;
}