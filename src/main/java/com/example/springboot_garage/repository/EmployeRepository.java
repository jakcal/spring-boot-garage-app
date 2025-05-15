package com.example.springboot_garage.repository;

import com.example.springboot_garage.model.Employe;
import com.example.springboot_garage.model.Employe.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeRepository extends JpaRepository<Employe, Long> {
    // Méthode pour trouver les employés par rôle
    List<Employe> findByRole(Role role);
    
    // Méthode pour trouver un employé par email
    Employe findByEmail(String email);
    
    // Méthode pour trouver des employés par nom ou prénom
    List<Employe> findByNomContainingOrPrenomContaining(String nom, String prenom);
}