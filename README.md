# Space Mission Telemetry Platform
## Overview

The Space Mission Telemetry Platform is a Microservices-based Spring Boot application designed to simulate the monitoring and management of space mission operations. The platform is divided into independent services, where each microservice performs a specific responsibility and communicates through an API Gateway.

This project demonstrates the implementation of Microservices Architecture using Spring Boot.

## Technologies Used

* Java 17
* Spring Boot
* Maven
* REST API
* Spring Boot Actuator
* IntelliJ IDEA
* Git
* GitHub

## Project Structure
```
Space-Mission-Telemetry-Platform
│
├── api-gateway
├── maintenance-service
├── mission-alert-service
├── orbital-registry-service
└── sensor-monitor-device
```

## Microservices
### 1. API Gateway

Acts as the single entry point for all client requests.

Project Name:
```
api-gateway
```

Responsibilities

* Routes incoming requests
* Centralized API access
* Future integration with Spring Cloud Gateway

### 2. Maintenance Service

Project Name:
```
maintenance-service
```

Port
```
8080
```

Responsibilities

* Handles maintenance-related operations
* Provides REST APIs for maintenance management

### 3. Orbital Registry Service

Project Name:
```
orbital-registry-service
```

Port
```
8081
```

Responsibilities

* Maintains orbital registry information
* Handles spacecraft registration data

### 4. Sensor Monitor Device

Project Name
```
sensor-monitor-device
```

Port
```
8082
```

Responsibilities

* Simulates spacecraft sensor monitoring
* Provides telemetry sensor data
  
## 5. Mission Alert Service

Project Name
```
mission-alert-service
```

Port
```
8083
```

Responsibilities

* Generates mission alerts
* Handles alert notifications

## Port Configuration

<img width="311" height="230" alt="image" src="https://github.com/user-attachments/assets/1e0ad946-a55b-49a1-ad5e-e471982bb266" />

## Architecture Diagram
```
                    +----------------------+
                    |       Client         |
                    +----------+-----------+
                               |
                               |
                     +---------v---------+
                     |    API Gateway    |
                     +---------+---------+
                               |
       -----------------------------------------------------
       |                  |                 |               |
       |                  |                 |               |
+------v------+   +-------v-------+ +-------v-------+ +-----v------+
| Maintenance |   |   Orbital     | | Sensor Monitor| |  Mission   |
|  Service    |   | Registry      | |    Device     | | Alert       |
|  Port 8080  |   | Port 8081     | | Port 8082     | | Port 8083   |
+-------------+   +---------------+ +---------------+ +-------------+
```

## Screenshots

All microservices were accessed and tested through the API Gateway running on Port 8084. The API Gateway acts as the single entry point for client requests and routes them to the appropriate microservice based on the configured routes. The following screenshots demonstrate successful GET and POST requests for each microservice through the API Gateway.


## Future Enhancements
* Spring Cloud Gateway
* Service Discovery
* Config Server
* Load Balancing
* Circuit Breaker
* JWT Authentication
* Docker
* Kubernetes
* Monitoring Dashboard
* Database Integration

## Author
### SYED SAIF SYED GHOUSE

## GitHub
https://github.com/SyedSaifGhouse
