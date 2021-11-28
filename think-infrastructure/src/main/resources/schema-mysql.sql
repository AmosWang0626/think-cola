SET NAMES utf8mb4;

-- ----------------------------
-- Table structure for org_user
-- ----------------------------
CREATE TABLE IF NOT EXISTS `org_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `info_id` varchar(255) DEFAULT NULL,
  `delete_flag` bit(1) NOT NULL,
  `creator` varchar(255) DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `modifier` varchar(255) DEFAULT NULL,
  `gmt_modify` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_username` (`username`),
  KEY `idx_info_id` (`info_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for org_user_info
-- ----------------------------
CREATE TABLE IF NOT EXISTS `org_user_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `phone_no` varchar(255) DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

