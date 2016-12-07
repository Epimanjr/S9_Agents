-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Lun 21 Novembre 2016 à 11:10
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
('BOBI16', 'Bière', 'Boisson alcoolisée à base d''orge et d''houblon', 'Chouffe', 'Boisson', 3.78, 0),
('BOBI655', 'Bière', 'Boisson alcoolisée à base d''orge et d''houblon', 'Kronenbourg', 'Boisson', 1.25, 0),
('BOCA695', 'Calva', 'Pour les hommes. les vrais', 'Alcolus', 'Boisson', 2.8, 0),
('BOCA892', 'Calva', 'Pour les hommes. les vrais', 'Deutshus', 'Boisson', 2.1, 0),
('BOCO244', 'Coca', 'Boisson gazeuse sucrée', 'Coca cola', 'Boisson', 1.1, 0),
('BOCO753', 'Coca', 'Boisson gazeuse sucrée', 'Pepsi', 'Boisson', 1.02, 0),
('BOEA564', 'Eau de vie', 'Le meilleur pour les fin de soirée', 'Arthurus', 'Boisson', 2.1, 0),
('BOEA589', 'Eau', 'Eau de source', 'Vittel', 'Boisson', 0.48, 0),
('BOEA644', 'Eau', 'Eau de source', 'Evian', 'Boisson', 0.57, 0),
('BOEA901', 'Eau de vie', 'Le meilleur pour les fin de soirée', 'Moureyus', 'Boisson', 2.7, 0),
('BOJU417', 'Jus de pomme', 'Pommes issue de l''agriculture biologique', 'Normalus', 'Boisson', 2.2, 0),
('BOJU586', 'Jus de raisin', 'Jus de raisin 100% pur fruit', 'Materne', 'Boisson', 2.1, 0),
('BOJU922', 'Jus de raisin', 'Jus de raisin 100% pur fruit', 'Normalus', 'Boisson', 2.5, 0),
('BOJU98', 'Jus de pomme', 'Pommes issue de l''agriculture biologique', 'Materne', 'Boisson', 2.9, 0),
('BOMA374', 'Marc', 'Marc mûrit en fût pendant 7 mois', 'PuRienBus', 'Boisson', 3, 0),
('BOMA970', 'Marc', 'Marc mûrit en fût pendant 7 mois', 'Alcolus', 'Boisson', 2.4, 0),
('BOMI864', 'Mirabelle', 'Idéal pour donner un peu de goût à vos repas', 'Moureyus', 'Boisson', 2.1, 0),
('BOMI952', 'Mirabelle', 'Idéal pour donner un peu de goût à vos repas', 'Arthurus', 'Boisson', 2.1, 0),
('BOSN815', 'Snaps', 'Artoung ça décoiffe', 'Deutshus', 'Boisson', 2.7, 0),
('BOSN991', 'Snaps', 'Artoung ça décoiffe', 'Moureyus', 'Boisson', 2.6, 0),
('BOVI117', 'Vin', 'Vin de grande qualité', 'Saint Émilion', 'Boisson', 2.1, 0),
('BOVI364', 'Vin', 'Vin de grande qualité', 'Veuve cliquot', 'Boisson', 2.7, 0),
('BOWH188', 'Whisky', 'Le seul. l''unique', 'Jack Daniels', 'Boisson', 2.9, 0),
('BOWH852', 'Whisky', 'Le seul. l''unique', 'Shivas', 'Boisson', 2.4, 0),
('COAN679', 'Anti cernes', 'Pour les lendemains de soirée', 'Maybelline', 'Cosmétique', 66.6, 0),
('COAN783', 'Anti cernes', 'Pour les lendemains de soirée', 'Velvet', 'Cosmétique', 122.6, 0),
('COBA855', 'Bande de cire', '100% avec douleurs', 'Channel', 'Cosmétique', 42.5, 0),
('COBA980', 'Bande de cire', '100% avec douleurs', 'Channel', 'Cosmétique', 118.3, 0),
('COCO267', 'Coton tige', '100% pure fibre de coton', 'Velvet', 'Cosmétique', 117.3, 0),
('COCO449', 'Coton tige', '100% pure fibre de coton', 'Velvet', 'Cosmétique', 145.3, 0),
('COCR418', 'Crème hydrante', 'Hydrate la peau en profondeur', 'Maybelline', 'Cosmétique', 104.9, 0),
('COCR954', 'Crème hydrante', 'Hydrate la peau en profondeur', 'Maybelline', 'Cosmétique', 81.5, 0),
('COEA109', 'Eau miscellaire', 'Idéal pour se démaquiller', 'Channel', 'Cosmétique', 144.8, 0),
('COEA937', 'Eau miscellaire', 'Idéal pour se démaquiller', 'Channel', 'Cosmétique', 154.4, 0),
('COEY564', 'Eye liner', 'Pour des maquillages réussis', 'Velvet', 'Cosmétique', 93.1, 0),
('COEY989', 'Eye liner', 'Pour des maquillages réussis', 'Velvet', 'Cosmétique', 97.2, 0),
('COFO10', 'Fond de teint', 'Produit cosmétique permettant d''unifier et de protéger l''épiderme', 'Maybelline', 'Cosmétique', 28.9, 0),
('COFO628', 'Fond de teint', 'Produit cosmétique permettant d''unifier et de protéger l''épiderme', 'Bourjois', 'Cosmétique', 32.5, 0),
('COGL658', 'Gloss', 'Pour augmenter la taille de vos lèvres', 'Channel', 'Cosmétique', 104.2, 0),
('COGL959', 'Gloss', 'Pour augmenter la taille de vos lèvres', 'Channel', 'Cosmétique', 22, 0),
('COMA29', 'Mascarat waterproof', 'Ne résiste pas à la piscine', 'Maybelline', 'Cosmétique', 9.6, 0),
('COMA970', 'Mascarat waterproof', 'Ne résiste pas à la piscine', 'Maybelline', 'Cosmétique', 166.2, 0),
('COPA148', 'Parfum', 'Fragrance délicate et boisée', 'Channel', 'Cosmétique', 56.48, 0),
('COPA890', 'Parfum', 'Fragrance délicate et boisée', 'Dior', 'Cosmétique', 46.38, 0),
('COPH318', 'Phare à paupière', 'Ne sert pas à attirer les bateaux', 'Velvet', 'Cosmétique', 185, 0),
('COPH720', 'Phare à paupière', 'Ne sert pas à attirer les bateaux', 'Velvet', 'Cosmétique', 18.3, 0),
('COPI562', 'Pince à épiler', 'Sert également à tirer les vers du nez', 'Maybelline', 'Cosmétique', 80.4, 0),
('COPI677', 'Pince à épiler', 'Sert également à tirer les vers du nez', 'Maybelline', 'Cosmétique', 83.7, 0),
('COPO491', 'Poudre BB', 'Poudre pour jouer au ninja dans un nuage de fumé', 'Channel', 'Cosmétique', 193.7, 0),
('COPO849', 'Poudre BB', 'Poudre pour jouer au ninja dans un nuage de fumé', 'Channel', 'Cosmétique', 143.9, 0),
('CORO230', 'Rouge à lèvre', 'Produit de cosmétique permettant de souligner les lèvres', 'Velvet', 'Cosmétique', 34.5, 0),
('HIAS651', 'Aspirateur', 'Aspirateur sans fil et sans sac', 'Sony', 'High-tech', 24.9, 0),
('HIAS668', 'Aspirateur', 'Aspirateur sans fil et sans sac', 'Phillips', 'High-tech', 77.7, 0),
('HICH361', 'Chaine HiFI', 'Chaine HiFi avec son HD', 'Phillips', 'High-tech', 91.1, 0),
('HICH967', 'Chaine HiFI', 'Chaine HiFi avec son HD', 'Samsung', 'High-tech', 162.2, 0),
('HIEC567', 'Ecran PC', 'Ecran 15 pouces LED', 'Phillips', 'High-tech', 195.5, 0),
('HIEC634', 'Ecran PC', 'Ecran 15 pouces LED', 'Sony', 'High-tech', 191.9, 0),
('HIFO363', 'Four à microonde', 'Four à microonde haut de gamme', 'Sony', 'High-tech', 135.5, 0),
('HIFO944', 'Four à microonde', 'Four à microonde haut de gamme', 'Samsung', 'High-tech', 87.5, 0),
('HIGR519', 'Grille pain', 'Idéal pour vos tartines du matin', 'Samsung', 'High-tech', 150, 0),
('HIGR808', 'Grille pain', 'Idéal pour vos tartines du matin', 'Phillips', 'High-tech', 154.3, 0),
('HIMO74', 'Montre connectée', 'Montre connectée répondant à tous vos besoins', 'Apple', 'High-tech', 183.6, 0),
('HIOR501', 'Ordinateur', 'Ordinateur top moumoute plus', 'Sony', 'High-tech', 120.6, 0),
('HIOR877', 'Ordinateur', 'Ordinateur top moumoute plus', 'Samsung', 'High-tech', 127.2, 0),
('HIRA284', 'Rasoir éléctrique', 'Rasoir performant et plus ergonomique pour un meilleur rasage de la moustache', 'Wilkinson', 'High-tech', 68.22, 0),
('HIRA367', 'Rasoir éléctrique', 'Rasoir performant et plus ergonomique pour un meilleur rasage de la moustache', 'Phillips', 'High-tech', 72.04, 0),
('HIRA600', 'Radio', 'Capter toutes vos radios préférées', 'Samsung', 'High-tech', 193, 0),
('HIRA826', 'Radio', 'Capter toutes vos radios préférées', 'Sony', 'High-tech', 112.8, 0),
('HISM26', 'Smartphone', 'GSM nouvelle génération', 'Apple', 'High-tech', 780, 0),
('HISM547', 'Smartphone', 'GSM nouvelle génération', 'Sony', 'High-tech', 149.9, 0),
('HITA489', 'Tablette', 'Tablette idéal pour vos envies de mobilité', 'Sony', 'High-tech', 35, 0),
('HITA532', 'Tablette', 'Tablette idéal pour vos envies de mobilité', 'Phillips', 'High-tech', 34.3, 0),
('HITE604', 'Television HD', 'Poste de télévision permettant l''emission et la reception de séquences audiovisuelles', 'LG', 'High-tech', 199.9, 0),
('HITE79', 'Television HD', 'Poste de télévision permettant l''emission et la reception de séquences audiovisuelles', 'Samsung', 'High-tech', 299.99, 0),
('LÉAR181', 'Artichaux', 'Superbe pièce murit à souhait', 'Cascina Belvedere', 'Légume', 1.6, 0),
('LÉAR372', 'Artichaux', 'Superbe pièce murit à souhait', 'Cascina Belvedere', 'Légume', 1.6, 0),
('LÉBR323', 'Brocolis', 'Beau brocolis vert', 'Géant Vert', 'Légume', 1.5, 0),
('LÉBR399', 'Brocolis', 'Beau brocolis vert', 'Géant Vert', 'Légume', 1.6, 0),
('LÉCA25', 'Carotte', 'Légume orange riche en protéines', 'Bonduel', 'Légume', 1, 0),
('LÉCA486', 'Carotte', 'Légume orange riche en protéines', 'Grand Frais', 'Légume', 1.2, 0),
('LÉCH220', 'Choux fleur', 'Choux fleur de nos régions', 'Cascina Belvedere', 'Légume', 1.6, 0),
('LÉCH635', 'Choux de bruxelles', 'Choux belges plusieurs fois primés', 'Géant Vert', 'Légume', 1.2, 0),
('LÉCH775', 'Choux de bruxelles', 'Choux belges plusieurs fois primés', 'Géant Vert', 'Légume', 1.9, 0),
('LÉCH883', 'Choux fleur', 'Choux fleur de nos régions', 'Géant Vert', 'Légume', 1.5, 0),
('LÉCI155', 'Citrouille', 'Légume orange parfait pour les fêtes d''Halloween', 'Nos régions ont du talent', 'Légume', 2.25, 0),
('LÉCI337', 'Citrouille', 'Légume orange parfait pour les fêtes d''Halloween', 'Cascina Belvedere', 'Légume', 1.95, 0),
('LÉFL176', 'Flageolets', 'Flageolets bien ferme et de taille suffisante', 'Cascina Belvedere', 'Légume', 1.6, 0),
('LÉFL42', 'Flageolets', 'Flageolets bien ferme et de taille suffisante', 'Cascina Belvedere', 'Légume', 1.3, 0),
('LÉHA704', 'Haricots Verts', 'Haricots vert made in France', 'Cascina Belvedere', 'Légume', 1.1, 0),
('LÉHA90', 'Haricots Verts', 'Haricots vert made in France', 'Cascina Belvedere', 'Légume', 1.4, 0),
('LÉPE159', 'Petits pois', 'Le must des petits pois', 'Cascina Belvedere', 'Légume', 2, 0),
('LÉPE183', 'Petits pois', 'Le must des petits pois', 'Bonduel', 'Légume', 2, 0),
('LÉPO242', 'Pommes de terre', 'Des patates. toujours des patates', 'Géant Vert', 'Légume', 1.7, 0),
('LÉPO401', 'Poireau', 'Légume vert plein de fibre', 'Cassegrin', 'Légume', 1.04, 0),
('LÉPO462', 'Pommes de terre', 'Des patates. toujours des patates', 'Géant Vert', 'Légume', 1.2, 0),
('LÉPO579', 'Poireau', 'Légume vert plein de fibre', 'Géant Vert', 'Légume', 1.2, 0),
('LÉTO241', 'Tomates', 'Bien ronde et bien rouge', 'Bonduel', 'Légume', 1.7, 0),
('LÉTO331', 'Tomates', 'Bien ronde et bien rouge', 'Cascina Belvedere', 'Légume', 1.6, 0),
('PRBA912', 'Balai', 'Ne sert pas à voler. mais à nettoyer', 'Kärcher', 'Produit entretien', 3.8, 0),
('PRBA935', 'Balai', 'Ne sert pas à voler. mais à nettoyer', 'Paic', 'Produit entretien', 3.1, 0),
('PRBO35', 'Bombe dépoussiérante', 'Idéal pour dépoussiérer', 'Kärcher', 'Produit entretien', 3.4, 0),
('PRBO367', 'Bombe dépoussiérante', 'Idéal pour dépoussiérer', 'Monsieur Propre', 'Produit entretien', 3.1, 0),
('PRBR126', 'Brie', 'Brie de nos régions', 'Entremont', 'Produit laitier', 2.3, 0),
('PRBR285', 'Brie', 'Fromage de caractère au lait de vache', 'Président', 'Produit laitier', 16.5, 0),
('PRBR646', 'Brie', 'Fromage de caractère au lait de vache', 'Coeur de lion', 'Produit laitier', 14.99, 0),
('PRBR942', 'Brie', 'Brie de nos régions', 'Entremont', 'Produit laitier', 2.6, 0),
('PRCH156', 'Chiffon vitre', 'Ne fonctionne pas avec les écrans d''ordinateur', 'Paic', 'Produit entretien', 3.7, 0),
('PRCH898', 'Chiffon vitre', 'Ne fonctionne pas avec les écrans d''ordinateur', 'Monsieur Propre', 'Produit entretien', 3.9, 0),
('PRCO281', 'Comté', 'Fromage au lait cru', 'Entremont', 'Produit laitier', 15.05, 0),
('PRCO317', 'Comté', 'Fromage au lait cru', 'Juraflore', 'Produit laitier', 12.5, 0),
('PRCR309', 'Crème fraiche', 'Idéale pour la cuisine', 'Président', 'Produit laitier', 2.7, 0),
('PRCR317', 'Crème fraiche', 'Idéale pour la cuisine', 'Président', 'Produit laitier', 2.5, 0),
('PRDÉ73', 'Déboucheur canalisation', 'Idéal pour le transit de vos canalisations. Ne pas ingérer', 'Paic', 'Produit entretien', 3.1, 0),
('PRDÉ860', 'Déodorisant WC', 'Idéal pour sentir bon où ça ne sent pas bon', 'Kärcher', 'Produit entretien', 3.1, 0),
('PRDÉ896', 'Déodorisant WC', 'Idéal pour sentir bon où ça ne sent pas bon', 'Monsieur Propre', 'Produit entretien', 3.1, 0),
('PRDÉ94', 'Déboucheur canalisation', 'Idéal pour le transit de vos canalisations. Ne pas ingérer', 'Kärcher', 'Produit entretien', 3.1, 0),
('PREM728', 'Emmentale', 'Emmentale de montagne', 'Candia', 'Produit laitier', 2.3, 0),
('PREM888', 'Emmentale', 'Emmentale de montagne', 'Président', 'Produit laitier', 2.1, 0),
('PREP502', 'Eponge', 'A utiliser avec de l''huile de coude', 'Paic', 'Produit entretien', 3.8, 0),
('PREP794', 'Eponge', 'A utiliser avec de l''huile de coude', 'Monsieur Propre', 'Produit entretien', 3.7, 0),
('PRFO687', 'Fondue', 'Fondue savoyarde', 'Candia', 'Produit laitier', 2.9, 0),
('PRFO992', 'Fondue', 'Fondue savoyarde', 'Entremont', 'Produit laitier', 2.9, 0),
('PRFR249', 'Fromage à tartiner', 'Fromage à tartiner idéal pour l''apéro', 'Candia', 'Produit laitier', 2.4, 0),
('PRFR305', 'Fromage en portion', 'Petites portions à emmener partout', 'Entremont', 'Produit laitier', 2.7, 0),
('PRFR346', 'Fromage à tartiner', 'Fromage à tartiner idéal pour l''apéro', 'Entremont', 'Produit laitier', 2.6, 0),
('PRFR572', 'Fromage à raclette', 'Idéal pour une raclette en famille ou amis', 'Président', 'Produit laitier', 2.4, 0),
('PRFR736', 'Fromage en portion', 'Petites portions à emmener partout', 'Entremont', 'Produit laitier', 2.1, 0),
('PRFR793', 'Fromage à raclette', 'Idéal pour une raclette en famille ou amis', 'Président', 'Produit laitier', 2.3, 0),
('PRGR660', 'Gruyère', 'Gruyère à déguster ou à ajouter dans vos plats', 'Candia', 'Produit laitier', 2.4, 0),
('PRGR685', 'Gruyère', 'Gruyère à déguster ou à ajouter dans vos plats', 'Entremont', 'Produit laitier', 2.8, 0),
('PRJA316', 'Javel', 'Solution liquide oxydante désinfectante et décolorante', 'Monsieur Propre', 'Produit entretien', 7.92, 0),
('PRJA805', 'Javel', 'Solution liquide oxydante désinfectante et décolorante', 'Saint Marc', 'Produit entretien', 6.54, 0),
('PRLA116', 'Lait', 'Produit laitier semi-écrémé', 'Lactel', 'Produit laitier', 0.98, 0),
('PRLA15', 'Lait chocolat en brique', 'Idéal pour le goûter', 'Candia', 'Produit laitier', 2.8, 0),
('PRLA154', 'Lait de chèvre', 'Pour ceux qui aiment le chèvre', 'Entremont', 'Produit laitier', 2.6, 0),
('PRLA374', 'Lave vitre', 'Solution nettoyante spéciale fenêtre', 'Ecovacs', 'Produit entretien', 2.6, 0),
('PRLA678', 'Lait', 'Produit laitier semi-écrémé', 'Candia', 'Produit laitier', 0.7, 0),
('PRLA777', 'Lave vitre', 'Solution nettoyante spéciale fenêtre', 'Kärcher', 'Produit entretien', 3.71, 0),
('PRLA908', 'Lait chocolat en brique', 'Idéal pour le goûter', 'Candia', 'Produit laitier', 2.4, 0),
('PRLA977', 'Lait de chèvre', 'Pour ceux qui aiment le chèvre', 'Candia', 'Produit laitier', 2.4, 0),
('PRLI138', 'Liquide vaisselle', 'Liquide vaisselle super dégraissant', 'Mir', 'Produit entretien', 12.6, 0),
('PRLI415', 'Liquide vaisselle', 'Liquide vaisselle super dégraissant', 'Paic', 'Produit entretien', 9.23, 0),
('PRNE564', 'Nettoyant WC', 'Nettoyage suprême des zones de guerres', 'Kärcher', 'Produit entretien', 3.3, 0),
('PRNE821', 'Nettoyant WC', 'Nettoyage suprême des zones de guerres', 'Paic', 'Produit entretien', 3.9, 0),
('PRNE922', 'Nettoyant sol', 'Mettre un bouchon dans 5 litres d''eau', 'Kärcher', 'Produit entretien', 3.6, 0),
('PRNE960', 'Nettoyant sol', 'Mettre un bouchon dans 5 litres d''eau', 'Monsieur Propre', 'Produit entretien', 3.6, 0),
('PRSE410', 'Serpillère', 'Serpillère 100% pure coton', 'Monsieur Propre', 'Produit entretien', 4, 0),
('PRSE967', 'Serpillère', 'Serpillère 100% pure coton', 'Paic', 'Produit entretien', 3.3, 0);

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
