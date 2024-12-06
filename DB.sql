-- Versión del servidor:         11.4.2-MariaDB - mariadb.org binary distribution
-- Volcando estructura de base de datos para si_database
CREATE DATABASE IF NOT EXISTS `si_database` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `si_database`;

-- Volcando estructura para tabla si_database.drug
CREATE TABLE IF NOT EXISTS `drug` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activePrinciple` varchar(255) DEFAULT NULL,
  `alternative` varchar(255) DEFAULT NULL,
  `atc` varchar(255) DEFAULT NULL,
  `isPrimaryCare` bit(1) DEFAULT NULL,
  `reasonToAvoid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKqmlqbqeh6o8dct7i4631gr8p5` (`activePrinciple`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla si_database.drug: ~3 rows (aproximadamente)
INSERT IGNORE INTO `drug` (`id`, `activePrinciple`, `alternative`, `atc`, `isPrimaryCare`, `reasonToAvoid`) VALUES
	(1, 'Aliskireno', 'asdf', 'AA01', b'1', 'asdf'),
	(2, 'Domperidona', 'dfsasss', 'BO23', b'0', 'fasdfff'),
	(3, 'EjemploPA', 'hfgdhgfh', 'EjemploATC', b'1', 'dfghdfgh');

-- Volcando estructura para tabla si_database.healthalert
CREATE TABLE IF NOT EXISTS `healthalert` (
  `idHealthAlert` bigint(20) NOT NULL AUTO_INCREMENT,
  `alertLink` varchar(255) DEFAULT NULL,
  `organization` varchar(255) DEFAULT NULL,
  `drug_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`idHealthAlert`),
  KEY `FK2qor0m01721c7ke5pomwaufiu` (`drug_id`),
  CONSTRAINT `FK2qor0m01721c7ke5pomwaufiu` FOREIGN KEY (`drug_id`) REFERENCES `drug` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla si_database.healthalert: ~0 rows (aproximadamente)
INSERT IGNORE INTO `healthalert` (`idHealthAlert`, `alertLink`, `organization`, `drug_id`) VALUES
	(1, 'https://alertas.example.com/1', 'FDA', 2);

-- Volcando estructura para tabla si_database.manufacturer
CREATE TABLE IF NOT EXISTS `manufacturer` (
  `name` varchar(255) NOT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `floor` int(11) DEFAULT NULL,
  `letra` varchar(255) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  `road` varchar(255) DEFAULT NULL,
  `cif` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`name`),
  UNIQUE KEY `UK9hip9h7den5upcf18lxgf9ttf` (`cif`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla si_database.manufacturer: ~2 rows (aproximadamente)
INSERT IGNORE INTO `manufacturer` (`name`, `city`, `country`, `floor`, `letra`, `number`, `region`, `road`, `cif`) VALUES
	('Bayer', 'Madrid', 'España', 12, 'A', 100, 'Madrid', 'Avenida Salud', 'B12345678'),
	('PepeSL', 'Pontevedra', 'España', 3, 'a', 123, 'Galicia', 'calle', '123456789G');

-- Volcando estructura para tabla si_database.product
CREATE TABLE IF NOT EXISTS `product` (
  `gtin` bigint(20) NOT NULL,
  `mgs` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `units` int(11) DEFAULT NULL,
  `manufacturer_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`gtin`),
  UNIQUE KEY `UKgxubutkbk5o2a6aakbe7q9kww` (`name`),
  KEY `FKq591nxj1ungdkn252v9p32n3b` (`manufacturer_name`),
  CONSTRAINT `FKq591nxj1ungdkn252v9p32n3b` FOREIGN KEY (`manufacturer_name`) REFERENCES `manufacturer` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla si_database.product: ~2 rows (aproximadamente)
INSERT IGNORE INTO `product` (`gtin`, `mgs`, `name`, `units`, `manufacturer_name`) VALUES
	(1234, 10, 'A.A.S.', 100, 'PepeSL'),
	(1234567890123, 500, 'Aspirina 500mg', 20, 'Bayer');

-- Volcando estructura para tabla si_database.product_drug
CREATE TABLE IF NOT EXISTS `product_drug` (
  `PRODUCT_ID` bigint(20) NOT NULL,
  `DRUG_ID` bigint(20) NOT NULL,
  KEY `FKjn1nwkns8mjo4vyqj9rvjjosj` (`DRUG_ID`),
  KEY `FKd9j2jcsht70bvcl9q5c411v4f` (`PRODUCT_ID`),
  CONSTRAINT `FKd9j2jcsht70bvcl9q5c411v4f` FOREIGN KEY (`PRODUCT_ID`) REFERENCES `product` (`gtin`),
  CONSTRAINT `FKjn1nwkns8mjo4vyqj9rvjjosj` FOREIGN KEY (`DRUG_ID`) REFERENCES `drug` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla si_database.product_drug: ~3 rows (aproximadamente)
INSERT IGNORE INTO `product_drug` (`PRODUCT_ID`, `DRUG_ID`) VALUES
	(1234, 1),
	(1234, 2),
	(1234, 3);

-- Volcando estructura para tabla si_database.publication
CREATE TABLE IF NOT EXISTS `publication` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `publicationLink` varchar(255) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKbx83hhbjrfl071qxq5td2nujf` (`publicationLink`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla si_database.publication: ~3 rows (aproximadamente)
INSERT IGNORE INTO `publication` (`id`, `publicationLink`, `year`) VALUES
	(1, 'https://web.archive.org/web/20230209113109/https://english.prescrire.org/en/C44A03938C833408D637CCDBAC9C349A/Download.aspx', 2023),
	(2, 'https://web.archive.org/web/20240814083415/https://english.prescrire.org/en/DAFEAE6270127C102DF462B5AA4A0659/Download.aspx', 2024),
	(4, 'https://web.archive.org/web/20220521064659/https://english.prescrire.org/en/0A3B7E6B94F2B2EAE84F816CDBA3D5EE/Download.aspx', 2022);

-- Volcando estructura para tabla si_database.publication_drug
CREATE TABLE IF NOT EXISTS `publication_drug` (
  `PUBLICATION_ID` bigint(20) NOT NULL,
  `DRUG_ID` bigint(20) NOT NULL,
  KEY `FK4tjndxk3915hvn5jwmtytu6p6` (`DRUG_ID`),
  KEY `FK2rh1kumuwr6413mwrtj5522d5` (`PUBLICATION_ID`),
  CONSTRAINT `FK2rh1kumuwr6413mwrtj5522d5` FOREIGN KEY (`PUBLICATION_ID`) REFERENCES `publication` (`id`),
  CONSTRAINT `FK4tjndxk3915hvn5jwmtytu6p6` FOREIGN KEY (`DRUG_ID`) REFERENCES `drug` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla si_database.publication_drug: ~2 rows (aproximadamente)
INSERT IGNORE INTO `publication_drug` (`PUBLICATION_ID`, `DRUG_ID`) VALUES
	(1, 2),
	(1, 3);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
