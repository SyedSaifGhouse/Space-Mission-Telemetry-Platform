# 🚀 Space Mission Telemetry Platform

<p align="center">

![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?style=for-the-badge&logo=springboot)
![MySQL](https://img.shields.io/badge/MySQL-8.0-4479A1?style=for-the-badge&logo=mysql)
![REST API](https://img.shields.io/badge/REST-API-blue?style=for-the-badge)
![Microservices](https://img.shields.io/badge/Microservices-Architecture-red?style=for-the-badge)
![API Gateway](https://img.shields.io/badge/API-Gateway-purple?style=for-the-badge)
![Maven](https://img.shields.io/badge/Maven-Build-C71A36?style=for-the-badge&logo=apachemaven)

</p>

A Microservices-based Space Mission Telemetry Platform developed using **Spring Boot**, **Spring Cloud Gateway**, **Spring Data JPA**, **MySQL**, and **REST APIs**.

The platform simulates the monitoring of satellites by collecting telemetry data, generating mission alerts, scheduling maintenance activities, and exposing all services through a centralized API Gateway.

---

# 📑 Table of Contents

- [Project Overview](#project-overview)
- [Key Features](#key-features)
- [System Architecture](#system-architecture)
- [Technologies Used](#technologies-used)
- [Microservices](#microservices)
- [Database Design](#database-design)
- [API Endpoints](#api-endpoints)
- [Microservice Communication](#microservice-communication)
- [Project Structure](#project-structure)
- [Running the Project](#running-the-project)
- [Testing](#testing)
- [Project Outputs](#project-outputs)
- [Future Enhancements](#future-enhancements)
- [Author](#author)
- [GitHub](#github)
  
---
<h1 id="project-overview">📌 Project Overview</h1>

This project demonstrates a complete Microservices Architecture where each business functionality is implemented as an independent Spring Boot application with its own database.

The system includes:


- Satellite Management Service
- Telemetry Management Service
- Alert Management Service
- Maintenance Management Service
- API Gateway

Each microservice owns its own database and communicates using REST APIs.

---

<h1 id="key-features">✨ Key Features</h1>

The **Space Mission Telemetry Platform** incorporates modern backend development practices and microservices architecture to efficiently manage satellite operations. The key features of the project include:

- 🛰️ Microservices-based architecture using Spring Boot.
- 🌐 Centralized request routing with Spring Cloud API Gateway.
- 📡 Satellite, Telemetry, Alert, and Maintenance management services.
- 🔗 RESTful APIs with inter-service communication using RestTemplate.
- 🛢️ Independent MySQL database for each microservice.
- 🔄 Complete CRUD operations using Spring Data JPA.
- ✅ Bean Validation and Global Exception Handling.
- 📬 REST API testing using Postman.
- 🏛️ Layered architecture for better maintainability and scalability.
- 🚀 Modular, scalable, and easy-to-extend backend design.

---

<h1 id="system-architecture">🏗️ System Architecture</h1>

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

<h1 id="technologies-used">⚙️ Technologies Used</h1>

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

<h1 id="microservices">📂 Microservices</h1>

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

<h1 id="database-design">🗄️ Database Design</h1>

Each microservice has its own independent database.

| Service | Database |
|----------|-----------|
| Satellite | satellite_db |
| Telemetry | telemetry_db |
| Alert | alert_db |
| Maintenance | maintenance_db |

---

<h1 id="api-endpoints">🔗 API Endpoints</h1>

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

<h1 id="microservice-communication">🔄 Microservice Communication</h1>

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

<h1 id="author">✅ Features</h1>

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

<h1 id="project-structure">📁 Project Structure</h1>

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

<h1 id="running-the-project">▶️ Running the Project</h1>

## Clone Repository

```bash
git clone https://github.com/SyedSaifGhouse/Space-Mission-Telemetry-Platform.git
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

<h1 id="testing">🧪 Testing</h1>

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

<h1 id="project-outputs">📸 Project Outputs</h1>

## 🛰️ 1. Satellite Service

### POST Satellite

<img width="1920" height="1020" alt="op 1" src="https://github.com/user-attachments/assets/76e06f8f-4c7a-4cf0-b483-0b500d73af48" />

### GET All Satellites

<img width="1920" height="1020" alt="op 2" src="https://github.com/user-attachments/assets/16569d71-133a-4b29-8231-8ee6f3094275" />

---

## 📡 2. Telemetry Service

### POST Telemetry

<img width="1920" height="1020" alt="op 3" src="https://github.com/user-attachments/assets/a3945008-b206-4467-b03f-4fde36e5390d" />

### GET All Telemetry

<img width="1920" height="1020" alt="op 4" src="https://github.com/user-attachments/assets/07cb49f8-2116-4cc9-8508-6f4a5c126d9d" />

---

## 🚨 3. Alert Service

### POST Alerts

<img width="1920" height="1020" alt="op 5 1" src="https://github.com/user-attachments/assets/028837b6-db17-4f3a-850e-e5776d79b5c7" />

### GET All Alerts

<img width="1920" height="1020" alt="op 5 2" src="https://github.com/user-attachments/assets/726eb676-ec96-4a32-b557-615b4d430a18" />

---

## 🔧 4. Maintenance Service

### POST Maintenance

<img width="1920" height="1020" alt="op 6" src="https://github.com/user-attachments/assets/67ea5fd3-9b5b-4078-97e9-8fda23ea5c65" />

### GET Maintenance Records

<img width="1920" height="1020" alt="op 7" src="https://github.com/user-attachments/assets/3afdc289-af09-4c0a-a15a-b788d92c748e" />

---

## 💾 5. MySQL Database

### Satellite Database

<img width="1920" height="1020" alt="satellite" src="https://github.com/user-attachments/assets/5bb38150-7d30-424e-a65a-f149cb65091b" />

### Telemetry Database

<img width="1920" height="1020" alt="Screenshot 2026-07-24 115727" src="https://github.com/user-attachments/assets/72b54064-1f42-4ac6-ae98-18e42b1e2e25" />

### Alert Database

<img width="1920" height="1020" alt="Screenshot 2026-07-24 115757" src="https://github.com/user-attachments/assets/5b834f40-d38d-46c2-8ddd-be7ba5163191" />

### Maintenance Database

<img width="1920" height="1020" alt="Screenshot 2026-07-24 115817" src="https://github.com/user-attachments/assets/40327405-3179-4e65-bfe7-991992590d4f" />

---

## 📑 7. Project Structure

![Project Structure](screenshots/project-structure.png)

---

## 🏛️ 8. Microservices Architecture

![Architecture](screenshots/architecture.png)
---

<h1 id="future-enhancements">📌 Future Enhancements</h1>

- Service Discovery (Eureka)
- Config Server
- JWT Authentication
- Docker
- Kubernetes Deployment
- RabbitMQ/Kafka Messaging
- Monitoring using Prometheus & Grafana
- Circuit Breaker using Resilience4j

---

<h1 id="author">👨‍💻 Author</h1>

**SYED SAIF SYED GHOUSE**

**B.TECH (AI & DS)**

**SAVEETHA ENGINEERING COLLEGE**

Spring Boot Microservices Project

---

<h1 id="github">📄 GitHub</h1>

**Developer Profile:**  
https://github.com/SyedSaifGhouse

**Project Repository:**  
https://github.com/SyedSaifGhouse/Space-Mission-Telemetry-Platform
