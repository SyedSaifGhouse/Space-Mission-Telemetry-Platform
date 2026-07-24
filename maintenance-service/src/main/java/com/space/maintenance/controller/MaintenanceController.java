package com.space.maintenance.controller;

import com.space.maintenance.entity.Maintenance;
import com.space.maintenance.service.MaintenanceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/maintenance")
public class MaintenanceController {

    @Autowired
    private MaintenanceService maintenanceService;

    // Create
    @PostMapping
    public Maintenance addMaintenance(@Valid @RequestBody Maintenance maintenance) {
        return maintenanceService.saveMaintenance(maintenance);
    }

    // Read All
    @GetMapping
    public List<Maintenance> getAllMaintenance() {
        return maintenanceService.getAllMaintenance();
    }

    // Read By ID
    @GetMapping("/{id}")
    public Maintenance getMaintenanceById(@PathVariable Long id) {
        return maintenanceService.getMaintenanceById(id);
    }

    // Update
    @PutMapping("/{id}")
    public Maintenance updateMaintenance(@PathVariable Long id,
                                         @Valid @RequestBody Maintenance maintenance) {
        return maintenanceService.updateMaintenance(id, maintenance);
    }

    // Delete
    @DeleteMapping("/{id}")
    public String deleteMaintenance(@PathVariable Long id) {
        return maintenanceService.deleteMaintenance(id);
    }
}