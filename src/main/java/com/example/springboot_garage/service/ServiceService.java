package com.example.springboot_garage.service;

import com.example.springboot_garage.model.Service;
import com.example.springboot_garage.model.Service.TypeService;
import com.example.springboot_garage.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ServiceService {

    private final ServiceRepository serviceRepository;

    @Autowired
    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public Service createService(Service service) {
        return serviceRepository.save(service);
    }

    public List<Service> getAllServices() {
        return serviceRepository.findAll();
    }

    public Optional<Service> getServiceById(Long id) {
        return serviceRepository.findById(id);
    }

    public List<Service> getServicesByType(TypeService type) {
        return serviceRepository.findByType(type);
    }

    public List<Service> searchServicesByName(String nom) {
        return serviceRepository.findByNomContaining(nom);
    }

    public List<Service> getServicesByPrixLessThan(Double prix) {
        return serviceRepository.findByPrixLessThan(prix);
    }

    public Service updateService(Long id, Service serviceDetails) {
        Service service = serviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service non trouvé avec l'id: " + id));

        service.setNom(serviceDetails.getNom());
        service.setDescription(serviceDetails.getDescription());
        service.setPrix(serviceDetails.getPrix());
        service.setType(serviceDetails.getType());

        return serviceRepository.save(service);
    }

    public void deleteService(Long id) {
        Service service = serviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service non trouvé avec l'id: " + id));
        serviceRepository.delete(service);
    }
}