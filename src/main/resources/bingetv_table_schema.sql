# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.5.5-10.7.3-MariaDB)
# Database: bingetv
# Generation Time: 2022-06-27 13:50:49 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;


# Dump of table refresh_token
# ------------------------------------------------------------
CREATE DATABASE IF NOT EXISTS bingetv;
USE bingetv;


CREATE TABLE `refresh_token`
(
    `id`           bigint(20) NOT NULL AUTO_INCREMENT,
    `created_date` datetime(6)  DEFAULT NULL,
    `token`        varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 6
  DEFAULT CHARSET = utf8mb4;

LOCK TABLES `refresh_token` WRITE;
/*!40000 ALTER TABLE `refresh_token`
    DISABLE KEYS */;


/*!40000 ALTER TABLE `refresh_token`
    ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table shows
# ------------------------------------------------------------

CREATE TABLE `shows`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT,
    `show_id`       bigint(20)   DEFAULT NULL,
    `show_name`     varchar(255) DEFAULT NULL,
    `users_user_id` bigint(20)   DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `FK6g711abwcv7nd7qlp0l8o3so1` (`users_user_id`),
    CONSTRAINT `FK6g711abwcv7nd7qlp0l8o3so1` FOREIGN KEY (`users_user_id`) REFERENCES `user` (`user_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;



# Dump of table token
# ------------------------------------------------------------

CREATE TABLE `token`
(
    `id`           bigint(20) NOT NULL AUTO_INCREMENT,
    `token`        varchar(255) DEFAULT NULL,
    `user_user_id` bigint(20)   DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `FK79keudebybjlldk2o4i0nwqev` (`user_user_id`),
    CONSTRAINT `FK79keudebybjlldk2o4i0nwqev` FOREIGN KEY (`user_user_id`) REFERENCES `user` (`user_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 4
  DEFAULT CHARSET = utf8mb4;

LOCK TABLES `token` WRITE;
/*!40000 ALTER TABLE `token`
    DISABLE KEYS */;


/*!40000 ALTER TABLE `token`
    ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table user
# ------------------------------------------------------------

CREATE TABLE `user`
(
    `user_id`  bigint(20) NOT NULL AUTO_INCREMENT,
    `bio`      varchar(255) DEFAULT NULL,
    `created`  datetime(6)  DEFAULT NULL,
    `email`    varchar(255) DEFAULT NULL,
    `enabled`  bit(1)     NOT NULL,
    `password` varchar(255) DEFAULT NULL,
    `username` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`user_id`),
    UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`),
    UNIQUE KEY `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 4
  DEFAULT CHARSET = utf8mb4;

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user`
    DISABLE KEYS */;



/*!40000 ALTER TABLE `user`
    ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;
