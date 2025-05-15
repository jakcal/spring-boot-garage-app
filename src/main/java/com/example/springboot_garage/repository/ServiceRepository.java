package com.example.springboot_garage.repository;

import com.example.springboot_garage.model.Service;
import com.example.springboot_garage.model.Service.TypeService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {
    // Méthode pour trouver les services par type
    List<Service> findByType(TypeService type);
    
    // Méthode pour trouver les services par nom contenant une chaîne de caractères
    List<Service> findByNomContaining(String nom);
    
    // Méthode pour trouver les services par prix inférieur à une valeur
    List<Service> findByPrixLessThan(Double prix);
}