-- -----------------------------------------------------
-- Table `dungeon`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `dungeon` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `name` TEXT NOT NULL ,
  `creator` TEXT NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `winner`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `winner` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `playerName` TEXT NOT NULL ,
  `dungeon` INT NOT NULL ,
  `date` DATETIME NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `actionBlock`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `actionBlock` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `dungeon` INT NOT NULL ,
  `x` INT NOT NULL ,
  `y` INT NOT NULL ,
  `z` INT NOT NULL ,
  `world` TEXT NOT NULL ,
  `blockID` INT NOT NULL ,
  `blockSubID` INT NOT NULL ,
  `actionType` INT NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `sign`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sign` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `dungeon` INT NOT NULL ,
  `x` INT NOT NULL ,
  `y` INT NOT NULL ,
  `z` INT NOT NULL ,
  `world` TEXT NOT NULL ,
  `subID` INT NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;