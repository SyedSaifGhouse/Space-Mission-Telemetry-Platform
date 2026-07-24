package com.space.alert.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "alert")
@Data
public class Alert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long alertId;

    @NotNull(message = "Satellite ID is required")
    private Long satelliteId;

    @NotBlank(message = "Alert type is required")
    private String alertType;

    @NotBlank(message = "Alert message is required")
    private String message;

    private LocalDateTime timestamp;
}