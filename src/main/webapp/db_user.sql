/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50623
Source Host           : 127.0.0.1:3306
Source Database       : db_user

Target Server Type    : MYSQL
Target Server Version : 50623
File Encoding         : 65001

Date: 2017-03-08 13:37:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `number` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `lastLoginTime` datetime DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('0000000006', '11116', ' zhaoliu21', 'zhaoliu', '傲视', '离线', '2017-03-05 19:48:51', '1899-12-31 00:00:00', '老师');
INSERT INTO `t_user` VALUES ('0000000008', '10009', 'lijiu', 'lijiu', '傻逼', '离线', '2017-03-04 00:00:00', '1899-12-31 00:00:00', '学生');
INSERT INTO `t_user` VALUES ('0000000013', '111111', ' zhang', '121', '老师', '离线', '2017-03-10 00:00:00', null, '学生');
INSERT INTO `t_user` VALUES ('0000000014', '9090', '0ppp', 'll', 'haha', '离线', '2017-03-08 00:00:00', null, '老师');
INSERT INTO `t_user` VALUES ('0000000015', '109090', 'hh', 'hh', '32', '离线', '2017-03-08 11:02:25', null, '学生');
INSERT INTO `t_user` VALUES ('0000000018', '1111', '1111', '1111', '1111', '在线', '2017-03-08 13:05:17', '2017-03-08 13:32:56', '管理员');
