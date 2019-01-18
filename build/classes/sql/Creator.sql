DROP SCHEMA IF EXISTS Bar_Soares;
CREATE DATABASE IF NOT EXISTS Bar_Soares;
USE Bar_Soares;


--
-- Table structure for table `cliente`
--
CREATE TABLE `cliente` (
  `codigo` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(30) NOT NULL,
  `cpf` VARCHAR(14) NOT NULL,
  `telefone` VARCHAR(17) NOT NULL,
  `rua` VARCHAR(30) NOT NULL,
  `numero` INT(11) NOT NULL,
  `complemento` VARCHAR(10) NULL, 
  `bairro` VARCHAR(30) NOT NULL,
  `cidade` VARCHAR(30) NOT NULL,
  `estado` VARCHAR(30) NOT NULL,
  `data_cadastro` DATE NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB;

--
-- Table structure for table `fornecedor`
--
CREATE TABLE `fornecedor` (
  `codigo` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(30) NOT NULL,
  `cnpj` VARCHAR(18) NOT NULL,
  `telefone` VARCHAR(17) NOT NULL,
  `rua` VARCHAR(30) NOT NULL,
  `numero` INT(11)) NOT NULL,
  `complemento` VARCHAR(10) NULL, 
  `bairro` VARCHAR(30) NOT NULL,
  `cidade` VARCHAR(30) NOT NULL,
  `estado` VARCHAR(30) NOT NULL,
  `data_cadastro` DATE NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB;

--
-- Table structure for table `produto`
--
CREATE TABLE `produto` (
  `codigo` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(30) NOT NULL,
  `valor_compra` DOUBLE NOT NULL,
  `valor_venda` DOUBLE NOT NULL,
  `quant_estoque` INT NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB;

--
-- Table structure for table `forn_prod`
--
CREATE TABLE `forn_prod` (
  `cod_forn` INT(11) NOT NULL AUTO_INCREMENT,
  `cod_prod` INT(11) NOT NULL,
  PRIMARY KEY (`cod_forn`, `cod_prod`),
  FOREIGN KEY (`cod_forn`) REFERENCES `fornecedor` (`codigo`),
  FOREIGN KEY (`cod_prod`) REFERENCES `produto` (`codigo`)
) ENGINE=InnoDB;

--
-- Table structure for table `pedido`
--
CREATE TABLE `pedido` (
  `codigo` INT(11) NOT NULL AUTO_INCREMENT,
  `cod_cliente` INT(11) NOT NULL,
  `data_cadastro` DATE NOT NULL,
  `valor_total` DOUBLE NOT NULL,
  PRIMARY KEY (`codigo`),
  FOREIGN KEY (`cod_cliente`) REFERENCES `cliente` (`codigo`)
) ENGINE=InnoDB;

--
-- Table structure for table `item_pedido`
--
CREATE TABLE `item_pedido` (
  `codigo` INT(11) NOT NULL AUTO_INCREMENT,
  `cod_produto` INT(11) NULL,
  `quantidade` INT NOT NULL,
  `cod_pedido` INT(11) NOT NULL,
  PRIMARY KEY (`codigo`),
  FOREIGN KEY (`cod_produto`) REFERENCES `produto` (`codigo`),
  FOREIGN KEY (`cod_pedido`) REFERENCES `pedido` (`codigo`)
) ENGINE=InnoDB;

--
-- Table structure for table `dividas`
--
CREATE TABLE `dividas` (
  `codigo` INT(11) NOT NULL AUTO_INCREMENT,
  `cod_pedido` INT(11) NOT NULL,
  `valor` DOUBLE NOT NULL,
  PRIMARY KEY (`codigo`),
  FOREIGN KEY (`cod_pedido`) REFERENCES `pedido` (`codigo`)
) ENGINE=InnoDB;

--
-- Table structure for table `div_cliente`
--
CREATE TABLE `div_cliente` (
  `cod_cliente` INT NOT NULL,
  `cod_divida` INT NOT NULL,
  CONSTRAINT `pk_div_cliente` PRIMARY KEY (`cod_cliente`, `cod_divida`),
  CONSTRAINT `fk_cod_cliente` FOREIGN KEY (`cod_cliente`) REFERENCES `cliente` (`codigo`),
  CONSTRAINT `fk_cod_divida` FOREIGN KEY (`cod_divida`) REFERENCES `divida` (`codigo`)
) ENGINE=InnoDB;

	