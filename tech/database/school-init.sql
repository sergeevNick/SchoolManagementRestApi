-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: school
-- ------------------------------------------------------
-- Server version	5.7.20-log

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
-- Table structure for table `days`
--

DROP TABLE IF EXISTS `days`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `days` (
  `DAY_ID` int(11) NOT NULL AUTO_INCREMENT,
  `DAY_NAME` varchar(15) NOT NULL,
  PRIMARY KEY (`DAY_ID`),
  UNIQUE KEY `DAYS_ID_UNIQUE` (`DAY_ID`),
  UNIQUE KEY `DAY_NAME_UNIQUE` (`DAY_NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `days`
--

LOCK TABLES `days` WRITE;
/*!40000 ALTER TABLE `days` DISABLE KEYS */;
INSERT INTO `days` VALUES (2,'Вторник'),(1,'Понедельник'),(5,'Пятница'),(3,'Среда'),(6,'Суббота'),(4,'Четверг');
/*!40000 ALTER TABLE `days` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grades`
--

DROP TABLE IF EXISTS `grades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grades` (
  `GRADE_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NUMBER` varchar(3) NOT NULL,
  PRIMARY KEY (`GRADE_ID`),
  UNIQUE KEY `CLASSES_ID_UNIQUE` (`GRADE_ID`),
  UNIQUE KEY `NUMBER_UNIQUE` (`NUMBER`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grades`
--

LOCK TABLES `grades` WRITE;
/*!40000 ALTER TABLE `grades` DISABLE KEYS */;
INSERT INTO `grades` VALUES (2,'10а'),(1,'11б'),(3,'9в');
/*!40000 ALTER TABLE `grades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lessons`
--

DROP TABLE IF EXISTS `lessons`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lessons` (
  `LESSON_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `START` time NOT NULL,
  `END` time NOT NULL,
  PRIMARY KEY (`LESSON_ID`),
  UNIQUE KEY `LESSON_ID_UNIQUE` (`LESSON_ID`),
  UNIQUE KEY `START_UNIQUE` (`START`),
  UNIQUE KEY `END_UNIQUE` (`END`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lessons`
--

LOCK TABLES `lessons` WRITE;
/*!40000 ALTER TABLE `lessons` DISABLE KEYS */;
INSERT INTO `lessons` VALUES (1,'09:00:00','09:45:00'),(2,'09:55:00','10:40:00'),(3,'11:00:00','11:45:00'),(4,'12:05:00','12:50:00'),(5,'13:00:00','13:45:00'),(6,'13:55:00','14:40:00'),(7,'14:45:00','15:30:00');
/*!40000 ALTER TABLE `lessons` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marks`
--

DROP TABLE IF EXISTS `marks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `marks` (
  `MARK_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `VALUE` int(10) unsigned NOT NULL,
  `DATE` date NOT NULL,
  `SUBJECT_ID` int(10) unsigned NOT NULL,
  `STUDENT_ID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`MARK_ID`,`SUBJECT_ID`,`STUDENT_ID`),
  UNIQUE KEY `MARKS_ID_UNIQUE` (`MARK_ID`),
  KEY `fk_MARKS_SUBJECTS1_idx` (`SUBJECT_ID`),
  KEY `fk_MARKS_USERS1_idx` (`STUDENT_ID`),
  CONSTRAINT `FKbobdu0dce8k5vpm5mbd5ggpb1` FOREIGN KEY (`SUBJECT_ID`) REFERENCES `subjects` (`SUBJECT_ID`),
  CONSTRAINT `FKo23cy8f33nm458cymqrjs540i` FOREIGN KEY (`STUDENT_ID`) REFERENCES `users` (`USER_ID`),
  CONSTRAINT `fk_MARKS_SUBJECTS1` FOREIGN KEY (`SUBJECT_ID`) REFERENCES `subjects` (`SUBJECT_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_MARKS_USERS1` FOREIGN KEY (`STUDENT_ID`) REFERENCES `users` (`USER_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marks`
--

LOCK TABLES `marks` WRITE;
/*!40000 ALTER TABLE `marks` DISABLE KEYS */;
INSERT INTO `marks` VALUES (1,4,'2018-04-07',5,1),(2,4,'2018-04-07',7,1),(3,4,'2018-04-07',6,1),(4,5,'2018-04-07',2,1),(5,5,'2018-04-07',2,2),(6,5,'2018-04-07',1,2),(7,5,'2018-04-07',1,2),(8,3,'2018-04-07',3,7),(9,4,'2018-04-07',3,7);
/*!40000 ALTER TABLE `marks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule_rows`
--

DROP TABLE IF EXISTS `schedule_rows`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schedule_rows` (
  `ROW_ID` int(11) NOT NULL AUTO_INCREMENT,
  `SCHEDULE_ID` int(10) unsigned NOT NULL,
  `SUBJECT_ID` int(10) unsigned NOT NULL,
  `LESSON_ID` int(10) unsigned NOT NULL,
  `TEACHER_ID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ROW_ID`,`SCHEDULE_ID`,`SUBJECT_ID`,`LESSON_ID`,`TEACHER_ID`),
  UNIQUE KEY `RAW_ID_UNIQUE` (`ROW_ID`),
  KEY `fk_SCHEDULE_RAWS_SCHEDULES1_idx` (`SCHEDULE_ID`),
  KEY `fk_SCHEDULE_ROWS_SUBJECTS1_idx` (`SUBJECT_ID`),
  KEY `fk_SCHEDULE_ROWS_LESSONS1_idx` (`LESSON_ID`),
  KEY `fk_SCHEDULE_ROWS_USERS1_idx` (`TEACHER_ID`),
  CONSTRAINT `FKa2hd2kdc8eo3g1fsjxnjjq0nk` FOREIGN KEY (`SUBJECT_ID`) REFERENCES `subjects` (`SUBJECT_ID`),
  CONSTRAINT `FKg4muo6vuhf5i8v4vjo0rmu1p4` FOREIGN KEY (`TEACHER_ID`) REFERENCES `users` (`USER_ID`),
  CONSTRAINT `FKhfc4v8ew6gdtet0lg8rqpe0kv` FOREIGN KEY (`LESSON_ID`) REFERENCES `lessons` (`LESSON_ID`),
  CONSTRAINT `FKohlygy94dp5edusfvv92xhfv5` FOREIGN KEY (`SCHEDULE_ID`) REFERENCES `schedules` (`SCHEDULE_ID`),
  CONSTRAINT `fk_SCHEDULE_RAWS_SCHEDULES1` FOREIGN KEY (`SCHEDULE_ID`) REFERENCES `schedules` (`SCHEDULE_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_SCHEDULE_ROWS_LESSONS1` FOREIGN KEY (`LESSON_ID`) REFERENCES `lessons` (`LESSON_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_SCHEDULE_ROWS_SUBJECTS1` FOREIGN KEY (`SUBJECT_ID`) REFERENCES `subjects` (`SUBJECT_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_SCHEDULE_ROWS_USERS1` FOREIGN KEY (`TEACHER_ID`) REFERENCES `users` (`USER_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule_rows`
--

LOCK TABLES `schedule_rows` WRITE;
/*!40000 ALTER TABLE `schedule_rows` DISABLE KEYS */;
INSERT INTO `schedule_rows` VALUES (1,1,1,1,9),(2,1,2,2,10),(3,1,3,3,9),(4,1,4,4,9),(5,2,5,1,15),(6,2,6,2,14),(7,2,7,3,10),(8,3,8,2,12),(9,3,9,3,11),(10,3,10,4,15),(11,4,11,1,9),(12,4,12,2,10),(13,4,12,3,11),(14,5,11,1,12),(15,5,10,2,12),(16,5,9,3,13),(17,6,8,2,14),(18,6,7,3,15),(19,6,6,4,12),(20,6,5,5,13),(21,7,4,1,10),(22,7,3,2,11),(23,7,2,3,9),(24,7,1,4,15),(25,8,5,1,14),(26,8,5,2,12),(27,9,3,2,13),(28,9,6,3,9),(29,9,6,4,10),(30,10,8,1,11);
/*!40000 ALTER TABLE `schedule_rows` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedules`
--

DROP TABLE IF EXISTS `schedules`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schedules` (
  `SCHEDULE_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `GRADE_ID` int(10) unsigned NOT NULL,
  `DAY_ID` int(11) NOT NULL,
  PRIMARY KEY (`SCHEDULE_ID`,`GRADE_ID`,`DAY_ID`),
  UNIQUE KEY `SCHEDULE_ID_UNIQUE` (`SCHEDULE_ID`),
  KEY `fk_SCHEDULES_DAYS1_idx` (`DAY_ID`),
  KEY `fk_SCHEDULES_CLASSES1_idx` (`GRADE_ID`),
  CONSTRAINT `FK41ef907xp6n9k547i2ofvj7e6` FOREIGN KEY (`GRADE_ID`) REFERENCES `grades` (`GRADE_ID`),
  CONSTRAINT `FKliu6miym9klmxjubwf109fj26` FOREIGN KEY (`DAY_ID`) REFERENCES `days` (`DAY_ID`),
  CONSTRAINT `fk_SCHEDULES_CLASSES1` FOREIGN KEY (`GRADE_ID`) REFERENCES `grades` (`GRADE_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_SCHEDULES_DAYS1` FOREIGN KEY (`DAY_ID`) REFERENCES `days` (`DAY_ID`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedules`
--

LOCK TABLES `schedules` WRITE;
/*!40000 ALTER TABLE `schedules` DISABLE KEYS */;
INSERT INTO `schedules` VALUES (1,1,1),(2,1,2),(3,1,3),(4,1,4),(5,1,5),(6,2,1),(7,2,2),(8,2,3),(9,2,4),(10,2,5);
/*!40000 ALTER TABLE `schedules` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subjects`
--

DROP TABLE IF EXISTS `subjects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subjects` (
  `SUBJECT_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NAME` varchar(20) NOT NULL,
  `ROOM` int(11) NOT NULL,
  PRIMARY KEY (`SUBJECT_ID`),
  UNIQUE KEY `SUBJECTS_ID_UNIQUE` (`SUBJECT_ID`),
  UNIQUE KEY `NAME_UNIQUE` (`NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subjects`
--

LOCK TABLES `subjects` WRITE;
/*!40000 ALTER TABLE `subjects` DISABLE KEYS */;
INSERT INTO `subjects` VALUES (1,'Математика',65),(2,'Русский язык',98),(3,'Физкультура',2),(4,'Физика',32),(5,'Алгебра',36),(6,'Геометрия',37),(7,'Информатика',12),(8,'География',59),(9,'ОБЖ',44),(10,'Литература',63),(11,'История',28),(12,'Обществознание',88);
/*!40000 ALTER TABLE `subjects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `USER_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `LOGIN` varchar(20) NOT NULL,
  `PASSWORD` char(60) NOT NULL,
  `ROLE` varchar(7) NOT NULL,
  `FIRST_NAME` varchar(45) NOT NULL,
  `SECOND_NAME` varchar(45) NOT NULL,
  `LAST_NAME` varchar(45) NOT NULL,
  `EMAIL` varchar(45) NOT NULL,
  `ADDRESS` varchar(45) NOT NULL,
  `BIRTH_DATE` date NOT NULL,
  `GRADE_ID` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`USER_ID`),
  UNIQUE KEY `LOGIN_ID_UNIQUE` (`USER_ID`),
  UNIQUE KEY `LOGIN_UNIQUE` (`LOGIN`),
  KEY `fk_USERS_CLASSES1_idx` (`GRADE_ID`),
  CONSTRAINT `FKocdpyagwqcwnsytdpie5p0qy2` FOREIGN KEY (`GRADE_ID`) REFERENCES `grades` (`GRADE_ID`),
  CONSTRAINT `fk_USERS_CLASSES1` FOREIGN KEY (`GRADE_ID`) REFERENCES `grades` (`GRADE_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'login','$2a$10$JOH/77ffecVQf3tF1PaY1etBkCD8pS5ZAFzdwMoXw6aKwx8QGOTYi','STUDENT','Никита','Сергеев','Николаевич','email','СПб','1997-03-23',1),(2,'login1','$2a$10$JOH/77ffecVQf3tF1PaY1etBkCD8pS5ZAFzdwMoXw6aKwx8QGOTYi','STUDENT','Даниил','Ситдиков','Альбертович','email1','СПб','1997-03-23',1),(3,'login2','$2a$10$JOH/77ffecVQf3tF1PaY1etBkCD8pS5ZAFzdwMoXw6aKwx8QGOTYi','STUDENT','Борис','Иванов','Глебович','email2','СПб','1997-03-23',1),(4,'login3','$2a$10$JOH/77ffecVQf3tF1PaY1etBkCD8pS5ZAFzdwMoXw6aKwx8QGOTYi','STUDENT','Лариса','Урбановская','Макаровна','email3','СПб','1997-03-23',1),(5,'login4','$2a$10$JOH/77ffecVQf3tF1PaY1etBkCD8pS5ZAFzdwMoXw6aKwx8QGOTYi','STUDENT','Вилен','Калашников','Аркадьевич','email4','СПб','1997-03-23',1),(6,'login5','$2a$10$JOH/77ffecVQf3tF1PaY1etBkCD8pS5ZAFzdwMoXw6aKwx8QGOTYi','STUDENT','Игнатий','Селезнёв','Альвианович','email5','СПб','1997-03-23',2),(7,'login6','$2a$10$JOH/77ffecVQf3tF1PaY1etBkCD8pS5ZAFzdwMoXw6aKwx8QGOTYi','STUDENT','Николай','Поляков','Русланович','email6','СПб','1997-03-23',2),(8,'login7','$2a$10$JOH/77ffecVQf3tF1PaY1etBkCD8pS5ZAFzdwMoXw6aKwx8QGOTYi','STUDENT','Наталья','Лазарева','Прокловна','email7','СПб','1997-03-23',2),(9,'login8','$2a$10$JOH/77ffecVQf3tF1PaY1etBkCD8pS5ZAFzdwMoXw6aKwx8QGOTYi','TEACHER','Инга','Кулакова','Святославовна','email8','СПб','1997-03-23',NULL),(10,'login9','$2a$10$JOH/77ffecVQf3tF1PaY1etBkCD8pS5ZAFzdwMoXw6aKwx8QGOTYi','TEACHER','Данил','Новосельцев','Родионович','email9','СПб','1997-03-23',NULL),(11,'login10','$2a$10$JOH/77ffecVQf3tF1PaY1etBkCD8pS5ZAFzdwMoXw6aKwx8QGOTYi','TEACHER','Лариса','Авдеева','Мечиславовна','email10','СПб','1997-03-23',NULL),(12,'login11','$2a$10$JOH/77ffecVQf3tF1PaY1etBkCD8pS5ZAFzdwMoXw6aKwx8QGOTYi','TEACHER','Влада','Чекудаева','Константиновна','email11','СПб','1997-03-23',NULL),(13,'login12','$2a$10$JOH/77ffecVQf3tF1PaY1etBkCD8pS5ZAFzdwMoXw6aKwx8QGOTYi','TEACHER','Рада','Зухина','Ираклиевна','email12','СПб','1997-03-23',NULL),(14,'login13','$2a$10$JOH/77ffecVQf3tF1PaY1etBkCD8pS5ZAFzdwMoXw6aKwx8QGOTYi','TEACHER','Оксана','Дёмшина','Елизаровна','email13','СПб','1997-03-23',NULL),(15,'login14','$2a$10$JOH/77ffecVQf3tF1PaY1etBkCD8pS5ZAFzdwMoXw6aKwx8QGOTYi','TEACHER','Лилия','Чепурина','Брониславовна','email14','СПб','1997-03-23',NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'school'
--

--
-- Dumping routines for database 'school'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-14 21:20:51
