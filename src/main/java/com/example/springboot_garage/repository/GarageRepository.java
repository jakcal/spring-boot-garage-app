package com.example.springboot_garage.repository;

import com.example.springboot_garage.model.Garage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GarageRepository extends JpaRepository<Garage, Long> {
    // JpaRepository provides CRUD methods like save, findById, findAll, deleteById, etc.
    // Custom query methods can be added here if needed
}