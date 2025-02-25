CREATE DATABASE  IF NOT EXISTS `breakfast` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `breakfast`;
-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: localhost    Database: breakfast
-- ------------------------------------------------------
-- Server version	8.0.41

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
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `idemployee` int NOT NULL AUTO_INCREMENT,
  `employeeno` varchar(45) DEFAULT NULL,
  `employeeintodate` varchar(45) DEFAULT NULL,
  `employeename` varchar(45) DEFAULT NULL,
  `employeeidcard` varchar(45) DEFAULT NULL,
  `employeepassword` varchar(100) DEFAULT NULL,
  `employeegender` varchar(45) DEFAULT NULL,
  `employeeage` varchar(45) DEFAULT NULL,
  `employeebirthday` varchar(45) DEFAULT NULL,
  `employeemobile` varchar(45) DEFAULT NULL,
  `employeeeducation` varchar(45) DEFAULT NULL,
  `employeeaddress` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idemployee`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (4,'E00001','2025/02/24(一)','Tony','A123456789','675d4a9457ee58fbec9709284e597828167a33d2f76dd9480346b8e564f3e9cc','男','30','83/2/5','0956987412','NNU','台北市中正區衡陽路60號'),(5,'E00002','2025/02/24(一)','Yam','A123456987','1b4066a45918cfd4e6050f12af7968bad0b31b5c2daf40fa97a95143efac4f16','男','30','83/3/5','0987456987','JJU','台北市大安區忠孝東路四段169號4F之1'),(6,'E00003','2025/02/24(一)','Shell','A258965412','5607301bae031279a1b82b1ecaa38ffb576a6b7c4bd40146437ab072c97f4a9e','女','26','87/8/7','0962369412','HNU','台北市大安區忠孝東路四段169號4F之1'),(7,'E00004','2025/02/24(一)','Rita','A254123654','de1463eb2a38dedb7a60cb340b168f949f01cdd9fdbc76d243bf2d1dffbea8de','女','22','91/5/6','0965412365','NTU','台北市大安區忠孝東路四段169號4F之1'),(8,'E00005','2025/02/24(一)','Alice','A256987412','6766ad37ada06ddc90f432f8d915f991dd0ec6559bfd8d400b380e4aef4e3ac1','女','35','79/10/6','0985412369','AU','台北市大安區忠孝東路四段169號4F之1');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-02-26  1:13:43
