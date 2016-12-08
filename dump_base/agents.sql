-- MySQL dump 10.16  Distrib 10.1.16-MariaDB, for Win32 (AMD64)
--
-- Host: localhost    Database: agents
-- ------------------------------------------------------
-- Server version	10.1.16-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `produit`
--

DROP TABLE IF EXISTS `produit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produit` (
  `id` int(11) NOT NULL,
  `reference` varchar(20) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `description` text NOT NULL,
  `marque` varchar(30) NOT NULL,
  `type` varchar(30) NOT NULL,
  `prix` double NOT NULL,
  `stock` int(11) NOT NULL,
  PRIMARY KEY (`reference`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produit`
--

LOCK TABLES `produit` WRITE;
/*!40000 ALTER TABLE `produit` DISABLE KEYS */;
INSERT INTO `produit` VALUES (1964520057,'BOBI16','Bière','Boisson alcoolisée à base d\'orge et d\'houblon','Chouffe','Boisson',3.78,0),(770584450,'BOBI655','Bière','Boisson alcoolisée à base d\'orge et d\'houblon','Kronenbourg','Boisson',1.25,0),(771269767,'BOCA695','Calva','Pour les hommes. les vrais','Alcolus','Boisson',2.8,0),(771271686,'BOCA892','Calva','Pour les hommes. les vrais','Deutshus','Boisson',2.1,0),(771682841,'BOCO244','Coca','Boisson gazeuse sucrée','Coca cola','Boisson',1.1,0),(771687676,'BOCO753','Coca','Boisson gazeuse sucrée','Pepsi','Boisson',1.02,0),(773115754,'BOEA564','Eau de vie','Le meilleur pour les fin de soirée','Arthurus','Boisson',2.1,0),(773115821,'BOEA589','Eau','Eau de source','Vittel','Boisson',0.48,0),(773116653,'BOEA644','Eau','Eau de source','Evian','Boisson',0.57,0),(773119409,'BOEA901','Eau de vie','Le meilleur pour les fin de soirée','Moureyus','Boisson',2.7,0),(778328066,'BOJU417','Jus de pomme','Pommes issue de l\'agriculture biologique','Normalus','Boisson',2.2,0),(778329243,'BOJU586','Jus de raisin','Jus de raisin 100% pur fruit','Materne','Boisson',2.1,0),(778332897,'BOJU922','Jus de raisin','Jus de raisin 100% pur fruit','Normalus','Boisson',2.5,0),(1964770167,'BOJU98','Jus de pomme','Pommes issue de l\'agriculture biologique','Materne','Boisson',2.9,0),(780502031,'BOMA374','Marc','Marc mûrit en fût pendant 7 mois','PuRienBus','Boisson',3,0),(780507793,'BOMA970','Marc','Marc mûrit en fût pendant 7 mois','Alcolus','Boisson',2.4,0),(780745133,'BOMI864','Mirabelle','Idéal pour donner un peu de goût à vos repas','Moureyus','Boisson',2.1,0),(780746061,'BOMI952','Mirabelle','Idéal pour donner un peu de goût à vos repas','Arthurus','Boisson',2.1,0),(786435060,'BOSN815','Snaps','Artoung ça décoiffe','Deutshus','Boisson',2.7,0),(786436265,'BOSN991','Snaps','Artoung ça décoiffe','Moureyus','Boisson',2.6,0),(789049943,'BOVI117','Vin','Vin de grande qualité','Saint Émilion','Boisson',2.1,0),(789052017,'BOVI364','Vin','Vin de grande qualité','Veuve cliquot','Boisson',2.7,0),(789943891,'BOWH188','Whisky','Le seul. l\'unique','Jack Daniels','Boisson',2.9,0),(789950519,'BOWH852','Whisky','Le seul. l\'unique','Shivas','Boisson',2.4,0),(1657313631,'COAN679','Anti cernes','Pour les lendemains de soirée','Maybelline','Cosmétique',66.6,0),(1657314617,'COAN783','Anti cernes','Pour les lendemains de soirée','Velvet','Cosmétique',122.6,0),(1657851725,'COBA855','Bande de cire','100% avec douleurs','Channel','Cosmétique',42.5,0),(1657852774,'COBA980','Bande de cire','100% avec douleurs','Channel','Cosmétique',118.3,0),(1659186587,'COCO267','Coton tige','100% pure fibre de coton','Velvet','Cosmétique',117.3,0),(1659188449,'COCO449','Coton tige','100% pure fibre de coton','Velvet','Cosmétique',145.3,0),(1659277728,'COCR418','Crème hydrante','Hydrate la peau en profondeur','Maybelline','Cosmétique',104.9,0),(1659282653,'COCR954','Crème hydrante','Hydrate la peau en profondeur','Maybelline','Cosmétique',81.5,0),(1660615410,'COEA109','Eau miscellaire','Idéal pour se démaquiller','Channel','Cosmétique',144.8,0),(1660623189,'COEA937','Eau miscellaire','Idéal pour se démaquiller','Channel','Cosmétique',154.4,0),(1661334419,'COEY564','Eye liner','Pour des maquillages réussis','Velvet','Cosmétique',93.1,0),(1661338330,'COEY989','Eye liner','Pour des maquillages réussis','Velvet','Cosmétique',97.2,0),(1993274132,'COFO10','Fond de teint','Produit cosmétique permettant d\'unifier et de protéger l\'épiderme','Maybelline','Cosmétique',28.9,0),(1661960871,'COFO628','Fond de teint','Produit cosmétique permettant d\'unifier et de protéger l\'épiderme','Bourjois','Cosmétique',32.5,0),(1662795112,'COGL658','Gloss','Pour augmenter la taille de vos lèvres','Channel','Cosmétique',104.2,0),(1662797996,'COGL959','Gloss','Pour augmenter la taille de vos lèvres','Channel','Cosmétique',22,0),(1993469255,'COMA29','Mascarat waterproof','Ne résiste pas à la piscine','Maybelline','Cosmétique',9.6,0),(1668011474,'COMA970','Mascarat waterproof','Ne résiste pas à la piscine','Maybelline','Cosmétique',166.2,0),(1670774264,'COPA148','Parfum','Fragrance délicate et boisée','Channel','Cosmétique',56.48,0),(1670781138,'COPA890','Parfum','Fragrance délicate et boisée','Dior','Cosmétique',46.38,0),(1670984630,'COPH318','Phare à paupière','Ne sert pas à attirer les bateaux','Velvet','Cosmétique',185,0),(1670988497,'COPH720','Phare à paupière','Ne sert pas à attirer les bateaux','Velvet','Cosmétique',18.3,0),(1671016492,'COPI562','Pince à épiler','Sert également à tirer les vers du nez','Maybelline','Cosmétique',80.4,0),(1671017489,'COPI677','Pince à épiler','Sert également à tirer les vers du nez','Maybelline','Cosmétique',83.7,0),(1671194369,'COPO491','Poudre BB','Poudre pour jouer au ninja dans un nuage de fumé','Channel','Cosmétique',193.7,0),(1671198066,'COPO849','Poudre BB','Poudre pour jouer au ninja dans un nuage de fumé','Channel','Cosmétique',143.9,0),(1673039302,'CORO230','Rouge à lèvre','Produit de cosmétique permettant de souligner les lèvres','Velvet','Cosmétique',34.5,0),(1628238719,'HIAS651','Aspirateur','Aspirateur sans fil et sans sac','Sony','High-tech',24.9,0),(1628238757,'HIAS668','Aspirateur','Aspirateur sans fil et sans sac','Phillips','High-tech',77.7,0),(1629755208,'HICH361','Chaine HiFI','Chaine HiFi avec son HD','Phillips','High-tech',91.1,0),(1629760980,'HICH967','Chaine HiFI','Chaine HiFi avec son HD','Samsung','High-tech',162.2,0),(1631455223,'HIEC567','Ecran PC','Ecran 15 pouces LED','Phillips','High-tech',195.5,0),(1631456088,'HIEC634','Ecran PC','Ecran 15 pouces LED','Sony','High-tech',191.9,0),(1632734310,'HIFO363','Four à microonde','Four à microonde haut de gamme','Sony','High-tech',135.5,0),(1632740015,'HIFO944','Four à microonde','Four à microonde haut de gamme','Samsung','High-tech',87.5,0),(1633748977,'HIGR519','Grille pain','Idéal pour vos tartines du matin','Samsung','High-tech',150,0),(1633751828,'HIGR808','Grille pain','Idéal pour vos tartines du matin','Phillips','High-tech',154.3,0),(2131087488,'HIMO74','Montre connectée','Montre connectée répondant à tous vos besoins','Apple','High-tech',183.6,0),(1641137106,'HIOR501','Ordinateur','Ordinateur top moumoute plus','Sony','High-tech',120.6,0),(1641140212,'HIOR877','Ordinateur','Ordinateur top moumoute plus','Samsung','High-tech',127.2,0),(1643398590,'HIRA284','Rasoir éléctrique','Rasoir performant et plus ergonomique pour un meilleur rasage de la moustache','Wilkinson','High-tech',68.22,0),(1643399492,'HIRA367','Rasoir éléctrique','Rasoir performant et plus ergonomique pour un meilleur rasage de la moustache','Phillips','High-tech',72.04,0),(1643402182,'HIRA600','Radio','Capter toutes vos radios préférées','Samsung','High-tech',193,0),(1643404172,'HIRA826','Radio','Capter toutes vos radios préférées','Sony','High-tech',112.8,0),(2131264159,'HISM26','Smartphone','GSM nouvelle génération','Apple','High-tech',780,0),(1644682365,'HISM547','Smartphone','GSM nouvelle génération','Sony','High-tech',149.9,0),(1645247559,'HITA489','Tablette','Tablette idéal pour vos envies de mobilité','Sony','High-tech',35,0),(1645248358,'HITA532','Tablette','Tablette idéal pour vos envies de mobilité','Phillips','High-tech',34.3,0),(1645368392,'HITE604','Television HD','Poste de télévision permettant l\'emission et la reception de séquences audiovisuelles','LG','High-tech',199.9,0),(2131286420,'HITE79','Television HD','Poste de télévision permettant l\'emission et la reception de séquences audiovisuelles','Samsung','High-tech',299.99,0),(252815676,'LÉAR181','Artichaux','Superbe pièce murit à souhait','Cascina Belvedere','Légume',1.6,0),(252817568,'LÉAR372','Artichaux','Superbe pièce murit à souhait','Cascina Belvedere','Légume',1.6,0),(253740935,'LÉBR323','Brocolis','Beau brocolis vert','Géant Vert','Légume',1.5,0),(253741158,'LÉBR399','Brocolis','Beau brocolis vert','Géant Vert','Légume',1.6,0),(-1931464034,'LÉCA25','Carotte','Légume orange riche en protéines','Bonduel','Légume',1,0),(254159159,'LÉCA486','Carotte','Légume orange riche en protéines','Grand Frais','Légume',1.2,0),(254365582,'LÉCH220','Choux fleur','Choux fleur de nos régions','Cascina Belvedere','Légume',1.6,0),(254369462,'LÉCH635','Choux de bruxelles','Choux belges plusieurs fois primés','Géant Vert','Légume',1.2,0),(254370547,'LÉCH775','Choux de bruxelles','Choux belges plusieurs fois primés','Géant Vert','Légume',1.9,0),(254371537,'LÉCH883','Choux fleur','Choux fleur de nos régions','Géant Vert','Légume',1.5,0),(254394510,'LÉCI155','Citrouille','Légume orange parfait pour les fêtes d\'Halloween','Nos régions ont du talent','Légume',2.25,0),(254396372,'LÉCI337','Citrouille','Légume orange parfait pour les fêtes d\'Halloween','Cascina Belvedere','Légume',1.95,0),(257254509,'LÉFL176','Flageolets','Flageolets bien ferme et de taille suffisante','Cascina Belvedere','Légume',1.6,0),(-1931364031,'LÉFL42','Flageolets','Flageolets bien ferme et de taille suffisante','Cascina Belvedere','Légume',1.3,0),(258779397,'LÉHA704','Haricots Verts','Haricots vert made in France','Cascina Belvedere','Légume',1.1,0),(-1931314867,'LÉHA90','Haricots Verts','Haricots vert made in France','Cascina Belvedere','Légume',1.4,0),(266281123,'LÉPE159','Petits pois','Le must des petits pois','Cascina Belvedere','Légume',2,0),(266281210,'LÉPE183','Petits pois','Le must des petits pois','Bonduel','Légume',2,0),(266579956,'LÉPO242','Pommes de terre','Des patates. toujours des patates','Géant Vert','Légume',1.7,0),(266581753,'LÉPO401','Poireau','Légume vert plein de fibre','Cassegrin','Légume',1.04,0),(266581940,'LÉPO462','Pommes de terre','Des patates. toujours des patates','Géant Vert','Légume',1.2,0),(266582939,'LÉPO579','Poireau','Légume vert plein de fibre','Géant Vert','Légume',1.2,0),(270274039,'LÉTO241','Tomates','Bien ronde et bien rouge','Bonduel','Légume',1.7,0),(270274969,'LÉTO331','Tomates','Bien ronde et bien rouge','Cascina Belvedere','Légume',1.6,0),(396385977,'PRBA912','Balai','Ne sert pas à voler. mais à nettoyer','Kärcher','Produit entretien',3.8,0),(396386042,'PRBA935','Balai','Ne sert pas à voler. mais à nettoyer','Paic','Produit entretien',3.1,0),(-1926862735,'PRBO35','Bombe dépoussiérante','Idéal pour dépoussiérer','Kärcher','Produit entretien',3.4,0),(396797445,'PRBO367','Bombe dépoussiérante','Idéal pour dépoussiérer','Monsieur Propre','Produit entretien',3.1,0),(396884771,'PRBR126','Brie','Brie de nos régions','Entremont','Produit laitier',2.3,0),(396885917,'PRBR285','Brie','Fromage de caractère au lait de vache','Président','Produit laitier',16.5,0),(396889638,'PRBR646','Brie','Fromage de caractère au lait de vache','Coeur de lion','Produit laitier',14.99,0),(396892517,'PRBR942','Brie','Brie de nos régions','Entremont','Produit laitier',2.6,0),(397510475,'PRCH156','Chiffon vitre','Ne fonctionne pas avec les écrans d\'ordinateur','Paic','Produit entretien',3.7,0),(397517328,'PRCH898','Chiffon vitre','Ne fonctionne pas avec les écrans d\'ordinateur','Monsieur Propre','Produit entretien',3.9,0),(397720061,'PRCO281','Comté','Fromage au lait cru','Entremont','Produit laitier',15.05,0),(397720811,'PRCO317','Comté','Fromage au lait cru','Juraflore','Produit laitier',12.5,0),(397810155,'PRCR309','Crème fraiche','Idéale pour la cuisine','Président','Produit laitier',2.7,0),(397810184,'PRCR317','Crème fraiche','Idéale pour la cuisine','Président','Produit laitier',2.5,0),(-1926685789,'PRDÉ73','Déboucheur canalisation','Idéal pour le transit de vos canalisations. Ne pas ingérer','Paic','Produit entretien',3.1,0),(402283787,'PRDÉ860','Déodorisant WC','Idéal pour sentir bon où ça ne sent pas bon','Kärcher','Produit entretien',3.1,0),(402283886,'PRDÉ896','Déodorisant WC','Idéal pour sentir bon où ça ne sent pas bon','Monsieur Propre','Produit entretien',3.1,0),(-1926685726,'PRDÉ94','Déboucheur canalisation','Idéal pour le transit de vos canalisations. Ne pas ingérer','Kärcher','Produit entretien',3.1,0),(399512147,'PREM728','Emmentale','Emmentale de montagne','Candia','Produit laitier',2.3,0),(399513294,'PREM888','Emmentale','Emmentale de montagne','Président','Produit laitier',2.1,0),(399599530,'PREP502','Eponge','A utiliser avec de l\'huile de coude','Paic','Produit entretien',3.8,0),(399601733,'PREP794','Eponge','A utiliser avec de l\'huile de coude','Monsieur Propre','Produit entretien',3.7,0),(400494474,'PRFO687','Fondue','Fondue savoyarde','Candia','Produit laitier',2.9,0),(400497383,'PRFO992','Fondue','Fondue savoyarde','Entremont','Produit laitier',2.9,0),(400579881,'PRFR249','Fromage à tartiner','Fromage à tartiner idéal pour l\'apéro','Candia','Produit laitier',2.4,0),(400580714,'PRFR305','Fromage en portion','Petites portions à emmener partout','Entremont','Produit laitier',2.7,0),(400580839,'PRFR346','Fromage à tartiner','Fromage à tartiner idéal pour l\'apéro','Entremont','Produit laitier',2.6,0),(400582850,'PRFR572','Fromage à raclette','Idéal pour une raclette en famille ou amis','Président','Produit laitier',2.4,0),(400584652,'PRFR736','Fromage en portion','Petites portions à emmener partout','Entremont','Produit laitier',2.1,0),(400584835,'PRFR793','Fromage à raclette','Idéal pour une raclette en famille ou amis','Président','Produit laitier',2.3,0),(401507299,'PRGR660','Gruyère','Gruyère à déguster ou à ajouter dans vos plats','Candia','Produit laitier',2.4,0),(401507366,'PRGR685','Gruyère','Gruyère à déguster ou à ajouter dans vos plats','Entremont','Produit laitier',2.8,0),(403768383,'PRJA316','Javel','Solution liquide oxydante désinfectante et décolorante','Monsieur Propre','Produit entretien',7.92,0),(403773156,'PRJA805','Javel','Solution liquide oxydante désinfectante et décolorante','Saint Marc','Produit entretien',6.54,0),(405613503,'PRLA116','Lait','Produit laitier semi-écrémé','Lactel','Produit laitier',0.98,0),(-1926578341,'PRLA15','Lait chocolat en brique','Idéal pour le goûter','Candia','Produit laitier',2.8,0),(405613625,'PRLA154','Lait de chèvre','Pour ceux qui aiment le chèvre','Entremont','Produit laitier',2.6,0),(405615609,'PRLA374','Lave vitre','Solution nettoyante spéciale fenêtre','Ecovacs','Produit entretien',2.6,0),(405618496,'PRLA678','Lait','Produit laitier semi-écrémé','Candia','Produit laitier',0.7,0),(405619456,'PRLA777','Lave vitre','Solution nettoyante spéciale fenêtre','Kärcher','Produit entretien',3.71,0),(405621162,'PRLA908','Lait chocolat en brique','Idéal pour le goûter','Candia','Produit laitier',2.4,0),(405621378,'PRLA977','Lait de chèvre','Pour ceux qui aiment le chèvre','Candia','Produit laitier',2.4,0),(405851895,'PRLI138','Liquide vaisselle','Liquide vaisselle super dégraissant','Mir','Produit entretien',12.6,0),(405854713,'PRLI415','Liquide vaisselle','Liquide vaisselle super dégraissant','Paic','Produit entretien',9.23,0),(407583706,'PRNE564','Nettoyant WC','Nettoyage suprême des zones de guerres','Kärcher','Produit entretien',3.3,0),(407586462,'PRNE821','Nettoyant WC','Nettoyage suprême des zones de guerres','Paic','Produit entretien',3.9,0),(407587424,'PRNE922','Nettoyant sol','Mettre un bouchon dans 5 litres d\'eau','Kärcher','Produit entretien',3.6,0),(407587546,'PRNE960','Nettoyant sol','Mettre un bouchon dans 5 litres d\'eau','Monsieur Propre','Produit entretien',3.6,0),(412200191,'PRSE410','Serpillère','Serpillère 100% pure coton','Monsieur Propre','Produit entretien',4,0),(412205158,'PRSE967','Serpillère','Serpillère 100% pure coton','Paic','Produit entretien',3.3,0);
/*!40000 ALTER TABLE `produit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `promo`
--

DROP TABLE IF EXISTS `promo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `promo` (
  `idPromo` int(11) NOT NULL AUTO_INCREMENT,
  `listeReference` text NOT NULL,
  `reduction` int(11) NOT NULL,
  PRIMARY KEY (`idPromo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `promo`
--

LOCK TABLES `promo` WRITE;
/*!40000 ALTER TABLE `promo` DISABLE KEYS */;
/*!40000 ALTER TABLE `promo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `solde`
--

DROP TABLE IF EXISTS `solde`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `solde` (
  `idSolde` int(11) NOT NULL AUTO_INCREMENT,
  `dateDebut` date NOT NULL,
  `dateFin` date NOT NULL,
  `statut` varchar(30) NOT NULL,
  PRIMARY KEY (`idSolde`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solde`
--

LOCK TABLES `solde` WRITE;
/*!40000 ALTER TABLE `solde` DISABLE KEYS */;
/*!40000 ALTER TABLE `solde` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-08 18:43:09
