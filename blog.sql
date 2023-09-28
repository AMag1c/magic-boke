-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: blog
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `article` (
  `article_id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) NOT NULL,
  `article_details` varchar(200) NOT NULL,
  `article_transmit` int DEFAULT '0',
  `article_discuss` int DEFAULT '0',
  `article_like` int DEFAULT '0',
  ` create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `modify_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`article_id`),
  UNIQUE KEY `article_article_id_uindex` (`article_id`),
  KEY `article_user_user_name_fk` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` VALUES (1,'magic','之前给大家简单科普了什么是复杂科学，这次我跟大家聊聊复杂科学中各自的观点。复杂科学目前其实有三个流派，现在国内学界热捧的复杂经济学，只是其中的一个流派 #',0,0,0,'2022-06-09 21:00:31','2022-06-09 13:00:31'),(2,'magic','【AI产生了多余的情感】反乌托邦游戏《Justice.exe》即将在Steam开启抢先体验，现已有免费试玩Demo，支持中文。玩家将在2279年的法庭上，为产生了感情的AI进行辩护，争取权益。收集信息，与证人交谈，为出庭做准备；用智谋、魅力和诡计与对方律师交锋。看起来微不足道的选择，也足以让委托人的命运发生',0,0,0,'2022-06-09 21:01:05','2022-06-09 13:01:05'),(3,'magic','文科一般全国统一，语文数理化啥的，但今年武科，海南去年是考煮文昌鸡和游泳，今年考爬椰子树和钓鱼，所以武科压题，',0,0,0,'2022-06-09 21:01:57','2022-06-09 13:01:57'),(4,'magic','老机型还有多少在用的？\n小米Note的2K屏幕、小米5的陶瓷背板、小米11 Pro的大底GN2、小米12 Pro的120W充电，你对哪个配置点感知/需求更强？ ',0,0,0,'2022-06-09 21:02:25','2022-06-09 13:02:25'),(5,'magic','【Steam新作】《The Fold: Ingression》\n【发售时间】今年第四季度\n【游戏简介】克苏鲁神话恐怖冒险游戏，灵感来自北欧神话、挪威传说以及洛夫克拉夫特世界观中的恐怖元素。2020年，阿穆·威雷在挪威泰勒马克海岸找到一份木条教堂临时看守的工作。他发现自己置身于陌生诡异的环境之中，这里似乎不止',0,0,0,'2022-06-09 21:02:41','2022-06-09 13:02:41'),(6,'magic','【XGP推出新试玩服务！可免费试玩未发行游戏】在微软举办的“What’s Next for Gaming”媒体沟通会上，官方公布了针对于XGP用户和独立游戏开发者的试玩服务“Project Moorcroft”。通过此服务玩家可以提前游玩未发行以及正在开发中游戏的Demo。Project Moorcroft计划于明年推出',0,0,0,'2022-06-09 21:02:50','2022-06-09 13:02:50'),(7,'日报','给大家分享一个省钱好习惯：看买家秀。很多产品在渲染图里非常精致美丽，让人很想拥有，但是当你在买家秀里看到这些产品在昏暗发绿的灯光下，被没有擦干净指纹印的手机摄像头拍下的模糊样子时，再强烈的购买欲望也会只剩下十分之一',0,0,0,'2022-06-09 21:04:05','2022-06-09 13:04:05'),(8,'日报','【美不胜收！#山西七彩盐湖美如调色板仲夏时节，随着气温的回升，山西运城的盐湖呈现出色彩斑斓的美丽景观，其高饱和度的色彩美若童话，令人陶醉！#夏日盐湖就像打翻了调色板# ​​​',0,0,0,'2022-06-09 21:04:51','2022-06-09 13:04:51'),(9,'日报','以6款极具盛名的雕为原型，博物推出了天然猛禽系列雕模型，复刻雕们走路时的样子，充满必胜的气息！今天有的考生高考结束了，祝各位和雕一样，猛禽振翅凌空飞，天高地阔任你翔。关注转发本微博抽6人各送雕实体模型1个，或戳这里把雕领回家',0,0,0,'2022-06-09 21:05:25','2022-06-09 13:05:25'),(10,'测评','今天在使用OPPO Pad Air和联想小新Pad的时候，发现OPPO配套的手写笔也可以直接在小新上使用~并且在小新Pad上也有压感，不需要蓝牙连接，全靠笔尖的磁力，还有悬浮的笔尖点，虽然有轻微的断触，不过不影响大致的使用',0,3,6,'2022-06-09 21:08:40','2022-06-14 16:40:11'),(11,'测评','手机释放性能的同时，发热是不可避免的。火龙这个名号已经不是一天两天了，本期为极客娱乐向视频，探究下一个手机处理器到底可以有多热？选择了几款争议较多的“火龙”SoC，这次追溯到810、820，以及最近的骁龙888、骁龙8。小小的手机芯片能到多少度？本期给你',0,0,0,'2022-06-09 21:10:57','2022-06-09 13:10:57'),(12,'测评','手机释放性能的同时，发热是不可避免的。火龙这个名号已经不是一天两天了，本期为极客娱乐向视频，探究下一个手机处理器到底可以有多热？选择了几款争议较多的“火龙”SoC，这次追溯到810、820，以及最近的骁龙888、骁龙8',0,0,0,'2022-06-09 21:11:10','2022-06-09 13:11:10'),(13,'怪零','今天在使用OPPO Pad Air和联想小新Pad的时候，发现OPPO配套的手写笔也可以直接在小新上使用~并且在小新Pad上也有压感，不需要蓝牙连接，全靠笔尖的磁力，还有悬浮的笔尖点，虽然有轻微的断触，不过不影响大致的使用',0,0,0,'2022-06-09 21:12:23','2022-06-09 13:12:23'),(14,'怪零','中国信息通信研究院推出了个一号通查「一键解绑互联网账号」的功能，目前支持解绑的互联网服务只有 6 个常规主流平台，有些少。\n',0,0,0,'2022-06-09 21:13:24','2022-06-09 13:13:24'),(15,'怪零','截止 6 月 8 日，小白测评数据库之充电榜单「前台显示充入100%电量」用时最快的前4台机型（均为15分钟，并列第一）',0,0,0,'2022-06-09 21:13:39','2022-06-09 13:13:39'),(16,'怪零','市调机构IDC发布的2022年Q1全球可穿戴设备市场报告：总出货量1.053亿台，同比下降3%；耳机类设备下降0.6%；腕带设备下降40.5%（手表增长9.1%，占28%）。具体市场份额TOP5依次是：',0,0,0,'2022-06-09 21:13:50','2022-06-09 13:13:50'),(17,'怪力','刘惜君 唐汉霄《逝去的歌》live\n一个温暖唯美的改编，在旅行团原曲温暖的基础上，把轻摇滚变得更加抒情柔软，更适合刘惜君这样女声声线柔美的风格，以表达对失去的人的怀念治愈内心',0,0,3,'2022-06-09 21:16:57','2022-06-13 00:42:54'),(18,'怪力','CDPR x 扳机社 《赛博朋克2077》世界观衍生动画《赛博朋克 EDGERUNNERS》先导预告片公开，共10集，9月上线Netflix。',0,0,0,'2022-06-09 21:17:04','2022-06-09 13:17:04'),(19,'magic','low low 的 韦德',0,0,0,'2022-06-09 21:40:42','2022-06-09 13:40:42'),(20,'magic','传世美玉和氏璧，化作人间阳维玉!',0,0,0,'2022-06-09 21:40:52','2022-06-09 13:40:52'),(21,'magic','《赛博朋克2077》世界观原创动画《赛博朋克 Edgerunners》预告公开，CDPR x 扳机社联合制作，《普罗米亚》导演「今石洋之」执导，,共十话，预计今年9月上线Netflix!',0,0,0,'2022-06-09 23:38:56','2022-06-09 16:22:27');
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discuss`
--

DROP TABLE IF EXISTS `discuss`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `discuss` (
  `article_id` int DEFAULT NULL,
  `user_name` varchar(20) DEFAULT NULL,
  `discuss_details` varchar(140) NOT NULL,
  `discuss_like` int DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `modify_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  KEY `discuss_article_id_fk` (`article_id`),
  KEY `discuss_user_name_fk` (`user_name`),
  CONSTRAINT `discuss_article_id_fk` FOREIGN KEY (`article_id`) REFERENCES `article` (`article_id`),
  CONSTRAINT `discuss_user_name_fk` FOREIGN KEY (`user_name`) REFERENCES `user` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discuss`
--

LOCK TABLES `discuss` WRITE;
/*!40000 ALTER TABLE `discuss` DISABLE KEYS */;
INSERT INTO `discuss` VALUES (16,'怪力','好1',0,'2022-06-09 21:17:37','2022-06-09 13:17:37'),(14,'怪力','那你可蒸牛！',0,'2022-06-09 21:17:53','2022-06-09 13:17:53'),(8,'怪力','啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊',0,'2022-06-09 21:18:00','2022-06-09 13:18:00'),(18,'怪力','什么蝼蚁',0,'2022-06-09 21:18:12','2022-06-09 13:18:12'),(15,'怪力','非常好',0,'2022-06-09 21:18:23','2022-06-09 13:18:23'),(13,'怪力','我真的服了',0,'2022-06-09 21:18:31','2022-06-09 13:18:31'),(11,'怪力','对对对！，太对啦！',0,'2022-06-09 21:18:43','2022-06-09 13:18:43'),(10,'怪力','打嗝好棒哦',0,'2022-06-09 21:18:56','2022-06-09 13:18:56'),(9,'怪力','打提开始！',0,'2022-06-09 21:19:12','2022-06-09 13:19:12'),(7,'怪力','挖！这你都知道！',0,'2022-06-09 21:19:29','2022-06-09 13:19:29'),(6,'怪力','我是！',0,'2022-06-09 21:19:46','2022-06-09 13:19:46'),(18,'怪零','你真的阴',0,'2022-06-09 21:20:23','2022-06-09 13:20:23'),(18,'magic','asd\n',0,'2022-06-09 21:26:46','2022-06-09 13:26:46'),(18,'magic','小丑！是你哟！',0,'2022-06-09 21:29:54','2022-06-09 13:29:54'),(18,'magic','你中了神魔！',0,'2022-06-09 21:34:49','2022-06-09 13:34:49'),(18,'magic','蒸不蒸的啊',0,'2022-06-09 21:35:02','2022-06-09 13:35:02'),(7,'magic','啊啊啊啊啊啊啊啊啊，受不了了',0,'2022-06-09 21:35:20','2022-06-09 13:35:20'),(5,'magic','高考必胜！',0,'2022-06-09 21:35:36','2022-06-09 13:35:36'),(4,'magic','对了',0,'2022-06-09 21:36:30','2022-06-09 13:36:30'),(2,'测评','你在干神魔！',0,'2022-06-09 21:41:28','2022-06-09 13:41:28'),(20,'测评','jar包',0,'2022-06-09 21:42:22','2022-06-09 13:42:22'),(21,'magic','普罗米亚',0,'2022-06-09 23:43:56','2022-06-09 15:43:56'),(21,'magic','怎么回事！',0,'2022-06-09 23:56:00','2022-06-09 15:56:00'),(20,'magic','要导jar包！',0,'2022-06-09 23:58:12','2022-06-09 15:58:12'),(21,'magic','怎么回事！',0,'2022-06-10 00:18:43','2022-06-09 16:18:43'),(21,'magic','世界观',0,'2022-06-10 00:22:17','2022-06-09 16:22:17'),(17,'magic','a',0,'2022-06-11 01:19:45','2022-06-10 17:19:45'),(17,'magic','评论',0,'2022-06-12 20:48:29','2022-06-12 12:48:29'),(17,'QQQ','NNN',0,'2022-06-13 08:42:54','2022-06-13 00:42:54'),(10,'SSS','YYY',0,'2022-06-13 09:45:17','2022-06-13 01:45:17'),(10,'无尽的黑夜','很牛哦',0,'2022-06-14 23:50:20','2022-06-14 16:40:11');
/*!40000 ALTER TABLE `discuss` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) NOT NULL,
  `user_password` varchar(20) NOT NULL,
  `user_email` varchar(40) NOT NULL,
  `user_image` varchar(40) DEFAULT NULL,
  `user_introduction` varchar(50) DEFAULT '传世美玉和氏璧，化作人间阳维玉!',
  `user_fannum` int DEFAULT '0',
  `user_attentionnum` int DEFAULT '0',
  PRIMARY KEY (`user_name`),
  UNIQUE KEY `User_UserName_uindex` (`user_name`),
  UNIQUE KEY `User_ID_uindex` (`user_id`),
  UNIQUE KEY `User_ID_uindex_2` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'magic','123','123123',NULL,'666666666',2,1),(7,'QQQ','123','4444444444444444444',NULL,'传世美玉和氏璧，化作人间阳维玉!',0,1),(6,'SL110','123','1111111111111',NULL,'传世美玉和氏璧，化作人间阳维玉!',0,1),(8,'SSS','123','11111111',NULL,'传世美玉和氏璧，化作人间阳维玉!',0,2),(5,'怪力','123','111111111111111',NULL,'传世美玉和氏璧，化作人间阳维玉!',0,0),(4,'怪零','123','1111111111111',NULL,'传世美玉和氏璧，化作人间阳维玉!',0,0),(11,'无尽的黑夜','111','9871413544@126.com',NULL,'传世美玉和氏璧，化作人间阳维玉!',0,1),(2,'日报','123','22222222222222',NULL,'传世美玉和氏璧，化作人间阳维玉!',1,0),(3,'测评','123','111111111111111111',NULL,'传世美玉和氏璧，化作人间阳维玉!',3,0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_fan`
--

DROP TABLE IF EXISTS `user_fan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_fan` (
  `user_name` varchar(20) NOT NULL,
  `fan_name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_fan`
--

LOCK TABLES `user_fan` WRITE;
/*!40000 ALTER TABLE `user_fan` DISABLE KEYS */;
INSERT INTO `user_fan` VALUES ('测评','magic'),('magic','SL110'),('magic','QQQ'),('测评','SSS'),('日报','SSS'),('测评','无尽的黑夜');
/*!40000 ALTER TABLE `user_fan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_focus`
--

DROP TABLE IF EXISTS `user_focus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_focus` (
  `user_name` varchar(20) NOT NULL,
  `follow_name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_focus`
--

LOCK TABLES `user_focus` WRITE;
/*!40000 ALTER TABLE `user_focus` DISABLE KEYS */;
INSERT INTO `user_focus` VALUES ('magic','测评'),('SL110','magic'),('QQQ','magic'),('SSS','测评'),('SSS','日报'),('无尽的黑夜','测评');
/*!40000 ALTER TABLE `user_focus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_like`
--

DROP TABLE IF EXISTS `user_like`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_like` (
  `user_name` varchar(20) DEFAULT NULL,
  `article_id` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_like`
--

LOCK TABLES `user_like` WRITE;
/*!40000 ALTER TABLE `user_like` DISABLE KEYS */;
INSERT INTO `user_like` VALUES ('magic',17),('magic',10),('magic',10),('无尽的黑夜',10),('无尽的黑夜',10),('无尽的黑夜',10),('无尽的黑夜',10),('无尽的黑夜',10);
/*!40000 ALTER TABLE `user_like` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_photo`
--

DROP TABLE IF EXISTS `user_photo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_photo` (
  `photo_id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) NOT NULL,
  `photo_path` varchar(50) NOT NULL,
  PRIMARY KEY (`photo_id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_photo`
--

LOCK TABLES `user_photo` WRITE;
/*!40000 ALTER TABLE `user_photo` DISABLE KEYS */;
INSERT INTO `user_photo` VALUES (43,'magic','image/16547731917011587692826320.jpg'),(44,'magic','image/16547734068171587692826320.jpg'),(45,'magic','image/16547814258791587692826320.jpg'),(46,'magic','image/16547814355361587692826320.jpg'),(47,'magic','image/16547814456111587692826320.jpg'),(48,'测评','image/16547821070001587692826320.jpg'),(49,'magic','image/16547903145881587692826320.jpg'),(50,'SSS','image/16550849156841587692826320.jpg');
/*!40000 ALTER TABLE `user_photo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-18 18:11:45
