DROP SCHEMA IF EXISTS Bar_Soares;
CREATE DATABASE IF NOT EXISTS Bar_Soares;
USE Bar_Soares;

--
-- Table structure for table `cliente`
--
CREATE TABLE `cliente` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(30) NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `rua` varchar(50) NOT NULL,
  `numero` varchar(10) NOT NULL,
  `complemento` varchar(10) NOT NULL, 
  `bairro` varchar(50) NOT NULL,
  `cidade` varchar(50) NOT NULL,
  `estado` varchar(15) NOT NULL, 
  `data_cadastro` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8_unicode;

	