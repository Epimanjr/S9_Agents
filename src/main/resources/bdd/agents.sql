-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Lun 21 Novembre 2016 à 11:03
-- Version du serveur :  10.1.16-MariaDB
-- Version de PHP :  7.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `agents`
--

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE `produit` (
  `reference` varchar(20) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `description` text NOT NULL,
  `marque` varchar(30) NOT NULL,
  `type` varchar(30) NOT NULL,
  `prix` double NOT NULL,
  `stock` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `produit`
--

INSERT INTO `produit` (`reference`, `nom`, `description`, `marque`, `type`, `prix`, `stock`) VALUES
('BoBi427', 'Bière', 'Boisson alcoolisée à base d''orge et d''houblon', 'Kronenbourg', 'Boisson', 1.25, 0),
('BoBi973', 'Bière', 'Boisson alcoolisée à base d''orge et d''houblon', 'Chouffe', 'Boisson', 3.78, 0),
('BoCa223', 'Calva', 'Pour les hommes. les vrais', 'Deutshus', 'Boisson', 2.1, 0),
('BoCa277', 'Calva', 'Pour les hommes. les vrais', 'Alcolus', 'Boisson', 2.8, 0),
('BoCo343', 'Coca', 'Boisson gazeuse sucrée', 'Coca cola', 'Boisson', 1.1, 0),
('BoCo497', 'Coca', 'Boisson gazeuse sucrée', 'Pepsi', 'Boisson', 1.02, 0),
('BoEa118', 'Eau', 'Eau de source', 'Evian', 'Boisson', 0.57, 0),
('BoEa625', 'Eau de vie', 'Le meilleur pour les fin de soirée', 'Arthurus', 'Boisson', 2.1, 0),
('BoEa665', 'Eau de vie', 'Le meilleur pour les fin de soirée', 'Moureyus', 'Boisson', 2.7, 0),
('BoEa959', 'Eau', 'Eau de source', 'Vittel', 'Boisson', 0.48, 0),
('BoJu100', 'Jus de pomme', 'Pommes issue de l''agriculture biologique', 'Materne', 'Boisson', 2.9, 0),
('BoJu203', 'Jus de pomme', 'Pommes issue de l''agriculture biologique', 'Normalus', 'Boisson', 2.2, 0),
('BoJu213', 'Jus de raisin', 'Jus de raisin 100% pur fruit', 'Materne', 'Boisson', 2.1, 0),
('BoJu432', 'Jus de raisin', 'Jus de raisin 100% pur fruit', 'Normalus', 'Boisson', 2.5, 0),
('BoMa576', 'Marc', 'Marc mûrit en fût pendant 7 mois', 'Alcolus', 'Boisson', 2.4, 0),
('BoMa974', 'Marc', 'Marc mûrit en fût pendant 7 mois', 'PuRienBus', 'Boisson', 3, 0),
('BoMi236', 'Mirabelle', 'Idéal pour donner un peu de goût à vos repas', 'Arthurus', 'Boisson', 2.1, 0),
('BoMi329', 'Mirabelle', 'Idéal pour donner un peu de goût à vos repas', 'Moureyus', 'Boisson', 2.1, 0),
('BoSn349', 'Snaps', 'Artoung ça décoiffe', 'Moureyus', 'Boisson', 2.6, 0),
('BoSn773', 'Snaps', 'Artoung ça décoiffe', 'Deutshus', 'Boisson', 2.7, 0),
('BoVi116', 'Vin', 'Vin de grande qualité', 'Veuve cliquot', 'Boisson', 2.7, 0),
('BoVi833', 'Vin', 'Vin de grande qualité', 'Saint Émilion', 'Boisson', 2.1, 0),
('BoWh188', 'Whisky', 'Le seul. l''unique', 'Jack Daniels', 'Boisson', 2.9, 0),
('BoWh592', 'Whisky', 'Le seul. l''unique', 'Shivas', 'Boisson', 2.4, 0),
('CoAn120', 'Anti cernes', 'Pour les lendemains de soirée', 'Velvet', 'Cosmétique', 122.6, 0),
('CoAn648', 'Anti cernes', 'Pour les lendemains de soirée', 'Maybelline', 'Cosmétique', 66.6, 0),
('CoBa278', 'Bande de cire', '100% avec douleurs', 'Channel', 'Cosmétique', 118.3, 0),
('CoBa633', 'Bande de cire', '100% avec douleurs', 'Channel', 'Cosmétique', 42.5, 0),
('CoCo382', 'Coton tige', '100% pure fibre de coton', 'Velvet', 'Cosmétique', 145.3, 0),
('CoCo587', 'Coton tige', '100% pure fibre de coton', 'Velvet', 'Cosmétique', 117.3, 0),
('CoCr496', 'Crème hydrante', 'Hydrate la peau en profondeur', 'Maybelline', 'Cosmétique', 81.5, 0),
('CoCr535', 'Crème hydrante', 'Hydrate la peau en profondeur', 'Maybelline', 'Cosmétique', 104.9, 0),
('CoEa566', 'Eau miscellaire', 'Idéal pour se démaquiller', 'Channel', 'Cosmétique', 154.4, 0),
('CoEa674', 'Eau miscellaire', 'Idéal pour se démaquiller', 'Channel', 'Cosmétique', 144.8, 0),
('CoEy405', 'Eye liner', 'Pour des maquillages réussis', 'Velvet', 'Cosmétique', 97.2, 0),
('CoEy644', 'Eye liner', 'Pour des maquillages réussis', 'Velvet', 'Cosmétique', 93.1, 0),
('CoFo451', 'Fond de teint', 'Produit cosmétique permettant d''unifier et de protéger l''épiderme', 'Maybelline', 'Cosmétique', 28.9, 0),
('CoFo994', 'Fond de teint', 'Produit cosmétique permettant d''unifier et de protéger l''épiderme', 'Bourjois', 'Cosmétique', 32.5, 0),
('CoGl148', 'Gloss', 'Pour augmenter la taille de vos lèvres', 'Channel', 'Cosmétique', 104.2, 0),
('CoGl571', 'Gloss', 'Pour augmenter la taille de vos lèvres', 'Channel', 'Cosmétique', 22, 0),
('CoMa251', 'Mascarat waterproof', 'Ne résiste pas à la piscine', 'Maybelline', 'Cosmétique', 166.2, 0),
('CoMa772', 'Mascarat waterproof', 'Ne résiste pas à la piscine', 'Maybelline', 'Cosmétique', 9.6, 0),
('CoPa296', 'Parfum', 'Fragrance délicate et boisée', 'Dior', 'Cosmétique', 46.38, 0),
('CoPa816', 'Parfum', 'Fragrance délicate et boisée', 'Channel', 'Cosmétique', 56.48, 0),
('CoPh128', 'Phare à paupière', 'Ne sert pas à attirer les bateaux', 'Velvet', 'Cosmétique', 185, 0),
('CoPh170', 'Phare à paupière', 'Ne sert pas à attirer les bateaux', 'Velvet', 'Cosmétique', 18.3, 0),
('CoPi43', 'Pince à épiler', 'Sert également à tirer les vers du nez', 'Maybelline', 'Cosmétique', 83.7, 0),
('CoPi64', 'Pince à épiler', 'Sert également à tirer les vers du nez', 'Maybelline', 'Cosmétique', 80.4, 0),
('CoPo242', 'Poudre BB', 'Poudre pour jouer au ninja dans un nuage de fumé', 'Channel', 'Cosmétique', 143.9, 0),
('CoPo93', 'Poudre BB', 'Poudre pour jouer au ninja dans un nuage de fumé', 'Channel', 'Cosmétique', 193.7, 0),
('CoRo118', 'Rouge à lèvre', 'Produit de cosmétique permettant de souligner les lèvres', 'Velvet', 'Cosmétique', 34.5, 0),
('HiAs197', 'Aspirateur', 'Aspirateur sans fil et sans sac', 'Sony', 'High-tech', 24.9, 0),
('HiAs71', 'Aspirateur', 'Aspirateur sans fil et sans sac', 'Phillips', 'High-tech', 77.7, 0),
('HiCh365', 'Chaine HiFI', 'Chaine HiFi avec son HD', 'Phillips', 'High-tech', 91.1, 0),
('HiCh601', 'Chaine HiFI', 'Chaine HiFi avec son HD', 'Samsung', 'High-tech', 162.2, 0),
('HiEc142', 'Ecran PC', 'Ecran 15 pouces LED', 'Sony', 'High-tech', 191.9, 0),
('HiEc653', 'Ecran PC', 'Ecran 15 pouces LED', 'Phillips', 'High-tech', 195.5, 0),
('HiFo266', 'Four à microonde', 'Four à microonde haut de gamme', 'Samsung', 'High-tech', 87.5, 0),
('HiFo41', 'Four à microonde', 'Four à microonde haut de gamme', 'Sony', 'High-tech', 135.5, 0),
('HiGr28', 'Grille pain', 'Idéal pour vos tartines du matin', 'Samsung', 'High-tech', 150, 0),
('HiGr930', 'Grille pain', 'Idéal pour vos tartines du matin', 'Phillips', 'High-tech', 154.3, 0),
('HiMo486', 'Montre connectée', 'Montre connectée répondant à tous vos besoins', 'Apple', 'High-tech', 183.6, 0),
('HiOr217', 'Ordinateur', 'Ordinateur top moumoute plus', 'Sony', 'High-tech', 120.6, 0),
('HiOr517', 'Ordinateur', 'Ordinateur top moumoute plus', 'Samsung', 'High-tech', 127.2, 0),
('HiRa217', 'Radio', 'Capter toutes vos radios préférées', 'Samsung', 'High-tech', 193, 0),
('HiRa483', 'Rasoir éléctrique', 'Rasoir performant et plus ergonomique pour un meilleur rasage de la moustache', 'Phillips', 'High-tech', 72.04, 0),
('HiRa817', 'Rasoir éléctrique', 'Rasoir performant et plus ergonomique pour un meilleur rasage de la moustache', 'Wilkinson', 'High-tech', 68.22, 0),
('HiRa926', 'Radio', 'Capter toutes vos radios préférées', 'Sony', 'High-tech', 112.8, 0),
('HiSm172', 'Smartphone', 'GSM nouvelle génération', 'Apple', 'High-tech', 780, 0),
('HiSm390', 'Smartphone', 'GSM nouvelle génération', 'Sony', 'High-tech', 149.9, 0),
('HiTa661', 'Tablette', 'Tablette idéal pour vos envies de mobilité', 'Phillips', 'High-tech', 34.3, 0),
('HiTa907', 'Tablette', 'Tablette idéal pour vos envies de mobilité', 'Sony', 'High-tech', 35, 0),
('HiTe451', 'Television HD', 'Poste de télévision permettant l''emission et la reception de séquences audiovisuelles', 'LG', 'High-tech', 199.9, 0),
('HiTe693', 'Television HD', 'Poste de télévision permettant l''emission et la reception de séquences audiovisuelles', 'Samsung', 'High-tech', 299.99, 0),
('LéAr220', 'Artichaux', 'Superbe pièce murit à souhait', 'Cascina Belvedere', 'Légume', 1.6, 0),
('LéAr966', 'Artichaux', 'Superbe pièce murit à souhait', 'Cascina Belvedere', 'Légume', 1.6, 0),
('LéBr594', 'Brocolis', 'Beau brocolis vert', 'Géant Vert', 'Légume', 1.5, 0),
('LéBr905', 'Brocolis', 'Beau brocolis vert', 'Géant Vert', 'Légume', 1.6, 0),
('LéCa202', 'Carotte', 'Légume orange riche en protéines', 'Grand Frais', 'Légume', 1.2, 0),
('LéCa358', 'Carotte', 'Légume orange riche en protéines', 'Bonduel', 'Légume', 1, 0),
('LéCh206', 'Choux de bruxelles', 'Choux belges plusieurs fois primés', 'Géant Vert', 'Légume', 1.9, 0),
('LéCh503', 'Choux fleur', 'Choux fleur de nos régions', 'Géant Vert', 'Légume', 1.5, 0),
('LéCh741', 'Choux fleur', 'Choux fleur de nos régions', 'Cascina Belvedere', 'Légume', 1.6, 0),
('LéCh803', 'Choux de bruxelles', 'Choux belges plusieurs fois primés', 'Géant Vert', 'Légume', 1.2, 0),
('LéCi582', 'Citrouille', 'Légume orange parfait pour les fêtes d''Halloween', 'Cascina Belvedere', 'Légume', 1.95, 0),
('LéCi711', 'Citrouille', 'Légume orange parfait pour les fêtes d''Halloween', 'Nos régions ont du talent', 'Légume', 2.25, 0),
('LéFl177', 'Flageolets', 'Flageolets bien ferme et de taille suffisante', 'Cascina Belvedere', 'Légume', 1.6, 0),
('LéFl600', 'Flageolets', 'Flageolets bien ferme et de taille suffisante', 'Cascina Belvedere', 'Légume', 1.3, 0),
('LéHa558', 'Haricots Verts', 'Haricots vert made in France', 'Cascina Belvedere', 'Légume', 1.4, 0),
('LéHa625', 'Haricots Verts', 'Haricots vert made in France', 'Cascina Belvedere', 'Légume', 1.1, 0),
('LéPe318', 'Petits pois', 'Le must des petits pois', 'Bonduel', 'Légume', 2, 0),
('LéPe964', 'Petits pois', 'Le must des petits pois', 'Cascina Belvedere', 'Légume', 2, 0),
('LéPo174', 'Pommes de terre', 'Des patates. toujours des patates', 'Géant Vert', 'Légume', 1.7, 0),
('LéPo414', 'Pommes de terre', 'Des patates. toujours des patates', 'Géant Vert', 'Légume', 1.2, 0),
('LéPo777', 'Poireau', 'Légume vert plein de fibre', 'Cassegrin', 'Légume', 1.04, 0),
('LéPo900', 'Poireau', 'Légume vert plein de fibre', 'Géant Vert', 'Légume', 1.2, 0),
('LéTo908', 'Tomates', 'Bien ronde et bien rouge', 'Cascina Belvedere', 'Légume', 1.6, 0),
('LéTo912', 'Tomates', 'Bien ronde et bien rouge', 'Bonduel', 'Légume', 1.7, 0),
('PrBa227', 'Balai', 'Ne sert pas à voler. mais à nettoyer', 'Paic', 'Produit entretien', 3.1, 0),
('PrBa390', 'Balai', 'Ne sert pas à voler. mais à nettoyer', 'Kärcher', 'Produit entretien', 3.8, 0),
('PrBo595', 'Bombe dépoussiérante', 'Idéal pour dépoussiérer', 'Monsieur Propre', 'Produit entretien', 3.1, 0),
('PrBo896', 'Bombe dépoussiérante', 'Idéal pour dépoussiérer', 'Kärcher', 'Produit entretien', 3.4, 0),
('PrBr132', 'Brie', 'Fromage de caractère au lait de vache', 'Président', 'Produit laitier', 16.5, 0),
('PrBr33', 'Brie', 'Brie de nos régions', 'Entremont', 'Produit laitier', 2.6, 0),
('PrBr418', 'Brie', 'Fromage de caractère au lait de vache', 'Coeur de lion', 'Produit laitier', 14.99, 0),
('PrBr597', 'Brie', 'Brie de nos régions', 'Entremont', 'Produit laitier', 2.3, 0),
('PrCh295', 'Chiffon vitre', 'Ne fonctionne pas avec les écrans d''ordinateur', 'Monsieur Propre', 'Produit entretien', 3.9, 0),
('PrCh915', 'Chiffon vitre', 'Ne fonctionne pas avec les écrans d''ordinateur', 'Paic', 'Produit entretien', 3.7, 0),
('PrCo487', 'Comté', 'Fromage au lait cru', 'Entremont', 'Produit laitier', 15.05, 0),
('PrCo660', 'Comté', 'Fromage au lait cru', 'Juraflore', 'Produit laitier', 12.5, 0),
('PrCr313', 'Crème fraiche', 'Idéale pour la cuisine', 'Président', 'Produit laitier', 2.5, 0),
('PrCr912', 'Crème fraiche', 'Idéale pour la cuisine', 'Président', 'Produit laitier', 2.7, 0),
('PrDé141', 'Déboucheur canalisation', 'Idéal pour le transit de vos canalisations. Ne pas ingérer', 'Kärcher', 'Produit entretien', 3.1, 0),
('PrDé217', 'Déodorisant WC', 'Idéal pour sentir bon où ça ne sent pas bon', 'Kärcher', 'Produit entretien', 3.1, 0),
('PrDé592', 'Déodorisant WC', 'Idéal pour sentir bon où ça ne sent pas bon', 'Monsieur Propre', 'Produit entretien', 3.1, 0),
('PrDé938', 'Déboucheur canalisation', 'Idéal pour le transit de vos canalisations. Ne pas ingérer', 'Paic', 'Produit entretien', 3.1, 0),
('PrEm341', 'Emmentale', 'Emmentale de montagne', 'Président', 'Produit laitier', 2.1, 0),
('PrEm598', 'Emmentale', 'Emmentale de montagne', 'Candia', 'Produit laitier', 2.3, 0),
('PrEp110', 'Eponge', 'A utiliser avec de l''huile de coude', 'Monsieur Propre', 'Produit entretien', 3.7, 0),
('PrEp30', 'Eponge', 'A utiliser avec de l''huile de coude', 'Paic', 'Produit entretien', 3.8, 0),
('PrFo810', 'Fondue', 'Fondue savoyarde', 'Candia', 'Produit laitier', 2.9, 0),
('PrFo980', 'Fondue', 'Fondue savoyarde', 'Entremont', 'Produit laitier', 2.9, 0),
('PrFr240', 'Fromage à raclette', 'Idéal pour une raclette en famille ou amis', 'Président', 'Produit laitier', 2.4, 0),
('PrFr470', 'Fromage à tartiner', 'Fromage à tartiner idéal pour l''apéro', 'Candia', 'Produit laitier', 2.4, 0),
('PrFr498', 'Fromage à tartiner', 'Fromage à tartiner idéal pour l''apéro', 'Entremont', 'Produit laitier', 2.6, 0),
('PrFr690', 'Fromage en portion', 'Petites portions à emmener partout', 'Entremont', 'Produit laitier', 2.7, 0),
('PrFr84', 'Fromage en portion', 'Petites portions à emmener partout', 'Entremont', 'Produit laitier', 2.1, 0),
('PrFr969', 'Fromage à raclette', 'Idéal pour une raclette en famille ou amis', 'Président', 'Produit laitier', 2.3, 0),
('PrGr189', 'Gruyère', 'Gruyère à déguster ou à ajouter dans vos plats', 'Candia', 'Produit laitier', 2.4, 0),
('PrGr881', 'Gruyère', 'Gruyère à déguster ou à ajouter dans vos plats', 'Entremont', 'Produit laitier', 2.8, 0),
('PrJa108', 'Javel', 'Solution liquide oxydante désinfectante et décolorante', 'Monsieur Propre', 'Produit entretien', 7.92, 0),
('PrJa89', 'Javel', 'Solution liquide oxydante désinfectante et décolorante', 'Saint Marc', 'Produit entretien', 6.54, 0),
('PrLa128', 'Lave vitre', 'Solution nettoyante spéciale fenêtre', 'Ecovacs', 'Produit entretien', 2.6, 0),
('PrLa270', 'Lave vitre', 'Solution nettoyante spéciale fenêtre', 'Kärcher', 'Produit entretien', 3.71, 0),
('PrLa423', 'Lait', 'Produit laitier semi-écrémé', 'Lactel', 'Produit laitier', 0.98, 0),
('PrLa447', 'Lait chocolat en brique', 'Idéal pour le goûter', 'Candia', 'Produit laitier', 2.8, 0),
('PrLa466', 'Lait de chèvre', 'Pour ceux qui aiment le chèvre', 'Candia', 'Produit laitier', 2.4, 0),
('PrLa62', 'Lait', 'Produit laitier semi-écrémé', 'Candia', 'Produit laitier', 0.7, 0),
('PrLa65', 'Lait de chèvre', 'Pour ceux qui aiment le chèvre', 'Entremont', 'Produit laitier', 2.6, 0),
('PrLa661', 'Lait chocolat en brique', 'Idéal pour le goûter', 'Candia', 'Produit laitier', 2.4, 0),
('PrLi110', 'Liquide vaisselle', 'Liquide vaisselle super dégraissant', 'Mir', 'Produit entretien', 12.6, 0),
('PrLi283', 'Liquide vaisselle', 'Liquide vaisselle super dégraissant', 'Paic', 'Produit entretien', 9.23, 0),
('PrNe173', 'Nettoyant sol', 'Mettre un bouchon dans 5 litres d''eau', 'Monsieur Propre', 'Produit entretien', 3.6, 0),
('PrNe675', 'Nettoyant WC', 'Nettoyage suprême des zones de guerres', 'Kärcher', 'Produit entretien', 3.3, 0),
('PrNe843', 'Nettoyant sol', 'Mettre un bouchon dans 5 litres d''eau', 'Kärcher', 'Produit entretien', 3.6, 0),
('PrNe866', 'Nettoyant WC', 'Nettoyage suprême des zones de guerres', 'Paic', 'Produit entretien', 3.9, 0),
('PrSe162', 'Serpillère', 'Serpillère 100% pure coton', 'Paic', 'Produit entretien', 3.3, 0),
('PrSe685', 'Serpillère', 'Serpillère 100% pure coton', 'Monsieur Propre', 'Produit entretien', 4, 0);

-- --------------------------------------------------------

--
-- Structure de la table `promo`
--

CREATE TABLE `promo` (
  `idPromo` int(11) NOT NULL,
  `listeReference` text NOT NULL,
  `reduction` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `solde`
--

CREATE TABLE `solde` (
  `idSolde` int(11) NOT NULL,
  `dateDebut` date NOT NULL,
  `dateFin` date NOT NULL,
  `statut` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Index pour les tables exportées
--

--
-- Index pour la table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`reference`);

--
-- Index pour la table `promo`
--
ALTER TABLE `promo`
  ADD PRIMARY KEY (`idPromo`);

--
-- Index pour la table `solde`
--
ALTER TABLE `solde`
  ADD PRIMARY KEY (`idSolde`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `promo`
--
ALTER TABLE `promo`
  MODIFY `idPromo` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `solde`
--
ALTER TABLE `solde`
  MODIFY `idSolde` int(11) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
