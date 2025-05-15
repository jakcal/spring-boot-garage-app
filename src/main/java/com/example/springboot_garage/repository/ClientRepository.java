package com.example.springboot_garage.repository;

import com.example.springboot_garage.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    // Méthode pour trouver un client par email
    Client findByEmail(String email);
    
    // Méthode pour trouver des clients par nom ou prénom
    List<Client> findByNomContainingOrPrenomContaining(String nom, String prenom);
    
    // Méthode pour trouver des clients par numéro de téléphone
    Client findByTelephone(String telephone);
}