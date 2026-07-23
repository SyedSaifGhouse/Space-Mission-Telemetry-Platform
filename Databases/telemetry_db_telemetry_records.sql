-- MySQL dump 10.13  Distrib 8.0.46, for Win64 (x86_64)
--
-- Host: localhost    Database: telemetry_db
-- ------------------------------------------------------
-- Server version	8.0.46

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `telemetry_records`
--

DROP TABLE IF EXISTS `telemetry_records`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `telemetry_records` (
  `telemetry_id` int NOT NULL AUTO_INCREMENT,
  `altitude` double DEFAULT NULL,
  `battery_level` int DEFAULT NULL,
  `satellite_id` int NOT NULL,
  `signal_strength` double DEFAULT NULL,
  `temperature` double NOT NULL,
  `timestamp` datetime(6) NOT NULL,
  PRIMARY KEY (`telemetry_id`),
  CONSTRAINT `telemetry_records_chk_1` CHECK (((`battery_level` >= 0) and (`battery_level` <= 100)))
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `telemetry_records`
--

LOCK TABLES `telemetry_records` WRITE;
/*!40000 ALTER TABLE `telemetry_records` DISABLE KEYS */;
INSERT INTO `telemetry_records` VALUES (3,450,15,100,18,82,'2026-07-22 15:30:00.000000'),(4,450,15,100,18,82,'2026-07-22 15:30:00.000000'),(5,450,15,100,18,82,'2026-07-22 15:30:00.000000'),(6,450,15,100,18,82,'2026-07-22 15:30:00.000000'),(7,550.2,85,1,92,35.5,'2026-07-23 20:30:00.000000'),(8,550,15,1,90,35,'2026-07-23 20:30:00.000000');
/*!40000 ALTER TABLE `telemetry_records` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-07-23 20:53:00
