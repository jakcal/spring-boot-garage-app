package com.example.springboot_garage.model;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String adresse;
    
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<RendezVous> rendezVous;
    
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Facture> factures;
}