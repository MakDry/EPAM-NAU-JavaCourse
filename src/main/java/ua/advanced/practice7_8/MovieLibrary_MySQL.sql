-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema MovieLibrary
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema MovieLibrary
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `MovieLibrary` DEFAULT CHARACTER SET utf8 ;
USE `MovieLibrary` ;

-- -----------------------------------------------------
-- Table `MovieLibrary`.`Directors`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MovieLibrary`.`Directors` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(200) NOT NULL,
  `Surname` VARCHAR(200) NOT NULL,
  `Patronumic` VARCHAR(200) NOT NULL,
  `DateOfBirth` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MovieLibrary`.`Movies`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MovieLibrary`.`Movies` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Title` VARCHAR(200) NOT NULL,
  `Director` INT NOT NULL,
  `DateOfCreation` DATE NOT NULL,
  `Country` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `Director_ID`
    FOREIGN KEY (`Director`)
    REFERENCES `MovieLibrary`.`Directors` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MovieLibrary`.`Actors`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MovieLibrary`.`Actors` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(200) NOT NULL,
  `Surname` VARCHAR(200) NOT NULL,
  `Patronymic` VARCHAR(200) NOT NULL,
  `DateOfBirth` DATE NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MovieLibrary`.`FilmsActors`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MovieLibrary`.`FilmsActors` (
  `Movie_ID` INT NOT NULL,
  `Actor_ID` INT NOT NULL,
  CONSTRAINT `Movie_ID`
    FOREIGN KEY (`Movie_ID`)
    REFERENCES `MovieLibrary`.`Movies` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Actor_ID`
    FOREIGN KEY (`Actor_ID`)
    REFERENCES `MovieLibrary`.`Actors` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
