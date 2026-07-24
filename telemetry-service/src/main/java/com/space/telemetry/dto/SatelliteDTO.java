package com.space.telemetry.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SatelliteDTO {

    private Long satelliteId;
    private String name;
    private String missionName;
    private LocalDate launchDate;
    private String orbitType;
    private String status;
}