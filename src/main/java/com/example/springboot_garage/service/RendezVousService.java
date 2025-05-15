package com.example.springboot_garage.service;

import com.example.springboot_garage.model.RendezVous;
import com.example.springboot_garage.repository.RendezVousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RendezVousService {

    private final RendezVousRepository rendezVousRepository;

    @Autowired
    public RendezVousService(RendezVousRepository rendezVousRepository) {
        this.rendezVousRepository = rendezVousRepository;
    }

    public RendezVous createRendezVous(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }

    public List<RendezVous> getAllRendezVous() {
        return rendezVousRepository.findAll();
    }

    public Optional<RendezVous> getRendezVousById(Long id) {
        return rendezVousRepository.findById(id);
    }

    public RendezVous updateRendezVous(Long id, RendezVous rendezVousDetails) {
        RendezVous rendezVous = rendezVousRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("RendezVous not found with id: " + id));

        // Update rendezVous properties here based on rendezVousDetails
        // rendezVous.setProperty(rendezVousDetails.getProperty());

        return rendezVousRepository.save(rendezVous);
    }

    public void deleteRendezVous(Long id) {
        RendezVous rendezVous = rendezVousRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("RendezVous not found with id: " + id));
        rendezVousRepository.delete(rendezVous);
    }
}