-- MySQL dump 10.13  Distrib 5.5.62, for Win64 (AMD64)
--
-- Host: localhost    Database: test
-- ------------------------------------------------------
-- Server version	5.5.62

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
-- Table structure for table `recipe_avoid`
--

DROP TABLE IF EXISTS `recipe_avoid`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recipe_avoid` (
  `rec_id` int(11) NOT NULL DEFAULT '0',
  `Avoid_for` varchar(100) NOT NULL DEFAULT '',
  PRIMARY KEY (`rec_id`,`Avoid_for`),
  CONSTRAINT `recipe_avoid_ibfk_1` FOREIGN KEY (`rec_id`) REFERENCES `recipes` (`rec_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recipe_avoid`
--

LOCK TABLES `recipe_avoid` WRITE;
/*!40000 ALTER TABLE `recipe_avoid` DISABLE KEYS */;
INSERT INTO `recipe_avoid` VALUES (1,'Soy Allergy'),(2,'Lactose Intolerance'),(3,'Gluten Intolerance'),(4,'Nut Allergy'),(5,'Egg Allergy'),(6,'Sesame Allergy'),(7,'High Cholesterol'),(7,'Lactose Intolerance'),(8,'Gluten Sensitivity'),(8,'Lactose Intolerance'),(9,'Soy Allergy'),(9,'Thyroid Patients'),(10,'Kidney Patients'),(10,'Soy Allergy'),(11,'High Cholesterol'),(11,'Lactose Intolerance'),(11,'Nut Allergy'),(12,'High Cholesterol'),(12,'Lactose Intolerance'),(13,'Gluten Sensitivity'),(13,'High Cholesterol'),(14,'Diabetic Patients'),(14,'Lactose Intolerance'),(15,'Diabetic Patients'),(15,'Gluten Sensitivity'),(15,'High Cholesterol');
/*!40000 ALTER TABLE `recipe_avoid` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recipe_ingredients`
--

DROP TABLE IF EXISTS `recipe_ingredients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recipe_ingredients` (
  `rec_id` int(11) NOT NULL DEFAULT '0',
  `Ingredient` varchar(100) NOT NULL DEFAULT '',
  PRIMARY KEY (`rec_id`,`Ingredient`),
  CONSTRAINT `recipe_ingredients_ibfk_1` FOREIGN KEY (`rec_id`) REFERENCES `recipes` (`rec_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recipe_ingredients`
--

LOCK TABLES `recipe_ingredients` WRITE;
/*!40000 ALTER TABLE `recipe_ingredients` DISABLE KEYS */;
INSERT INTO `recipe_ingredients` VALUES (1,'Bell Pepper'),(1,'Carrot'),(1,'Chili Flakes'),(1,'Coconut Milk'),(1,'Coriander'),(1,'Garlic'),(1,'Ginger'),(1,'Lemongrass'),(1,'Lime Juice'),(1,'Mushroom'),(1,'Soy Sauce'),(1,'Thai Curry Paste'),(1,'Vegetable Broth'),(2,'Baking Powder'),(2,'Banana'),(2,'Butter'),(2,'Honey'),(2,'Milk'),(2,'Rolled Oats'),(3,'Chicken Breast'),(3,'Cumin Powder'),(3,'Garlic'),(3,'Hummus'),(3,'Lemon Juice'),(3,'Lettuce'),(3,'Onion'),(3,'Paprika'),(3,'Pita Bread'),(3,'Tomato'),(3,'Yogurt'),(4,'Almond Milk'),(4,'Chia Seeds'),(4,'Maple Syrup'),(4,'Mixed Berries'),(4,'Vanilla Extract'),(5,'Chili Powder'),(5,'Eggs'),(5,'Garam Masala'),(5,'Garlic'),(5,'Ginger'),(5,'Oil'),(5,'Onion'),(5,'Salt'),(5,'Spinach'),(5,'Tomato'),(5,'Turmeric'),(6,'Cherry Tomatoes'),(6,'Chickpeas'),(6,'Cucumber'),(6,'Lemon Juice'),(6,'Olive Oil'),(6,'Pepper'),(6,'Quinoa'),(6,'Salt'),(6,'Spinach'),(6,'Tahini'),(7,'Basmati Rice'),(7,'Biryani Masala'),(7,'Ghee'),(7,'Mint Leaves'),(7,'Onions'),(7,'Paneer Cubes'),(7,'Saffron Milk'),(7,'Yogurt'),(8,'Bell Peppers'),(8,'Garlic'),(8,'Lasagna Sheets'),(8,'Mozzarella Cheese'),(8,'Olive Oil'),(8,'Onions'),(8,'Tomato Sauce'),(8,'Zucchini'),(9,'Basil Leaves'),(9,'Bell Peppers'),(9,'Chili'),(9,'Garlic'),(9,'Onion'),(9,'Sesame Oil'),(9,'Soy Sauce'),(9,'Tofu'),(10,'Coriander'),(10,'Garlic'),(10,'Ginger'),(10,'Onions'),(10,'Soya Chunks'),(10,'Spices'),(10,'Tomatoes'),(11,'Butter'),(11,'Cashews'),(11,'Cream'),(11,'Onions'),(11,'Paneer'),(11,'Spices'),(11,'Tomatoes'),(12,'Butter'),(12,'Coriander'),(12,'Cream'),(12,'Garlic'),(12,'Paneer'),(12,'Spices'),(12,'Tomatoes'),(13,'Coriander'),(13,'Ghee'),(13,'Green Chili'),(13,'Potatoes'),(13,'Salt'),(13,'Wheat Flour'),(14,'Almonds'),(14,'Cardamom'),(14,'Cashew'),(14,'Milk'),(14,'Raisins'),(14,'Rice'),(14,'Sugar'),(15,'Baking Powder'),(15,'Butter'),(15,'Cocoa Powder'),(15,'Egg Substitute'),(15,'Flour'),(15,'Sugar');
/*!40000 ALTER TABLE `recipe_ingredients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recipes`
--

DROP TABLE IF EXISTS `recipes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recipes` (
  `rec_id` int(11) NOT NULL AUTO_INCREMENT,
  `R_name` varchar(100) NOT NULL,
  `Descr` text,
  `Instructions` text,
  `R_category` varchar(50) DEFAULT NULL,
  `Time` int(11) DEFAULT NULL,
  `Level` varchar(20) DEFAULT NULL,
  `Cuisine` varchar(50) DEFAULT NULL,
  `Protein` decimal(5,2) DEFAULT NULL,
  `Carbs` decimal(5,2) DEFAULT NULL,
  `Fats` decimal(5,2) DEFAULT NULL,
  `Sugar` decimal(5,2) DEFAULT NULL,
  `Fibre` decimal(5,2) DEFAULT NULL,
  `Calories` decimal(6,2) DEFAULT NULL,
  PRIMARY KEY (`rec_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recipes`
--

LOCK TABLES `recipes` WRITE;
/*!40000 ALTER TABLE `recipes` DISABLE KEYS */;
INSERT INTO `recipes` VALUES (1,'Thai Coconut Curry Soup','A creamy vegan soup with coconut milk, lemongrass, and veggies - light yet full of flavor.','1. Heat coconut oil in a pot and saut‚ minced garlic, ginger, and lemongrass for 1 minute.\n\n     2. Add sliced mushrooms, carrots, and bell peppers; stir-fry for 3-4 minutes.\n\n     3. Pour in coconut milk and vegetable broth, then add curry paste and soy sauce.\n\n     4. Simmer for 10 minutes on medium heat.\n\n     5. Add lime juice, stir well, and top with fresh coriander and chili flakes before serving hot.','Vegan',25,'Medium','Thai',7.00,20.00,14.00,5.00,3.00,220.00),(2,'Oats Banana Pancakes','Fluffy, wholesome pancakes made from oats and ripe bananas - perfect for breakfast.','1. Blend rolled oats into fine flour.\n\n     2. In a mixing bowl, mash ripe bananas and add oat flour, milk, honey, and baking powder.\n\n     3. Mix until smooth; add more milk if batter is too thick.\n\n     4. Heat a pan with a little butter and pour one ladle of batter.\n\n     5. Cook until bubbles form, then flip and cook until golden brown.\n\n     6. Serve with honey, peanut butter, or sliced fruits on top.','Veg',20,'Easy','Continental',11.00,55.00,9.00,14.00,5.00,320.00),(3,'Chicken Shawarma Wrap','Juicy spiced chicken wrapped with vegetables and garlic sauce in pita bread.','1. Marinate chicken strips with yogurt, lemon juice, garlic, cumin, paprika, and salt for 1 hour.\n\n     2. Grill or pan-fry chicken until golden brown.\n\n     3. Warm pita bread and spread garlic sauce or hummus.\n\n     4. Add sliced lettuce, tomatoes, onions, and the cooked chicken.\n\n     5. Roll tightly and toast lightly on a pan.\n\n     6. Slice and serve warm with fries or salad.','Non-Veg',35,'Medium','Middle Eastern',32.00,45.00,12.00,6.00,4.00,390.00),(4,'Chia Seed Pudding','A creamy, no-cook dessert made with chia seeds and almond milk - rich in omega-3 and fiber.','1. In a bowl, combine chia seeds, almond milk, vanilla extract, and maple syrup.\n\n     2. Stir well to avoid lumps and refrigerate for at least 4 hours (or overnight).\n\n     3. Once thickened, stir again and adjust sweetness if needed.\n\n     4. Layer with fruit puree or fresh berries before serving chilled.','Vegan',10,'Easy','Continental',8.00,25.00,7.00,10.00,8.00,210.00),(5,'Palak Egg Curry','A protein-rich Indian curry made by combining boiled eggs with creamy spinach gravy.','1. Boil eggs, peel them, and lightly fry in oil until golden.\n\n     2. Blanch spinach leaves and blend into a smooth puree.\n\n     3. In a pan, heat oil and saut‚ onions, garlic, and ginger until soft.\n\n     4. Add tomatoes, chili powder, turmeric, and garam masala. Cook till oil separates.\n\n     5. Add spinach puree, salt, and « cup water. Simmer for 5 minutes.\n\n     6. Add fried eggs and simmer for another 3 minutes.\n\n     7. Serve hot with rice or roti.','Non-Veg',30,'Medium','Indian',22.00,18.00,12.00,4.00,4.00,260.00),(6,'Quinoa Bowl with Chickpeas','A protein-packed vegan bowl combining quinoa, chickpeas, and greens for a wholesome meal.','1. Rinse quinoa thoroughly and cook it in 2 cups of water until soft and fluffy (about 15 minutes).\n\n     2. In a mixing bowl, combine cooked quinoa with boiled chickpeas.\n\n     3. Add chopped spinach, diced cucumber, and halved cherry tomatoes.\n\n     4. For dressing, whisk together tahini, lemon juice, olive oil, salt, and pepper.\n\n     5. Pour the dressing over the mixture and toss gently to coat evenly.\n\n     6. Garnish with sesame seeds or coriander leaves and serve warm or chilled.','Vegan',30,'Medium','Mediterranean',18.00,40.00,9.00,4.00,7.00,310.00),(7,'Paneer Biryani','Rich and aromatic rice layered with marinated paneer and spices.','1. Cook basmati rice till 90% done.\n\n     2. Marinate paneer with yogurt, biryani masala, and salt; rest for 30 minutes.\n\n     3. Fry onions till golden and set aside.\n\n     4. In a pot, layer rice, paneer, fried onions, mint, and saffron milk.\n\n     5. Cover and cook on low heat for 15 minutes.\n\n     6. Serve hot with raita.','Veg',60,'Hard','Indian',22.00,65.00,18.00,4.00,5.50,620.00),(8,'Vegetable Lasagna','Layered pasta baked with vegetables, tomato sauce, and cheese.','1. Boil lasagna sheets until tender.\n\n     2. Saut‚ onions, garlic, bell peppers, and zucchini.\n\n     3. In a baking tray, layer pasta, tomato sauce, veggies, and cheese.\n\n     4. Repeat layers and top with cheese.\n\n     5. Bake at 180øC for 25 minutes until golden.','Veg',75,'Hard','Italian',20.00,58.00,22.00,6.00,4.00,640.00),(9,'Thai Basil Tofu','Crispy tofu stir-fried with vegetables and basil leaves in spicy soy sauce.','1. Fry tofu until crisp and golden.\n\n     2. Saut‚ garlic, chili, and onions in sesame oil.\n\n     3. Add bell peppers and stir-fry for 2 minutes.\n\n     4. Add soy sauce, basil leaves, and cooked tofu.\n\n     5. Toss and serve hot with jasmine rice.','Vegan',50,'Hard','Thai',25.00,32.00,14.00,5.00,3.80,400.00),(10,'Soya Chunks Curry','Protein-rich curry made with soya nuggets cooked in tomato gravy.','1. Boil soya chunks and squeeze excess water.\n\n     2. Saut‚ onions, ginger, and garlic until golden.\n\n     3. Add tomatoes and spices; cook till oil separates.\n\n     4. Add soya chunks and simmer for 10 minutes.\n\n     5. Garnish with coriander and serve.','Vegan',35,'Medium','Indian',32.00,28.00,12.00,3.00,5.50,380.00),(11,'Shahi Paneer','Rich and creamy curry made with paneer, cream, and cashew paste.','1. Soak cashews in warm water and blend with cream to form a paste.\n\n     2. Saut‚ onions, tomatoes, and spices in butter.\n\n     3. Add cashew-cream paste and cook till thick.\n\n     4. Add paneer cubes and simmer for 5 minutes.\n\n     5. Serve hot with naan.','Veg',40,'Medium','Indian',18.00,28.00,32.00,5.50,3.00,720.00),(12,'Paneer Butter Masala','Creamy tomato-based gravy cooked with butter and paneer cubes.','1. Saut‚ onions, garlic, and tomatoes in butter.\n\n     2. Blend the mixture into a smooth puree.\n\n     3. Add cream, spices, and paneer cubes.\n\n     4. Simmer for 5 minutes and garnish with coriander.\n\n     5. Serve hot with naan or rice.','Veg',45,'Medium','Indian',21.00,34.00,28.00,5.00,3.20,690.00),(13,'Aloo Paratha','Whole wheat flatbread stuffed with spicy mashed potatoes.','1. Prepare dough using wheat flour and water.\n\n     2. Boil and mash potatoes; add salt, coriander, and chili.\n\n     3. Stuff dough with potato mix and roll into parathas.\n\n     4. Cook on tawa with ghee until golden on both sides.','Veg',25,'Easy','Indian',9.00,48.00,14.00,3.50,4.00,380.00),(14,'Kheer','Sweet Indian rice pudding made with milk, rice, and nuts.','1. Boil milk and add cooked rice.\n\n     2. Add sugar, cardamom, and simmer until thick.\n\n     3. Stir in dry fruits and cook 5 more minutes.\n\n     4. Serve warm or chilled.','Veg',35,'Easy','Indian',10.00,48.00,12.00,22.00,1.00,320.00),(15,'Chocolate Brownie','Fudgy chocolate dessert baked with butter and cocoa powder.','1. Melt butter and mix with cocoa powder and sugar.\n\n     2. Add flour, baking powder, and egg substitute.\n\n     3. Mix into thick batter and pour into tray.\n\n     4. Bake at 180øC for 25 minutes.\n\n     5. Cool and cut into squares.','Veg',30,'Medium','American',6.00,40.00,18.00,28.00,2.00,370.00);
/*!40000 ALTER TABLE `recipes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reviews`
--

DROP TABLE IF EXISTS `reviews`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reviews` (
  `rev_id` int(11) NOT NULL AUTO_INCREMENT,
  `rec_id` int(11) DEFAULT NULL,
  `reviews` text,
  `ratings` decimal(2,1) DEFAULT NULL,
  PRIMARY KEY (`rev_id`),
  KEY `rec_id` (`rec_id`),
  CONSTRAINT `reviews_ibfk_1` FOREIGN KEY (`rec_id`) REFERENCES `recipes` (`rec_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reviews`
--

LOCK TABLES `reviews` WRITE;
/*!40000 ALTER TABLE `reviews` DISABLE KEYS */;
INSERT INTO `reviews` VALUES (1,4,'not like at all.',3.4),(2,4,'ert',3.0),(3,4,'tfuk',4.0),(4,4,'hsrht',4.8),(5,4,'I really liked this.',4.5);
/*!40000 ALTER TABLE `reviews` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `selected`
--

DROP TABLE IF EXISTS `selected`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `selected` (
  `u_id` int(11) NOT NULL DEFAULT '0',
  `rec_id` int(11) NOT NULL DEFAULT '0',
  `date` date NOT NULL DEFAULT '0000-00-00',
  PRIMARY KEY (`u_id`,`rec_id`,`date`),
  KEY `rec_id` (`rec_id`),
  CONSTRAINT `selected_ibfk_1` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`) ON DELETE CASCADE,
  CONSTRAINT `selected_ibfk_2` FOREIGN KEY (`rec_id`) REFERENCES `recipes` (`rec_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `selected`
--

LOCK TABLES `selected` WRITE;
/*!40000 ALTER TABLE `selected` DISABLE KEYS */;
INSERT INTO `selected` VALUES (1,1,'2025-11-04'),(4,1,'2025-11-04'),(4,2,'2025-11-07'),(7,2,'2025-11-04'),(4,6,'2025-11-04'),(4,11,'2025-11-04'),(4,12,'2025-11-04');
/*!40000 ALTER TABLE `selected` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = latin1 */ ;
/*!50003 SET character_set_results = latin1 */ ;
/*!50003 SET collation_connection  = latin1_swedish_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER set_selected_date
BEFORE INSERT ON Selected
FOR EACH ROW
BEGIN
    SET NEW.date= CURRENT_DATE;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `u_id` int(11) NOT NULL AUTO_INCREMENT,
  `UF_name` varchar(50) NOT NULL,
  `UM_name` varchar(50) DEFAULT NULL,
  `UL_name` varchar(50) DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `dob` date DEFAULT NULL,
  `weight` decimal(5,2) DEFAULT NULL,
  `contact_no` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`u_id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Aarav','Kumar','Sharma','aarav.sharma@gmail.com','pass123','2001-05-10',68.50,'9876543210'),(2,'Priya','Ravi','Patel','priya.patel@gmail.com','priya@321','1999-12-22',54.30,'9988776655'),(3,'Rohan','Singh',NULL,'rohan.singh@yahoo.com','rohan789','2000-08-17',72.00,'9123456780'),(4,'Neha','Kiran','Joshi','neha.joshi@gmail.com','neha2024','2002-03-05',60.40,'9001122334'),(5,'Vikram',NULL,'Das','vikram.das@gmail.com','vikram@999','1998-11-01',80.20,'9090909090'),(6,'Ketaki','Sachin','Bhate','ketaki@gmail.com','ket@123','2009-09-09',56.00,'87962178'),(7,'Shreya ','Pravin','Dhage','s@gmail.com','s@123','2009-09-08',67.00,'7965354625'),(8,'Fatima',NULL,'Khan','f@gmail.com','f@123','2004-04-15',78.00,NULL),(9,'Saumya',NULL,'Belgi','s.@gmail.com','s@123','2006-01-05',70.00,NULL),(10,'Geeta',NULL,'Ambekar','geet@gmail.com','g@123','2006-01-02',70.00,NULL),(11,'Harshad',NULL,'Deo','h123@gmail.com','h@123','0200-03-03',70.00,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_allergies`
--

DROP TABLE IF EXISTS `user_allergies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_allergies` (
  `u_id` int(11) NOT NULL DEFAULT '0',
  `allergy` varchar(100) NOT NULL DEFAULT '',
  PRIMARY KEY (`u_id`,`allergy`),
  CONSTRAINT `user_allergies_ibfk_1` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_allergies`
--

LOCK TABLES `user_allergies` WRITE;
/*!40000 ALTER TABLE `user_allergies` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_allergies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_health_concerns`
--

DROP TABLE IF EXISTS `user_health_concerns`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_health_concerns` (
  `u_id` int(11) NOT NULL DEFAULT '0',
  `health_concern` varchar(100) NOT NULL DEFAULT '',
  PRIMARY KEY (`u_id`,`health_concern`),
  CONSTRAINT `user_health_concerns_ibfk_1` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_health_concerns`
--

LOCK TABLES `user_health_concerns` WRITE;
/*!40000 ALTER TABLE `user_health_concerns` DISABLE KEYS */;
INSERT INTO `user_health_concerns` VALUES (1,'cholesterol'),(2,'diabetes'),(3,'thyroid'),(8,'Diabetes'),(8,'Thyroid'),(9,'Diabetes'),(9,'Thyroid'),(10,'Cholesterol'),(11,'Heart Disease'),(11,'Lactose Intolerance'),(11,'Thyroid');
/*!40000 ALTER TABLE `user_health_concerns` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-03-13 18:35:34
