-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: localhost    Database: 2c_accounting
-- ------------------------------------------------------
-- Server version	5.6.22-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `authority`
--

LOCK TABLES `authority` WRITE;
/*!40000 ALTER TABLE `authority` DISABLE KEYS */;
INSERT INTO `authority` VALUES 
(1,'admin','administrator');
/*!40000 ALTER TABLE `authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES 
(1,'admin','admin',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tax_rates`
--

LOCK TABLES `tax_rates` WRITE;
/*!40000 ALTER TABLE `tax_rates` DISABLE KEYS */;
INSERT INTO `tax_rates` VALUES 
(1,'nds','20.0');
/*!40000 ALTER TABLE `tax_rates` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `organization`
--

LOCK TABLES `organization` WRITE;
/*!40000 ALTER TABLE `organization` DISABLE KEYS */;
INSERT INTO `organization` VALUES 
(NULL,'ИП Мельников Николай Сергеевич','220007, г. Минск, ул. Могилевская, 16 кв. 415'),
(NULL,'ООО \"Джи Джи Н\"','РБ, 220114, г. Минск, ул. Кедышко, 24, каб. 30'),
(NULL,'ИП Смирнов Алексей Александрович','г. Минск, ул. Куйбышева, 91, кв. 51'),
(NULL,'ЧП \"Ладсервис\"','г. Минск, ул. Могилевская, 9'),
(NULL,'ООО \"Лект-торг\"','г. Минск, ул. Одинцова, 53');
/*!40000 ALTER TABLE `organization` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES 
(NULL,'Чашка для кофе 180мл. \"Интеко\" однор.'),
(NULL,'Бумага туалетная \"Хатнiк\" (белая), уп. 4 шт. 100% целлюл. 2-х слойн.'),
(NULL,'Вилка 16,5см. \"БалтПласт\" (х8000) однор.'),
(NULL,'Контейнер 250 мл'),
(NULL,'Мешки фасов. ПНД 10+8*27 КК');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `invoice`
--

LOCK TABLES `invoice` WRITE;
/*!40000 ALTER TABLE `invoice` DISABLE KEYS */;
INSERT INTO `invoice` VALUES 
(NULL,10102,'2016-01-10 16:00:00',2,1,1,200,350,70000,1,14000,84000),
(NULL,10102,'2016-01-10 16:00:00',2,1,2,50,2700,135000,1,27000,162000),
(NULL,10102,'2016-01-10 16:00:00',2,1,3,3000,120,360000,1,72000,432000),
(NULL,10133,'2016-01-15 16:00:00',3,1,4,480,3400,1632000,1,326400,1958400),
(NULL,10133,'2016-01-15 16:00:00',3,1,5,1300,850,1105000,1,221000,1326000),

(NULL,20201,'2016-01-22 16:00:00',1,4,1,110,402.5,44275,1,8855,53130),
(NULL,20201,'2016-01-22 16:00:00',1,4,2,50,3105,155250,1,31050,186300),

(NULL,20244,'2016-01-25 16:00:00',1,5,1,90,402.5,36225,1,7245,43470),
(NULL,20244,'2016-01-25 16:00:00',1,5,4,400,3910,1564000,1,312800,1876800),
(NULL,20244,'2016-01-25 16:00:00',1,5,5,1300,977.5,1270750,1,254150,1524900);
/*!40000 ALTER TABLE `invoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `income_position`
--

LOCK TABLES `income_position` WRITE;
/*!40000 ALTER TABLE `income_position` DISABLE KEYS */;
/*!40000 ALTER TABLE `income_position` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `income_position_payment`
--

LOCK TABLES `income_position_payment` WRITE;
/*!40000 ALTER TABLE `income_position_payment` DISABLE KEYS */;
/*!40000 ALTER TABLE `income_position_payment` ENABLE KEYS */;
UNLOCK TABLES;




--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES
(NULL,30301,'2016-01-11 16:00:00',10102,1,2,1,200,70000),
(NULL,30301,'2016-01-11 16:00:00',10102,1,2,2,50,135000),
(NULL,30301,'2016-01-11 16:00:00',10102,1,2,3,2500,300000),

(NULL,30352,'2016-01-16 16:00:00',10133,1,3,4,480,1632000),
(NULL,30352,'2016-01-16 16:00:00',10102,1,3,5,1300,1105000),

(NULL,40401,'2016-01-23 16:00:00',20201,4,1,1,110,44275),
(NULL,40401,'2016-01-23 16:00:00',20201,4,1,2,50,155250),

(NULL,40463,'2016-01-26 16:00:00',20244,5,1,1,90,36225),
(NULL,40463,'2016-01-26 16:00:00',20244,5,1,4,400,1564000),
(NULL,40463,'2016-01-26 16:00:00',20244,5,1,5,1300,1270750);
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `shipment_position`
--

LOCK TABLES `shipment_position` WRITE;
/*!40000 ALTER TABLE `shipment` DISABLE KEYS */;
/*!40000 ALTER TABLE `shipment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `shipment_position_payment`
--

LOCK TABLES `shipment_position_payment` WRITE;
/*!40000 ALTER TABLE `shipment_payment` DISABLE KEYS */;
/*!40000 ALTER TABLE `shipment_payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `storage`
--

LOCK TABLES `storage` WRITE;
/*!40000 ALTER TABLE `storage` DISABLE KEYS */;
/*!40000 ALTER TABLE `storage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `bank_account`
--

LOCK TABLES `bank_account` WRITE;
/*!40000 ALTER TABLE `storage` DISABLE KEYS */;
/*!40000 ALTER TABLE `storage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `test_invoice`
--

LOCK TABLES `test_invoice` WRITE;
/*!40000 ALTER TABLE `test_invoice` DISABLE KEYS */;
/*!40000 ALTER TABLE `test_invoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `test_product`
--

LOCK TABLES `test_product` WRITE;
/*!40000 ALTER TABLE `test_product` DISABLE KEYS */;
/*!40000 ALTER TABLE `test_product` ENABLE KEYS */;
UNLOCK TABLES;


/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-01-26 20:14:29
