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
-- Table structure for table `organization`
--

DROP TABLE IF EXISTS `organization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `organization` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(300) NOT NULL,
  `address` varchar(300) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(300) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `authority`
--

DROP TABLE IF EXISTS `authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `authority` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `permissions` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `login` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `authority_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_authority_idx` (`authority_id`),
  CONSTRAINT `fk_user_authority_id` FOREIGN KEY (`authority_id`) REFERENCES `authority` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tax_rates`
--

DROP TABLE IF EXISTS `tax_rates`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tax_rates` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `value` decimal(20,4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `invoice`
--

DROP TABLE IF EXISTS `invoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `invoice` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `number` bigint(20) NOT NULL,
  `date` datetime NOT NULL,
  `sender_id` bigint(20) NOT NULL,
  `reciever_id` bigint(20) NOT NULL,
  `product_id` bigint(20) NOT NULL,
  `product_amount` bigint(20) NOT NULL,
  `product_price` decimal(20,4) NOT NULL,
  `product_cost` decimal(20,4) NOT NULL,
  `nds_id` bigint(20) NOT NULL,
  `nds_cost` decimal(20,4) NOT NULL,
  `total_cost` decimal(20,4) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_number_idx` (`number`),
  KEY `fk_sender_idx` (`sender_id`),
  KEY `fk_reciever_idx` (`reciever_id`),
  KEY `fk_product_idx` (`product_id`),
  KEY `fk_nds_idx` (`nds_id`),
  CONSTRAINT `fk_invoice_sender_id` FOREIGN KEY (`sender_id`) REFERENCES `organization` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_invoice_reciever_id` FOREIGN KEY (`reciever_id`) REFERENCES `organization` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,  
  CONSTRAINT `fk_invoice_product_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_invoice_nds_id` FOREIGN KEY (`nds_id`) REFERENCES `tax_rates` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `number` bigint(20) NOT NULL,
  `date` datetime NOT NULL,
  `invoice_number` bigint(20) NOT NULL,
  `sender_id` bigint(20) NOT NULL,
  `reciever_id` bigint(20) NOT NULL,  
  `product_id` bigint(20) NOT NULL,
  `product_amount` bigint(20) NOT NULL,
  `amount` decimal(20,4) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_invoice_numberx` (`invoice_number`),
  KEY `fk_sender_idx` (`sender_id`),
  KEY `fk_reciever_idx` (`reciever_id`),
  KEY `fk_product_idx` (`product_id`),
  CONSTRAINT `fk_payment_invoice_number` FOREIGN KEY (`invoice_number`) REFERENCES `invoice` (`number`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_payment_sender_id` FOREIGN KEY (`sender_id`) REFERENCES `organization` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_payment_reciever_id` FOREIGN KEY (`reciever_id`) REFERENCES `organization` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,  
  CONSTRAINT `fk_payment_product_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `storage`
--

DROP TABLE IF EXISTS `storage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `storage` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `invoice_id` bigint(20) NOT NULL,
  `product_id` bigint(20) NOT NULL,
  `product_amount` decimal(20,4) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_invoice_idx` (`invoice_id`),
  KEY `fk_product_idx` (`product_id`),
  CONSTRAINT `fk_storage_invoice_id` FOREIGN KEY (`invoice_id`) REFERENCES `invoice` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_storage_product_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `bank_account`
--

DROP TABLE IF EXISTS `bank_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bank_account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `payment_id` bigint(20) NOT NULL,
  `income_amount` decimal(20,4) NOT NULL,
  `outcome_amount` decimal(20,4) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_payment_idx` (`payment_id`),
  CONSTRAINT `fk_bank_account_payment_id` FOREIGN KEY (`payment_id`) REFERENCES `payment` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `income_position`
--

DROP TABLE IF EXISTS `income_position`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `income_position` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sender_id` bigint(20) NOT NULL,
  `reciever_id` bigint(20) NOT NULL,
  `invoice_id` bigint(20) NOT NULL,
  `product_id` bigint(20) NOT NULL,
  `product_amount` bigint(20) NOT NULL,
  `product_cost` decimal(20,4) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_sender_idx` (`sender_id`),
  KEY `fk_reciever_idx` (`reciever_id`),
  KEY `fk_invoice_idx` (`invoice_id`),
  KEY `fk_product_idx` (`product_id`),
  CONSTRAINT `fk_income_position_sender_id` FOREIGN KEY (`sender_id`) REFERENCES `organization` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_income_position_reciever_id` FOREIGN KEY (`reciever_id`) REFERENCES `organization` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_income_position_invoice_id` FOREIGN KEY (`invoice_id`) REFERENCES `invoice` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_income_position_product_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `income_position_payment`
--

DROP TABLE IF EXISTS `income_position_payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `income_position_payment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sender_id` bigint(20) NOT NULL,
  `reciever_id` bigint(20) NOT NULL,
  `payment_id` bigint(20) NOT NULL,
  `payment_amount` decimal(20,4) NOT NULL,
  `product_id` bigint(20) NOT NULL,
  `product_amount` bigint(20) NOT NULL,
  `product_cost` decimal(20,4) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_sender_idx` (`sender_id`),
  KEY `fk_reciever_idx` (`reciever_id`),
  KEY `fk_payment_idx` (`payment_id`),
  KEY `fk_product_idx` (`product_id`),
  CONSTRAINT `fk_income_position_payment_sender_id` FOREIGN KEY (`sender_id`) REFERENCES `organization` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_income_position_payment_reciever_id` FOREIGN KEY (`reciever_id`) REFERENCES `organization` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_income_position_payment_payment_id` FOREIGN KEY (`payment_id`) REFERENCES `payment` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_income_position_payment_product_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `shipment_position`
--

DROP TABLE IF EXISTS `shipment_position`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shipment_position` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sender_id` bigint(20) NOT NULL,
  `reciever_id` bigint(20) NOT NULL,
  `invoice_id` bigint(20) NOT NULL,
  `product_id` bigint(20) NOT NULL,
  `product_amount` bigint(20) NOT NULL,
  `shipment_cost` decimal(20,4) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_sender_idx` (`sender_id`),
  KEY `fk_reciever_idx` (`reciever_id`),  
  KEY `fk_invoice_idx` (`invoice_id`),
  KEY `fk_product_idx` (`product_id`),
  CONSTRAINT `fk_shipment_sender_id` FOREIGN KEY (`sender_id`) REFERENCES `organization` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_shipment_reciever_id` FOREIGN KEY (`reciever_id`) REFERENCES `organization` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,    
  CONSTRAINT `fk_shipment_invoice_id` FOREIGN KEY (`invoice_id`) REFERENCES `invoice` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_shipment_product_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `shipment_position_payment`
--

DROP TABLE IF EXISTS `shipment_position_payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shipment_position_payment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sender_id` bigint(20) NOT NULL,
  `reciever_id` bigint(20) NOT NULL,
  `payment_id` bigint(20) NOT NULL,
  `payment_amount` decimal(20,4) NOT NULL,
  `product_id` bigint(20) NOT NULL,
  `product_amount` bigint(20) NOT NULL,
  `product_cost` decimal(20,4) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_sender_idx` (`sender_id`),
  KEY `fk_reciever_idx` (`reciever_id`),
  KEY `fk_payment_idx` (`payment_id`),
  KEY `fk_product_idx` (`product_id`),
  CONSTRAINT `fk_shipment_payment_sender_id` FOREIGN KEY (`sender_id`) REFERENCES `organization` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_shipment_payment_reciever_id` FOREIGN KEY (`reciever_id`) REFERENCES `organization` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_shipment_payment_payment_id` FOREIGN KEY (`payment_id`) REFERENCES `payment` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_shipment_payment_product_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;