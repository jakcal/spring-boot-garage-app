package com.example.springboot_garage.model;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String description;
    private Double prix;

    @Enumerated(EnumType.STRING)
    private TypeService type;

    // Enum pour les différents types de services proposés
    public enum TypeService {
        LUSTRAGE_LAVAGE("Lustrage & Lavage Auto"),
        PNEUMATIQUE("Pneumatique"),
        DIAGNOSTIC_ELECTRICITE("Diagnostique & Electricité"),
        GESTION_SINISTRES("Gestion des sinistres automobile"),
        CARROSSERIE_PEINTURE("Carrosserie & Peinture"),
        MECANIQUE_GENERALE("Mécanique Générale");

        private final String libelle;

        TypeService(String libelle) {
            this.libelle = libelle;
        }

        public String getLibelle() {
            return libelle;
        }
    }
}