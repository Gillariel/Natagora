-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  localhost
-- Généré le :  Jeu 28 Septembre 2017 à 00:24
-- Version du serveur :  5.7.19
-- Version de PHP :  5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `in15b1169`
--

-- --------------------------------------------------------

--
-- Structure de la table `Birds`
--

CREATE TABLE `Birds` (
  `ID` int(11) NOT NULL,
  `Name` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Birds`
--

INSERT INTO `Birds` (`ID`, `Name`) VALUES
(1, 'Pigeon'),
(2, 'Merle Noir'),
(3, 'Mésange charbonnière'),
(4, 'Rougegorge familier'),
(5, 'Corneille noire');

-- --------------------------------------------------------

--
-- Structure de la table `Comments`
--

CREATE TABLE `Comments` (
  `ID` int(11) NOT NULL,
  `Message` varchar(256) NOT NULL,
  `Date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Likes` int(11) NOT NULL,
  `Dislikes` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `Comments_Forums`
--

CREATE TABLE `Comments_Forums` (
  `Comments_ID` int(11) NOT NULL,
  `Forums_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `Forums`
--

CREATE TABLE `Forums` (
  `ID` int(11) NOT NULL,
  `Likes` int(11) NOT NULL,
  `Dislike` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `Media`
--

CREATE TABLE `Media` (
  `ID` int(11) NOT NULL,
  `Name` varchar(100) NOT NULL,
  `Url` varchar(500) NOT NULL,
  `MediaType_ID` int(11) NOT NULL,
  `Observations_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `MediaType`
--

CREATE TABLE `MediaType` (
  `ID` int(11) NOT NULL,
  `Type` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `MediaType`
--

INSERT INTO `MediaType` (`ID`, `Type`) VALUES
(1, 'Photo'),
(2, 'Audio'),
(3, 'Video');

-- --------------------------------------------------------

--
-- Structure de la table `Notes`
--

CREATE TABLE `Notes` (
  `ID` int(11) NOT NULL,
  `Message` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `OAuth`
--

CREATE TABLE `OAuth` (
  `ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='To Define When Researching On OAuth';

-- --------------------------------------------------------

--
-- Structure de la table `Observations`
--

CREATE TABLE `Observations` (
  `ID` int(11) NOT NULL,
  `Date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Media_ID` int(11) NOT NULL,
  `Sessions_ID` int(11) NOT NULL,
  `Notes_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `Observations_Birds`
--

CREATE TABLE `Observations_Birds` (
  `Observations_ID` int(11) NOT NULL,
  `Birds_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `Roles`
--

CREATE TABLE `Roles` (
  `ID` int(11) NOT NULL,
  `Name` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Roles`
--

INSERT INTO `Roles` (`ID`, `Name`) VALUES
(1, 'User'),
(2, 'Admin');

-- --------------------------------------------------------

--
-- Structure de la table `Sessions`
--

CREATE TABLE `Sessions` (
  `ID` int(11) NOT NULL,
  `Validated` tinyint(1) NOT NULL DEFAULT '1',
  `Date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Latitude` float NOT NULL,
  `Longitude` float NOT NULL,
  `User_ID` int(11) NOT NULL,
  `Forum_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `Tags`
--

CREATE TABLE `Tags` (
  `ID` int(11) NOT NULL,
  `Name` varchar(24) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Tags`
--

INSERT INTO `Tags` (`ID`, `Name`) VALUES
(1, '#birds'),
(2, '#sun'),
(3, '#mood'),
(4, '#happy'),
(5, '#goodSession');

-- --------------------------------------------------------

--
-- Structure de la table `Tags_Forums`
--

CREATE TABLE `Tags_Forums` (
  `Tags_ID` int(11) NOT NULL,
  `Forums_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `Users`
--

CREATE TABLE `Users` (
  `ID` int(11) NOT NULL,
  `Pseudo` varchar(30) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Forname` varchar(50) NOT NULL,
  `Mail` varchar(60) NOT NULL,
  `Password` varchar(512) NOT NULL,
  `Roles_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Users`
--

INSERT INTO `Users` (`ID`, `Pseudo`, `Name`, `Forname`, `Mail`, `Password`, `Roles_ID`) VALUES
(1, 'SuperAdmin', 'Admin', 'Super', 'superadmin@admin.com', 'azerty', 2);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `Birds`
--
ALTER TABLE `Birds`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `Comments`
--
ALTER TABLE `Comments`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `Comments_Forums`
--
ALTER TABLE `Comments_Forums`
  ADD PRIMARY KEY (`Comments_ID`,`Forums_ID`),
  ADD KEY `FK_Forums_Comments1` (`Forums_ID`);

--
-- Index pour la table `Forums`
--
ALTER TABLE `Forums`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `Media`
--
ALTER TABLE `Media`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `MediaType_ID` (`MediaType_ID`),
  ADD UNIQUE KEY `Observations_ID` (`Observations_ID`);

--
-- Index pour la table `MediaType`
--
ALTER TABLE `MediaType`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `Notes`
--
ALTER TABLE `Notes`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `OAuth`
--
ALTER TABLE `OAuth`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `Observations`
--
ALTER TABLE `Observations`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `Media_ID` (`Media_ID`),
  ADD UNIQUE KEY `Sessions_ID` (`Sessions_ID`),
  ADD UNIQUE KEY `Notes_ID` (`Notes_ID`);

--
-- Index pour la table `Observations_Birds`
--
ALTER TABLE `Observations_Birds`
  ADD UNIQUE KEY `Birds_ID` (`Birds_ID`),
  ADD UNIQUE KEY `Observations_ID` (`Observations_ID`);

--
-- Index pour la table `Roles`
--
ALTER TABLE `Roles`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `Sessions`
--
ALTER TABLE `Sessions`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `User_ID` (`User_ID`),
  ADD UNIQUE KEY `Forum_ID` (`Forum_ID`);

--
-- Index pour la table `Tags`
--
ALTER TABLE `Tags`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `Tags_Forums`
--
ALTER TABLE `Tags_Forums`
  ADD PRIMARY KEY (`Tags_ID`,`Forums_ID`),
  ADD KEY `FK_Forums_Tags` (`Forums_ID`);

--
-- Index pour la table `Users`
--
ALTER TABLE `Users`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `Roles_ID` (`Roles_ID`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `Birds`
--
ALTER TABLE `Birds`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT pour la table `Comments`
--
ALTER TABLE `Comments`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `Forums`
--
ALTER TABLE `Forums`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `Media`
--
ALTER TABLE `Media`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `MediaType`
--
ALTER TABLE `MediaType`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `Notes`
--
ALTER TABLE `Notes`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `OAuth`
--
ALTER TABLE `OAuth`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `Observations`
--
ALTER TABLE `Observations`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `Roles`
--
ALTER TABLE `Roles`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `Sessions`
--
ALTER TABLE `Sessions`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `Tags`
--
ALTER TABLE `Tags`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT pour la table `Users`
--
ALTER TABLE `Users`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `Comments_Forums`
--
ALTER TABLE `Comments_Forums`
  ADD CONSTRAINT `FK_Comments_Forums1` FOREIGN KEY (`Comments_ID`) REFERENCES `Comments` (`ID`),
  ADD CONSTRAINT `FK_Forums_Comments1` FOREIGN KEY (`Forums_ID`) REFERENCES `Forums` (`ID`);

--
-- Contraintes pour la table `Media`
--
ALTER TABLE `Media`
  ADD CONSTRAINT `FK_Media_MediaType` FOREIGN KEY (`MediaType_ID`) REFERENCES `MediaType` (`ID`),
  ADD CONSTRAINT `FK_Media_Observations` FOREIGN KEY (`Observations_ID`) REFERENCES `Observations` (`ID`);

--
-- Contraintes pour la table `Observations`
--
ALTER TABLE `Observations`
  ADD CONSTRAINT `FK_Observations_Notes` FOREIGN KEY (`Notes_ID`) REFERENCES `Notes` (`ID`),
  ADD CONSTRAINT `FK_Observations_Sessions` FOREIGN KEY (`Sessions_ID`) REFERENCES `Sessions` (`ID`);

--
-- Contraintes pour la table `Observations_Birds`
--
ALTER TABLE `Observations_Birds`
  ADD CONSTRAINT `FK_Birds_Observations` FOREIGN KEY (`Birds_ID`) REFERENCES `Birds` (`ID`),
  ADD CONSTRAINT `FK_Observations_Birds` FOREIGN KEY (`Observations_ID`) REFERENCES `Observations` (`ID`);

--
-- Contraintes pour la table `Sessions`
--
ALTER TABLE `Sessions`
  ADD CONSTRAINT `FK_Sessions_Forums` FOREIGN KEY (`Forum_ID`) REFERENCES `Forums` (`ID`),
  ADD CONSTRAINT `FK_Sessions_Users` FOREIGN KEY (`User_ID`) REFERENCES `Users` (`ID`);

--
-- Contraintes pour la table `Tags_Forums`
--
ALTER TABLE `Tags_Forums`
  ADD CONSTRAINT `FK_Forums_Tags` FOREIGN KEY (`Forums_ID`) REFERENCES `Forums` (`ID`),
  ADD CONSTRAINT `FK_Tags_Forums` FOREIGN KEY (`Tags_ID`) REFERENCES `Tags` (`ID`);

--
-- Contraintes pour la table `Users`
--
ALTER TABLE `Users`
  ADD CONSTRAINT `FK_Roles_Users` FOREIGN KEY (`Roles_ID`) REFERENCES `Roles` (`ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
