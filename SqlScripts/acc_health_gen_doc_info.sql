-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: acc_health
-- ------------------------------------------------------
-- Server version	8.0.11
USE `acc_health`;

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `gen_doc_info`
--

DROP TABLE IF EXISTS `gen_doc_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `gen_doc_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `gender` varchar(6) NOT NULL,
  `clinic_address` varchar(100) NOT NULL,
  `state` varchar(20) NOT NULL,
  `longi` varchar(20) DEFAULT NULL,
  `lat` varchar(20) DEFAULT NULL,
  `openhr` time NOT NULL,
  `closehr` time NOT NULL,
  `contact_no` varchar(20) DEFAULT NULL,
  `waiting_patient` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gen_doc_info`
--

LOCK TABLES `gen_doc_info` WRITE;
/*!40000 ALTER TABLE `gen_doc_info` DISABLE KEYS */;
INSERT INTO `gen_doc_info` VALUES (100,'Selvamalar Ponnambalam','Male','No. 25 Jalan Metro Perdana Barat 1 Taman Usahawan, Kepong 52100','Kuala Lumpur','101.642765','3.215317','08:00:00','21:00:00','03-62571436',5),(101,'Lim Zi Shan','Female','52, Jalan Lang Kuning, Taman Sri Bintang, 52100 Kuala Lumpur, Wilayah Persekutuan Kuala Lumpur','Kuala Lumpur','101.644548','3.190917','08:00:00','20:00:00','03-62741471',4),(102,'Json Chong','Male','52,  Jalan Othman 3/14, Pjs 3, 46000 Petaling Jaya','Selangor','101.649214','3.086968','08:00:00','20:00:00','\r03-77853130',7),(103,'Khairi Rahman','Male','119, Jalan SS 20/10, Damansara Utama, 47400 Petaling Jaya','Selangor','101.627731','3.138143','09:00:00','18:00:00','\r03-77181000',7);
/*!40000 ALTER TABLE `gen_doc_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-08-27  1:28:04
