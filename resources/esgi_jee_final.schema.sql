-- phpMyAdmin SQL Dump
-- version 4.6.6deb4
-- https://www.phpmyadmin.net/
--
-- Client :  localhost:3306
-- Généré le :  Sam 05 Mai 2018 à 12:02
-- Version du serveur :  10.2.14-MariaDB-10.2.14+maria~stretch-log
-- Version de PHP :  7.1.16-1+0~20180405085419.16+stretch~1.gbp4937aa

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `esgi_jee_final`
--

-- --------------------------------------------------------

--
-- Structure de la table `complex_url`
--

CREATE TABLE `complex_url` (
  `id` int(11) NOT NULL,
  `simple_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `password`
--

CREATE TABLE `password` (
  `url` int(11) NOT NULL,
  `password` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `simple_url`
--

CREATE TABLE `simple_url` (
  `id` int(11) NOT NULL,
  `base_url` text NOT NULL,
  `new_url` varchar(256) NOT NULL,
  `created_at` datetime NOT NULL,
  `deleted_at` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `url_pass_option`
--

CREATE TABLE `url_pass_option` (
  `url_complex_id` int(11) NOT NULL,
  `libelle` varchar(256) NOT NULL,
  `end_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `url_stat`
--

CREATE TABLE `url_stat` (
  `url_id` int(11) NOT NULL,
  `date` datetime NOT NULL,
  `ip` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `password` varchar(256) NOT NULL,
  `email` varchar(256) NOT NULL,
  `pro_status` varchar(256) NOT NULL,
  `enabled` tinyint(4) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Index pour les tables exportées
--

--
-- Index pour la table `complex_url`
--
ALTER TABLE `complex_url`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `complex_url_ibfk_1` (`simple_id`);

--
-- Index pour la table `password`
--
ALTER TABLE `password`
  ADD KEY `url` (`url`);

--
-- Index pour la table `simple_url`
--
ALTER TABLE `simple_url`
  ADD KEY `id` (`id`);

--
-- Index pour la table `url_pass_option`
--
ALTER TABLE `url_pass_option`
  ADD KEY `url_pass_option_ibfk_1` (`url_complex_id`);

--
-- Index pour la table `url_stat`
--
ALTER TABLE `url_stat`
  ADD KEY `url` (`url_id`);

--
-- Index pour la table `users`
--
ALTER TABLE `users`
  ADD KEY `id` (`id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `complex_url`
--
ALTER TABLE `complex_url`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `simple_url`
--
ALTER TABLE `simple_url`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT pour la table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `complex_url`
--
ALTER TABLE `complex_url`
  ADD CONSTRAINT `complex_url_ibfk_1` FOREIGN KEY (`simple_id`) REFERENCES `simple_url` (`id`),
  ADD CONSTRAINT `complex_url_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Contraintes pour la table `password`
--
ALTER TABLE `password`
  ADD CONSTRAINT `password_ibfk_1` FOREIGN KEY (`url`) REFERENCES `simple_url` (`id`);

--
-- Contraintes pour la table `url_pass_option`
--
ALTER TABLE `url_pass_option`
  ADD CONSTRAINT `url_pass_option_ibfk_1` FOREIGN KEY (`url_complex_id`) REFERENCES `simple_url` (`id`);

--
-- Contraintes pour la table `url_stat`
--
ALTER TABLE `url_stat`
  ADD CONSTRAINT `url_stat_ibfk_1` FOREIGN KEY (`url_id`) REFERENCES `simple_url` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
