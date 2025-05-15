package com.example.springboot_garage.repository;

import com.example.springboot_garage.model.Facture;
import com.example.springboot_garage.model.Client;
import com.example.springboot_garage.model.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FactureRepository extends JpaRepository<Facture, Long> {
    // Méthode pour trouver les factures d'un client
    List<Facture> findByClient(Client client);
    
    // Méthode pour trouver une facture par son numéro
    Facture findByNumero(String numero);
    
    // Méthode pour trouver les factures par statut
    List<Facture> findByStatut(String statut);
    
    // Méthode pour trouver les factures par mode de paiement
    List<Facture> findByModePaiement(String modePaiement);
    
    // Méthode pour trouver les factures entre deux dates
    List<Facture> findByDateEmissionBetween(LocalDate debut, LocalDate fin);
    
    // Méthode pour trouver la facture associée à un rendez-vous
    Facture findByRendezVous(RendezVous rendezVous);
}