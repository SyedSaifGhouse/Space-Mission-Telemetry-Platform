package com.space.telemetry.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "telemetry")
@Data
public class Telemetry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long telemetryId;

    @NotNull(message = "Satellite ID is required")
    private Long satelliteId;

    @NotNull(message = "Temperature is required")
    private Double temperature;

    @NotNull(message = "Battery level is required")
    @Min(value = 0, message = "Battery level cannot be less than 0")
    @Max(value = 100, message = "Battery level cannot exceed 100")
    private Double batteryLevel;

    @NotNull(message = "Signal strength is required")
    private String signalStrength;

    private LocalDateTime timestamp;
}