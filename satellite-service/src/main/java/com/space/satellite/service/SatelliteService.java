package com.space.satellite.service;

import com.space.satellite.entity.Satellite;
import com.space.satellite.exception.SatelliteNotFoundException;
import com.space.satellite.repository.SatelliteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SatelliteService {

    @Autowired
    private SatelliteRepository satelliteRepository;

    // Create a new satellite
    public Satellite saveSatellite(Satellite satellite) {
        return satelliteRepository.save(satellite);
    }

    // Get all satellites
    public List<Satellite> getAllSatellites() {
        return satelliteRepository.findAll();
    }

    // Get satellite by ID
    public Satellite getSatelliteById(Long id) {
        return satelliteRepository.findById(id)
                .orElseThrow(() ->
                        new SatelliteNotFoundException("Satellite with ID " + id + " not found."));
    }

    // Update satellite
    public Satellite updateSatellite(Long id, Satellite satellite) {

        Satellite existingSatellite = satelliteRepository.findById(id)
                .orElseThrow(() ->
                        new SatelliteNotFoundException("Satellite with ID " + id + " not found."));

        existingSatellite.setName(satellite.getName());
        existingSatellite.setMissionName(satellite.getMissionName());
        existingSatellite.setLaunchDate(satellite.getLaunchDate());
        existingSatellite.setOrbitType(satellite.getOrbitType());
        existingSatellite.setStatus(satellite.getStatus());

        return satelliteRepository.save(existingSatellite);
    }

    // Delete satellite
    public String deleteSatellite(Long id) {

        Satellite satellite = satelliteRepository.findById(id)
                .orElseThrow(() ->
                        new SatelliteNotFoundException("Satellite with ID " + id + " not found."));

        satelliteRepository.delete(satellite);

        return "Satellite deleted successfully.";
    }
}