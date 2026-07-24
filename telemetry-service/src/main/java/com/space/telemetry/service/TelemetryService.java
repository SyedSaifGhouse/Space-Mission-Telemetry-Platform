package com.space.telemetry.service;

import com.space.telemetry.dto.AlertDTO;
import com.space.telemetry.dto.SatelliteDTO;
import com.space.telemetry.entity.Telemetry;
import com.space.telemetry.exception.TelemetryNotFoundException;
import com.space.telemetry.repository.TelemetryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TelemetryService {

    @Autowired
    private TelemetryRepository telemetryRepository;

    @Autowired
    private RestTemplate restTemplate;

    // ===========================
    // Create Telemetry
    // ===========================
    public Telemetry saveTelemetry(Telemetry telemetry) {

        verifySatelliteExists(telemetry.getSatelliteId());

        telemetry.setTimestamp(LocalDateTime.now());

        Telemetry savedTelemetry = telemetryRepository.save(telemetry);

        generateAlert(savedTelemetry);

        return savedTelemetry;
    }

    // ===========================
    // Get All Telemetry
    // ===========================
    public List<Telemetry> getAllTelemetry() {
        return telemetryRepository.findAll();
    }

    // ===========================
    // Get Telemetry By ID
    // ===========================
    public Telemetry getTelemetryById(Long id) {

        return telemetryRepository.findById(id)
                .orElseThrow(() ->
                        new TelemetryNotFoundException(
                                "Telemetry with ID " + id + " not found."));
    }

    // ===========================
    // Update Telemetry
    // ===========================
    public Telemetry updateTelemetry(Long id, Telemetry telemetry) {

        Telemetry existingTelemetry = telemetryRepository.findById(id)
                .orElseThrow(() ->
                        new TelemetryNotFoundException(
                                "Telemetry with ID " + id + " not found."));

        verifySatelliteExists(telemetry.getSatelliteId());

        existingTelemetry.setSatelliteId(telemetry.getSatelliteId());
        existingTelemetry.setTemperature(telemetry.getTemperature());
        existingTelemetry.setBatteryLevel(telemetry.getBatteryLevel());
        existingTelemetry.setSignalStrength(telemetry.getSignalStrength());
        existingTelemetry.setTimestamp(LocalDateTime.now());

        Telemetry updatedTelemetry = telemetryRepository.save(existingTelemetry);

        generateAlert(updatedTelemetry);

        return updatedTelemetry;
    }

    // ===========================
    // Delete Telemetry
    // ===========================
    public String deleteTelemetry(Long id) {

        Telemetry telemetry = telemetryRepository.findById(id)
                .orElseThrow(() ->
                        new TelemetryNotFoundException(
                                "Telemetry with ID " + id + " not found."));

        telemetryRepository.delete(telemetry);

        return "Telemetry deleted successfully.";
    }

    // ===========================
    // Verify Satellite Exists
    // ===========================
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

    // ===========================
    // Generate Alert
    // ===========================
    private void generateAlert(Telemetry telemetry) {

        AlertDTO alert = new AlertDTO();

        alert.setSatelliteId(telemetry.getSatelliteId());

        if (telemetry.getBatteryLevel() < 20) {

            alert.setAlertType("LOW_BATTERY");
            alert.setMessage("Battery level is below 20%");

        } else if (telemetry.getTemperature() > 80) {

            alert.setAlertType("HIGH_TEMPERATURE");
            alert.setMessage("Temperature exceeded 80°C");

        } else if ("Weak".equalsIgnoreCase(telemetry.getSignalStrength())) {

            alert.setAlertType("WEAK_SIGNAL");
            alert.setMessage("Signal strength is weak");

        } else {
            return;
        }

        restTemplate.postForObject(
                "http://localhost:8083/alerts",
                alert,
                AlertDTO.class);
    }
}