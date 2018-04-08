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
-- Table structure for table `classes`
--

DROP TABLE IF EXISTS `classes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `classes` (
  `CLASS_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NUMBER` varchar(3) NOT NULL,
  PRIMARY KEY (`CLASS_ID`),
  UNIQUE KEY `CLASSES_ID_UNIQUE` (`CLASS_ID`),
  UNIQUE KEY `NUMBER_UNIQUE` (`NUMBER`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classes`
--

LOCK TABLES `classes` WRITE;
/*!40000 ALTER TABLE `classes` DISABLE KEYS */;
INSERT INTO `classes` VALUES (2,'10а'),(1,'11б');
/*!40000 ALTER TABLE `classes` ENABLE KEYS */;
UNLOCK TABLES;

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
  `STUDENT_ID` int(11) NOT NULL,
  `SUBJECT_ID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`MARK_ID`,`STUDENT_ID`,`SUBJECT_ID`),
  UNIQUE KEY `MARKS_ID_UNIQUE` (`MARK_ID`),
  KEY `fk_MARKS_STUDENTS1_idx` (`STUDENT_ID`),
  KEY `fk_MARKS_SUBJECTS1_idx` (`SUBJECT_ID`),
  CONSTRAINT `fk_MARKS_STUDENTS1` FOREIGN KEY (`STUDENT_ID`) REFERENCES `students` (`STUDENT_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_MARKS_SUBJECTS1` FOREIGN KEY (`SUBJECT_ID`) REFERENCES `subjects` (`SUBJECT_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marks`
--

LOCK TABLES `marks` WRITE;
/*!40000 ALTER TABLE `marks` DISABLE KEYS */;
INSERT INTO `marks` VALUES (1,5,'2018-03-14',1,2),(4,3,'2018-04-07',1,2),(5,3,'2018-04-07',1,3),(6,3,'2018-04-07',1,12),(8,3,'2018-04-07',1,8),(9,3,'2018-04-07',1,11),(11,3,'2018-04-07',1,5),(12,3,'2018-04-07',1,9),(14,3,'2018-04-07',1,7),(15,4,'2018-04-07',2,11),(16,4,'2018-04-07',2,9),(17,4,'2018-04-07',2,4),(18,4,'2018-04-07',2,7),(19,5,'2018-04-07',6,4),(20,5,'2018-04-07',6,5),(21,3,'2018-04-07',1,3),(22,3,'2018-04-07',1,3),(23,4,'2018-04-07',1,2),(24,4,'2018-04-07',1,2),(25,4,'2018-04-07',1,2),(26,4,'2018-04-07',1,2),(27,4,'2018-04-07',1,2),(28,4,'2018-04-07',1,12),(30,3,'2018-04-07',1,12);
/*!40000 ALTER TABLE `marks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `names`
--

DROP TABLE IF EXISTS `names`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `names` (
  `NAME_ID` int(11) NOT NULL AUTO_INCREMENT,
  `FIRST_NAME` varchar(45) NOT NULL,
  `SECOND_NAME` varchar(45) NOT NULL,
  `LAST_NAME` varchar(45) NOT NULL,
  PRIMARY KEY (`NAME_ID`),
  UNIQUE KEY `NAMES_ID_UNIQUE` (`NAME_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `names`
--

LOCK TABLES `names` WRITE;
/*!40000 ALTER TABLE `names` DISABLE KEYS */;
INSERT INTO `names` VALUES (1,'Никита','Сергеев','Николаевич'),(2,'Даниил','Ситдиков','Альбертович'),(3,'Борис','Иванов','Глебович'),(4,'Вилен','Калашников','Аркадьевич'),(5,'Игнатий','Селезнёв','Альвианович'),(6,'Николай','Поляков','Русланович'),(7,'Наталья','Лазарева','Прокловна'),(8,'Инга','Кулакова','Святославовна'),(9,'Данил','Новосельцев','Родионович'),(10,'Лариса','Авдеева','Мечиславовна'),(11,'Влада','Чекудаева','Константиновна'),(12,'Рада','Зухина','Ираклиевна'),(13,'Оксана','Дёмшина','Елизаровна'),(14,'Лилия','Чепурина','Брониславовна'),(15,'Лариса','Урбановская','Макаровна');
/*!40000 ALTER TABLE `names` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `other_info`
--

DROP TABLE IF EXISTS `other_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `other_info` (
  `OTHER_INFO_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `EMAIL` varchar(45) NOT NULL,
  `ADDRESS` varchar(45) NOT NULL,
  `BIRTH_DATE` date NOT NULL,
  PRIMARY KEY (`OTHER_INFO_ID`),
  UNIQUE KEY `OTHER_INFO_ID_UNIQUE` (`OTHER_INFO_ID`),
  UNIQUE KEY `EMAIL_UNIQUE` (`EMAIL`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `other_info`
--

LOCK TABLES `other_info` WRITE;
/*!40000 ALTER TABLE `other_info` DISABLE KEYS */;
INSERT INTO `other_info` VALUES (1,'email','СПб','1997-03-23'),(2,'email1','СПб','1997-03-23'),(3,'email2','СПб','1997-03-23'),(4,'email3','СПб','1997-03-23'),(5,'email4','СПб','1997-03-23'),(6,'email5','СПб','1997-03-23'),(7,'email6','СПб','1997-03-23'),(8,'email7','СПб','1997-03-23'),(9,'email8','СПб','1997-03-23'),(10,'email9','СПб','1997-03-23'),(11,'email10','СПб','1997-03-23'),(12,'email11','СПб','1997-03-23'),(13,'email12','СПб','1997-03-23'),(14,'email13','СПб','1997-03-23'),(15,'email14','СПб','1997-03-23');
/*!40000 ALTER TABLE `other_info` ENABLE KEYS */;
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
  `TEACHER_ID` int(10) unsigned NOT NULL,
  `SUBJECT_ID` int(10) unsigned NOT NULL,
  `LESSON_ID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ROW_ID`,`SCHEDULE_ID`,`TEACHER_ID`,`SUBJECT_ID`,`LESSON_ID`),
  UNIQUE KEY `RAW_ID_UNIQUE` (`ROW_ID`),
  KEY `fk_SCHEDULE_RAWS_SCHEDULES1_idx` (`SCHEDULE_ID`),
  KEY `fk_SCHEDULE_ROWS_TEACHERS1_idx` (`TEACHER_ID`),
  KEY `fk_SCHEDULE_ROWS_SUBJECTS1_idx` (`SUBJECT_ID`),
  KEY `fk_SCHEDULE_ROWS_LESSONS1_idx` (`LESSON_ID`),
  CONSTRAINT `fk_SCHEDULE_RAWS_SCHEDULES1` FOREIGN KEY (`SCHEDULE_ID`) REFERENCES `schedules` (`SCHEDULE_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_SCHEDULE_ROWS_LESSONS1` FOREIGN KEY (`LESSON_ID`) REFERENCES `lessons` (`LESSON_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_SCHEDULE_ROWS_SUBJECTS1` FOREIGN KEY (`SUBJECT_ID`) REFERENCES `subjects` (`SUBJECT_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_SCHEDULE_ROWS_TEACHERS1` FOREIGN KEY (`TEACHER_ID`) REFERENCES `teachers` (`TEACHER_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule_rows`
--

LOCK TABLES `schedule_rows` WRITE;
/*!40000 ALTER TABLE `schedule_rows` DISABLE KEYS */;
INSERT INTO `schedule_rows` VALUES (1,1,1,1,1),(2,1,2,2,2),(3,1,3,3,3),(4,2,4,4,1),(5,2,5,5,2),(6,2,6,6,3),(7,2,5,7,4),(8,3,6,8,2),(9,3,8,9,3),(10,3,4,10,4),(11,3,2,11,5),(12,4,1,12,2),(13,4,5,2,3),(14,5,3,5,1),(15,6,1,1,1),(16,6,2,2,2),(17,6,3,3,3),(18,6,4,4,4),(19,7,5,5,1),(20,7,6,6,2),(21,7,7,7,3),(22,7,8,8,4),(23,8,1,9,2),(24,8,2,10,3),(25,8,3,3,4),(26,8,4,8,5),(27,8,5,1,6),(28,9,6,2,1),(29,9,7,3,2),(30,9,8,4,3),(31,10,1,5,1),(32,10,2,6,2);
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
  `CLASS_ID` int(10) unsigned NOT NULL,
  `DAY_ID` int(11) NOT NULL,
  PRIMARY KEY (`SCHEDULE_ID`,`CLASS_ID`,`DAY_ID`),
  UNIQUE KEY `SCHEDULE_ID_UNIQUE` (`SCHEDULE_ID`),
  KEY `fk_SCHEDULES_CLASSES1_idx` (`CLASS_ID`),
  KEY `fk_SCHEDULES_DAYS1_idx` (`DAY_ID`),
  CONSTRAINT `fk_SCHEDULES_CLASSES1` FOREIGN KEY (`CLASS_ID`) REFERENCES `classes` (`CLASS_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_SCHEDULES_DAYS1` FOREIGN KEY (`DAY_ID`) REFERENCES `days` (`DAY_ID`) ON DELETE NO ACTION ON UPDATE CASCADE
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
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `students` (
  `STUDENT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME_ID` int(11) NOT NULL,
  `OTHER_INFO_ID` int(10) unsigned NOT NULL,
  `CLASS_ID` int(10) unsigned NOT NULL,
  `USER_ID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`STUDENT_ID`,`NAME_ID`,`OTHER_INFO_ID`,`CLASS_ID`,`USER_ID`),
  UNIQUE KEY `STUDENT_ID_UNIQUE` (`STUDENT_ID`),
  KEY `fk_STUDENTS_NAMES_idx` (`NAME_ID`),
  KEY `fk_STUDENTS_OTHER_INFO1_idx` (`OTHER_INFO_ID`),
  KEY `fk_STUDENTS_CLASSES1_idx` (`CLASS_ID`),
  KEY `fk_STUDENTS_USER1_idx` (`USER_ID`),
  CONSTRAINT `fk_STUDENTS_CLASSES1` FOREIGN KEY (`CLASS_ID`) REFERENCES `classes` (`CLASS_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_STUDENTS_NAMES` FOREIGN KEY (`NAME_ID`) REFERENCES `names` (`NAME_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_STUDENTS_OTHER_INFO1` FOREIGN KEY (`OTHER_INFO_ID`) REFERENCES `other_info` (`OTHER_INFO_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_STUDENTS_USER1` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`USER_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES (1,1,1,1,9),(2,2,2,1,10),(3,3,3,1,11),(4,4,4,1,12),(5,5,5,1,13),(6,6,6,2,14),(7,7,7,2,15);
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
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
-- Table structure for table `teachers`
--

DROP TABLE IF EXISTS `teachers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teachers` (
  `TEACHER_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NAME_ID` int(11) NOT NULL,
  `OTHER_INFO_ID` int(10) unsigned NOT NULL,
  `USER_ID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`TEACHER_ID`,`NAME_ID`,`OTHER_INFO_ID`,`USER_ID`),
  UNIQUE KEY `TEACHERS_ID_UNIQUE` (`TEACHER_ID`),
  KEY `fk_TEACHERS_NAMES1_idx` (`NAME_ID`),
  KEY `fk_TEACHERS_OTHER_INFO1_idx` (`OTHER_INFO_ID`),
  KEY `fk_TEACHERS_USER1_idx` (`USER_ID`),
  CONSTRAINT `fk_TEACHERS_NAMES1` FOREIGN KEY (`NAME_ID`) REFERENCES `names` (`NAME_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_TEACHERS_OTHER_INFO1` FOREIGN KEY (`OTHER_INFO_ID`) REFERENCES `other_info` (`OTHER_INFO_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_TEACHERS_USER1` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`USER_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teachers`
--

LOCK TABLES `teachers` WRITE;
/*!40000 ALTER TABLE `teachers` DISABLE KEYS */;
INSERT INTO `teachers` VALUES (1,8,8,1),(2,9,9,2),(3,10,10,3),(4,11,11,4),(5,12,12,5),(6,13,13,6),(7,14,14,7),(8,15,15,8);
/*!40000 ALTER TABLE `teachers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `USER_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `LOGIN` varchar(20) NOT NULL,
  `PASSWORD` char(60) NOT NULL,
  `ROLE` varchar(7) NOT NULL,
  PRIMARY KEY (`USER_ID`),
  UNIQUE KEY `LOGIN_ID_UNIQUE` (`USER_ID`),
  UNIQUE KEY `LOGIN_UNIQUE` (`LOGIN`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'login','$2a$10$JOH/77ffecVQf3tF1PaY1etBkCD8pS5ZAFzdwMoXw6aKwx8QGOTYi','TEACHER'),(2,'login1','$2a$10$JOH/77ffecVQf3tF1PaY1etBkCD8pS5ZAFzdwMoXw6aKwx8QGOTYi','TEACHER'),(3,'login2','$2a$10$JOH/77ffecVQf3tF1PaY1etBkCD8pS5ZAFzdwMoXw6aKwx8QGOTYi','TEACHER'),(4,'login3','$2a$10$JOH/77ffecVQf3tF1PaY1etBkCD8pS5ZAFzdwMoXw6aKwx8QGOTYi','TEACHER'),(5,'login4','$2a$10$JOH/77ffecVQf3tF1PaY1etBkCD8pS5ZAFzdwMoXw6aKwx8QGOTYi','TEACHER'),(6,'login5','$2a$10$JOH/77ffecVQf3tF1PaY1etBkCD8pS5ZAFzdwMoXw6aKwx8QGOTYi','TEACHER'),(7,'login6','$2a$10$JOH/77ffecVQf3tF1PaY1etBkCD8pS5ZAFzdwMoXw6aKwx8QGOTYi','TEACHER'),(8,'login7','$2a$10$JOH/77ffecVQf3tF1PaY1etBkCD8pS5ZAFzdwMoXw6aKwx8QGOTYi','TEACHER'),(9,'login8','$2a$10$JOH/77ffecVQf3tF1PaY1etBkCD8pS5ZAFzdwMoXw6aKwx8QGOTYi','STUDENT'),(10,'login9','$2a$10$JOH/77ffecVQf3tF1PaY1etBkCD8pS5ZAFzdwMoXw6aKwx8QGOTYi','STUDENT'),(11,'login10','$2a$10$JOH/77ffecVQf3tF1PaY1etBkCD8pS5ZAFzdwMoXw6aKwx8QGOTYi','STUDENT'),(12,'log','$2a$10$JOH/77ffecVQf3tF1PaY1etBkCD8pS5ZAFzdwMoXw6aKwx8QGOTYi','STUDENT'),(13,'login11','$2a$10$JOH/77ffecVQf3tF1PaY1etBkCD8pS5ZAFzdwMoXw6aKwx8QGOTYi','STUDENT'),(14,'login12','$2a$10$JOH/77ffecVQf3tF1PaY1etBkCD8pS5ZAFzdwMoXw6aKwx8QGOTYi','STUDENT'),(15,'login13','$2a$10$JOH/77ffecVQf3tF1PaY1etBkCD8pS5ZAFzdwMoXw6aKwx8QGOTYi','STUDENT');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
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

-- Dump completed on 2018-04-08  0:07:55
