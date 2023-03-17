-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-03-2023 a las 12:17:45
-- Versión del servidor: 10.4.27-MariaDB
-- Versión de PHP: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `peregrinosfxsergio`
--
CREATE DATABASE IF NOT EXISTS `peregrinosfxsergio` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `peregrinosfxsergio`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `carnets`
--

DROP TABLE IF EXISTS `carnets`;
CREATE TABLE `carnets` (
  `id_carnet` bigint(20) NOT NULL,
  `distancia` double NOT NULL,
  `fecha_exp` date DEFAULT NULL,
  `num_vips` int(11) NOT NULL,
  `parada_inicial_id_parada` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `carnets`
--

INSERT INTO `carnets` (`id_carnet`, `distancia`, `fecha_exp`, `num_vips`, `parada_inicial_id_parada`) VALUES(1, 300, '2022-12-17', 1, 2);
INSERT INTO `carnets` (`id_carnet`, `distancia`, `fecha_exp`, `num_vips`, `parada_inicial_id_parada`) VALUES(2, 400, '2022-12-17', 2, 3);
INSERT INTO `carnets` (`id_carnet`, `distancia`, `fecha_exp`, `num_vips`, `parada_inicial_id_parada`) VALUES(3, 0, '2023-03-11', 0, 3);
INSERT INTO `carnets` (`id_carnet`, `distancia`, `fecha_exp`, `num_vips`, `parada_inicial_id_parada`) VALUES(4, 0, '2023-03-16', 0, 1);
INSERT INTO `carnets` (`id_carnet`, `distancia`, `fecha_exp`, `num_vips`, `parada_inicial_id_parada`) VALUES(5, 0, '2023-03-16', 0, 1);
INSERT INTO `carnets` (`id_carnet`, `distancia`, `fecha_exp`, `num_vips`, `parada_inicial_id_parada`) VALUES(6, 0, '2023-03-16', 0, 2);
INSERT INTO `carnets` (`id_carnet`, `distancia`, `fecha_exp`, `num_vips`, `parada_inicial_id_parada`) VALUES(7, 0, '2023-03-16', 0, 3);
INSERT INTO `carnets` (`id_carnet`, `distancia`, `fecha_exp`, `num_vips`, `parada_inicial_id_parada`) VALUES(8, 0, '2023-03-16', 0, 1);
INSERT INTO `carnets` (`id_carnet`, `distancia`, `fecha_exp`, `num_vips`, `parada_inicial_id_parada`) VALUES(9, 0, '2023-03-16', 0, 2);
INSERT INTO `carnets` (`id_carnet`, `distancia`, `fecha_exp`, `num_vips`, `parada_inicial_id_parada`) VALUES(10, 0, '2023-03-16', 0, 4);
INSERT INTO `carnets` (`id_carnet`, `distancia`, `fecha_exp`, `num_vips`, `parada_inicial_id_parada`) VALUES(11, 0, '2023-03-16', 0, 1);
INSERT INTO `carnets` (`id_carnet`, `distancia`, `fecha_exp`, `num_vips`, `parada_inicial_id_parada`) VALUES(12, 0, '2023-03-17', 0, 1);
INSERT INTO `carnets` (`id_carnet`, `distancia`, `fecha_exp`, `num_vips`, `parada_inicial_id_parada`) VALUES(13, 0, '2023-03-17', 0, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `direccion`
--

DROP TABLE IF EXISTS `direccion`;
CREATE TABLE `direccion` (
  `id_direccion` bigint(20) NOT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `localidad` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `direccion_seq`
--

DROP TABLE IF EXISTS `direccion_seq`;
CREATE TABLE `direccion_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `direccion_seq`
--

INSERT INTO `direccion_seq` (`next_val`) VALUES(1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `envioacasa`
--

DROP TABLE IF EXISTS `envioacasa`;
CREATE TABLE `envioacasa` (
  `id` bigint(20) NOT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `localidad` varchar(255) DEFAULT NULL,
  `peso` double NOT NULL,
  `urgente` bit(1) NOT NULL,
  `volumen` varbinary(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `envioacasa_seq`
--

DROP TABLE IF EXISTS `envioacasa_seq`;
CREATE TABLE `envioacasa_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `envioacasa_seq`
--

INSERT INTO `envioacasa_seq` (`next_val`) VALUES(1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estancias`
--

DROP TABLE IF EXISTS `estancias`;
CREATE TABLE `estancias` (
  `id_estancia` bigint(20) NOT NULL,
  `fecha` date DEFAULT NULL,
  `vip` bit(1) NOT NULL,
  `parada_id_parada` bigint(20) DEFAULT NULL,
  `peregrino_id_peregrino` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `estancias`
--

INSERT INTO `estancias` (`id_estancia`, `fecha`, `vip`, `parada_id_parada`, `peregrino_id_peregrino`) VALUES(1, '2022-12-15', b'0', 1, 1);
INSERT INTO `estancias` (`id_estancia`, `fecha`, `vip`, `parada_id_parada`, `peregrino_id_peregrino`) VALUES(2, '2022-12-08', b'0', 2, 2);
INSERT INTO `estancias` (`id_estancia`, `fecha`, `vip`, `parada_id_parada`, `peregrino_id_peregrino`) VALUES(3, '2022-12-17', b'1', 3, 2);
INSERT INTO `estancias` (`id_estancia`, `fecha`, `vip`, `parada_id_parada`, `peregrino_id_peregrino`) VALUES(4, '2022-12-17', b'1', 5, 2);
INSERT INTO `estancias` (`id_estancia`, `fecha`, `vip`, `parada_id_parada`, `peregrino_id_peregrino`) VALUES(5, '2022-12-17', b'1', 4, 2);
INSERT INTO `estancias` (`id_estancia`, `fecha`, `vip`, `parada_id_parada`, `peregrino_id_peregrino`) VALUES(6, '2022-12-17', b'1', 2, 2);
INSERT INTO `estancias` (`id_estancia`, `fecha`, `vip`, `parada_id_parada`, `peregrino_id_peregrino`) VALUES(7, '2022-12-17', b'1', 1, 2);
INSERT INTO `estancias` (`id_estancia`, `fecha`, `vip`, `parada_id_parada`, `peregrino_id_peregrino`) VALUES(8, '2023-03-10', b'0', 1, 2);
INSERT INTO `estancias` (`id_estancia`, `fecha`, `vip`, `parada_id_parada`, `peregrino_id_peregrino`) VALUES(9, '2023-03-10', b'0', 2, 2);
INSERT INTO `estancias` (`id_estancia`, `fecha`, `vip`, `parada_id_parada`, `peregrino_id_peregrino`) VALUES(10, '2023-03-10', b'0', 2, 1);
INSERT INTO `estancias` (`id_estancia`, `fecha`, `vip`, `parada_id_parada`, `peregrino_id_peregrino`) VALUES(11, '2023-03-10', b'0', 2, 1);
INSERT INTO `estancias` (`id_estancia`, `fecha`, `vip`, `parada_id_parada`, `peregrino_id_peregrino`) VALUES(12, '2023-03-10', b'1', 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paradas`
--

DROP TABLE IF EXISTS `paradas`;
CREATE TABLE `paradas` (
  `id_parada` bigint(20) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `region` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `paradas`
--

INSERT INTO `paradas` (`id_parada`, `nombre`, `region`) VALUES(1, 'Irun', 'P');
INSERT INTO `paradas` (`id_parada`, `nombre`, `region`) VALUES(2, 'Santander', 'C');
INSERT INTO `paradas` (`id_parada`, `nombre`, `region`) VALUES(3, 'Gijon', 'A');
INSERT INTO `paradas` (`id_parada`, `nombre`, `region`) VALUES(4, 'Aviles', 'A');
INSERT INTO `paradas` (`id_parada`, `nombre`, `region`) VALUES(5, 'Vegadeo', 'G');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `peregrinos`
--

DROP TABLE IF EXISTS `peregrinos`;
CREATE TABLE `peregrinos` (
  `id_peregrino` bigint(20) NOT NULL,
  `nacionalidad` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `carnet_id_carnet` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `peregrinos`
--

INSERT INTO `peregrinos` (`id_peregrino`, `nacionalidad`, `nombre`, `carnet_id_carnet`) VALUES(1, 'España', 'prueba', 1);
INSERT INTO `peregrinos` (`id_peregrino`, `nacionalidad`, `nombre`, `carnet_id_carnet`) VALUES(2, 'Alemania', 'Lucas', 2);
INSERT INTO `peregrinos` (`id_peregrino`, `nacionalidad`, `nombre`, `carnet_id_carnet`) VALUES(3, 'España', 'Sergio', 3);
INSERT INTO `peregrinos` (`id_peregrino`, `nacionalidad`, `nombre`, `carnet_id_carnet`) VALUES(4, 'Alemania', 'pruebaexit', 4);
INSERT INTO `peregrinos` (`id_peregrino`, `nacionalidad`, `nombre`, `carnet_id_carnet`) VALUES(5, 'Alemania', 'pruebaexit', 5);
INSERT INTO `peregrinos` (`id_peregrino`, `nacionalidad`, `nombre`, `carnet_id_carnet`) VALUES(6, 'Alemania', 'prueba2', 6);
INSERT INTO `peregrinos` (`id_peregrino`, `nacionalidad`, `nombre`, `carnet_id_carnet`) VALUES(7, 'España', 'prueba3', 7);
INSERT INTO `peregrinos` (`id_peregrino`, `nacionalidad`, `nombre`, `carnet_id_carnet`) VALUES(8, 'España', 'prueba4', 8);
INSERT INTO `peregrinos` (`id_peregrino`, `nacionalidad`, `nombre`, `carnet_id_carnet`) VALUES(9, 'Alemania', 'prueba5', 9);
INSERT INTO `peregrinos` (`id_peregrino`, `nacionalidad`, `nombre`, `carnet_id_carnet`) VALUES(10, 'Alemania', 'prueba5', 10);
INSERT INTO `peregrinos` (`id_peregrino`, `nacionalidad`, `nombre`, `carnet_id_carnet`) VALUES(11, 'Alemania', 'prueba7', 11);
INSERT INTO `peregrinos` (`id_peregrino`, `nacionalidad`, `nombre`, `carnet_id_carnet`) VALUES(12, 'España', 'Alba', 12);
INSERT INTO `peregrinos` (`id_peregrino`, `nacionalidad`, `nombre`, `carnet_id_carnet`) VALUES(13, 'España', 'sonia', 13);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `peregrinos_paradas`
--

DROP TABLE IF EXISTS `peregrinos_paradas`;
CREATE TABLE `peregrinos_paradas` (
  `peregrinos_id_peregrino` bigint(20) NOT NULL,
  `paradas_id_parada` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `peregrinos_paradas`
--

INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(3, 3);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(3, 3);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(3, 2);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(3, 1);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(2, 1);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(2, 1);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(2, 1);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(2, 1);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(2, 1);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(2, 1);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(2, 1);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(2, 2);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(2, 2);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(2, 2);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(2, 2);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(2, 2);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(2, 2);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(2, 2);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(2, 2);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(2, 2);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(2, 2);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(2, 2);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(2, 2);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(2, 3);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(2, 3);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(2, 3);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(2, 4);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(2, 4);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(2, 5);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(2, 5);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(2, 2);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(5, 1);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(6, 2);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(7, 3);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(9, 2);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(10, 4);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(11, 1);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(8, 1);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(8, 2);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(4, 1);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(4, 2);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(1, 1);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(1, 1);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(1, 1);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(1, 1);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(1, 1);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(1, 1);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(1, 1);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(1, 1);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(1, 1);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(1, 1);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(1, 1);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(1, 1);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(1, 1);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(1, 1);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(1, 1);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(1, 2);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(1, 2);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(1, 2);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(1, 2);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(1, 2);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(1, 2);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(1, 2);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(1, 2);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(1, 2);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(1, 2);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(1, 2);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(1, 2);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(1, 2);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(1, 2);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(1, 2);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(1, 2);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(1, 2);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(1, 2);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(1, 2);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(1, 2);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(1, 2);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(1, 2);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(1, 2);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(1, 2);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(1, 3);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(1, 3);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(1, 3);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(1, 3);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(1, 4);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(1, 4);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(1, 4);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(1, 5);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(1, 3);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(12, 1);
INSERT INTO `peregrinos_paradas` (`peregrinos_id_peregrino`, `paradas_id_parada`) VALUES(13, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `perfil`
--

DROP TABLE IF EXISTS `perfil`;
CREATE TABLE `perfil` (
  `id_perfil` bigint(20) NOT NULL,
  `rol` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `perfil`
--

INSERT INTO `perfil` (`id_perfil`, `rol`) VALUES(1, 'PEREGRINO');
INSERT INTO `perfil` (`id_perfil`, `rol`) VALUES(2, 'PARADA');
INSERT INTO `perfil` (`id_perfil`, `rol`) VALUES(3, 'GENERAL');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE `usuarios` (
  `id_usuario` bigint(20) NOT NULL,
  `contrasenia` varchar(255) DEFAULT NULL,
  `usuario` varchar(255) DEFAULT NULL,
  `parada_id_parada` bigint(20) DEFAULT NULL,
  `peregrino_id_peregrino` bigint(20) DEFAULT NULL,
  `perfil_id_perfil` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id_usuario`, `contrasenia`, `usuario`, `parada_id_parada`, `peregrino_id_peregrino`, `perfil_id_perfil`) VALUES(1, 'prueba', 'prueba', NULL, 1, 1);
INSERT INTO `usuarios` (`id_usuario`, `contrasenia`, `usuario`, `parada_id_parada`, `peregrino_id_peregrino`, `perfil_id_perfil`) VALUES(2, 'admin', 'admin', NULL, NULL, 3);
INSERT INTO `usuarios` (`id_usuario`, `contrasenia`, `usuario`, `parada_id_parada`, `peregrino_id_peregrino`, `perfil_id_perfil`) VALUES(3, 'lucas123', 'lucas', NULL, 2, 1);
INSERT INTO `usuarios` (`id_usuario`, `contrasenia`, `usuario`, `parada_id_parada`, `peregrino_id_peregrino`, `perfil_id_perfil`) VALUES(4, 'irun', 'irun', 1, NULL, 2);
INSERT INTO `usuarios` (`id_usuario`, `contrasenia`, `usuario`, `parada_id_parada`, `peregrino_id_peregrino`, `perfil_id_perfil`) VALUES(5, 'sergio123', 'sergio', NULL, 3, 1);
INSERT INTO `usuarios` (`id_usuario`, `contrasenia`, `usuario`, `parada_id_parada`, `peregrino_id_peregrino`, `perfil_id_perfil`) VALUES(6, 'prueba', 'exitdb', NULL, 4, 1);
INSERT INTO `usuarios` (`id_usuario`, `contrasenia`, `usuario`, `parada_id_parada`, `peregrino_id_peregrino`, `perfil_id_perfil`) VALUES(7, 'prueba', 'exitdb1', NULL, 5, 1);
INSERT INTO `usuarios` (`id_usuario`, `contrasenia`, `usuario`, `parada_id_parada`, `peregrino_id_peregrino`, `perfil_id_perfil`) VALUES(8, 'prueba', 'prueba2', NULL, 6, 1);
INSERT INTO `usuarios` (`id_usuario`, `contrasenia`, `usuario`, `parada_id_parada`, `peregrino_id_peregrino`, `perfil_id_perfil`) VALUES(9, 'prueba', 'prueba3', NULL, 7, 1);
INSERT INTO `usuarios` (`id_usuario`, `contrasenia`, `usuario`, `parada_id_parada`, `peregrino_id_peregrino`, `perfil_id_perfil`) VALUES(10, 'prueba4', 'prueba4', NULL, 8, 1);
INSERT INTO `usuarios` (`id_usuario`, `contrasenia`, `usuario`, `parada_id_parada`, `peregrino_id_peregrino`, `perfil_id_perfil`) VALUES(11, 'prueba5', 'prueba5', NULL, 9, 1);
INSERT INTO `usuarios` (`id_usuario`, `contrasenia`, `usuario`, `parada_id_parada`, `peregrino_id_peregrino`, `perfil_id_perfil`) VALUES(12, 'prueba5', 'prueba6', NULL, 10, 1);
INSERT INTO `usuarios` (`id_usuario`, `contrasenia`, `usuario`, `parada_id_parada`, `peregrino_id_peregrino`, `perfil_id_perfil`) VALUES(13, 'prueba7', 'prueba7', NULL, 11, 1);
INSERT INTO `usuarios` (`id_usuario`, `contrasenia`, `usuario`, `parada_id_parada`, `peregrino_id_peregrino`, `perfil_id_perfil`) VALUES(14, 'alba', 'alba', NULL, 12, 1);
INSERT INTO `usuarios` (`id_usuario`, `contrasenia`, `usuario`, `parada_id_parada`, `peregrino_id_peregrino`, `perfil_id_perfil`) VALUES(15, 'sonia', 'sonia', NULL, 13, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `carnets`
--
ALTER TABLE `carnets`
  ADD PRIMARY KEY (`id_carnet`),
  ADD KEY `FK2kp9psc03gr32ww5mtntrk30k` (`parada_inicial_id_parada`);

--
-- Indices de la tabla `direccion`
--
ALTER TABLE `direccion`
  ADD PRIMARY KEY (`id_direccion`);

--
-- Indices de la tabla `envioacasa`
--
ALTER TABLE `envioacasa`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `estancias`
--
ALTER TABLE `estancias`
  ADD PRIMARY KEY (`id_estancia`),
  ADD KEY `FKgfofgvwjr86drtnrpaacbl069` (`parada_id_parada`),
  ADD KEY `FKjwdigh3rbyo3fww6s3h46nrls` (`peregrino_id_peregrino`);

--
-- Indices de la tabla `paradas`
--
ALTER TABLE `paradas`
  ADD PRIMARY KEY (`id_parada`);

--
-- Indices de la tabla `peregrinos`
--
ALTER TABLE `peregrinos`
  ADD PRIMARY KEY (`id_peregrino`),
  ADD KEY `FKbb3b3aoif73at4ssmwpv64d0q` (`carnet_id_carnet`);

--
-- Indices de la tabla `peregrinos_paradas`
--
ALTER TABLE `peregrinos_paradas`
  ADD KEY `FKhtk8flnsrst9f8j5c23m5cxw2` (`paradas_id_parada`),
  ADD KEY `FKcjcytad7fekc0x05ik7hamfc4` (`peregrinos_id_peregrino`);

--
-- Indices de la tabla `perfil`
--
ALTER TABLE `perfil`
  ADD PRIMARY KEY (`id_perfil`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id_usuario`),
  ADD KEY `FKogb847vky0g0e37r851od041` (`parada_id_parada`),
  ADD KEY `FKay68dumt8r9jgn07i49bqjcgh` (`peregrino_id_peregrino`),
  ADD KEY `FK7ar4hsd7t69323864kl0fms9l` (`perfil_id_perfil`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `carnets`
--
ALTER TABLE `carnets`
  MODIFY `id_carnet` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `estancias`
--
ALTER TABLE `estancias`
  MODIFY `id_estancia` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `paradas`
--
ALTER TABLE `paradas`
  MODIFY `id_parada` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `peregrinos`
--
ALTER TABLE `peregrinos`
  MODIFY `id_peregrino` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `perfil`
--
ALTER TABLE `perfil`
  MODIFY `id_perfil` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id_usuario` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `carnets`
--
ALTER TABLE `carnets`
  ADD CONSTRAINT `FK2kp9psc03gr32ww5mtntrk30k` FOREIGN KEY (`parada_inicial_id_parada`) REFERENCES `paradas` (`id_parada`);

--
-- Filtros para la tabla `estancias`
--
ALTER TABLE `estancias`
  ADD CONSTRAINT `FKgfofgvwjr86drtnrpaacbl069` FOREIGN KEY (`parada_id_parada`) REFERENCES `paradas` (`id_parada`),
  ADD CONSTRAINT `FKjwdigh3rbyo3fww6s3h46nrls` FOREIGN KEY (`peregrino_id_peregrino`) REFERENCES `peregrinos` (`id_peregrino`);

--
-- Filtros para la tabla `peregrinos`
--
ALTER TABLE `peregrinos`
  ADD CONSTRAINT `FKbb3b3aoif73at4ssmwpv64d0q` FOREIGN KEY (`carnet_id_carnet`) REFERENCES `carnets` (`id_carnet`);

--
-- Filtros para la tabla `peregrinos_paradas`
--
ALTER TABLE `peregrinos_paradas`
  ADD CONSTRAINT `FKcjcytad7fekc0x05ik7hamfc4` FOREIGN KEY (`peregrinos_id_peregrino`) REFERENCES `peregrinos` (`id_peregrino`),
  ADD CONSTRAINT `FKhtk8flnsrst9f8j5c23m5cxw2` FOREIGN KEY (`paradas_id_parada`) REFERENCES `paradas` (`id_parada`);

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `FK7ar4hsd7t69323864kl0fms9l` FOREIGN KEY (`perfil_id_perfil`) REFERENCES `perfil` (`id_perfil`),
  ADD CONSTRAINT `FKay68dumt8r9jgn07i49bqjcgh` FOREIGN KEY (`peregrino_id_peregrino`) REFERENCES `peregrinos` (`id_peregrino`),
  ADD CONSTRAINT `FKogb847vky0g0e37r851od041` FOREIGN KEY (`parada_id_parada`) REFERENCES `paradas` (`id_parada`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
