package com.space.satellite.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "satellite")
@Data
public class Satellite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long satelliteId;

    @NotBlank(message = "Satellite name is required")
    private String name;

    @NotBlank(message = "Mission name is required")
    private String missionName;

    private LocalDate launchDate;

    private String orbitType;

    private String status;
}