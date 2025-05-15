package com.example.springboot_garage.repository;

import com.example.springboot_garage.model.RendezVous;
import com.example.springboot_garage.model.Client;
import com.example.springboot_garage.model.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RendezVousRepository extends JpaRepository<RendezVous, Long> {
    // Méthode pour trouver les rendez-vous d'un client
    List<RendezVous> findByClient(Client client);
    
    // Méthode pour trouver les rendez-vous d'un mécanicien
    List<RendezVous> findByMecanicien(Employe mecanicien);
    
    // Méthode pour trouver les rendez-vous par statut
    List<RendezVous> findByStatut(String statut);
    
    // Méthode pour trouver les rendez-vous entre deux dates
    List<RendezVous> findByDateHeureBetween(LocalDateTime debut, LocalDateTime fin);
    
    // Méthode pour trouver les rendez-vous après une date donnée
    List<RendezVous> findByDateHeureAfter(LocalDateTime date);
}