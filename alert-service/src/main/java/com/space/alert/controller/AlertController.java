package com.space.alert.controller;

import com.space.alert.entity.Alert;
import com.space.alert.service.AlertService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alerts")
public class AlertController {

    @Autowired
    private AlertService alertService;

    // Create
    @PostMapping
    public Alert addAlert(@Valid @RequestBody Alert alert) {
        return alertService.saveAlert(alert);
    }

    // Read All
    @GetMapping
    public List<Alert> getAllAlerts() {
        return alertService.getAllAlerts();
    }

    // Read By ID
    @GetMapping("/{id}")
    public Alert getAlertById(@PathVariable Long id) {
        return alertService.getAlertById(id);
    }

    // Update
    @PutMapping("/{id}")
    public Alert updateAlert(@PathVariable Long id,
                             @Valid @RequestBody Alert alert) {
        return alertService.updateAlert(id, alert);
    }

    // Delete
    @DeleteMapping("/{id}")
    public String deleteAlert(@PathVariable Long id) {
        return alertService.deleteAlert(id);
    }
}