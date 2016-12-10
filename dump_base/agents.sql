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
-- Table structure for table `categorie`
--

DROP TABLE IF EXISTS `categorie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categorie` (
  `idCategorie` int(11) NOT NULL,
  `nomCategorie` varchar(80) NOT NULL,
  PRIMARY KEY (`idCategorie`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorie`
--

LOCK TABLES `categorie` WRITE;
/*!40000 ALTER TABLE `categorie` DISABLE KEYS */;
INSERT INTO `categorie` VALUES (1,'Légume'),(2,'Produit laitier'),(3,'Boisson'),(4,'Produit entretien'),(5,'Cosmétique'),(6,'High-Tech');
/*!40000 ALTER TABLE `categorie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produit`
--

DROP TABLE IF EXISTS `produit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produit` (
  `idProduit` bigint(20) NOT NULL AUTO_INCREMENT,
  `nomProduit` varchar(100) NOT NULL,
  `marqueProduit` varchar(100) NOT NULL,
  `descriptionProduit` text NOT NULL,
  `prixProduit` float NOT NULL,
  `prix` float NOT NULL DEFAULT '-1',
  `prixAchat` float NOT NULL DEFAULT '-1',
  `stock` int(11) NOT NULL DEFAULT '0',
  `idCategorie` int(11) NOT NULL,
  PRIMARY KEY (`idProduit`)
) ENGINE=InnoDB AUTO_INCREMENT=150 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produit`
--

LOCK TABLES `produit` WRITE;
/*!40000 ALTER TABLE `produit` DISABLE KEYS */;
INSERT INTO `produit` VALUES (1,'Carotte','Bonduel','Légume orange riche en protéines',1,-1,-1,0,1),(2,'Poireau','Géant Vert','Légume vert plein de fibre',1.2,-1,-1,0,1),(3,'Citrouille','Cascina Belvedere','Légume orange parfait pour les fêtes d\'Halloween',1.95,-1,-1,0,1),(4,'Brie','Président','Fromage de caractère au lait de vache',16.5,-1,-1,0,2),(5,'Comté','Entremont','Fromage au lait cru',15.05,-1,-1,0,2),(6,'Lait','Candia','Produit laitier semi-écrémé',0.7,-1,-1,0,2),(7,'Bière','Chouffe','Boisson alcoolisée à base d\'orge et d\'houblon',3.78,-1,-1,0,3),(8,'Eau','Evian','Eau de source',0.57,-1,-1,0,3),(9,'Coca','Coca cola','Boisson gazeuse sucrée',1.1,-1,-1,0,3),(10,'Javel','Monsieur Propre','Solution liquide oxydante désinfectante et décolorante',7.92,-1,-1,0,4),(11,'Lave vitre','Kärcher','Solution nettoyante spéciale fenêtre',3.71,-1,-1,0,4),(12,'Liquide vaisselle','Paic','Liquide vaisselle super dégraissant',9.23,-1,-1,0,4),(13,'Parfum','Channel','Fragrance délicate et boisée',56.48,-1,-1,0,5),(14,'Rouge à lèvre','Velvet','Produit de cosmétique permettant de souligner les lèvres',34.5,-1,-1,0,5),(15,'Fond de teint','Maybelline','Produit cosmétique permettant d\'unifier et de protéger l\'épiderme',28.9,-1,-1,0,5),(16,'Television HD','Samsung','Poste de télévision permettant l\'emission et la reception de séquences audiovisuelles',299.99,-1,-1,0,6),(17,'Smartphone','Sony','GSM nouvelle génération',149.9,-1,-1,0,6),(18,'Rasoir éléctrique','Phillips','Rasoir performant et plus ergonomique pour un meilleur rasage de la moustache',72.04,-1,-1,0,6),(19,'Carotte','Grand Frais','Légume orange riche en protéines',1.2,-1,-1,0,1),(20,'Poireau','Cassegrin','Légume vert plein de fibre',1.04,-1,-1,0,1),(21,'Citrouille','Nos régions ont du talent','Légume orange parfait pour les fêtes d\'Halloween',2.25,-1,-1,0,1),(22,'Brie','Coeur de lion','Fromage de caractère au lait de vache',14.99,-1,-1,0,2),(23,'Comté','Juraflore','Fromage au lait cru',12.5,-1,-1,0,2),(24,'Lait','Lactel','Produit laitier semi-écrémé',0.98,-1,-1,0,2),(25,'Bière','Kronenbourg','Boisson alcoolisée à base d\'orge et d\'houblon',1.25,-1,-1,0,3),(26,'Eau','Vittel','Eau de source',0.48,-1,-1,0,3),(27,'Coca','Pepsi','Boisson gazeuse sucrée',1.02,-1,-1,0,3),(28,'Javel','Saint Marc','Solution liquide oxydante désinfectante et décolorante',6.54,-1,-1,0,4),(29,'Lave vitre','Ecovacs','Solution nettoyante spéciale fenêtre',2.6,-1,-1,0,4),(30,'Liquide vaisselle','Mir','Liquide vaisselle super dégraissant',12.6,-1,-1,0,4),(31,'Parfum','Dior','Fragrance délicate et boisée',46.38,-1,-1,0,5),(32,'Rouge à lèvre','L\'Oreal','Produit de cosmétique permettant de souligner les lèvres',41.2,-1,-1,0,5),(33,'Fond de teint','Bourjois','Produit cosmétique permettant d\'unifier et de protéger l\'épiderme',32.5,-1,-1,0,5),(34,'Television HD','LG','Poste de télévision permettant l\'emission et la reception de séquences audiovisuelles',199.9,-1,-1,0,6),(35,'Smartphone','Apple','GSM nouvelle génération',780,-1,-1,0,6),(36,'Rasoir éléctrique','Wilkinson','Rasoir performant et plus ergonomique pour un meilleur rasage de la moustache',68.22,-1,-1,0,6),(37,'Petits pois','Bonduel','Le must des petits pois',1.6,-1,-1,0,1),(38,'Pommes de terre','Géant Vert','Des patates. toujours des patates',1.9,-1,-1,0,1),(39,'Artichaux','Cascina Belvedere','Superbe pièce murit à souhait',1.3,-1,-1,0,1),(40,'Petits pois','Cascina Belvedere','Le must des petits pois',1.3,-1,-1,0,1),(41,'Pommes de terre','Géant Vert','Des patates. toujours des patates',1.7,-1,-1,0,1),(42,'Artichaux','Cascina Belvedere','Superbe pièce murit à souhait',2,-1,-1,0,1),(43,'Tomates','Bonduel','Bien ronde et bien rouge',1.8,-1,-1,0,1),(44,'Brocolis','Géant Vert','Beau brocolis vert',1.6,-1,-1,0,1),(45,'Haricots Verts','Cascina Belvedere','Haricots vert made in France',1.9,-1,-1,0,1),(46,'Tomates','Cascina Belvedere','Bien ronde et bien rouge',1.6,-1,-1,0,1),(47,'Brocolis','Géant Vert','Beau brocolis vert',1.3,-1,-1,0,1),(48,'Haricots Verts','Cascina Belvedere','Haricots vert made in France',1.8,-1,-1,0,1),(49,'Choux fleur','Géant Vert','Choux fleur de nos régions',1.9,-1,-1,0,1),(50,'Choux de bruxelles','Géant Vert','Choux belges plusieurs fois primés',1.2,-1,-1,0,1),(51,'Flageolets','Cascina Belvedere','Flageolets bien ferme et de taille suffisante',1.1,-1,-1,0,1),(52,'Choux fleur','Cascina Belvedere','Choux fleur de nos régions',1.9,-1,-1,0,1),(53,'Choux de bruxelles','Géant Vert','Choux belges plusieurs fois primés',1.9,-1,-1,0,1),(54,'Flageolets','Cascina Belvedere','Flageolets bien ferme et de taille suffisante',1.6,-1,-1,0,1),(55,'Emmentale','Président','Emmentale de montagne',2.5,-1,-1,0,2),(56,'Brie','Entremont','Brie de nos régions',2.2,-1,-1,0,2),(57,'Lait chocolat en brique','Candia','Idéal pour le goûter',3,-1,-1,0,2),(58,'Crème fraiche','Président','Idéale pour la cuisine',2.5,-1,-1,0,2),(59,'Fromage en portion','Entremont','Petites portions à emmener partout',3,-1,-1,0,2),(60,'Gruyère','Candia','Gruyère à déguster ou à ajouter dans vos plats',2.5,-1,-1,0,2),(61,'Fromage à raclette','Président','Idéal pour une raclette en famille ou amis',2.7,-1,-1,0,2),(62,'Fromage à tartiner','Entremont','Fromage à tartiner idéal pour l\'apéro',2.7,-1,-1,0,2),(63,'Emmentale','Candia','Emmentale de montagne',2.2,-1,-1,0,2),(64,'Brie','Entremont','Brie de nos régions',2.3,-1,-1,0,2),(65,'Lait chocolat en brique','Candia','Idéal pour le goûter',2.7,-1,-1,0,2),(66,'Crème fraiche','Président','Idéale pour la cuisine',3,-1,-1,0,2),(67,'Fromage en portion','Entremont','Petites portions à emmener partout',2.4,-1,-1,0,2),(68,'Gruyère','Entremont','Gruyère à déguster ou à ajouter dans vos plats',2.2,-1,-1,0,2),(69,'Fromage à raclette','Président','Idéal pour une raclette en famille ou amis',2.6,-1,-1,0,2),(70,'Fromage à tartiner','Candia','Fromage à tartiner idéal pour l\'apéro',2.4,-1,-1,0,2),(71,'Fondue','Candia','Fondue savoyarde',2.1,-1,-1,0,2),(72,'Lait de chèvre','Candia','Pour ceux qui aiment le chèvre',3,-1,-1,0,2),(73,'Fondue','Entremont','Fondue savoyarde',2.2,-1,-1,0,2),(74,'Lait de chèvre','Entremont','Pour ceux qui aiment le chèvre',3,-1,-1,0,2),(75,'Eau de vie','Arthurus','Le meilleur pour les fin de soirée',2.3,-1,-1,0,3),(76,'Mirabelle','Moureyus','Idéal pour donner un peu de goût à vos repas',2.3,-1,-1,0,3),(77,'Calva','Alcolus','Pour les hommes. les vrais',3,-1,-1,0,3),(78,'Marc','PuRienBus','Marc mûrit en fût pendant 7 mois',2.7,-1,-1,0,3),(79,'Whisky','Jack Daniels','Le seul. l\'unique',2.8,-1,-1,0,3),(80,'Vin','Veuve cliquot','Vin de grande qualité',2.1,-1,-1,0,3),(81,'Snaps','Deutshus','Artoung ça décoiffe',2.7,-1,-1,0,3),(82,'Jus de raisin','Materne','Jus de raisin 100% pur fruit',2.2,-1,-1,0,3),(83,'Jus de pomme','Normalus','Pommes issue de l\'agriculture biologique',2.6,-1,-1,0,3),(84,'Eau de vie','Asbach','Le meilleur pour les fin de soirée',2.8,-1,-1,0,3),(85,'Mirabelle','Adam','Idéal pour donner un peu de goût à vos repas',3,-1,-1,0,3),(86,'Calva','Deutshus','Pour les hommes. les vrais',2.1,-1,-1,0,3),(87,'Marc','Alcolus','Marc mûrit en fût pendant 7 mois',2.2,-1,-1,0,3),(88,'Whisky','Shivas','Le seul. l\'unique',2.3,-1,-1,0,3),(89,'Vin','Saint Émilion','Vin de grande qualité',3,-1,-1,0,3),(90,'Snaps','Moureyus','Artoung ça décoiffe',2.8,-1,-1,0,3),(91,'Jus de raisin','Normalus','Jus de raisin 100% pur fruit',2.6,-1,-1,0,3),(92,'Jus de pomme','Materne','Pommes issue de l\'agriculture biologique',3,-1,-1,0,3),(93,'Déodorisant WC','Monsieur Propre','Idéal pour sentir bon où ça ne sent pas bon',3.9,-1,-1,0,4),(94,'Nettoyant WC','Kärcher','Nettoyage suprême des zones de guerres',3.6,-1,-1,0,4),(95,'Eponge','Paic','A utiliser avec de l\'huile de coude',3.6,-1,-1,0,4),(96,'Nettoyant sol','Monsieur Propre','Mettre un bouchon dans 5 litres d\'eau',3.3,-1,-1,0,4),(97,'Déboucheur canalisation','Kärcher','Idéal pour le transit de vos canalisations. Ne pas ingérer',3.1,-1,-1,0,4),(98,'Chiffon vitre','Paic','Ne fonctionne pas avec les écrans d\'ordinateur',3.5,-1,-1,0,4),(99,'Bombe dépoussiérante','Monsieur Propre','Idéal pour dépoussiérer',3.1,-1,-1,0,4),(100,'Balai','Kärcher','Ne sert pas à voler. mais à nettoyer',3.9,-1,-1,0,4),(101,'Serpillère','Paic','Serpillère 100% pure coton',3.9,-1,-1,0,4),(102,'Déodorisant WC','Kärcher','Idéal pour sentir bon où ça ne sent pas bon',3.2,-1,-1,0,4),(103,'Nettoyant WC','Paic','Nettoyage suprême des zones de guerres',3.1,-1,-1,0,4),(104,'Eponge','Monsieur Propre','A utiliser avec de l\'huile de coude',3.1,-1,-1,0,4),(105,'Nettoyant sol','Kärcher','Mettre un bouchon dans 5 litres d\'eau',3.1,-1,-1,0,4),(106,'Déboucheur canalisation','Paic','Idéal pour le transit de vos canalisations. Ne pas ingérer',3.8,-1,-1,0,4),(107,'Chiffon vitre','Monsieur Propre','Ne fonctionne pas avec les écrans d\'ordinateur',3.8,-1,-1,0,4),(108,'Bombe dépoussiérante','Kärcher','Idéal pour dépoussiérer',4,-1,-1,0,4),(109,'Balai','Paic','Ne sert pas à voler. mais à nettoyer',3.8,-1,-1,0,4),(110,'Serpillère','Monsieur Propre','Serpillère 100% pure coton',3.8,-1,-1,0,4),(111,'Poudre BB','Channel','Poudre pour jouer au ninja dans un nuage de fumé',60.9,-1,-1,0,5),(112,'Eye liner','Velvet','Pour des maquillages réussis',57.7,-1,-1,0,5),(113,'Mascarat waterproof','Maybelline','Ne résiste pas à la piscine',73.9,-1,-1,0,5),(114,'Gloss','Channel','Pour augmenter la taille de vos lèvres',75.9,-1,-1,0,5),(115,'Phare à paupière','Velvet','Ne sert pas à attirer les bateaux',6.7,-1,-1,0,5),(116,'Pince à épiler','Maybelline','Sert également à tirer les vers du nez',176.6,-1,-1,0,5),(117,'Bande de cire','Channel','100% avec douleurs',119.1,-1,-1,0,5),(118,'Coton tige','Velvet','100% pure fibre de coton',123.9,-1,-1,0,5),(119,'Crème hydrante','Maybelline','Hydrate la peau en profondeur',173.5,-1,-1,0,5),(120,'Eau miscellaire','Channel','Idéal pour se démaquiller',55.1,-1,-1,0,5),(121,'Anti cernes','Velvet','Pour les lendemains de soirée',131.5,-1,-1,0,5),(122,'Poudre BB','Channel','Poudre pour jouer au ninja dans un nuage de fumé',48.2,-1,-1,0,5),(123,'Eye liner','Velvet','Pour des maquillages réussis',58.9,-1,-1,0,5),(124,'Mascarat waterproof','Maybelline','Ne résiste pas à la piscine',178.2,-1,-1,0,5),(125,'Gloss','Channel','Pour augmenter la taille de vos lèvres',158.5,-1,-1,0,5),(126,'Phare à paupière','Velvet','Ne sert pas à attirer les bateaux',82.7,-1,-1,0,5),(127,'Pince à épiler','Maybelline','Sert également à tirer les vers du nez',199.7,-1,-1,0,5),(128,'Bande de cire','Channel','100% avec douleurs',69.6,-1,-1,0,5),(129,'Coton tige','Velvet','100% pure fibre de coton',105.2,-1,-1,0,5),(130,'Crème hydrante','Maybelline','Hydrate la peau en profondeur',114.7,-1,-1,0,5),(131,'Eau miscellaire','Channel','Idéal pour se démaquiller',75.5,-1,-1,0,5),(132,'Anti cernes','Maybelline','Pour les lendemains de soirée',78.3,-1,-1,0,5),(133,'Four à microonde','Samsung','Four à microonde haut de gamme',94.4,-1,-1,0,6),(134,'Aspirateur','Sony','Aspirateur sans fil et sans sac',24.3,-1,-1,0,6),(135,'Grille pain','Phillips','Idéal pour vos tartines du matin',80.7,-1,-1,0,6),(136,'Ordinateur','Samsung','Ordinateur top moumoute plus',77,-1,-1,0,6),(137,'Tablette','Sony','Tablette idéal pour vos envies de mobilité',66.2,-1,-1,0,6),(138,'Chaine HiFI','Phillips','Chaine HiFi avec son HD',122.3,-1,-1,0,6),(139,'Radio','Samsung','Capter toutes vos radios préférées',194.8,-1,-1,0,6),(140,'Ecran PC','Sony','Ecran 15 pouces LED',37.1,-1,-1,0,6),(141,'Four à microonde','Sony','Four à microonde haut de gamme',148.8,-1,-1,0,6),(142,'Aspirateur','Phillips','Aspirateur sans fil et sans sac',61.1,-1,-1,0,6),(143,'Grille pain','Samsung','Idéal pour vos tartines du matin',130.2,-1,-1,0,6),(144,'Ordinateur','Sony','Ordinateur top moumoute plus',54.5,-1,-1,0,6),(145,'Tablette','Phillips','Tablette idéal pour vos envies de mobilité',23.5,-1,-1,0,6),(146,'Chaine HiFI','Samsung','Chaine HiFi avec son HD',35.9,-1,-1,0,6),(147,'Radio','Sony','Capter toutes vos radios préférées',21.3,-1,-1,0,6),(148,'Ecran PC','Phillips','Ecran 15 pouces LED',59.8,-1,-1,0,6),(149,'Montre connectée','Apple','Montre connectée répondant à tous vos besoins',177.6,-1,-1,0,6);
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

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transaction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(20) NOT NULL,
  `idProduit` int(11) NOT NULL,
  `qteProduit` int(11) NOT NULL,
  `montantTotal` float NOT NULL,
  `timestamp` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-10 12:22:49
