package com.example.springboot_garage.service;

import com.example.springboot_garage.model.Employe;
import com.example.springboot_garage.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeService {

    private final EmployeRepository employeRepository;

    @Autowired
    public EmployeService(EmployeRepository employeRepository) {
        this.employeRepository = employeRepository;
    }

    public Employe createEmploye(Employe employe) {
        return employeRepository.save(employe);
    }

    public List<Employe> getAllEmployes() {
        return employeRepository.findAll();
    }

    public Optional<Employe> getEmployeById(Long id) {
        return employeRepository.findById(id);
    }

    public Employe updateEmploye(Long id, Employe employeDetails) {
        Employe employe = employeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employe not found with id: " + id));

        // Update employe properties here based on employeDetails
        // employe.setProperty(employeDetails.getProperty());

        return employeRepository.save(employe);
    }

    public void deleteEmploye(Long id) {
        Employe employe = employeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employe not found with id: " + id));
        employeRepository.delete(employe);
    }
}