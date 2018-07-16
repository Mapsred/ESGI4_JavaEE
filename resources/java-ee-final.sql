-- MySQL dump 10.13  Distrib 5.7.14, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: java-ee-final
-- ------------------------------------------------------
-- Server version	5.5.5-10.2.14-MariaDB-10.2.14+maria~jessie

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
-- Table structure for table `complex_url`
--

DROP TABLE IF EXISTS `complex_url`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `complex_url` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `simple_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `complex_url_ibfk_1` (`simple_id`),
  CONSTRAINT `complex_url_ibfk_1` FOREIGN KEY (`simple_id`) REFERENCES `simple_url` (`id`),
  CONSTRAINT `complex_url_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `complex_url`
--

LOCK TABLES `complex_url` WRITE;
/*!40000 ALTER TABLE `complex_url` DISABLE KEYS */;
INSERT INTO `complex_url` VALUES (1,1,1);
/*!40000 ALTER TABLE `complex_url` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `password`
--

DROP TABLE IF EXISTS `password`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `password` (
  `url` int(11) NOT NULL,
  `password` varchar(256) NOT NULL,
  KEY `url` (`url`),
  CONSTRAINT `password_ibfk_1` FOREIGN KEY (`url`) REFERENCES `simple_url` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `password`
--

LOCK TABLES `password` WRITE;
/*!40000 ALTER TABLE `password` DISABLE KEYS */;
INSERT INTO `password` VALUES (2,'kamal123');
/*!40000 ALTER TABLE `password` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `simple_url`
--

DROP TABLE IF EXISTS `simple_url`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `simple_url` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `base_url` text NOT NULL,
  `new_url` varchar(256) NOT NULL,
  `created_at` datetime NOT NULL,
  `deleted_at` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`),
  KEY `id_2` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `simple_url`
--

LOCK TABLES `simple_url` WRITE;
/*!40000 ALTER TABLE `simple_url` DISABLE KEYS */;
INSERT INTO `simple_url` VALUES (1,'https://google.fr','63c4b0e8-21f1-4176-bfa1-9a5a5bb3b6ab','2018-07-16 00:00:00','2019-01-16 00:00:00'),(2,'https://google.fr','620fe631-a7db-4a99-aaac-062f54810284','2018-07-16 00:00:00','2019-01-16 00:00:00');
/*!40000 ALTER TABLE `simple_url` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `url_pass_option`
--

DROP TABLE IF EXISTS `url_pass_option`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `url_pass_option` (
  `url_complex_id` int(11) NOT NULL,
  `libelle` varchar(256) NOT NULL,
  `end_date` date DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `max_click` int(11) DEFAULT NULL,
  KEY `url_pass_option_ibfk_1` (`url_complex_id`),
  CONSTRAINT `url_pass_option_ibfk_1` FOREIGN KEY (`url_complex_id`) REFERENCES `complex_url` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `url_pass_option`
--

LOCK TABLES `url_pass_option` WRITE;
/*!40000 ALTER TABLE `url_pass_option` DISABLE KEYS */;
INSERT INTO `url_pass_option` VALUES (1,'captcha',NULL,NULL,NULL);
/*!40000 ALTER TABLE `url_pass_option` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `url_stat`
--

DROP TABLE IF EXISTS `url_stat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `url_stat` (
  `url_id` int(11) NOT NULL,
  `date` datetime NOT NULL,
  `ip` varchar(256) NOT NULL,
  KEY `url` (`url_id`),
  CONSTRAINT `url_stat_ibfk_1` FOREIGN KEY (`url_id`) REFERENCES `simple_url` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `url_stat`
--

LOCK TABLES `url_stat` WRITE;
/*!40000 ALTER TABLE `url_stat` DISABLE KEYS */;
/*!40000 ALTER TABLE `url_stat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(256) NOT NULL,
  `email` varchar(256) NOT NULL,
  `pro_status` varchar(256) NOT NULL,
  `enabled` tinyint(4) NOT NULL DEFAULT 1,
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'kamal123','test@gmail.com','PRO',1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-16 22:34:17
