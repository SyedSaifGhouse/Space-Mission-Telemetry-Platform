package com.space.maintenance.service;

import com.space.maintenance.dto.SatelliteDTO;
import com.space.maintenance.entity.Maintenance;
import com.space.maintenance.exception.MaintenanceNotFoundException;
import com.space.maintenance.repository.MaintenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class MaintenanceService {

    @Autowired
    private MaintenanceRepository maintenanceRepository;

    @Autowired
    private RestTemplate restTemplate;

    // Create
    public Maintenance saveMaintenance(Maintenance maintenance) {

        verifySatelliteExists(maintenance.getSatelliteId());

        return maintenanceRepository.save(maintenance);
    }

    // Read All
    public List<Maintenance> getAllMaintenance() {
        return maintenanceRepository.findAll();
    }

    // Read By ID
    public Maintenance getMaintenanceById(Long id) {

        return maintenanceRepository.findById(id)
                .orElseThrow(() ->
                        new MaintenanceNotFoundException(
                                "Maintenance record with ID " + id + " not found."));
    }

    // Update
    public Maintenance updateMaintenance(Long id, Maintenance maintenance) {

        Maintenance existing = maintenanceRepository.findById(id)
                .orElseThrow(() ->
                        new MaintenanceNotFoundException(
                                "Maintenance record with ID " + id + " not found."));

        verifySatelliteExists(maintenance.getSatelliteId());

        existing.setSatelliteId(maintenance.getSatelliteId());
        existing.setMaintenanceType(maintenance.getMaintenanceType());
        existing.setDescription(maintenance.getDescription());
        existing.setScheduledDate(maintenance.getScheduledDate());
        existing.setStatus(maintenance.getStatus());

        return maintenanceRepository.save(existing);
    }

    // Delete
    public String deleteMaintenance(Long id) {

        Maintenance maintenance = maintenanceRepository.findById(id)
                .orElseThrow(() ->
                        new MaintenanceNotFoundException(
                                "Maintenance record with ID " + id + " not found."));

        maintenanceRepository.delete(maintenance);

        return "Maintenance record deleted successfully.";
    }

    // Verify Satellite Exists
    private void verifySatelliteExists(Long satelliteId) {

        try {

            SatelliteDTO satellite = restTemplate.getForObject(
                    "http://localhost:8081/satellites/" + satelliteId,
                    SatelliteDTO.class);

            if (satellite == null) {
                throw new RuntimeException("Satellite not found.");
            }

        } catch (RestClientException ex) {

            throw new RuntimeException(
                    "Satellite with ID " + satelliteId + " does not exist.");
        }
    }
}