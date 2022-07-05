/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80019
Source Host           : localhost:3306
Source Database       : lizhi_task

Target Server Type    : MYSQL
Target Server Version : 80019
File Encoding         : 65001

Date: 2022-07-06 00:24:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity` (
  `activity_id` int NOT NULL AUTO_INCREMENT COMMENT '活动自增id',
  `activity_name` varchar(50) DEFAULT NULL COMMENT '活动名称',
  `start_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '活动开始时间',
  `end_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '活动结束时间',
  `note` varchar(255) DEFAULT NULL COMMENT '活动备注',
  PRIMARY KEY (`activity_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of activity
-- ----------------------------
INSERT INTO `activity` VALUES ('1', '积分活动1', '2022-07-03 13:40:01', '2022-07-03 13:40:01', '备注1');
INSERT INTO `activity` VALUES ('2', '积分活动2', '2022-07-03 13:40:07', '2022-07-03 13:40:07', '备注2');
INSERT INTO `activity` VALUES ('3', '积分活动3', '2022-07-05 23:50:00', '2022-07-06 22:30:00', '积分活动3备注');
INSERT INTO `activity` VALUES ('4', '积分活动3', '2022-07-05 23:49:54', '2022-07-06 07:30:00', '积分活动3备注');
INSERT INTO `activity` VALUES ('5', '积分活动3', '2022-07-05 23:50:07', '2022-07-06 04:30:00', '积分活动3备注');

-- ----------------------------
-- Table structure for sign
-- ----------------------------
DROP TABLE IF EXISTS `sign`;
CREATE TABLE `sign` (
  `sign_id` int NOT NULL AUTO_INCREMENT COMMENT '签到表自增id',
  `user_id` int DEFAULT NULL COMMENT '用户id',
  `activity_id` int DEFAULT NULL COMMENT '活动id',
  `sign_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '签到时间',
  `note` varchar(255) DEFAULT NULL COMMENT '签到备注',
  PRIMARY KEY (`sign_id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sign
-- ----------------------------
INSERT INTO `sign` VALUES ('1', '1', '1', '2022-07-03 13:40:24', '签到1');
INSERT INTO `sign` VALUES ('2', '1', '2', '2022-07-03 13:41:49', null);
INSERT INTO `sign` VALUES ('3', '1', '1', '2022-07-03 13:42:01', null);
INSERT INTO `sign` VALUES ('4', '1', '1', '2022-07-03 13:42:08', null);
INSERT INTO `sign` VALUES ('5', '1', '1', '2022-07-02 13:42:17', null);
INSERT INTO `sign` VALUES ('6', '1', '2', '2022-07-03 13:42:33', null);
INSERT INTO `sign` VALUES ('7', '1', '2', '2022-07-01 13:42:41', null);
INSERT INTO `sign` VALUES ('8', '1', '1', '2022-07-03 13:42:51', null);
INSERT INTO `sign` VALUES ('9', '1', '1', '2022-07-03 13:42:55', null);
INSERT INTO `sign` VALUES ('10', '1', '1', '2022-07-03 13:42:59', null);
INSERT INTO `sign` VALUES ('11', '1', '2', '2022-07-01 13:43:02', null);
INSERT INTO `sign` VALUES ('12', '3', '1', '2022-07-01 13:43:18', null);
INSERT INTO `sign` VALUES ('13', '1', '2', '2022-07-03 13:43:26', null);
INSERT INTO `sign` VALUES ('14', '1', '1', '2022-07-03 14:59:47', null);
INSERT INTO `sign` VALUES ('15', '1', '2', '2022-07-03 13:43:52', null);
INSERT INTO `sign` VALUES ('16', '1', '1', '2022-06-30 13:43:59', null);
INSERT INTO `sign` VALUES ('17', '1', '1', '2022-07-02 08:44:26', null);
INSERT INTO `sign` VALUES ('18', '3', '1', '2022-07-03 13:44:54', null);
INSERT INTO `sign` VALUES ('19', '3', '2', '2022-07-03 13:45:00', null);
INSERT INTO `sign` VALUES ('20', '3', '1', '2022-07-01 13:45:08', null);
INSERT INTO `sign` VALUES ('21', '1', '1', '2022-07-03 13:45:41', null);
INSERT INTO `sign` VALUES ('22', '1', '1', '2022-07-03 13:45:44', null);
INSERT INTO `sign` VALUES ('23', '1', '4', '2022-07-03 16:46:09', '我签到了');
INSERT INTO `sign` VALUES ('24', '1', '4', '2022-07-03 16:46:33', '我签到了');
INSERT INTO `sign` VALUES ('25', '1', '4', '2022-07-03 16:46:36', '我签到了');
INSERT INTO `sign` VALUES ('26', '1', '4', '2022-07-03 16:46:38', '我签到了');
INSERT INTO `sign` VALUES ('27', '1', '4', '2022-07-03 16:46:41', '我签到了');
INSERT INTO `sign` VALUES ('28', '1', '4', '2022-07-03 16:46:44', '我签到了');
INSERT INTO `sign` VALUES ('29', '1', '4', '2022-07-03 16:46:46', '我签到了');
INSERT INTO `sign` VALUES ('30', '1', '4', '2022-07-03 16:46:49', '我签到了');
INSERT INTO `sign` VALUES ('31', '1', '4', '2022-07-03 16:46:51', '我签到了');
INSERT INTO `sign` VALUES ('32', '1', '4', '2022-07-03 16:46:56', '我签到了');
INSERT INTO `sign` VALUES ('33', '1', '4', '2022-07-03 16:50:47', '我签到了');
INSERT INTO `sign` VALUES ('34', '1', '4', '2022-07-03 16:50:53', '我签到了');
INSERT INTO `sign` VALUES ('35', '1', '4', '2022-07-03 16:50:59', '我签到了');
INSERT INTO `sign` VALUES ('36', '1', '4', '2022-07-03 16:51:24', '我签到了');
INSERT INTO `sign` VALUES ('37', '1', '4', '2022-07-03 16:51:37', '我签到了');
INSERT INTO `sign` VALUES ('38', '1', '4', '2022-07-03 16:51:45', '我签到了');
INSERT INTO `sign` VALUES ('39', '1', '4', '2022-07-03 16:51:58', '我签到了');
INSERT INTO `sign` VALUES ('43', '1', '4', '2022-07-03 16:54:08', '我签到了');
INSERT INTO `sign` VALUES ('44', '1', '4', '2022-07-03 16:54:14', '我签到了');
INSERT INTO `sign` VALUES ('45', '1', '3', '2022-07-05 15:52:39', '我签到了');
INSERT INTO `sign` VALUES ('46', '1', '3', '2022-07-05 15:52:53', '我签到了');
INSERT INTO `sign` VALUES ('47', '2', '3', '2022-07-05 15:53:11', '我签到了');
INSERT INTO `sign` VALUES ('48', '2', '3', '2022-07-05 15:53:41', '我签到了');
INSERT INTO `sign` VALUES ('49', '3', '3', '2022-07-05 15:54:35', '我签到了');
INSERT INTO `sign` VALUES ('50', '3', '3', '2022-07-05 15:54:41', '我签到了');
INSERT INTO `sign` VALUES ('51', '4', '3', '2022-07-05 15:55:51', '我签到了');
INSERT INTO `sign` VALUES ('52', '4', '3', '2022-07-05 15:55:59', '我签到了');
INSERT INTO `sign` VALUES ('53', '4', '3', '2022-07-05 15:58:02', '我签到了');
INSERT INTO `sign` VALUES ('54', '4', '3', '2022-07-05 15:58:58', '我签到了');
INSERT INTO `sign` VALUES ('55', '4', '4', '2022-07-05 15:59:30', '我签到了');
INSERT INTO `sign` VALUES ('56', '4', '5', '2022-07-05 16:00:13', '我签到了');
INSERT INTO `sign` VALUES ('57', '5', '4', '2022-07-05 16:00:47', '我签到了');
INSERT INTO `sign` VALUES ('58', '5', '3', '2022-07-05 16:01:08', '我签到了');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT COMMENT '用户主键自增id',
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `sex` int DEFAULT '1' COMMENT '性别，1：男生  0：女生',
  `age` int DEFAULT NULL COMMENT '年龄',
  `integral_num` int DEFAULT '0' COMMENT '用户积分数',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'mzl', '88888', '1', '23', '40');
INSERT INTO `user` VALUES ('3', 'lisi', '88888', '1', '21', '35');
INSERT INTO `user` VALUES ('4', 'lili', '88888', '0', '22', '30');
INSERT INTO `user` VALUES ('5', 'lizi', '88888', '1', '20', '10');
INSERT INTO `user` VALUES ('6', 'lizhi', '88888', '1', '25', '0');
