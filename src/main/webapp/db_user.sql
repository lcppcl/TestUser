/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50623
Source Host           : 127.0.0.1:3306
Source Database       : db_user

Target Server Type    : MYSQL
Target Server Version : 50623
File Encoding         : 65001

Date: 2017-03-08 13:55:38
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
INSERT INTO `t_user` VALUES ('0000000013', '111111', ' 赵倩', 'zhaoqian', '老师', '离线', '2017-03-10 00:00:00', null, '老师');
INSERT INTO `t_user` VALUES ('0000000014', '9090', '小刘', 'xiaoliu', '学生', '离线', '2017-03-08 00:00:00', null, '学生');
INSERT INTO `t_user` VALUES ('0000000015', '109090', '吴琼', 'wuqiong', '学生', '离线', '2017-03-08 11:02:25', null, '学生');
INSERT INTO `t_user` VALUES ('0000000018', '1111', '1111', '1111', '1111', '在线', '2017-03-08 13:05:17', '2017-03-08 13:55:15', '管理员');
