CREATE DATABASE  IF NOT EXISTS `couchpotatodb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `couchpotatodb`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: couchpotatodb
-- ------------------------------------------------------
-- Server version	5.7.24

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
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `USER_ID` int(11) NOT NULL,
  `CONTENTS` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` VALUES (5,'1;Soft Pillow;A fluffy and comfortable pillow for a good night\'s sleep;19.99;4:2;Cozy Blanket;A warm and cozy blanket to keep you snug;29.99;2:19;Warmth-Infused Slippers;Slippers with built-in warmth for cold mornings;19.99;1'),(7,'2;Cozy Blanket;A warm and cozy blanket to keep you snug;29.99;5:8;Warm Electric Blanket;An electric blanket with adjustable warmth settings;49.99;1:1;Soft Pillow;A fluffy and comfortable pillow for a good night\'s sleep;19.99;2'),(13,'7;Cushiony Sofa;A comfortable sofa for your living room;599.99;30:23;Face Mask;Cucumber scent;12.99;31'),(18,'1;Soft Pillow;A fluffy and comfortable pillow for a good night\'s sleep;11.99;3'),(19,'4;Plush Robe;A plush bathrobe for luxurious lounging;39.99;8:5;Memory Foam Mattress;A high-quality memory foam mattress for ultimate comfort;299.99;1');
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `CATEGORY_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CATEGORY_NAME` varchar(32) NOT NULL,
  PRIMARY KEY (`CATEGORY_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Bedding'),(2,'Footwear'),(3,'Apparel'),(4,'Furniture'),(5,'Home Decor'),(6,'Toys'),(7,'Outdoor'),(8,'Office'),(9,'Accessories'),(10,'Bath');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `PRODUCT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `PRODUCT_NAME` varchar(50) NOT NULL,
  `PRODUCT_DESCRIPTION` varchar(255) DEFAULT NULL,
  `PRODUCT_PRICE` float DEFAULT '0',
  `PRODUCT_QUANTITY` int(11) DEFAULT '0',
  `PRODUCT_CATEGORY` varchar(32) NOT NULL,
  PRIMARY KEY (`PRODUCT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Soft Pillow','A fluffy and comfortable pillow for a good night\'s sleep',11.99,25,'Bedding'),(2,'Cozy Blanket','A warm and cozy blanket to keep you snug',29.99,6,'Bedding'),(3,'Comfy Slippers','Soft and comfortable slippers for relaxing at home',14.99,33,'Footwear'),(4,'Plush Robe','A plush bathrobe for luxurious lounging',39.99,42,'Apparel'),(5,'Memory Foam Mattress','A high-quality memory foam mattress for ultimate comfort',299.99,99,'Bedding'),(6,'Massage Chair','An ergonomic massage chair for relaxation and stress relief',499.99,3,'Furniture'),(7,'Cushiony Sofa','A comfortable sofa for your living room',599.99,56,'Furniture'),(8,'Warm Electric Blanket','An electric blanket with adjustable warmth settings',49.99,12,'Bedding'),(9,'Soft Throw Pillow','A decorative and soft throw pillow for your couch',9.99,78,'Home Decor'),(10,'Plush Teddy Bear','A huggable and cuddly teddy bear for comfort',19.99,85,'Toys'),(11,'Relaxing Hammock','A hammock for peaceful outdoor relaxation',39.99,1200,'Outdoor'),(12,'Fuzzy Socks','Warm and fuzzy socks for cozy feet',7.99,32,'Footwear'),(13,'Scented Candles','A set of scented candles to create a calming atmosphere',12.99,88,'Home Decor'),(14,'Gel Seat Cushion','A gel seat cushion for comfortable sitting',24,45,'Office'),(15,'Plush Throw Blanket','A soft and plush throw blanket for chilly evenings',17.99,86,'Home Decor'),(16,'Comfy Lounge Chair','A lounge chair for reading and relaxation',79.99,90,'Furniture'),(17,'Silk Sleep Mask','A silk sleep mask for uninterrupted rest',6.99,146,'Accessories'),(18,'Soft Bath Towels','Soft and absorbent bath towels for a spa-like experience',9.99,46,'Bath'),(19,'Warmth-Infused Slippers','Slippers with built-in warmth for cold mornings',19.99,35,'Footwear'),(20,'Faux Fur Throw','A luxurious faux fur throw for added comfort',29.99,47,'Home Decor'),(22,'face cream','very creamy',9.99,2,'Bath'),(23,'Face Mask','Cucumber scent',12.99,1000,'Bath');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `ROLE_ID` int(11) NOT NULL,
  `ROLE_NAME` varchar(50) NOT NULL,
  PRIMARY KEY (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'admin'),(2,'manager'),(3,'employee'),(4,'user');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `USER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `FIRST_NAME` varchar(50) NOT NULL,
  `LAST_NAME` varchar(50) NOT NULL,
  `EMAIL` varchar(100) NOT NULL,
  `PHONE_NUMBER` varchar(10) NOT NULL,
  `USERNAME` varchar(32) NOT NULL,
  `PASSWORD` varchar(255) NOT NULL,
  `IS_ACTIVE` tinyint(1) DEFAULT '1',
  `ROLE` int(11) DEFAULT '4',
  PRIMARY KEY (`USER_ID`),
  UNIQUE KEY `USER_EMAIL_uindex` (`EMAIL`),
  UNIQUE KEY `USER_USERNAME_uindex` (`USERNAME`),
  KEY `USER_ROLE_ROLE_ID_fk` (`ROLE`),
  CONSTRAINT `USER_ROLE_ROLE_ID_fk` FOREIGN KEY (`ROLE`) REFERENCES `role` (`ROLE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Chris','Markel','cmarkel@gmail.com','6026535167','cmarkel','Password123',1,1),(2,'Jeanette','Markel','luckyj5521@gmail.com','6025011490','luckyjen','Password1234',1,1),(3,'Biff','Tannen','btannen@gmail.com','6025555555','btannen','Password12345',1,2),(4,'Marty','McFly','martymcfly@gmail.com','6025555555','mmcfly','Password/123',1,3),(5,'James','Markel','jmarkel@gmail.com','5555555555','jmarkel','$2a$10$yJJcAEKXd27CwKORCo/Hp.Go.AzyGwlEQH/CuU2UdkAtdOxScjTPG',1,1),(7,'Katherine','Markel','kmarkel@gmail.com','5555555555','kmarkel','$2a$10$8QbXXVA4QuFXKOTQDMNVv.1eufNGxXUzv3Dywggozbv5L1rOH8rYi',1,4),(8,'Christine','Markel','christinemarkel@gmail.com','5555555555','chmarkel','$2a$10$jgP/h5/vWWDSTMpHZennHu.XWExv5wRCISdLPrUiWGa02PYVj9KLS',1,4),(11,'Christopher','Markel','chrismarkel@outlook.com','5555555555','cjmarkel','$2a$10$6G8ujd9p3xhmYAIgt.cWGOjNwPzJFaQJx52lIdQy/RCWp1D.qFxD.',1,4),(12,'Billy ','Bob','bbob@aol.com','5555555555','bbob','$2a$10$mDVLMYboVQ5dhMrYScErOumOa/nNaq9aQamKQVm3/u/Mw6V4v.OnS',1,4),(13,'Christine','Markel','christinemarkel@outlook.com','5555555555','Potato1919','$2a$10$IASykE1jxnLSEYx6NTvPUO8aZNfH6V9uilukfcczu2fOF0AXraNN.',1,4),(14,'Michael','Carmen','mcarmen@outlook.com','5555555555','mcarmen','$2a$10$kAG5SriVKng1Y89g9K/gW.mvLGR11ZOAsXTTXnp4Bhy7RlHJftekG',1,4),(16,'Will','Riker','wriker@outlook.com','5555555555','wriker','$2a$10$5ReBjbkFX.cJOc7mQIdjdOWFMnUIYJhcJREVIFLUScApztOTLz26W',1,4),(17,'Beverly','Crusher','bcrusher@outlook.com','5555555555','bcrusher','$2a$10$wfrS9ALWCjWZwxPBIO/0Rug3kym.gZ5kjpurYg4ckcBeQda.xjRnq',1,4),(18,'Deanna','Troi','dtroi@outlook.com','5555555555','dtroi','$2a$10$V.5ZKxcAReRAzshaYaC4ge4zXjcwZTA734X2PJc4VqxvU8zx2nSfS',1,4),(19,'James','Kirk','jkirk@outlook.com','5555555555','jkirk','$2a$10$i5U3v9D07ImLUM2HMTZx0.DmjhZx.CkchAexIkI.yySIRSDylerrS',1,4);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-30 16:48:26
