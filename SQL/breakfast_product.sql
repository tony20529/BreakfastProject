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
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `idproduct` int NOT NULL AUTO_INCREMENT,
  `productno` varchar(45) DEFAULT NULL,
  `productname` varchar(45) DEFAULT NULL,
  `productprice` int DEFAULT NULL,
  `productinventory` int DEFAULT NULL,
  `productsafeinventory` int DEFAULT NULL,
  `productintodate` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idproduct`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (2,'P00001','雞腿排漢堡',70,69,30,'2025/02/24(一)'),(3,'P00002','夾蛋堡',30,67,30,'2025/02/24(一)'),(4,'P00003','招牌漢堡',45,98,70,'2025/02/24(一)'),(5,'P00004','果醬吐司',50,95,50,'2025/02/24(一)'),(6,'P00005','蔥抓餅',30,67,40,'2025/02/24(一)'),(7,'P00006','經典美式牛肉堡',75,98,70,'2025/02/24(一)'),(8,'P00007','原味蛋餅',25,96,50,'2025/02/24(一)'),(9,'P00008','玉米蛋餅',40,69,50,'2025/02/24(一)'),(10,'P00009','火腿三明治',30,100,70,'2025/02/24(一)'),(11,'P00010','肉鬆三明治',30,100,70,'2025/02/24(一)'),(12,'P00011','黑胡椒鐵板麵',40,100,70,'2025/02/24(一)'),(13,'P00012','蘑菇鐵板麵',40,99,70,'2025/02/24(一)'),(14,'P00013','奶茶',20,193,100,'2025/02/24(一)'),(15,'P00014','豆漿',20,200,100,'2025/02/24(一)'),(16,'P00015','玩具牛奶',35,141,70,'2025/02/24(一)');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
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
