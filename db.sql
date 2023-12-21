-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: crowdsourcing
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `accessrequestinfo`
--

DROP TABLE IF EXISTS `accessrequestinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `accessrequestinfo` (
  `workerusername` varchar(45) NOT NULL DEFAULT '',
  `taskID` varchar(45) NOT NULL DEFAULT '',
  `provideruname` varchar(45) NOT NULL DEFAULT '',
  `datetime` varchar(45) NOT NULL DEFAULT '',
  `status` varchar(45) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accessrequestinfo`
--

LOCK TABLES `accessrequestinfo` WRITE;
/*!40000 ALTER TABLE `accessrequestinfo` DISABLE KEYS */;
INSERT INTO `accessrequestinfo` VALUES ('dilip123','1','yogesh123','20:23:1','closed');
/*!40000 ALTER TABLE `accessrequestinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admininfo`
--

DROP TABLE IF EXISTS `admininfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admininfo` (
  `username` varchar(10) NOT NULL DEFAULT '',
  `password` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admininfo`
--

LOCK TABLES `admininfo` WRITE;
/*!40000 ALTER TABLE `admininfo` DISABLE KEYS */;
INSERT INTO `admininfo` VALUES ('admin','123');
/*!40000 ALTER TABLE `admininfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assignedinfo`
--

DROP TABLE IF EXISTS `assignedinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `assignedinfo` (
  `taskid` varchar(45) NOT NULL DEFAULT '',
  `puname` varchar(45) NOT NULL DEFAULT '',
  `wuname` varchar(45) NOT NULL DEFAULT '',
  `assignedfilename` varchar(45) NOT NULL DEFAULT '',
  `submittedfilename` varchar(45) NOT NULL DEFAULT '',
  `mkey` varchar(45) NOT NULL DEFAULT '',
  `assigneddatetime` varchar(45) NOT NULL DEFAULT '',
  `submitdatetime` varchar(45) NOT NULL DEFAULT '',
  `rewards` varchar(45) NOT NULL DEFAULT '',
  `penalty` varchar(45) NOT NULL DEFAULT '',
  `status` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`taskid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assignedinfo`
--

LOCK TABLES `assignedinfo` WRITE;
/*!40000 ALTER TABLE `assignedinfo` DISABLE KEYS */;
INSERT INTO `assignedinfo` VALUES ('1','yogesh123','dilip123','task1.txt','task1.txt','E97D5CB','20:23:19','20:25:8','13','0','closed');
/*!40000 ALTER TABLE `assignedinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `blockchaininfo`
--

DROP TABLE IF EXISTS `blockchaininfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `blockchaininfo` (
  `type` varchar(45) NOT NULL DEFAULT '',
  `datetime` varchar(45) NOT NULL DEFAULT '',
  `terminalkey` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blockchaininfo`
--

LOCK TABLES `blockchaininfo` WRITE;
/*!40000 ALTER TABLE `blockchaininfo` DISABLE KEYS */;
INSERT INTO `blockchaininfo` VALUES ('blockchainterminalkey','20:27:20-8:27:20 PM','D9EFBA3');
/*!40000 ALTER TABLE `blockchaininfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `providerinfo`
--

DROP TABLE IF EXISTS `providerinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `providerinfo` (
  `name` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `mobile` varchar(100) DEFAULT NULL,
  `initial_balance` varchar(100) DEFAULT NULL,
  `userid` varchar(100) NOT NULL DEFAULT '',
  `password` varchar(100) DEFAULT NULL,
  `pin` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `providerinfo`
--

LOCK TABLES `providerinfo` WRITE;
/*!40000 ALTER TABLE `providerinfo` DISABLE KEYS */;
INSERT INTO `providerinfo` VALUES ('Yogesh','yogesh@gmail.com','9988776655','10,0000','yogesh123','1234','0742');
/*!40000 ALTER TABLE `providerinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `taskinfo`
--

DROP TABLE IF EXISTS `taskinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `taskinfo` (
  `taskid` varchar(45) NOT NULL DEFAULT '',
  `providername` varchar(45) NOT NULL DEFAULT '',
  `enckey` varchar(45) NOT NULL DEFAULT '',
  `filename` varchar(45) NOT NULL DEFAULT '',
  `taskdescription` varchar(1000) NOT NULL DEFAULT '',
  `notask` varchar(45) NOT NULL DEFAULT '',
  `taskdeadline` varchar(45) NOT NULL DEFAULT '',
  `taskamt` varchar(45) NOT NULL DEFAULT '',
  `securitydeposit` varchar(45) NOT NULL DEFAULT '',
  `status` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`taskid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taskinfo`
--

LOCK TABLES `taskinfo` WRITE;
/*!40000 ALTER TABLE `taskinfo` DISABLE KEYS */;
INSERT INTO `taskinfo` VALUES ('1','yogesh123','0742','task1.txt','Java Programm','1','10','12000','2000','closed'),('2','yogesh123','0742','task2.txt','Python Programm','1','6','5000','1000','New');
/*!40000 ALTER TABLE `taskinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workerinfo`
--

DROP TABLE IF EXISTS `workerinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `workerinfo` (
  `name` varchar(45) NOT NULL DEFAULT '',
  `mobileno` varchar(45) NOT NULL DEFAULT '',
  `emailid` varchar(45) NOT NULL DEFAULT '',
  `experience` varchar(45) NOT NULL DEFAULT '',
  `username` varchar(45) NOT NULL DEFAULT '',
  `password` varchar(45) NOT NULL DEFAULT '',
  `balance` varchar(45) NOT NULL DEFAULT '',
  `sign` varchar(45) NOT NULL DEFAULT '',
  `rewards` varchar(45) NOT NULL DEFAULT '',
  `penalty` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workerinfo`
--

LOCK TABLES `workerinfo` WRITE;
/*!40000 ALTER TABLE `workerinfo` DISABLE KEYS */;
INSERT INTO `workerinfo` VALUES ('Dilip','9988776655','dilip123@gmail.com','10','dilip123','1234','100000','4EC8B62','13','0');
/*!40000 ALTER TABLE `workerinfo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-11 19:05:37
