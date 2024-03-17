-- MySQL Script generated by MySQL Workbench
-- dom 17 mar 2024 18:10:13
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Table `Aluno`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Aluno` ;

CREATE TABLE IF NOT EXISTS `Aluno` (
  `CPF` CHAR(11) NOT NULL,
  `Nome` VARCHAR(45) NULL,
  `Sobrenome` VARCHAR(45) NULL,
  `Sexo` CHAR(1) NULL,
  `DataNasc` DATE NULL,
  PRIMARY KEY (`CPF`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Area`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Area` ;

CREATE TABLE IF NOT EXISTS `Area` (
  `Sigla` VARCHAR(5) NOT NULL,
  `Nome` VARCHAR(45) NULL,
  `SuperArea` VARCHAR(5) NOT NULL,
  PRIMARY KEY (`Sigla`),
  CONSTRAINT `fk_Area_Area1`
    FOREIGN KEY (`SuperArea`)
    REFERENCES `Area` (`Sigla`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Area_Area1_idx` ON `Area` (`SuperArea` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `Curso`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Curso` ;

CREATE TABLE IF NOT EXISTS `Curso` (
  `Sigla` VARCHAR(5) NOT NULL,
  `Nome` VARCHAR(45) NULL,
  `Horas` INT NULL,
  `Custo` FLOAT NULL,
  `Area` VARCHAR(5) NOT NULL,
  PRIMARY KEY (`Sigla`),
  CONSTRAINT `fk_Curso_Area1`
    FOREIGN KEY (`Area`)
    REFERENCES `Area` (`Sigla`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Curso_Area1_idx` ON `Curso` (`Area` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `Matricula`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Matricula` ;

CREATE TABLE IF NOT EXISTS `Matricula` (
  `Curso` VARCHAR(5) NOT NULL,
  `Aluno` CHAR(11) NOT NULL,
  `Data` DATE NULL,
  `Pago` INT NULL,
  PRIMARY KEY (`Curso`, `Aluno`),
  CONSTRAINT `fk_Matricula_Aluno`
    FOREIGN KEY (`Aluno`)
    REFERENCES `Aluno` (`CPF`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Matricula_Curso1`
    FOREIGN KEY (`Curso`)
    REFERENCES `Curso` (`Sigla`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Matricula_Aluno_idx` ON `Matricula` (`Aluno` ASC) VISIBLE;

CREATE INDEX `fk_Matricula_Curso1_idx` ON `Matricula` (`Curso` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `Modulo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Modulo` ;

CREATE TABLE IF NOT EXISTS `Modulo` (
  `Sigla` VARCHAR(5) NOT NULL,
  `Nome` VARCHAR(45) NULL,
  `Curso` VARCHAR(5) NOT NULL,
  PRIMARY KEY (`Sigla`),
  CONSTRAINT `fk_Modulo_Curso1`
    FOREIGN KEY (`Curso`)
    REFERENCES `Curso` (`Sigla`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Modulo_Curso1_idx` ON `Modulo` (`Curso` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `Professor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Professor` ;

CREATE TABLE IF NOT EXISTS `Professor` (
  `Curso` VARCHAR(5) NOT NULL,
  `CPF` CHAR(11) NOT NULL,
  `Nome` VARCHAR(45) NULL,
  PRIMARY KEY (`Curso`, `CPF`),
  CONSTRAINT `fk_Professor_Curso1`
    FOREIGN KEY (`Curso`)
    REFERENCES `Curso` (`Sigla`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Professor_Curso1_idx` ON `Professor` (`Curso` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `Topico`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Topico` ;

CREATE TABLE IF NOT EXISTS `Topico` (
  `Modulo` VARCHAR(5) NOT NULL,
  `Sigla` VARCHAR(5) NOT NULL,
  `Nome` VARCHAR(45) NULL,
  `Horas` INT NULL,
  PRIMARY KEY (`Modulo`, `Sigla`),
  CONSTRAINT `fk_Topico_Modulo1`
    FOREIGN KEY (`Modulo`)
    REFERENCES `Modulo` (`Sigla`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Topico_Modulo1_idx` ON `Topico` (`Modulo` ASC) VISIBLE;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
