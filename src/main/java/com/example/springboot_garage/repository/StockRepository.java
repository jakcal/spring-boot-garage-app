package com.example.springboot_garage.repository;

import com.example.springboot_garage.model.Stock;
import com.example.springboot_garage.model.Garage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
    // Méthode pour trouver les articles par catégorie
    List<Stock> findByCategorie(String categorie);
    
    // Méthode pour trouver les articles par garage
    List<Stock> findByGarage(Garage garage);
    
    // Méthode pour trouver les articles par fournisseur
    List<Stock> findByFournisseur(String fournisseur);
    
    // Méthode pour trouver les articles dont la quantité est inférieure au seuil d'alerte
    List<Stock> findByQuantiteLessThanEqual(Integer seuilAlerte);
    
    // Méthode pour trouver les articles par référence
    Stock findByReference(String reference);
}