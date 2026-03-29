-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         12.2.2-MariaDB - MariaDB Server
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.14.0.7165
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Volcando datos para la tabla edumanager_db.cursos: ~1 rows (aproximadamente)
INSERT INTO `cursos` (`id_curso`, `canal`, `codigo`, `nombre`, `duracion_horas`, `categoria`, `activo`) VALUES
	(1, 'Java-001', 'RTD-25-01-14-0061-1', 'Desarrollo de Aplicaciones Full Stack Java Trainee', 483, 'Programación', 1);

-- Volcando datos para la tabla edumanager_db.estudiantes: ~3 rows (aproximadamente)
INSERT INTO `estudiantes` (`id`, `nombre`, `email`, `progreso`, `activo`, `curso_id`, `password`, `rol`) VALUES
	(1, 'Elena Nito del Bosque', 'elenanito@gmail.com', 45, 1, 1, '$2a$10$mMSeyx6DFRZpwpccPvLssepllmu6aczQmYInPbvWlXSiVIXM2iM2q', 'USER'),
	(2, 'Elsa Pato', 'elsapatito@gmail.com', 90, 1, 1, '$2a$10$SPezzcwbX3MUNZA43WiOWuSDLuJpM3qnvGCloU2Xe7knR50eSty1y', 'USER'),
	(47, 'Administrador', 'admin@otec.cl', NULL, 1, NULL, '$2a$10$h69ai3GPwV/7T5mGctQERe2PrDSU93Tw2juRfaaniHGcfkkPNvsti', 'USER');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
