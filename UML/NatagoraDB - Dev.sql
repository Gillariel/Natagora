-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  localhost
-- Généré le :  Mer 25 Octobre 2017 à 15:13
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
-- Structure de la table `Birds_Dev`
--

CREATE TABLE `Birds_Dev` (
  `ID` int(11) NOT NULL,
  `Name` varchar(60) NOT NULL,
  `Length` int(3) DEFAULT NULL,
  `Weight` int(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Birds_Dev`
--

INSERT INTO `Birds_Dev` (`ID`, `Name`, `Length`, `Weight`) VALUES
(1, 'Pigeon', NULL, NULL),
(2, 'Merle Noir', NULL, NULL),
(3, 'Mésange charbonnière', NULL, NULL),
(4, 'Rougegorge familier', NULL, NULL),
(5, 'Corneille noire', NULL, NULL);

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

--
-- Contenu de la table `Comments`
--

INSERT INTO `Comments` (`ID`, `Message`, `Date`, `Likes`, `Dislikes`) VALUES
(1, 'Shitty admin.', '2017-10-18 00:38:57', 355, 1);

-- --------------------------------------------------------

--
-- Structure de la table `Comments_Dev`
--

CREATE TABLE `Comments_Dev` (
  `ID` int(11) NOT NULL,
  `Message` varchar(256) NOT NULL,
  `Date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Likes` int(11) NOT NULL,
  `Dislikes` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Comments_Dev`
--

INSERT INTO `Comments_Dev` (`ID`, `Message`, `Date`, `Likes`, `Dislikes`) VALUES
(1, 'Shitty admin.', '2017-10-18 00:38:57', 355, 1);

-- --------------------------------------------------------

--
-- Structure de la table `Comments_Forums`
--

CREATE TABLE `Comments_Forums` (
  `Comments_ID` int(11) NOT NULL,
  `Forums_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Comments_Forums`
--

INSERT INTO `Comments_Forums` (`Comments_ID`, `Forums_ID`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `Comments_Forums_Dev`
--

CREATE TABLE `Comments_Forums_Dev` (
  `Comment_ID` int(11) NOT NULL,
  `Forum_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Comments_Forums_Dev`
--

INSERT INTO `Comments_Forums_Dev` (`Comment_ID`, `Forum_ID`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `Forums`
--

CREATE TABLE `Forums` (
  `ID` int(11) NOT NULL,
  `Likes` int(11) NOT NULL,
  `Dislike` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Forums`
--

INSERT INTO `Forums` (`ID`, `Likes`, `Dislike`) VALUES
(1, 2, 10);

-- --------------------------------------------------------

--
-- Structure de la table `Forums_Dev`
--

CREATE TABLE `Forums_Dev` (
  `ID` int(11) NOT NULL,
  `Likes` int(11) NOT NULL,
  `Dislike` int(11) NOT NULL,
  `Session_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Forums_Dev`
--

INSERT INTO `Forums_Dev` (`ID`, `Likes`, `Dislike`, `Session_ID`) VALUES
(1, 2, 10, 1);

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

--
-- Contenu de la table `Media`
--

INSERT INTO `Media` (`ID`, `Name`, `Url`, `MediaType_ID`, `Observations_ID`) VALUES
(3, 'pas un oiseau lol', 'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAALoAAAB0CAMAAAAFMtgHAAAANlBMVEWSwdz///+IvNnb6vKMvtqaxd7X5/Hw9vq71+jr8/iu0OTF3ev6/P2/2umjyuGozeLP4u/k7/YS7KSNAAAA20lEQVR4nO3WWw6DIBBAUcEBLFi0+99sa9v0kfjAnzI298QF3JABp2kAAAAAAAAAAAAAAACAnxKZvgOyLo1+7BpbO2S/tjeTfqwdspPkR/jkUjummLicnXuXH6ZdnA/GhGA+JWut+vsq0czoU+s7pzpebO7n0p/9atuliSmdFstvWqXvpOTV7LtO57kPy6PyElztyjk2bJcbE2tnzskl5SonRs7/nq5xYGQoKVd6TQseGJXzsrQBfFP7S4ob5655EXCdbxcpX7/ErtAcDgAAAAAAAAAAAAAAANR2BV3EBZzGo5BgAAAAAElFTkSuQmCC', 1, 3);

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
-- Structure de la table `MediaType_Dev`
--

CREATE TABLE `MediaType_Dev` (
  `ID` int(11) NOT NULL,
  `Type` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `MediaType_Dev`
--

INSERT INTO `MediaType_Dev` (`ID`, `Type`) VALUES
(1, 'Photo'),
(2, 'Audio'),
(3, 'Video'),
(4, 'Text');

-- --------------------------------------------------------

--
-- Structure de la table `Media_Dev`
--

CREATE TABLE `Media_Dev` (
  `ID` int(11) NOT NULL,
  `Name` varchar(100) NOT NULL,
  `Url` varchar(500) DEFAULT NULL,
  `Text` varchar(144) DEFAULT NULL,
  `Validated` tinyint(4) NOT NULL DEFAULT '0',
  `MediaType_ID` int(11) NOT NULL,
  `Observation_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Media_Dev`
--

INSERT INTO `Media_Dev` (`ID`, `Name`, `Url`, `Text`, `Validated`, `MediaType_ID`, `Observation_ID`) VALUES
(3, 'pas un oiseau lol', 'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAALoAAAB0CAMAAAAFMtgHAAAANlBMVEWSwdz///+IvNnb6vKMvtqaxd7X5/Hw9vq71+jr8/iu0OTF3ev6/P2/2umjyuGozeLP4u/k7/YS7KSNAAAA20lEQVR4nO3WWw6DIBBAUcEBLFi0+99sa9v0kfjAnzI298QF3JABp2kAAAAAAAAAAAAAAACAnxKZvgOyLo1+7BpbO2S/tjeTfqwdspPkR/jkUjummLicnXuXH6ZdnA/GhGA+JWut+vsq0czoU+s7pzpebO7n0p/9atuliSmdFstvWqXvpOTV7LtO57kPy6PyElztyjk2bJcbE2tnzskl5SonRs7/nq5xYGQoKVd6TQseGJXzsrQBfFP7S4ob5655EXCdbxcpX7/ErtAcDgAAAAAAAAAAAAAAANR2BV3EBZzGo5BgAAAAAElFTkSuQmCC', NULL, 0, 1, 3);

-- --------------------------------------------------------

--
-- Structure de la table `Notes`
--

CREATE TABLE `Notes` (
  `ID` int(11) NOT NULL,
  `Message` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Notes`
--

INSERT INTO `Notes` (`ID`, `Message`) VALUES
(2, 'little trip');

-- --------------------------------------------------------

--
-- Structure de la table `Notes_Dev`
--

CREATE TABLE `Notes_Dev` (
  `ID` int(11) NOT NULL,
  `Message` varchar(256) NOT NULL,
  `Obervation_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Notes_Dev`
--

INSERT INTO `Notes_Dev` (`ID`, `Message`, `Obervation_ID`) VALUES
(1, 'little trip', 1);

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
  `Sessions_ID` int(11) NOT NULL,
  `Notes_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Observations`
--

INSERT INTO `Observations` (`ID`, `Date`, `Sessions_ID`, `Notes_ID`) VALUES
(3, '2017-10-18 00:57:42', 1, 2);

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
-- Structure de la table `Observations_Birds_Dev`
--

CREATE TABLE `Observations_Birds_Dev` (
  `Observation_ID` int(11) NOT NULL,
  `Bird_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `Observations_Dev`
--

CREATE TABLE `Observations_Dev` (
  `ID` int(11) NOT NULL,
  `Date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Session_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Observations_Dev`
--

INSERT INTO `Observations_Dev` (`ID`, `Date`, `Session_ID`) VALUES
(1, '2017-10-18 00:57:42', 1);

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
-- Structure de la table `Roles_Dev`
--

CREATE TABLE `Roles_Dev` (
  `ID` int(11) NOT NULL,
  `Name` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Roles_Dev`
--

INSERT INTO `Roles_Dev` (`ID`, `Name`) VALUES
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

--
-- Contenu de la table `Sessions`
--

INSERT INTO `Sessions` (`ID`, `Validated`, `Date`, `Latitude`, `Longitude`, `User_ID`, `Forum_ID`) VALUES
(1, 1, '2017-10-18 00:37:54', 40.8883, 79.4624, 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `Sessions_Dev`
--

CREATE TABLE `Sessions_Dev` (
  `ID` int(11) NOT NULL,
  `Validated` tinyint(1) NOT NULL DEFAULT '1',
  `Date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Latitude` float NOT NULL,
  `Longitude` float NOT NULL,
  `User_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Sessions_Dev`
--

INSERT INTO `Sessions_Dev` (`ID`, `Validated`, `Date`, `Latitude`, `Longitude`, `User_ID`) VALUES
(1, 1, '2017-10-18 00:37:54', 40.8883, 79.4624, 1);

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
-- Structure de la table `Tags_Dev`
--

CREATE TABLE `Tags_Dev` (
  `ID` int(11) NOT NULL,
  `Name` varchar(24) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Tags_Dev`
--

INSERT INTO `Tags_Dev` (`ID`, `Name`) VALUES
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

--
-- Contenu de la table `Tags_Forums`
--

INSERT INTO `Tags_Forums` (`Tags_ID`, `Forums_ID`) VALUES
(1, 1),
(4, 1);

-- --------------------------------------------------------

--
-- Structure de la table `Tags_Forums_Dev`
--

CREATE TABLE `Tags_Forums_Dev` (
  `Tag_ID` int(11) NOT NULL,
  `Forum_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Tags_Forums_Dev`
--

INSERT INTO `Tags_Forums_Dev` (`Tag_ID`, `Forum_ID`) VALUES
(1, 1),
(4, 1);

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

-- --------------------------------------------------------

--
-- Structure de la table `Users_Dev`
--

CREATE TABLE `Users_Dev` (
  `ID` int(11) NOT NULL,
  `Pseudo` varchar(30) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Forname` varchar(50) NOT NULL,
  `Mail` varchar(60) NOT NULL,
  `Password` varchar(512) NOT NULL,
  `Role_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Users_Dev`
--

INSERT INTO `Users_Dev` (`ID`, `Pseudo`, `Name`, `Forname`, `Mail`, `Password`, `Role_ID`) VALUES
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
-- Index pour la table `Birds_Dev`
--
ALTER TABLE `Birds_Dev`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `Comments`
--
ALTER TABLE `Comments`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `Comments_Dev`
--
ALTER TABLE `Comments_Dev`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `Comments_Forums`
--
ALTER TABLE `Comments_Forums`
  ADD PRIMARY KEY (`Comments_ID`,`Forums_ID`),
  ADD KEY `FK_Forums_Comments1` (`Forums_ID`);

--
-- Index pour la table `Comments_Forums_Dev`
--
ALTER TABLE `Comments_Forums_Dev`
  ADD PRIMARY KEY (`Comment_ID`,`Forum_ID`),
  ADD KEY `FK_Forums_Comments1_Dev` (`Forum_ID`);

--
-- Index pour la table `Forums`
--
ALTER TABLE `Forums`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `Forums_Dev`
--
ALTER TABLE `Forums_Dev`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_Sessions_Dev` (`Session_ID`) USING BTREE;

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
-- Index pour la table `MediaType_Dev`
--
ALTER TABLE `MediaType_Dev`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `Media_Dev`
--
ALTER TABLE `Media_Dev`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `MediaType_ID_Dev` (`MediaType_ID`),
  ADD UNIQUE KEY `Observations_ID_Dev` (`Observation_ID`);

--
-- Index pour la table `Notes`
--
ALTER TABLE `Notes`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `Notes_Dev`
--
ALTER TABLE `Notes_Dev`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_Observations_Dev` (`Obervation_ID`) USING BTREE;

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
  ADD UNIQUE KEY `Sessions_ID` (`Sessions_ID`),
  ADD UNIQUE KEY `Notes_ID` (`Notes_ID`);

--
-- Index pour la table `Observations_Birds`
--
ALTER TABLE `Observations_Birds`
  ADD PRIMARY KEY (`Observations_ID`,`Birds_ID`),
  ADD UNIQUE KEY `Birds_ID` (`Birds_ID`),
  ADD UNIQUE KEY `Observations_ID` (`Observations_ID`);

--
-- Index pour la table `Observations_Birds_Dev`
--
ALTER TABLE `Observations_Birds_Dev`
  ADD PRIMARY KEY (`Observation_ID`,`Bird_ID`),
  ADD UNIQUE KEY `Birds_ID_Dev` (`Bird_ID`),
  ADD UNIQUE KEY `Observations_ID_Dev` (`Observation_ID`);

--
-- Index pour la table `Observations_Dev`
--
ALTER TABLE `Observations_Dev`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `Sessions_ID_Dev` (`Session_ID`);

--
-- Index pour la table `Roles`
--
ALTER TABLE `Roles`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `Roles_Dev`
--
ALTER TABLE `Roles_Dev`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `Sessions`
--
ALTER TABLE `Sessions`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `User_ID` (`User_ID`),
  ADD UNIQUE KEY `Forum_ID` (`Forum_ID`);

--
-- Index pour la table `Sessions_Dev`
--
ALTER TABLE `Sessions_Dev`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `User_ID_Dev` (`User_ID`);

--
-- Index pour la table `Tags`
--
ALTER TABLE `Tags`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `Tags_Dev`
--
ALTER TABLE `Tags_Dev`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `Tags_Forums`
--
ALTER TABLE `Tags_Forums`
  ADD PRIMARY KEY (`Tags_ID`,`Forums_ID`),
  ADD KEY `FK_Forums_Tags` (`Forums_ID`);

--
-- Index pour la table `Tags_Forums_Dev`
--
ALTER TABLE `Tags_Forums_Dev`
  ADD PRIMARY KEY (`Tag_ID`,`Forum_ID`),
  ADD KEY `FK_Forums_Tags_Dev` (`Forum_ID`);

--
-- Index pour la table `Users`
--
ALTER TABLE `Users`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `Roles_ID` (`Roles_ID`);

--
-- Index pour la table `Users_Dev`
--
ALTER TABLE `Users_Dev`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `Roles_ID_Dev` (`Role_ID`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `Birds`
--
ALTER TABLE `Birds`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT pour la table `Birds_Dev`
--
ALTER TABLE `Birds_Dev`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT pour la table `Comments`
--
ALTER TABLE `Comments`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `Comments_Dev`
--
ALTER TABLE `Comments_Dev`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `Forums`
--
ALTER TABLE `Forums`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `Forums_Dev`
--
ALTER TABLE `Forums_Dev`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `Media`
--
ALTER TABLE `Media`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `MediaType`
--
ALTER TABLE `MediaType`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `MediaType_Dev`
--
ALTER TABLE `MediaType_Dev`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT pour la table `Media_Dev`
--
ALTER TABLE `Media_Dev`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `Notes`
--
ALTER TABLE `Notes`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `Notes_Dev`
--
ALTER TABLE `Notes_Dev`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `OAuth`
--
ALTER TABLE `OAuth`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `Observations`
--
ALTER TABLE `Observations`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `Observations_Dev`
--
ALTER TABLE `Observations_Dev`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `Roles`
--
ALTER TABLE `Roles`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `Roles_Dev`
--
ALTER TABLE `Roles_Dev`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `Sessions`
--
ALTER TABLE `Sessions`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `Sessions_Dev`
--
ALTER TABLE `Sessions_Dev`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `Tags`
--
ALTER TABLE `Tags`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT pour la table `Tags_Dev`
--
ALTER TABLE `Tags_Dev`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT pour la table `Users`
--
ALTER TABLE `Users`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `Users_Dev`
--
ALTER TABLE `Users_Dev`
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
-- Contraintes pour la table `Comments_Forums_Dev`
--
ALTER TABLE `Comments_Forums_Dev`
  ADD CONSTRAINT `FK_Comments_Forums1_Dev` FOREIGN KEY (`Comment_ID`) REFERENCES `Comments_Dev` (`ID`),
  ADD CONSTRAINT `FK_Forums_Comments1_Dev` FOREIGN KEY (`Forum_ID`) REFERENCES `Forums_Dev` (`ID`);

--
-- Contraintes pour la table `Forums_Dev`
--
ALTER TABLE `Forums_Dev`
  ADD CONSTRAINT `FK_Forums_Sessions_Dev` FOREIGN KEY (`Session_ID`) REFERENCES `Sessions_Dev` (`ID`);

--
-- Contraintes pour la table `Media`
--
ALTER TABLE `Media`
  ADD CONSTRAINT `FK_Media_MediaType` FOREIGN KEY (`MediaType_ID`) REFERENCES `MediaType` (`ID`),
  ADD CONSTRAINT `FK_Media_Observations` FOREIGN KEY (`Observations_ID`) REFERENCES `Observations` (`ID`);

--
-- Contraintes pour la table `Media_Dev`
--
ALTER TABLE `Media_Dev`
  ADD CONSTRAINT `FK_Media_MediaType_Dev` FOREIGN KEY (`MediaType_ID`) REFERENCES `MediaType_Dev` (`ID`),
  ADD CONSTRAINT `FK_Media_Observations_Dev` FOREIGN KEY (`Observation_ID`) REFERENCES `Observations_Dev` (`ID`);

--
-- Contraintes pour la table `Notes_Dev`
--
ALTER TABLE `Notes_Dev`
  ADD CONSTRAINT `FK_Notes_Observations_Dev` FOREIGN KEY (`Obervation_ID`) REFERENCES `Observations_Dev` (`ID`);

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
-- Contraintes pour la table `Observations_Birds_Dev`
--
ALTER TABLE `Observations_Birds_Dev`
  ADD CONSTRAINT `FK_Birds_Observations_Dev` FOREIGN KEY (`Bird_ID`) REFERENCES `Birds_Dev` (`ID`),
  ADD CONSTRAINT `FK_Observations_Birds_Dev` FOREIGN KEY (`Observation_ID`) REFERENCES `Observations_Dev` (`ID`);

--
-- Contraintes pour la table `Observations_Dev`
--
ALTER TABLE `Observations_Dev`
  ADD CONSTRAINT `FK_Observations_Sessions_Dev` FOREIGN KEY (`Session_ID`) REFERENCES `Sessions_Dev` (`ID`);

--
-- Contraintes pour la table `Sessions`
--
ALTER TABLE `Sessions`
  ADD CONSTRAINT `FK_Sessions_Forums` FOREIGN KEY (`Forum_ID`) REFERENCES `Forums` (`ID`),
  ADD CONSTRAINT `FK_Sessions_Users` FOREIGN KEY (`User_ID`) REFERENCES `Users` (`ID`);

--
-- Contraintes pour la table `Sessions_Dev`
--
ALTER TABLE `Sessions_Dev`
  ADD CONSTRAINT `FK_Sessions_Users_Dev` FOREIGN KEY (`User_ID`) REFERENCES `Users_Dev` (`ID`);

--
-- Contraintes pour la table `Tags_Forums`
--
ALTER TABLE `Tags_Forums`
  ADD CONSTRAINT `FK_Forums_Tags` FOREIGN KEY (`Forums_ID`) REFERENCES `Forums` (`ID`),
  ADD CONSTRAINT `FK_Tags_Forums` FOREIGN KEY (`Tags_ID`) REFERENCES `Tags` (`ID`);

--
-- Contraintes pour la table `Tags_Forums_Dev`
--
ALTER TABLE `Tags_Forums_Dev`
  ADD CONSTRAINT `FK_Forums_Tags_Dev` FOREIGN KEY (`Forum_ID`) REFERENCES `Forums_Dev` (`ID`),
  ADD CONSTRAINT `FK_Tags_Forums_Dev` FOREIGN KEY (`Tag_ID`) REFERENCES `Tags_Dev` (`ID`);

--
-- Contraintes pour la table `Users`
--
ALTER TABLE `Users`
  ADD CONSTRAINT `FK_Roles_Users` FOREIGN KEY (`Roles_ID`) REFERENCES `Roles` (`ID`);

--
-- Contraintes pour la table `Users_Dev`
--
ALTER TABLE `Users_Dev`
  ADD CONSTRAINT `FK_Roles_Users_Dev` FOREIGN KEY (`Role_ID`) REFERENCES `Roles_Dev` (`ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
