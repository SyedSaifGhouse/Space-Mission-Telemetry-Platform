package com.space.telemetry.dto;

import lombok.Data;

@Data
public class AlertDTO {

    private Long satelliteId;
    private String alertType;
    private String message;
}