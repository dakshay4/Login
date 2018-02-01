-- MySQL dump 10.13  Distrib 5.7.20, for Linux (x86_64)
--
-- Host: localhost    Database: login
-- ------------------------------------------------------
-- Server version	5.7.20-0ubuntu0.17.10.1

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
-- Table structure for table `PROFILE`
--

DROP TABLE IF EXISTS `PROFILE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PROFILE` (
  `FIRST_NAME` varchar(20) NOT NULL,
  `LAST_NAME` varchar(20) NOT NULL,
  `ADDRESS` varchar(50) DEFAULT NULL,
  `CITY` varchar(20) DEFAULT NULL,
  `PIN` int(11) DEFAULT NULL,
  `DOB` date DEFAULT NULL,
  `USERID` varchar(20) NOT NULL,
  PRIMARY KEY (`USERID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PROFILE`
--

LOCK TABLES `PROFILE` WRITE;
/*!40000 ALTER TABLE `PROFILE` DISABLE KEYS */;
INSERT INTO `PROFILE` VALUES ('abc','pqr','123','Haryana',122010,'1996-12-04','abcd'),('AGARWAL','DAKSHAY','U 50/11, DLF PH 3','Rajasthan',122010,'1970-01-01','agarwal'),('DAKSHAY','AGARWAL','63/127, PRATAP NAGAR, SANGANER, JAIPUR','Rajasthan',302033,'1970-01-01','dakshay'),('DAKSHAY','AGARWAL','U50/11','Haryana',122010,'1970-01-01','dakshayagarwal'),('pqr','xyz','000','Haryana',122021,'1995-12-12','pqr'),('g','h','jk','Haryana',122010,'1970-01-01','rahul');
/*!40000 ALTER TABLE `PROFILE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `REGISTER`
--

DROP TABLE IF EXISTS `REGISTER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `REGISTER` (
  `USERID` varchar(20) NOT NULL,
  `EMAIL` varchar(100) DEFAULT NULL,
  `PASS` varchar(15) DEFAULT NULL,
  `MOBILE_NO` bigint(20) DEFAULT NULL,
  `PROFILE` int(1) NOT NULL,
  PRIMARY KEY (`USERID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `REGISTER`
--

LOCK TABLES `REGISTER` WRITE;
/*!40000 ALTER TABLE `REGISTER` DISABLE KEYS */;
INSERT INTO `REGISTER` VALUES ('abcd','abcd@gmail','456',9876543210,0),('agar','safas@sf.com','asdfaf',4567894561,1),('agarwal','dakdk@gsdnj','asjdfjakbfb',1234567890,1),('DAK','dak@gmmgail.com','dsfsf',9251699651,0),('dakkkk','sadlfn@knb','9784561230',9878989789,0),('dakshay','dakshay@outlook.in','sdfdsf',9799477161,1),('dakshay1','dakshay@outlook.in','sdfsdf',9799477161,0),('dakshayagarwal','dakshsince96@d','123456',9799477161,1),('dfgdfgdfg','dfgdfgdf','gdfgfdgfd',2345345345,0),('dsfdsf','dsfsdfsdf@dfhg.fgh','dfgdfgdf',5645645666,0),('ghjghj','ghjghjg@dsf','ghjgjgjgh',4564564565,0),('MANOJ','manoj.singh@skilrock.com','123',9876543210,0),('pqr','pqr@gmail.com','789',1234567890,0),('rahul','rahul.kumar@gmail.com','123456789',9876543210,1);
/*!40000 ALTER TABLE `REGISTER` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-01-18 18:40:54
