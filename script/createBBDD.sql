-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.6.17 - MySQL Community Server (GPL)
-- SO del servidor:              Win64
-- HeidiSQL Versión:             9.3.0.5027
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Volcando estructura de base de datos para santisvs
CREATE DATABASE IF NOT EXISTS `santisvs` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `santisvs`;


-- Volcando estructura para procedimiento santisvs.deleteById
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteById`(IN `ident` INT)
    COMMENT 'Elimina el registro con id '
BEGIN

delete
from perro
where `id` = ident;

END//
DELIMITER ;


-- Volcando estructura para procedimiento santisvs.getAll
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAll`(IN `pLimite` INT)
    COMMENT 'Procedimiento almacenado que devuelve toda la lista de perros'
BEGIN

select
p.`id`,
p.`nombre`,
p.`raza`,
p.`sexo`
from perro AS p
order by p.`id` LIMIT pLimite;

END//
DELIMITER ;


-- Volcando estructura para procedimiento santisvs.getById
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `getById`(IN `id` INT)
    COMMENT 'Devuelve el elmento con id'
BEGIN

select
p.`id`,
p.`nombre`,
p.`raza`,
p.`sexo`
from perro AS p
WHERE p.`id` = id;

END//
DELIMITER ;


-- Volcando estructura para procedimiento santisvs.insertReg
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertReg`(IN `inNombre` VARCHAR(200), IN `inRaza` VARCHAR(200), IN `inSexo` CHAR(50), OUT `outId` INT)
    COMMENT 'Inserta un registro nuevo en la tabla'
BEGIN

INSERT INTO Perro (`nombre`, `raza`, `sexo`) VALUES (inNombre, inRaza, inSexo);

-- CONSULTAR ID GENERADO


SET outId = LAST_INSERT_ID();


END//
DELIMITER ;


-- Volcando estructura para tabla santisvs.perro
CREATE TABLE IF NOT EXISTS `perro` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(200) NOT NULL DEFAULT 'Sin Definir' COMMENT 'Nombre del perro',
  `raza` varchar(200) NOT NULL DEFAULT 'Sin definir' COMMENT 'Raza del perro',
  `sexo` char(1) NOT NULL DEFAULT 'I' COMMENT 'Sexo (Indefinido I , Macho M, Hembra H)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=140 DEFAULT CHARSET=utf8 COMMENT='tabla donde guardamos la informacion de cada perro';

-- Volcando datos para la tabla santisvs.perro: ~107 rows (aproximadamente)
/*!40000 ALTER TABLE `perro` DISABLE KEYS */;
INSERT INTO `perro` (`id`, `nombre`, `raza`, `sexo`) VALUES
	(7, 'prueba', 'Chucho', 'M'),
	(8, 'Sin Definir', 'Sin Definir', 'I'),
	(9, 'Sin Definir', 'Sin Definir', 'I'),
	(10, 'Perro1', 'Sin Definir', 'I'),
	(11, 'Perro1', 'Sin Definir', 'I'),
	(12, 'Perro2', 'Sin Definir', 'I'),
	(13, 'Perro2', 'Sin Definir', 'I'),
	(14, 'Perro3', 'Sin Definir', 'I'),
	(15, 'Perro3', 'Sin Definir', 'I'),
	(16, 'Sin Definir', 'Sin Definir', 'I'),
	(17, 'Sin Definir', 'Sin Definir', 'I'),
	(18, 'Perro1', 'Sin Definir', 'I'),
	(19, 'Perro1', 'Sin Definir', 'I'),
	(20, 'Perro2', 'Sin Definir', 'I'),
	(21, 'Perro2', 'Sin Definir', 'I'),
	(22, 'Perro3', 'Sin Definir', 'I'),
	(23, 'Perro3', 'Sin Definir', 'I'),
	(24, 'Paris', 'Stafford', 'H'),
	(25, 'Paris', 'Stafford', 'H'),
	(26, 'Sin Definir', 'Sin Definir', 'I'),
	(27, 'Sin Definir', 'Sin Definir', 'I'),
	(28, 'Perro1', 'Sin Definir', 'I'),
	(29, 'Perro1', 'Sin Definir', 'I'),
	(30, 'Perro2', 'Sin Definir', 'I'),
	(31, 'Perro2', 'Sin Definir', 'I'),
	(32, 'Perro3', 'Sin Definir', 'I'),
	(33, 'Perro3', 'Sin Definir', 'I'),
	(34, 'Paris', 'Stafford', 'H'),
	(35, 'Paris', 'Stafford', 'H'),
	(36, 'Sin Definir', 'Sin Definir', 'I'),
	(37, 'Sin Definir', 'Sin Definir', 'I'),
	(38, 'Perro1', 'Sin Definir', 'I'),
	(39, 'Perro1', 'Sin Definir', 'I'),
	(40, 'Perro2', 'Sin Definir', 'I'),
	(41, 'Perro2', 'Sin Definir', 'I'),
	(42, 'Perro3', 'Sin Definir', 'I'),
	(43, 'Perro3', 'Sin Definir', 'I'),
	(44, 'Paris', 'Stafford', 'H'),
	(45, 'Paris', 'Stafford', 'H'),
	(46, 'Sin Definir', 'Sin Definir', 'I'),
	(47, 'Sin Definir', 'Sin Definir', 'I'),
	(48, 'Perro1', 'Sin Definir', 'I'),
	(49, 'Perro1', 'Sin Definir', 'I'),
	(50, 'Perro2', 'Sin Definir', 'I'),
	(51, 'Perro2', 'Sin Definir', 'I'),
	(52, 'Perro3', 'Sin Definir', 'I'),
	(53, 'Perro3', 'Sin Definir', 'I'),
	(54, 'Paris', 'Stafford', 'H'),
	(55, 'Paris', 'Stafford', 'H'),
	(56, 'Sin Definir', 'Sin Definir', 'I'),
	(57, 'Sin Definir', 'Sin Definir', 'I'),
	(58, 'Perro1', 'Sin Definir', 'I'),
	(59, 'Perro1', 'Sin Definir', 'I'),
	(60, 'Perro2', 'Sin Definir', 'I'),
	(61, 'Perro2', 'Sin Definir', 'I'),
	(62, 'Perro3', 'Sin Definir', 'I'),
	(63, 'Perro3', 'Sin Definir', 'I'),
	(64, 'Sin Definir', 'Sin Definir', 'I'),
	(65, 'Sin Definir', 'Sin Definir', 'I'),
	(66, 'Perro1', 'Sin Definir', 'I'),
	(67, 'Perro1', 'Sin Definir', 'I'),
	(68, 'Perro2', 'Sin Definir', 'I'),
	(69, 'Perro2', 'Sin Definir', 'I'),
	(70, 'Perro3', 'Sin Definir', 'I'),
	(71, 'Perro3', 'Sin Definir', 'I'),
	(72, 'Sin Definir', 'Sin Definir', 'I'),
	(73, 'Sin Definir', 'Sin Definir', 'I'),
	(74, 'Perro1', 'Sin Definir', 'I'),
	(75, 'Perro1', 'Sin Definir', 'I'),
	(76, 'Perro2', 'Sin Definir', 'I'),
	(77, 'Perro2', 'Sin Definir', 'I'),
	(78, 'Perro3', 'Sin Definir', 'I'),
	(79, 'Perro3', 'Sin Definir', 'I'),
	(80, 'Sin Definir', 'Sin Definir', 'I'),
	(81, 'Sin Definir', 'Sin Definir', 'I'),
	(82, 'Sin Definir', 'Sin Definir', 'I'),
	(83, 'Sin Definir', 'Sin Definir', 'I'),
	(84, 'Perro1', 'Sin Definir', 'I'),
	(85, 'Perro1', 'Sin Definir', 'I'),
	(86, 'Sin Definir', 'Sin Definir', 'I'),
	(87, 'Prueba Perro', 'Raza Prueba', 'I'),
	(88, 'Sin Definir', 'Sin Definir', 'I'),
	(89, 'Sin Definir', 'Sin Definir', 'I'),
	(90, 'Sin Definir', 'Sin Definir', 'I'),
	(91, 'Sin Definir', 'Sin Definir', 'I'),
	(92, 'Sin Definir', 'Sin Definir', 'I'),
	(93, 'Sin Definir', 'Sin Definir', 'I'),
	(94, 'Perro1', 'Sin Definir', 'I'),
	(95, 'Perro1', 'Sin Definir', 'I'),
	(96, 'Sin Definir', 'Sin Definir', 'I'),
	(97, 'Sin Definir', 'Sin Definir', 'I'),
	(98, 'Sin Definir', 'Sin Definir', 'I'),
	(99, 'Sin Definir', 'Sin Definir', 'I'),
	(100, 'Sin Definir', 'Sin Definir', 'I'),
	(101, 'Sin Definir', 'Sin Definir', 'I'),
	(102, 'Sin Definir', 'Sin Definir', 'I'),
	(103, 'Sin Definir', 'Sin Definir', 'I'),
	(104, 'Perro1', 'Sin Definir', 'I'),
	(105, 'Sin Definir', 'Sin Definir', 'I'),
	(106, 'Perro1', 'Sin Definir', 'I'),
	(107, 'Perro2', 'Sin Definir', 'I'),
	(108, 'Perro3', 'Sin Definir', 'I'),
	(109, 'Sin Definir', 'Sin Definir', 'I'),
	(110, 'Perro1', 'Sin Definir', 'I'),
	(111, 'Perro2', 'Sin Definir', 'I'),
	(112, 'Perro3', 'Sin Definir', 'I'),
	(113, 'Paris', 'Stafford', 'H');
/*!40000 ALTER TABLE `perro` ENABLE KEYS */;


-- Volcando estructura para procedimiento santisvs.updateReg
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateReg`(IN `inId` INT, IN `inNombre` VARCHAR(200), IN `inRaza` VARCHAR(200), IN `inSexo` CHAR(50))
    COMMENT 'Actualiza el registro id con los datos indicados'
BEGIN

UPDATE perro
SET nombre=inNombre, raza=inRaza, sexo=inSexo
WHERE id=inId; 

END//
DELIMITER ;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
