-- Volcando datos para la tabla si_database.drug: ~3 rows (aproximadamente)
INSERT IGNORE INTO `drug` (`id`, `activePrinciple`, `alternative`, `atc`, `isPrimaryCare`, `reasonToAvoid`) VALUES
	(1, 'Aliskireno', 'asdf', 'AA01', b'1', 'asdf'),
	(2, 'Domperidona', 'dfsasss', 'BO23', b'0', 'fasdfff'),
	(3, 'EjemploPA', 'hfgdhgfh', 'EjemploATC', b'1', 'dfghdfgh');


-- Volcando datos para la tabla si_database.healthalert: ~0 rows (aproximadamente)
INSERT IGNORE INTO `healthalert` (`idHealthAlert`, `alertLink`, `organization`, `drug_id`) VALUES
	(1, 'https://alertas.example.com/1', 'FDA', 2);

-- Volcando datos para la tabla si_database.manufacturer: ~2 rows (aproximadamente)
INSERT IGNORE INTO `manufacturer` (`name`, `city`, `country`, `floor`, `letra`, `number`, `region`, `road`, `cif`) VALUES
	('Bayer', 'Madrid', 'España', 12, 'A', 100, 'Madrid', 'Avenida Salud', 'B12345678'),
	('PepeSL', 'Pontevedra', 'España', 3, 'a', 123, 'Galicia', 'calle', '123456789G');
-- Volcando datos para la tabla si_database.product: ~2 rows (aproximadamente)
INSERT IGNORE INTO `product` (`gtin`, `mgs`, `name`, `units`, `manufacturer_name`) VALUES
	(1234, 10, 'A.A.S.', 100, 'PepeSL'),
	(1234567890123, 500, 'Aspirina 500mg', 20, 'Bayer');

-- Volcando datos para la tabla si_database.product_drug: ~3 rows (aproximadamente)
INSERT IGNORE INTO `product_drug` (`PRODUCT_ID`, `DRUG_ID`) VALUES
	(1234, 1),
	(1234, 2),
	(1234, 3);

-- Volcando datos para la tabla si_database.publication: ~3 rows (aproximadamente)
INSERT IGNORE INTO `publication` (`id`, `publicationLink`, `year`) VALUES
	(1, 'https://web.archive.org/web/20230209113109/https://english.prescrire.org/en/C44A03938C833408D637CCDBAC9C349A/Download.aspx', 2023),
	(2, 'https://web.archive.org/web/20240814083415/https://english.prescrire.org/en/DAFEAE6270127C102DF462B5AA4A0659/Download.aspx', 2024),
	(4, 'https://web.archive.org/web/20220521064659/https://english.prescrire.org/en/0A3B7E6B94F2B2EAE84F816CDBA3D5EE/Download.aspx', 2022);

-- Volcando datos para la tabla si_database.publication_drug: ~2 rows (aproximadamente)
INSERT IGNORE INTO `publication_drug` (`PUBLICATION_ID`, `DRUG_ID`) VALUES
	(1, 2),
	(1, 3);

