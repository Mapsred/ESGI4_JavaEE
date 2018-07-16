-- MySQL dump 10.13  Distrib 5.7.22, for Linux (x86_64)
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `complex_url`
--

LOCK TABLES `complex_url` WRITE;
/*!40000 ALTER TABLE `complex_url` DISABLE KEYS */;
INSERT INTO `complex_url` VALUES (1,8,1),(2,7,1),(3,10,1),(4,11,1),(5,12,1),(6,13,1),(7,18,1),(8,19,1);
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
INSERT INTO `password` VALUES (2,'mdr'),(3,'mdr'),(4,'mdr'),(5,'mdr'),(6,'kamal123'),(7,'kamal123'),(8,'tt'),(9,'kamal123'),(14,'kamal123'),(15,'kamal123');
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
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `simple_url`
--

LOCK TABLES `simple_url` WRITE;
/*!40000 ALTER TABLE `simple_url` DISABLE KEYS */;
INSERT INTO `simple_url` VALUES (1,'https://google.fr','https://google.fr','2018-05-05 00:00:00','2018-11-05 00:00:00'),(2,'https://github.com/Mapsred?tab=repositories','https://github.com/Mapsred?tab=repositories','2018-05-05 00:00:00','2018-11-05 00:00:00'),(3,'https://github.com/Mapsred?tab=repositories','https://github.com/Mapsred?tab=repositories','2018-05-05 00:00:00','2018-11-05 00:00:00'),(4,'https://github.com/Mapsred?tab=repositories','https://github.com/Mapsred?tab=repositories','2018-05-05 00:00:00','2018-11-05 00:00:00'),(5,'https://github.com/Mapsred?tab=repositories','https://github.com/Mapsred?tab=repositories','2018-05-05 00:00:00','2018-11-05 00:00:00'),(6,'https://github.com/Mapsred?tab=repositories','https://github.com/Mapsred?tab=repositories','2018-05-05 00:00:00','2018-11-05 00:00:00'),(7,'https://www.myges.fr/common/project-group-creation/2810','https://www.myges.fr/common/project-group-creation/2810','2018-05-05 00:00:00','2018-11-05 00:00:00'),(8,'https://github.com/Mapsred?tab=repositories\n','tt','2018-05-22 00:00:00','2018-11-22 00:00:00'),(9,'TestWithMDP','TestWithMDP','2018-06-09 00:00:00','2018-12-09 00:00:00'),(10,'TestWithCaptcha','TestWithCaptcha','2018-06-09 00:00:00','2018-12-09 00:00:00'),(11,'TestWithMaxClick','TestWithMaxClick','2018-06-09 00:00:00','2018-12-09 00:00:00'),(12,'TestDateRange','TestDateRange','2018-06-09 00:00:00','2018-12-09 00:00:00'),(13,'TestDateMax','TestDateMax','2018-06-09 00:00:00','2018-12-09 00:00:00'),(14,'test@gmail.com','59d24e0e-2200-4865-9a1a-750e89a37a84','2018-07-03 00:00:00','2019-01-03 00:00:00'),(15,'test@gmail.com','4','2018-07-03 00:00:00','2019-01-03 00:00:00'),(16,'test@gmail.com','2','2018-07-03 00:00:00','2019-01-03 00:00:00'),(17,'test@gmail.com','2','2018-07-03 00:00:00','2019-01-03 00:00:00'),(18,'toto.com','6907c0ff-79c3-435c-8a49-55d03d3672a2','2018-07-10 00:00:00','2019-01-10 00:00:00'),(19,'tata.com','f5d83825-0692-4c40-8d79-c104e7b551d4','2018-07-10 00:00:00','2019-01-10 00:00:00');
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
INSERT INTO `url_pass_option` VALUES (3,'captcha',NULL,NULL,NULL),(4,'click',NULL,NULL,100),(5,'daterange','2018-06-11','2018-06-09',NULL),(6,'datemax','2018-06-09','2018-06-30',NULL),(7,'captcha',NULL,NULL,NULL),(8,'captcha',NULL,NULL,NULL);
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

-- Dump completed on 2018-07-16  9:27:02
