package com.space.telemetry.exception;

public class TelemetryNotFoundException extends RuntimeException {

    public TelemetryNotFoundException(String message) {
        super(message);
    }
}