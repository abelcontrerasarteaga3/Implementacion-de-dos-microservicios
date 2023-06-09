-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: bdcrud
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
-- Table structure for table `tb_factura_detalle`
--

DROP TABLE IF EXISTS `tb_factura_detalle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_factura_detalle` (
  `IDDETALLEFACTURA` int NOT NULL AUTO_INCREMENT,
  `ID_FACTURA` int NOT NULL,
  `ID_PRODUCTO` int NOT NULL,
  `CANTIDAD` int NOT NULL,
  `PRECIO` decimal(10,2) NOT NULL,
  `SUBTOTAL` decimal(10,2) NOT NULL,
  `FECHA_REGISTRO` datetime NOT NULL,
  PRIMARY KEY (`IDDETALLEFACTURA`),
  KEY `tb_factura_detalle_FK` (`ID_PRODUCTO`),
  KEY `tb_factura_detalle_FK_1` (`ID_FACTURA`),
  CONSTRAINT `tb_factura_detalle_FK` FOREIGN KEY (`ID_PRODUCTO`) REFERENCES `tb_producto` (`IDPRODUCTO`),
  CONSTRAINT `tb_factura_detalle_FK_1` FOREIGN KEY (`ID_FACTURA`) REFERENCES `tb_factura` (`IDFACTURA`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_factura_detalle`
--

LOCK TABLES `tb_factura_detalle` WRITE;
/*!40000 ALTER TABLE `tb_factura_detalle` DISABLE KEYS */;
INSERT INTO `tb_factura_detalle` VALUES (3,6,1,1,2.50,2.50,'2023-03-30 15:07:36'),(4,6,2,1,5.00,5.00,'2023-03-30 15:07:36'),(5,7,1,1000,2.50,2500.00,'2023-03-30 15:15:16'),(7,10,1,1,2.50,2.50,'2023-03-31 11:32:29'),(8,10,2,1,5.00,5.00,'2023-03-31 11:32:29');
/*!40000 ALTER TABLE `tb_factura_detalle` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-12  0:43:46
