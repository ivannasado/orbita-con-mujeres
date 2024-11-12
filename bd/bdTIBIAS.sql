CREATE SCHEMA IF NOT EXISTS `bdtibias` DEFAULT CHARACTER SET utf8mb3 ;
USE `bdtibias` ;

-- TABLA BOARD
CREATE TABLE IF NOT EXISTS `bdtibias`.`board` (
  `id_board` BIGINT NOT NULL,
  `id_admin` BIGINT NOT NULL,
  `description` VARCHAR(200) NOT NULL,
  `image` VARCHAR(300) NOT NULL,
  `creation_date` DATE NOT NULL,
  PRIMARY KEY (`id_board`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;

-- TABLA PROFILE
CREATE TABLE IF NOT EXISTS `bdtibias`.`profile` (
  `id_profile` BIGINT NOT NULL,
  `user_name` VARCHAR(45) NOT NULL,
  `profile_image` VARCHAR(300) NOT NULL,
  `about_me` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`id_profile`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;

-- TABLA USERS
CREATE TABLE IF NOT EXISTS `bdtibias`.`users` (
  `id_user` BIGINT NOT NULL,
  `user_name` VARCHAR(45) NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `telephone` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(150) NOT NULL,
  `creation_date` DATE NOT NULL,
  `profile_id_profile` BIGINT NOT NULL,
  PRIMARY KEY (`id_user`),
  INDEX `fk_users_profile_idx` (`profile_id_profile` ASC) VISIBLE,
  CONSTRAINT `fk_users_profile`
    FOREIGN KEY (`profile_id_profile`)
    REFERENCES `bdtibias`.`profile` (`id_profile`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;

-- TABLA ADMINS
CREATE TABLE IF NOT EXISTS `bdtibias`.`admins` (
  `id_admins` BIGINT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `board_id_board` BIGINT NOT NULL,
  `users_id_user` BIGINT NOT NULL,
  PRIMARY KEY (`id_admins`),
  INDEX `fk_admins_board1_idx` (`board_id_board` ASC) VISIBLE,
  INDEX `fk_admins_users1_idx` (`users_id_user` ASC) VISIBLE,
  CONSTRAINT `fk_admins_board1`
    FOREIGN KEY (`board_id_board`)
    REFERENCES `bdtibias`.`board` (`id_board`),
  CONSTRAINT `fk_admins_users1`
    FOREIGN KEY (`users_id_user`)
    REFERENCES `bdtibias`.`users` (`id_user`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;

-- TABLA LABEL
CREATE TABLE IF NOT EXISTS `bdtibias`.`label` (
  `id_label` BIGINT NOT NULL,
  `Categories` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_label`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;

-- TABLA POST
CREATE TABLE IF NOT EXISTS `bdtibias`.`post` (
  `id_post` BIGINT NOT NULL,
  `content` VARCHAR(200) NOT NULL,
  `image` VARCHAR(300) NOT NULL,
  `creation_date` DATE NOT NULL,
  `label_id_label` BIGINT NOT NULL,
  `users_id_user` BIGINT NOT NULL,
  PRIMARY KEY (`id_post`),
  INDEX `fk_post_label1_idx` (`label_id_label` ASC) VISIBLE,
  INDEX `fk_post_users1_idx` (`users_id_user` ASC) VISIBLE,
  CONSTRAINT `fk_post_label1`
    FOREIGN KEY (`label_id_label`)
    REFERENCES `bdtibias`.`label` (`id_label`),
  CONSTRAINT `fk_post_users1`
    FOREIGN KEY (`users_id_user`)
    REFERENCES `bdtibias`.`users` (`id_user`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;

-- TABLA FAVORITE
CREATE TABLE IF NOT EXISTS `bdtibias`.`favorite` (
  `id_favorite` BIGINT NOT NULL,
  `users_id_user` BIGINT NOT NULL,
  `post_id_post` BIGINT NOT NULL,
  PRIMARY KEY (`id_favorite`),
  INDEX `fk_favorite_users1_idx` (`users_id_user` ASC) VISIBLE,
  INDEX `fk_favorite_post1_idx` (`post_id_post` ASC) VISIBLE,
  CONSTRAINT `fk_favorite_post1`
    FOREIGN KEY (`post_id_post`)
    REFERENCES `bdtibias`.`post` (`id_post`),
  CONSTRAINT `fk_favorite_users1`
    FOREIGN KEY (`users_id_user`)
    REFERENCES `bdtibias`.`users` (`id_user`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


