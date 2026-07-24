package com.space.satellite.controller;

import com.space.satellite.entity.Satellite;
import com.space.satellite.service.SatelliteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/satellites")
public class SatelliteController {

    @Autowired
    private SatelliteService satelliteService;

    // Create
    @PostMapping
    public Satellite addSatellite(@Valid @RequestBody Satellite satellite) {
        return satelliteService.saveSatellite(satellite);
    }

    // Read All
    @GetMapping
    public List<Satellite> getAllSatellites() {
        return satelliteService.getAllSatellites();
    }

    // Read By ID
    @GetMapping("/{id}")
    public Satellite getSatelliteById(@PathVariable Long id) {
        return satelliteService.getSatelliteById(id);
    }

    // Update
    @PutMapping("/{id}")
    public Satellite updateSatellite(@PathVariable Long id,
                                     @Valid @RequestBody Satellite satellite) {
        return satelliteService.updateSatellite(id, satellite);
    }

    // Delete
    @DeleteMapping("/{id}")
    public String deleteSatellite(@PathVariable Long id) {
        return satelliteService.deleteSatellite(id);
    }
}