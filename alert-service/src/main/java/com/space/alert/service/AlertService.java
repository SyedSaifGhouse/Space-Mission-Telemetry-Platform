package com.space.alert.service;

import com.space.alert.entity.Alert;
import com.space.alert.exception.AlertNotFoundException;
import com.space.alert.repository.AlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AlertService {

    @Autowired
    private AlertRepository alertRepository;

    // Create
    public Alert saveAlert(Alert alert) {
        alert.setTimestamp(LocalDateTime.now());
        return alertRepository.save(alert);
    }

    // Read All
    public List<Alert> getAllAlerts() {
        return alertRepository.findAll();
    }

    // Read By ID
    public Alert getAlertById(Long id) {
        return alertRepository.findById(id)
                .orElseThrow(() ->
                        new AlertNotFoundException("Alert with ID " + id + " not found."));
    }

    // Update
    public Alert updateAlert(Long id, Alert alert) {

        Alert existingAlert = alertRepository.findById(id)
                .orElseThrow(() ->
                        new AlertNotFoundException("Alert with ID " + id + " not found."));

        existingAlert.setSatelliteId(alert.getSatelliteId());
        existingAlert.setAlertType(alert.getAlertType());
        existingAlert.setMessage(alert.getMessage());
        existingAlert.setTimestamp(LocalDateTime.now());

        return alertRepository.save(existingAlert);
    }

    // Delete
    public String deleteAlert(Long id) {

        Alert alert = alertRepository.findById(id)
                .orElseThrow(() ->
                        new AlertNotFoundException("Alert with ID " + id + " not found."));

        alertRepository.delete(alert);

        return "Alert deleted successfully.";
    }
}