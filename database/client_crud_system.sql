-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Tempo de geração: 20/06/2021 às 04:23
-- Versão do servidor: 10.4.19-MariaDB
-- Versão do PHP: 7.4.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `client_crud_system`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `clients`
--

CREATE TABLE `clients` (
  `id` bigint(20) NOT NULL,
  `cpf` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `email2` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `phone2` varchar(255) DEFAULT NULL,
  `phone_type` varchar(255) DEFAULT NULL,
  `adress` varchar(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  `complement` varchar(255) DEFAULT NULL,
  `district` varchar(255) NOT NULL,
  `state` varchar(255) NOT NULL,
  `zipcode` varchar(255) NOT NULL,
  `phone_type2` varchar(255) NOT NULL,
  `number` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Despejando dados para a tabela `clients`
--

INSERT INTO `clients` (`id`, `cpf`, `email`, `email2`, `name`, `phone`, `phone2`, `phone_type`, `adress`, `city`, `complement`, `district`, `state`, `zipcode`, `phone_type2`, `number`) VALUES
(37, '98743364792', 'amanda@gamil.com', '', 'Amanda Luiza ', '98984435296', '', 'cellphone', 'Residencial Solar dos Encantos', 'São Luís', '', 'Forquilha', 'MA', '65052735', 'phone', 5),
(38, '74326589922', 'rebeca@gmail.com', 'emanu@gmail.com', 'Rebeca Emanuelli', '98988448133', '98981258744', 'cellphone', 'Residencial Solar dos Encantos', 'São Luís', '', 'Forquilha', 'MA', '65052735', 'phone', 52),
(39, '65379983465', 'ester@gmail.com', '', 'Esther Valina', '98982450898', '', 'cellphone', 'Residencial Solar dos Encantos', 'São Luís', '', 'Forquilha', 'MA', '65052735', '', 8),
(40, '98465783929', 'renan@gmail.com', 'gabii08@gmail.com', 'Renan Gabriel ', '98097735743', '98775462800', 'cellphone', 'Residencial Solar dos Encantos', 'São Luís', '', 'Forquilha', 'MA', '65052735', 'cellphone', 98),
(41, '98645609866', 'georgia@gmail.com', '', 'Georgia Rodriges ', '98987536876', '', 'cellphone', 'Residencial Solar dos Encantos', 'São Luís', '', 'Forquilha', 'MA', '65052735', '', 9),
(42, '87463028374', 'luan@gmail.com', '', 'Rafaell Luan ', '98846580993', '', 'cellphone', 'Residencial Solar dos Encantos', 'São Luís', '', 'Forquilha', 'MA', '65052735', '', 8),
(43, '87543423538', 'safira@gmail.com', '', 'Safira Amélia ', '98987748833', '', 'cellphone', 'Residencial Solar dos Encantos', 'São Luís', '', 'Forquilha', 'MA', '65052735', '', 12),
(44, '87463547829', 'luis@gmail.com', '', 'Rafael Luís', '98764554533', '', 'cellphone', 'Residencial Solar dos Encantos', 'São Luís', '', 'Forquilha', 'MA', '65052735', '', 12),
(45, '26489372627', 'dani@gmail.com', '', 'Daniella Paiva', '98775566473', '', 'cellphone', 'Residencial Solar dos Encantos', 'São Luís', '', 'Forquilha', 'MA', '65052735', '', 12),
(46, '68753920283', 'lenii@gmail.com', '', 'Leni Amaral', '98857453728', '', 'cellphone', 'Residencial Solar dos Encantos', 'São Luís', '', 'Forquilha', 'MA', '65052735', '', 12);

-- --------------------------------------------------------

--
-- Estrutura para tabela `roles`
--

CREATE TABLE `roles` (
  `id` bigint(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Despejando dados para a tabela `roles`
--

INSERT INTO `roles` (`id`, `name`) VALUES
(1, 'ROLE_USER'),
(2, 'ROLE_ADMIN');

-- --------------------------------------------------------

--
-- Estrutura para tabela `users`
--

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Despejando dados para a tabela `users`
--

INSERT INTO `users` (`id`, `email`, `password`, `username`) VALUES
(1, 'admin@email.com', '$2a$10$Pnaj/DtK8GxjlislqKINmOPzQ3zESykmgJHOKL/uxXQP4610MaLt.', 'admin'),
(2, 'user@email.com', '$2a$10$BpsGi2N7/b.YM2t2FiqOfeXZMmbot7ux9.geDPD.zqXawjvuUTY/q', 'user'),
(3, 'bicicleta123', '$2a$10$PKRFbOB8kHEJOsoWDzk5mOq.SY056WgySxEV//Y1131PEoMyJVXUK', 'vitorpaixaoa');

-- --------------------------------------------------------

--
-- Estrutura para tabela `user_roles`
--

CREATE TABLE `user_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Despejando dados para a tabela `user_roles`
--

INSERT INTO `user_roles` (`user_id`, `role_id`) VALUES
(1, 1),
(1, 2),
(2, 1),
(3, 1);

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `clients`
--
ALTER TABLE `clients`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKr43af9ap4edm43mmtq01oddj6` (`username`),
  ADD UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`email`);

--
-- Índices de tabela `user_roles`
--
ALTER TABLE `user_roles`
  ADD PRIMARY KEY (`user_id`,`role_id`),
  ADD KEY `FKh8ciramu9cc9q3qcqiv4ue8a6` (`role_id`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `clients`
--
ALTER TABLE `clients`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;

--
-- AUTO_INCREMENT de tabela `roles`
--
ALTER TABLE `roles`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `user_roles`
--
ALTER TABLE `user_roles`
  ADD CONSTRAINT `FKh8ciramu9cc9q3qcqiv4ue8a6` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
  ADD CONSTRAINT `FKhfh9dx7w3ubf1co1vdev94g3f` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
