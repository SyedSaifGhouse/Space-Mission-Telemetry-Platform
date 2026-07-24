package com.space.satellite.exception;

public class SatelliteNotFoundException extends RuntimeException {

    public SatelliteNotFoundException(String message) {
        super(message);
    }
}