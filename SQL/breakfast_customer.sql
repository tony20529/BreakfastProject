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
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `idcustomer` int NOT NULL AUTO_INCREMENT,
  `customno` varchar(45) DEFAULT NULL,
  `customerintodate` varchar(45) DEFAULT NULL,
  `customername` varchar(45) DEFAULT NULL,
  `customerusername` varchar(45) DEFAULT NULL,
  `customerpassword` varchar(100) DEFAULT NULL,
  `customergender` varchar(45) DEFAULT NULL,
  `customerage` varchar(45) DEFAULT NULL,
  `customermobile` varchar(45) DEFAULT NULL,
  `customeraddress` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idcustomer`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'C00001','2025/02/23(日)','King','king123','c2dd07e19e21616c891309b0a09c25df629de93cdc0c0c8ac493f498c32bf8dc','女','22','0956369874','台北市中正區南陽街7號2樓'),(2,'C00002','2025/02/24(一)','Ben','ben123','9afc93baa4f360629aa2a6b6e44d013d417975609cd14aef3252e5ccbac1cbe1','男','30','0926987412','台北市中正區公園路30號3樓'),(3,'C00003','2025/02/24(一)','Mary','mary123','85c8aab5e999059e29e14fdd4c8ee8528eaf79faf139ab61f600c6be93b1d3ba','女','30','0956987412','台北市中正區公園路30號3樓'),(4,'C00004','2025/02/24(一)','Aen','aen123','a63a7e3e7aea7fea0004e7d7f6081ef4750cf1f9cef0a075ef6e701b5544d4ff','男','30','0923698547','台北市中正區公園路30號3樓'),(5,'C00005','2025/02/24(一)','Den','den123','afa9b66211b2492a5c4b76a2ac548464edfa2e4c71d215e5d3aefd67b8a6246c','男','25','0953698741','台北市中正區公園路30號3樓'),(6,'C00006','2025/02/24(一)','Gen','gen123','4217f0e543324b028576d1a45d0c02ebf27caea09b8933834b5ce20dfa35e482','男','22','0965478963','台北市中正區公園路30號3樓'),(7,'C00007','2025/02/24(一)','Hen','hen123','7e6c7836fdd844614c5b906cfcc221cef806361285f9a1b4ebbe76b67a5b5833','男','22','0936987452','基隆市中正區義一路18號9樓'),(8,'C00008','2025/02/24(一)','Ien','ien123','185c2a05e361688c5170f3ed991dcef43a0669d194e942a044f0a5f600d39693','男','26','0965412369','基隆市中正區義一路18號9樓'),(9,'C00009','2025/02/24(一)','Jen','jen123','d915d0d363fabf71bcd8c87688eb189fc892256420bd01025b4547b8e28c91ba','男','48','0965874123','基隆市中正區義一路18號9樓'),(10,'C00010','2025/02/24(一)','Len','len123','6380416016fcde75fbda10b4a62a05753450ccd77d3f8b14ec6f9853a1cac302','男','24','0985654123','基隆市中正區義一路18號9樓'),(11,'C00011','2025/02/24(一)','Yen','yen123','49f13100d2c7f719b964e1ff020e2f21d66f63d22548ff718fad2ed0a2913e63','男','26','0936542123','台北市大安區忠孝東路四段169號4F之1'),(12,'C00012','2025/02/24(一)','Zen','zen123','c208f36ef5987f75818a0a3f62fc1c560df44674f9826e785a4e400773a0d101','男','26','0965412369','台北市大安區忠孝東路四段169號4F之1'),(13,'C00013','2025/02/24(一)','Fen','fen123','a956ca92b404fecb55ea462a696c4924478d236f3a67fca64a6d076f59c53fe6','男','22','0965412369','台北市大安區忠孝東路四段169號4F之1'),(14,'C00014','2025/02/24(一)','Dan','dan123','e27af8fbb4512eb70eab789e572e48fa9617ab9d3003cfcee18bbb40672bf9c7','男','22','0985412369','台北市大安區忠孝東路四段169號4F之1'),(15,'C00015','2025/02/24(一)','BBQ','bbq123','72e0b5ac5e7d1cb1d71d04dedf6e3750a8e3c3fe2ce33d4554de8e39b04ff01e','男','20','0965569874','台北市大安區忠孝東路四段169號4F之1'),(16,'C00016','2025/02/24(一)','Gan','gan123','acc3a8dce865a32f468526e2426a16586cf6e3afdd373ea59b661f804141d67e','男','25','0987456123','台北市大安區忠孝東路四段169號4F之1'),(17,'C00017','2025/02/24(一)','Ting','ting123','f98d28c4840f337e1bd39de3d38eaf125f60c4a4358e5fbb303863bbb9c17d1b','女','18','0958745698','台北市大安區忠孝東路四段169號4F之1'),(18,'C00018','2025/02/24(一)','Snow','snow123','25368626a9a9673c7f19f0ba3e14bc5d469687bae0885fcf63c195967a920837','女','22','0987456321','台北市大安區忠孝東路四段169號4F之1'),(19,'C00019','2025/02/24(一)','Joy','joy123','5b93ce3c09a125c7fd03952c361c6e1a0ada367108c754235832f47a2be30fae','男','40','0985456321','台北市大安區忠孝東路四段169號4F之1'),(20,'C00020','2025/02/24(一)','Yuu','yuu123','e3bebd3231250d06cd52e5b51edcaa276d940c1484011061ef3b866b5d3a9c9e','女','18','0985469321','台北市大安區忠孝東路四段169號4F之1');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
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
