# 🚀 Space Mission Telemetry Platform

A Microservices-based Space Mission Telemetry Platform developed using **Spring Boot**, **Spring Cloud Gateway**, **Spring Data JPA**, **MySQL**, and **REST APIs**.

The platform simulates the monitoring of satellites by collecting telemetry data, generating mission alerts, scheduling maintenance activities, and exposing all services through a centralized API Gateway.

---

# 📌 Project Overview

This project demonstrates a complete Microservices Architecture where each business functionality is implemented as an independent Spring Boot application with its own database.

The system includes:

- Satellite Management Service
- Telemetry Management Service
- Alert Management Service
- Maintenance Management Service
- API Gateway

Each microservice owns its own database and communicates using REST APIs.

---

# 🏗️ System Architecture

```
                   Client / Postman
                          │
                          ▼
                 API Gateway (8080)
                          │
     ┌────────────┬────────────┬────────────┬────────────┐
     ▼            ▼            ▼            ▼
Satellite      Telemetry     Alert     Maintenance
Service         Service      Service      Service
(8081)          (8082)       (8083)       (8084)
     │            │            │            │
     ▼            ▼            ▼            ▼
satellite_db telemetry_db alert_db maintenance_db
```

---

# ⚙️ Technologies Used

- Java 17
- Spring Boot
- Spring Data JPA
- Spring Cloud Gateway
- REST APIs
- Maven
- MySQL
- MySQL Workbench
- Hibernate
- Bean Validation
- Lombok
- IntelliJ IDEA
- Postman
- Git
- GitHub

---

# 📂 Microservices

## 1️⃣ Satellite Service

**Port:** `8081`

### Responsibilities

- Register satellites
- Update satellite information
- Retrieve satellite details
- Delete satellites

### Database

```
satellite_db
```

---

## 2️⃣ Telemetry Service

**Port:** `8082`

### Responsibilities

- Store telemetry data
- Validate satellite existence
- Generate mission alerts automatically

### Database

```
telemetry_db
```

---

## 3️⃣ Alert Service

**Port:** `8083`

### Responsibilities

- Store mission alerts
- Retrieve alert history
- Update alerts
- Delete alerts

### Database

```
alert_db
```

---

## 4️⃣ Maintenance Service

**Port:** `8084`

### Responsibilities

- Schedule maintenance
- Validate satellite existence
- Update maintenance status
- Delete maintenance records

### Database

```
maintenance_db
```

---

## 5️⃣ API Gateway

**Port:** `8080`

Acts as the single entry point for all client requests.

Routes requests to the appropriate microservice.

---

# 🗄️ Database Design

Each microservice has its own independent database.

| Service | Database |
|----------|-----------|
| Satellite | satellite_db |
| Telemetry | telemetry_db |
| Alert | alert_db |
| Maintenance | maintenance_db |

---

# 🔗 API Endpoints

## Satellite Service

| Method | Endpoint |
|---------|-----------|
| POST | /satellites |
| GET | /satellites |
| GET | /satellites/{id} |
| PUT | /satellites/{id} |
| DELETE | /satellites/{id} |

---

## Telemetry Service

| Method | Endpoint |
|---------|-----------|
| POST | /telemetry |
| GET | /telemetry |
| GET | /telemetry/{id} |
| PUT | /telemetry/{id} |
| DELETE | /telemetry/{id} |

---

## Alert Service

| Method | Endpoint |
|---------|-----------|
| POST | /alerts |
| GET | /alerts |
| GET | /alerts/{id} |
| PUT | /alerts/{id} |
| DELETE | /alerts/{id} |

---

## Maintenance Service

| Method | Endpoint |
|---------|-----------|
| POST | /maintenance |
| GET | /maintenance |
| GET | /maintenance/{id} |
| PUT | /maintenance/{id} |
| DELETE | /maintenance/{id} |

---

# 🔄 Microservice Communication

The project uses **RestTemplate** for synchronous communication.

### Telemetry Service

Checks whether a satellite exists before storing telemetry.

```
Telemetry Service
        │
        ▼
Satellite Service
```

Telemetry also automatically generates alerts when thresholds are exceeded.

```
Telemetry Service
        │
        ▼
 Alert Service
```

---

### Maintenance Service

Validates satellite existence before scheduling maintenance.

```
Maintenance Service
          │
          ▼
   Satellite Service
```

---

# ✅ Features

- Microservices Architecture
- CRUD Operations
- REST APIs
- Spring Data JPA
- Bean Validation
- Global Exception Handling
- MySQL Integration
- API Gateway Routing
- Service-to-Service Communication
- Automatic Alert Generation
- Independent Databases
- Maven Build
- Clean Layered Architecture

---

# 📁 Project Structure

```
Space-Mission-Telemetry-Platform

│
├── satellite-service
│
├── telemetry-service
│
├── alert-service
│
├── maintenance-service
│
├── api-gateway
│
├── SQL Scripts
│
├── Postman Collection
│
└── README.md
```

---

# ▶️ Running the Project

## Clone Repository

```bash
git clone https://github.com/yourusername/Space-Mission-Telemetry-Platform.git
```

---

## Create Databases

```
satellite_db
telemetry_db
alert_db
maintenance_db
```

---

## Start Services

Run services in the following order:

1. Satellite Service
2. Telemetry Service
3. Alert Service
4. Maintenance Service
5. API Gateway

---

# 🧪 Testing

Use Postman through the API Gateway.

```
http://localhost:8080
```

Example:

```
GET /satellites
POST /telemetry
GET /alerts
POST /maintenance
```

---

# 📌 Future Enhancements

- Service Discovery (Eureka)
- Config Server
- JWT Authentication
- Docker
- Kubernetes Deployment
- RabbitMQ/Kafka Messaging
- Monitoring using Prometheus & Grafana
- Circuit Breaker using Resilience4j

---

# 👨‍💻 Author

**SYED SAIF SYED GHOUSE**
**B.TECH (AI & DS)**
**SAVEETHA ENGINEERING COLLEGE**

Spring Boot Microservices Project

---

# 📄 GitHub
https://github.com/SyedSaifGhouse
