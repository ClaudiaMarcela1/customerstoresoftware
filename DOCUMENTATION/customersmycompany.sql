-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 07-08-2021 a las 23:37:59
-- Versión del servidor: 10.4.20-MariaDB
-- Versión de PHP: 8.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: customersmycompany
--
CREATE DATABASE IF NOT EXISTS customersmycompany DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE customersmycompany;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla customers
--

DROP TABLE IF EXISTS customers;
CREATE TABLE customers (
  idCustomerPk int(11) NOT NULL,
  nameCustomer varchar(40) NOT NULL,
  emailCustomer varchar(50) NOT NULL,
  phoneCustomer bigint(11) NOT NULL,
  codeStoreFk int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla customers
--

INSERT INTO customers (idCustomerPk, nameCustomer, emailCustomer, phoneCustomer, codeStoreFk) VALUES
(123456, 'Carlos Zuleta', 'carlos.zuleta@gmail.com', 310456789, 2),
(4888555, 'Isabel Campo', 'isabel.campo@gmail.com', 3201112233, 1),
(8555222, 'Paula Serrano', 'paula.serrano@outlook.com', 3158967422, 4),
(10222222, 'Juan Perez', 'juan.perez@hotmail.com', 3104556677, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla stores
--

DROP TABLE IF EXISTS stores;
CREATE TABLE stores (
  codeStorePk int(11) NOT NULL,
  nameStore varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla stores
--

INSERT INTO stores (codeStorePk, nameStore) VALUES
(1, 'Chicago'),
(2, 'Boston'),
(3, 'Seattle'),
(4, 'Miami');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla customers
--
ALTER TABLE customers
  ADD UNIQUE KEY idCustomerPk (idCustomerPk),
  ADD UNIQUE KEY emailCustomer (emailCustomer),
  ADD UNIQUE KEY phoneCustomer (phoneCustomer),
  ADD KEY codeStoreFk (codeStoreFk);

--
-- Indices de la tabla stores
--
ALTER TABLE stores
  ADD PRIMARY KEY (codeStorePk);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla stores
--
ALTER TABLE stores
  MODIFY codeStorePk int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla customers
--
ALTER TABLE customers
  ADD CONSTRAINT customers_ibfk_1 FOREIGN KEY (codeStoreFk) REFERENCES stores (codeStorePk);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
