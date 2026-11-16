-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.32 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             12.4.0.6659
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for bms
CREATE DATABASE IF NOT EXISTS `bms` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bms`;

-- Dumping structure for table bms.buyer
CREATE TABLE IF NOT EXISTS `buyer` (
  `contactNo` varchar(10) NOT NULL,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `address` varchar(500) NOT NULL,
  `gender` varchar(20) NOT NULL,
  PRIMARY KEY (`contactNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Dumping data for table bms.buyer: ~8 rows (approximately)
INSERT INTO `buyer` (`contactNo`, `name`, `email`, `address`, `gender`) VALUES
	('0711122222', 'kalhara', 'kalhara@gmail.com', '20/7 kandy road', 'Male'),
	('0712345678', 'saduni', 'saduni@gmail.com', '43/7 kandy road matale', 'Female'),
	('0713343342', 'sahn', 'sahan2@gmail.com', 'kandy2', 'Male'),
	('0714464673', 'Enter Name', 'sahan@gmail.com', 'kandy12', 'Male'),
	('0717845783', 'sahan', 'sahan@gmail.com', 'kand23', 'Male'),
	('0717935924', 'Enter Name', 'sahan@gmail.com', 'kandy12', 'Male'),
	('0723456789', 'ravidu', 'ravidu@gmail.com', '12/7 colombo', 'Male'),
	('0766687666', 'avishka', 'avishka@gmail.com', '410/2 kandy ', 'Male');

-- Dumping structure for table bms.product
CREATE TABLE IF NOT EXISTS `product` (
  `pId` int NOT NULL,
  `pName` varchar(100) DEFAULT NULL,
  `rate` int DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `activate` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`pId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Dumping data for table bms.product: ~4 rows (approximately)
INSERT INTO `product` (`pId`, `pName`, `rate`, `description`, `activate`) VALUES
	(1, 'apple', 150, 'fruit', 'Yes'),
	(2, 'mango', 50, 'fruit', 'Yes'),
	(3, 'Banana', 200, 'fruit', 'Yes'),
	(4, 'orange', 80, 'fruit', 'Yes');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
