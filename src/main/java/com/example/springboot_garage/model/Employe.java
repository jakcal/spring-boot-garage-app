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
public class Employe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    
    @Enumerated(EnumType.STRING)
    private Role role;
    
    @OneToMany(mappedBy = "mecanicien")
    private List<RendezVous> rendezVous;
    
    // Enum pour les différents rôles des employés
    public enum Role {
        MECANICIEN("Mécanicien"),
        RECEPTIONNISTE("Réceptionniste"),
        ADMINISTRATEUR("Administrateur");
        
        private final String libelle;
        
        Role(String libelle) {
            this.libelle = libelle;
        }
        
        public String getLibelle() {
            return libelle;
        }
    }
}