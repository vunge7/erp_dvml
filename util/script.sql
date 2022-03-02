CREATE DATABASE  IF NOT EXISTS `erp_dvml_db` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `erp_dvml_db`;
-- MySQL dump 10.13  Distrib 8.0.17, for macos10.14 (x86_64)
--
-- Host: localhost    Database: erp_dvml_db
-- ------------------------------------------------------
-- Server version	8.0.15

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
-- Table structure for table `af_actividades`
--

DROP TABLE IF EXISTS `af_actividades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `af_actividades` (
  `pk_af_actividades` int(11) NOT NULL AUTO_INCREMENT,
  `data` datetime DEFAULT NULL,
  `problema` varchar(150) DEFAULT NULL,
  `possivel_resolucao` varchar(200) DEFAULT NULL,
  `fk_af_cliente` int(11) NOT NULL,
  `fk_parc_software` int(11) NOT NULL,
  PRIMARY KEY (`pk_af_actividades`),
  KEY `fk_af_actividades_af_clientes1_idx` (`fk_af_cliente`),
  KEY `fk_af_actividades_parc_software1_idx` (`fk_parc_software`),
  CONSTRAINT `fk_af_actividades_af_clientes1` FOREIGN KEY (`fk_af_cliente`) REFERENCES `af_clientes` (`pk_af_cliente`),
  CONSTRAINT `fk_af_actividades_parc_software1` FOREIGN KEY (`fk_parc_software`) REFERENCES `parc_software` (`pk_parc_software`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `af_actividades`
--

LOCK TABLES `af_actividades` WRITE;
/*!40000 ALTER TABLE `af_actividades` DISABLE KEYS */;
/*!40000 ALTER TABLE `af_actividades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `af_clientes`
--

DROP TABLE IF EXISTS `af_clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `af_clientes` (
  `pk_af_cliente` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `nif` varchar(45) DEFAULT NULL,
  `endereco` varchar(45) DEFAULT NULL,
  `telefone` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`pk_af_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `af_clientes`
--

LOCK TABLES `af_clientes` WRITE;
/*!40000 ALTER TABLE `af_clientes` DISABLE KEYS */;
/*!40000 ALTER TABLE `af_clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `af_funcionarios`
--

DROP TABLE IF EXISTS `af_funcionarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `af_funcionarios` (
  `pk_af_funcionario` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `telefone` varchar(45) DEFAULT NULL,
  `endereco` varchar(45) DEFAULT NULL,
  `funcao` varchar(45) DEFAULT NULL,
  `status` enum('Activo','Desactivo') DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `sexo` enum('Masculino','Femenino') DEFAULT NULL,
  PRIMARY KEY (`pk_af_funcionario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `af_funcionarios`
--

LOCK TABLES `af_funcionarios` WRITE;
/*!40000 ALTER TABLE `af_funcionarios` DISABLE KEYS */;
/*!40000 ALTER TABLE `af_funcionarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `af_linhas_actividade`
--

DROP TABLE IF EXISTS `af_linhas_actividade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `af_linhas_actividade` (
  `fk_af_funcionario` int(11) NOT NULL,
  `fk_af_actividade` int(11) NOT NULL,
  `funcao` enum('Lider Master','Membro') DEFAULT NULL,
  PRIMARY KEY (`fk_af_funcionario`,`fk_af_actividade`),
  KEY `fk_af_funcionarios_has_af_actividades_af_actividades1_idx` (`fk_af_actividade`),
  KEY `fk_af_funcionarios_has_af_actividades_af_funcionarios1_idx` (`fk_af_funcionario`),
  CONSTRAINT `fk_af_funcionarios_has_af_actividades_af_actividades1` FOREIGN KEY (`fk_af_actividade`) REFERENCES `af_actividades` (`pk_af_actividades`),
  CONSTRAINT `fk_af_funcionarios_has_af_actividades_af_funcionarios1` FOREIGN KEY (`fk_af_funcionario`) REFERENCES `af_funcionarios` (`pk_af_funcionario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `af_linhas_actividade`
--

LOCK TABLES `af_linhas_actividade` WRITE;
/*!40000 ALTER TABLE `af_linhas_actividade` DISABLE KEYS */;
/*!40000 ALTER TABLE `af_linhas_actividade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parc_adesao`
--

DROP TABLE IF EXISTS `parc_adesao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `parc_adesao` (
  `pk_parc_adesao` int(11) NOT NULL AUTO_INCREMENT,
  `data` datetime DEFAULT NULL,
  `valor_venda` decimal(10,2) DEFAULT NULL,
  `valor_equivalente` decimal(10,2) DEFAULT NULL,
  `pago_totalidade` tinyint(4) DEFAULT '0',
  `fk_parc_empresa` int(11) NOT NULL,
  PRIMARY KEY (`pk_parc_adesao`),
  KEY `fk_parc_adesao_parc_empresa1_idx` (`fk_parc_empresa`),
  CONSTRAINT `fk_parc_adesao_parc_empresa1` FOREIGN KEY (`fk_parc_empresa`) REFERENCES `parc_empresa` (`pk_parc_empresa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parc_adesao`
--

LOCK TABLES `parc_adesao` WRITE;
/*!40000 ALTER TABLE `parc_adesao` DISABLE KEYS */;
/*!40000 ALTER TABLE `parc_adesao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parc_empresa`
--

DROP TABLE IF EXISTS `parc_empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `parc_empresa` (
  `pk_parc_empresa` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(75) DEFAULT NULL,
  `nif` varchar(45) DEFAULT NULL,
  `telefone` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `endereco` varchar(150) DEFAULT NULL,
  `fk_parc_tipologia` int(11) NOT NULL,
  PRIMARY KEY (`pk_parc_empresa`),
  KEY `fk_parc_empresa_parc_tipologia_idx` (`fk_parc_tipologia`),
  CONSTRAINT `fk_parc_empresa_parc_tipologia` FOREIGN KEY (`fk_parc_tipologia`) REFERENCES `parc_tipologia` (`pk_parc_tipologia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parc_empresa`
--

LOCK TABLES `parc_empresa` WRITE;
/*!40000 ALTER TABLE `parc_empresa` DISABLE KEYS */;
/*!40000 ALTER TABLE `parc_empresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parc_empresa_has_parc_software`
--

DROP TABLE IF EXISTS `parc_empresa_has_parc_software`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `parc_empresa_has_parc_software` (
  `fk_parc_empresa` int(11) NOT NULL,
  `fk_parc_software` int(11) NOT NULL,
  `data_atribuicao` date DEFAULT NULL,
  PRIMARY KEY (`fk_parc_empresa`,`fk_parc_software`),
  KEY `fk_parc_empresa_has_parc_software_parc_software1_idx` (`fk_parc_software`),
  KEY `fk_parc_empresa_has_parc_software_parc_empresa1_idx` (`fk_parc_empresa`),
  CONSTRAINT `fk_parc_empresa_has_parc_software_parc_empresa1` FOREIGN KEY (`fk_parc_empresa`) REFERENCES `parc_empresa` (`pk_parc_empresa`),
  CONSTRAINT `fk_parc_empresa_has_parc_software_parc_software1` FOREIGN KEY (`fk_parc_software`) REFERENCES `parc_software` (`pk_parc_software`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parc_empresa_has_parc_software`
--

LOCK TABLES `parc_empresa_has_parc_software` WRITE;
/*!40000 ALTER TABLE `parc_empresa_has_parc_software` DISABLE KEYS */;
/*!40000 ALTER TABLE `parc_empresa_has_parc_software` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parc_linhas_adesao`
--

DROP TABLE IF EXISTS `parc_linhas_adesao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `parc_linhas_adesao` (
  `pk_parc_linhas_adesao` int(11) NOT NULL AUTO_INCREMENT,
  `fk_parc_software` int(11) NOT NULL,
  `fk_parc_adesao` int(11) NOT NULL,
  `valor_percentagem` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`pk_parc_linhas_adesao`),
  KEY `fk_parc_linhas_adesao_parc_software1_idx` (`fk_parc_software`),
  KEY `fk_parc_linhas_adesao_parc_adesao1_idx` (`fk_parc_adesao`),
  CONSTRAINT `fk_parc_linhas_adesao_parc_adesao1` FOREIGN KEY (`fk_parc_adesao`) REFERENCES `parc_adesao` (`pk_parc_adesao`),
  CONSTRAINT `fk_parc_linhas_adesao_parc_software1` FOREIGN KEY (`fk_parc_software`) REFERENCES `parc_software` (`pk_parc_software`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parc_linhas_adesao`
--

LOCK TABLES `parc_linhas_adesao` WRITE;
/*!40000 ALTER TABLE `parc_linhas_adesao` DISABLE KEYS */;
/*!40000 ALTER TABLE `parc_linhas_adesao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parc_pagamentos`
--

DROP TABLE IF EXISTS `parc_pagamentos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `parc_pagamentos` (
  `pk_parc_pagamentos` int(11) NOT NULL AUTO_INCREMENT,
  `data` datetime DEFAULT NULL,
  `valor` decimal(10,2) DEFAULT NULL,
  `fk_parc_adesao` int(11) NOT NULL,
  PRIMARY KEY (`pk_parc_pagamentos`),
  KEY `fk_parc_pagamentos_parc_adesao1_idx` (`fk_parc_adesao`),
  CONSTRAINT `fk_parc_pagamentos_parc_adesao1` FOREIGN KEY (`fk_parc_adesao`) REFERENCES `parc_adesao` (`pk_parc_adesao`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parc_pagamentos`
--

LOCK TABLES `parc_pagamentos` WRITE;
/*!40000 ALTER TABLE `parc_pagamentos` DISABLE KEYS */;
/*!40000 ALTER TABLE `parc_pagamentos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parc_software`
--

DROP TABLE IF EXISTS `parc_software`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `parc_software` (
  `pk_parc_software` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `descricao` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`pk_parc_software`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parc_software`
--

LOCK TABLES `parc_software` WRITE;
/*!40000 ALTER TABLE `parc_software` DISABLE KEYS */;
/*!40000 ALTER TABLE `parc_software` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parc_tipologia`
--

DROP TABLE IF EXISTS `parc_tipologia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `parc_tipologia` (
  `pk_parc_tipologia` int(11) NOT NULL AUTO_INCREMENT,
  `designacao` varchar(45) DEFAULT NULL,
  `percetagem` double DEFAULT NULL,
  PRIMARY KEY (`pk_parc_tipologia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parc_tipologia`
--

LOCK TABLES `parc_tipologia` WRITE;
/*!40000 ALTER TABLE `parc_tipologia` DISABLE KEYS */;
/*!40000 ALTER TABLE `parc_tipologia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'erp_dvml_db'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-25 13:30:33
