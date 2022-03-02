-- MySQL Workbench Synchronization
-- Generated: 2022-02-25 14:52
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: Domingos Dala Vunge

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE TABLE IF NOT EXISTS `erp_dvml_db`.`parc_empresa` (
  `pk_parc_empresa` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(75) NULL DEFAULT NULL,
  `nif` VARCHAR(45) NULL DEFAULT NULL,
  `telefone` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `endereco` VARCHAR(150) NULL DEFAULT NULL,
  `fk_parc_tipologia` INT(11) NOT NULL,
  PRIMARY KEY (`pk_parc_empresa`),
  INDEX `fk_parc_empresa_parc_tipologia_idx` (`fk_parc_tipologia` ASC),
  CONSTRAINT `fk_parc_empresa_parc_tipologia`
    FOREIGN KEY (`fk_parc_tipologia`)
    REFERENCES `erp_dvml_db`.`parc_tipologia` (`pk_parc_tipologia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `erp_dvml_db`.`parc_tipologia` (
  `pk_parc_tipologia` INT(11) NOT NULL AUTO_INCREMENT,
  `designacao` VARCHAR(45) NULL DEFAULT NULL,
  `percetagem` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`pk_parc_tipologia`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `erp_dvml_db`.`parc_software` (
  `pk_parc_software` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL DEFAULT NULL,
  `descricao` VARCHAR(200) NULL DEFAULT NULL,
  PRIMARY KEY (`pk_parc_software`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `erp_dvml_db`.`parc_empresa_has_parc_software` (
  `fk_parc_empresa` INT(11) NOT NULL,
  `fk_parc_software` INT(11) NOT NULL,
  `data_atribuicao` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`fk_parc_empresa`, `fk_parc_software`),
  INDEX `fk_parc_empresa_has_parc_software_parc_software1_idx` (`fk_parc_software` ASC),
  INDEX `fk_parc_empresa_has_parc_software_parc_empresa1_idx` (`fk_parc_empresa` ASC),
  CONSTRAINT `fk_parc_empresa_has_parc_software_parc_empresa1`
    FOREIGN KEY (`fk_parc_empresa`)
    REFERENCES `erp_dvml_db`.`parc_empresa` (`pk_parc_empresa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_parc_empresa_has_parc_software_parc_software1`
    FOREIGN KEY (`fk_parc_software`)
    REFERENCES `erp_dvml_db`.`parc_software` (`pk_parc_software`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `erp_dvml_db`.`parc_adesao` (
  `pk_parc_adesao` INT(11) NOT NULL AUTO_INCREMENT,
  `data` DATETIME NULL DEFAULT NULL,
  `valor_venda` DECIMAL(10,2) NULL DEFAULT NULL,
  `valor_equivalente` DECIMAL(10,2) NULL DEFAULT NULL,
  `pago_totalidade` TINYINT(4) NULL DEFAULT 0,
  `fk_parc_empresa` INT(11) NOT NULL,
  PRIMARY KEY (`pk_parc_adesao`),
  INDEX `fk_parc_adesao_parc_empresa1_idx` (`fk_parc_empresa` ASC),
  CONSTRAINT `fk_parc_adesao_parc_empresa1`
    FOREIGN KEY (`fk_parc_empresa`)
    REFERENCES `erp_dvml_db`.`parc_empresa` (`pk_parc_empresa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `erp_dvml_db`.`parc_linhas_adesao` (
  `pk_parc_linhas_adesao` INT(11) NOT NULL AUTO_INCREMENT,
  `fk_parc_software` INT(11) NOT NULL,
  `fk_parc_adesao` INT(11) NOT NULL,
  `valor_percentagem` DECIMAL(10,2) NULL DEFAULT NULL,
  PRIMARY KEY (`pk_parc_linhas_adesao`),
  INDEX `fk_parc_linhas_adesao_parc_software1_idx` (`fk_parc_software` ASC),
  INDEX `fk_parc_linhas_adesao_parc_adesao1_idx` (`fk_parc_adesao` ASC),
  CONSTRAINT `fk_parc_linhas_adesao_parc_software1`
    FOREIGN KEY (`fk_parc_software`)
    REFERENCES `erp_dvml_db`.`parc_software` (`pk_parc_software`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_parc_linhas_adesao_parc_adesao1`
    FOREIGN KEY (`fk_parc_adesao`)
    REFERENCES `erp_dvml_db`.`parc_adesao` (`pk_parc_adesao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `erp_dvml_db`.`parc_pagamentos` (
  `pk_parc_pagamentos` INT(11) NOT NULL AUTO_INCREMENT,
  `data` DATETIME NULL DEFAULT NULL,
  `valor` DECIMAL(10,2) NULL DEFAULT NULL,
  `fk_parc_adesao` INT(11) NOT NULL,
  PRIMARY KEY (`pk_parc_pagamentos`),
  INDEX `fk_parc_pagamentos_parc_adesao1_idx` (`fk_parc_adesao` ASC),
  CONSTRAINT `fk_parc_pagamentos_parc_adesao1`
    FOREIGN KEY (`fk_parc_adesao`)
    REFERENCES `erp_dvml_db`.`parc_adesao` (`pk_parc_adesao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `erp_dvml_db`.`af_funcionarios` (
  `pk_af_funcionario` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL DEFAULT NULL,
  `telefone` VARCHAR(45) NULL DEFAULT NULL,
  `endereco` VARCHAR(45) NULL DEFAULT NULL,
  `funcao` VARCHAR(45) NULL DEFAULT NULL,
  `status` ENUM('Activo', 'Desactivo') NULL DEFAULT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `sexo` ENUM('Masculino', 'Femenino') NULL DEFAULT NULL,
  PRIMARY KEY (`pk_af_funcionario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `erp_dvml_db`.`af_actividades` (
  `pk_af_actividades` INT(11) NOT NULL AUTO_INCREMENT,
  `data` DATETIME NULL DEFAULT NULL,
  `problema` VARCHAR(150) NULL DEFAULT NULL,
  `possivel_resolucao` VARCHAR(200) NULL DEFAULT NULL,
  `fk_af_cliente` INT(11) NOT NULL,
  `fk_parc_software` INT(11) NOT NULL,
  PRIMARY KEY (`pk_af_actividades`),
  INDEX `fk_af_actividades_af_clientes1_idx` (`fk_af_cliente` ASC),
  INDEX `fk_af_actividades_parc_software1_idx` (`fk_parc_software` ASC),
  CONSTRAINT `fk_af_actividades_af_clientes1`
    FOREIGN KEY (`fk_af_cliente`)
    REFERENCES `erp_dvml_db`.`af_clientes` (`pk_af_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_af_actividades_parc_software1`
    FOREIGN KEY (`fk_parc_software`)
    REFERENCES `erp_dvml_db`.`parc_software` (`pk_parc_software`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `erp_dvml_db`.`af_clientes` (
  `pk_af_cliente` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL DEFAULT NULL,
  `nif` VARCHAR(45) NULL DEFAULT NULL,
  `endereco` VARCHAR(45) NULL DEFAULT NULL,
  `telefone` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`pk_af_cliente`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `erp_dvml_db`.`af_linhas_actividade` (
  `fk_af_funcionario` INT(11) NOT NULL,
  `fk_af_actividade` INT(11) NOT NULL,
  `funcao` ENUM('Lider Master', 'Membro') NULL DEFAULT NULL,
  PRIMARY KEY (`fk_af_funcionario`, `fk_af_actividade`),
  INDEX `fk_af_funcionarios_has_af_actividades_af_actividades1_idx` (`fk_af_actividade` ASC),
  INDEX `fk_af_funcionarios_has_af_actividades_af_funcionarios1_idx` (`fk_af_funcionario` ASC),
  CONSTRAINT `fk_af_funcionarios_has_af_actividades_af_funcionarios1`
    FOREIGN KEY (`fk_af_funcionario`)
    REFERENCES `erp_dvml_db`.`af_funcionarios` (`pk_af_funcionario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_af_funcionarios_has_af_actividades_af_actividades1`
    FOREIGN KEY (`fk_af_actividade`)
    REFERENCES `erp_dvml_db`.`af_actividades` (`pk_af_actividades`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `erp_dvml_db`.`pat_artigos` (
  `pk_pat_artigo` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(75) NOT NULL,
  `data_fabrico` DATE NULL DEFAULT NULL,
  `data_expiracao` DATE NULL DEFAULT NULL,
  `custo_compra` DECIMAL(10,2) NULL DEFAULT NULL,
  `estado` ENUM('Bom', 'Mau', 'Em reparação', 'Suspenso') NULL DEFAULT NULL,
  `fk_pat_categoria` INT(11) NOT NULL,
  PRIMARY KEY (`pk_pat_artigo`),
  INDEX `fk_pat_artigos_pat_categorias1_idx` (`fk_pat_categoria` ASC),
  CONSTRAINT `fk_pat_artigos_pat_categorias1`
    FOREIGN KEY (`fk_pat_categoria`)
    REFERENCES `erp_dvml_db`.`pat_categorias` (`pk_pat_categoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `erp_dvml_db`.`pat_categorias` (
  `pk_pat_categoria` INT(11) NOT NULL AUTO_INCREMENT,
  `designacao` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`pk_pat_categoria`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `erp_dvml_db`.`pat_repacoes` (
  `pk_pat_repacao` INT(11) NOT NULL AUTO_INCREMENT,
  `data` DATETIME NULL DEFAULT NULL,
  `nome_responsavel` VARCHAR(45) NULL DEFAULT NULL,
  `custo` DECIMAL(10,2) NULL DEFAULT NULL,
  PRIMARY KEY (`pk_pat_repacao`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `erp_dvml_db`.`linhas_repacao` (
  `fk_pat_artigo` INT(11) NOT NULL,
  `fk_pat_repacao` INT(11) NOT NULL,
  `qtd` INT(11) NULL DEFAULT NULL,
  `sub_total` DECIMAL(10,2) NULL DEFAULT NULL,
  PRIMARY KEY (`fk_pat_artigo`, `fk_pat_repacao`),
  INDEX `fk_pat_artigos_has_pat_repacoes_pat_repacoes1_idx` (`fk_pat_repacao` ASC),
  INDEX `fk_pat_artigos_has_pat_repacoes_pat_artigos1_idx` (`fk_pat_artigo` ASC),
  CONSTRAINT `fk_pat_artigos_has_pat_repacoes_pat_artigos1`
    FOREIGN KEY (`fk_pat_artigo`)
    REFERENCES `erp_dvml_db`.`pat_artigos` (`pk_pat_artigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pat_artigos_has_pat_repacoes_pat_repacoes1`
    FOREIGN KEY (`fk_pat_repacao`)
    REFERENCES `erp_dvml_db`.`pat_repacoes` (`pk_pat_repacao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
