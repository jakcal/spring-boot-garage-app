package com.example.springboot_garage.service;

import com.example.springboot_garage.model.Garage;
import com.example.springboot_garage.repository.GarageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GarageService {

    private final GarageRepository garageRepository;

    @Autowired
    public GarageService(GarageRepository garageRepository) {
        this.garageRepository = garageRepository;
    }

    public Garage createGarage(Garage garage) {
        return garageRepository.save(garage);
    }

    public List<Garage> getAllGarages() {
        return garageRepository.findAll();
    }

    public Optional<Garage> getGarageById(Long id) {
        return garageRepository.findById(id);
    }

    public Garage updateGarage(Long id, Garage garageDetails) {
        Garage garage = garageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Garage not found with id: " + id)); // Consider creating a custom exception

        garage.setName(garageDetails.getName());
        garage.setLocation(garageDetails.getLocation());
        return garageRepository.save(garage);
    }

    public void deleteGarage(Long id) {
        Garage garage = garageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Garage not found with id: " + id)); // Consider creating a custom exception
        garageRepository.delete(garage);
    }
}