/*
 Navicat Premium Data Transfer

 Source Server         : MyConn
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : heibi_vote

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 20/08/2021 01:08:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `wechat_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_vote_relationship
-- ----------------------------
DROP TABLE IF EXISTS `user_vote_relationship`;
CREATE TABLE `user_vote_relationship` (
  `user_id` int(11) NOT NULL,
  `vote_id` int(11) NOT NULL,
  `vote_option_id` int(11) NOT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`user_id`,`vote_id`,`vote_option_id`) USING BTREE,
  KEY `f_vote_id` (`vote_id`),
  KEY `f_option_id` (`vote_option_id`),
  CONSTRAINT `f_option_id` FOREIGN KEY (`vote_option_id`) REFERENCES `vote_option` (`id`),
  CONSTRAINT `f_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `f_vote_id` FOREIGN KEY (`vote_id`) REFERENCES `vote` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for vote
-- ----------------------------
DROP TABLE IF EXISTS `vote`;
CREATE TABLE `vote` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `wechat_id` varchar(50) NOT NULL,
  `title` varchar(30) NOT NULL,
  `description` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `type` int(11) NOT NULL,
  `pic_url` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `status` int(11) NOT NULL,
  `cut_off_time` datetime NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for vote_option
-- ----------------------------
DROP TABLE IF EXISTS `vote_option`;
CREATE TABLE `vote_option` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `vote_id` int(11) NOT NULL,
  `option_content` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `picture_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `f_vote_id_2` (`vote_id`),
  CONSTRAINT `f_vote_id_2` FOREIGN KEY (`vote_id`) REFERENCES `vote` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
