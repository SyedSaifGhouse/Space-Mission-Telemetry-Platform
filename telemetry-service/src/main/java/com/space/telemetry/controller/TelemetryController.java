package com.space.telemetry.controller;

import com.space.telemetry.entity.Telemetry;
import com.space.telemetry.service.TelemetryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/telemetry")
public class TelemetryController {

    @Autowired
    private TelemetryService telemetryService;

    // Create
    @PostMapping
    public Telemetry addTelemetry(@Valid @RequestBody Telemetry telemetry) {
        return telemetryService.saveTelemetry(telemetry);
    }

    // Read All
    @GetMapping
    public List<Telemetry> getAllTelemetry() {
        return telemetryService.getAllTelemetry();
    }

    // Read By ID
    @GetMapping("/{id}")
    public Telemetry getTelemetryById(@PathVariable Long id) {
        return telemetryService.getTelemetryById(id);
    }

    // Update
    @PutMapping("/{id}")
    public Telemetry updateTelemetry(@PathVariable Long id,
                                     @Valid @RequestBody Telemetry telemetry) {

        return telemetryService.updateTelemetry(id, telemetry);
    }

    // Delete
    @DeleteMapping("/{id}")
    public String deleteTelemetry(@PathVariable Long id) {

        return telemetryService.deleteTelemetry(id);
    }
}