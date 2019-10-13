/*
 Navicat Premium Data Transfer

 Source Server         : MysqlConnect
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : localhost:3306
 Source Schema         : javaweb_servlet

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 13/10/2019 19:04:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `gender` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(255) NULL DEFAULT NULL,
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `qq` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '张三', '男', 13, '山西', '12345', 'shangsan@figo.cn', 'zhangsan', '123');
INSERT INTO `user` VALUES (2, '李四', '女', 15, '北京', '88888', 'lisi@figo.cn', 'lisi', '234');
INSERT INTO `user` VALUES (10, '王五', '男', 25, '陕西', '66666', 'wangwu@figo.cn', NULL, NULL);
INSERT INTO `user` VALUES (12, '麻七', '男', 18, '陕西', '45345354', 'maqi@figo.com', NULL, NULL);
INSERT INTO `user` VALUES (13, '郑八', '女', 18, '上海', '9999999', 'zhengba@figo.com', NULL, NULL);
INSERT INTO `user` VALUES (14, '钱九', '男', 18, '陕西', '111111', 'qianjiu@figo.com', NULL, NULL);
INSERT INTO `user` VALUES (15, '王五', '男', 25, '陕西', '66666', 'wangwu@figo.cn', NULL, NULL);
INSERT INTO `user` VALUES (16, '王五', '男', 25, '陕西', '66666', 'wangwu@figo.cn', NULL, NULL);
INSERT INTO `user` VALUES (17, '麻七', '男', 18, '陕西', '45345354', 'maqi@figo.com', NULL, NULL);
INSERT INTO `user` VALUES (18, '郑八', '女', 18, '上海', '9999999', 'zhengba@figo.com', NULL, NULL);
INSERT INTO `user` VALUES (19, '冯十', '男', 18, '陕西', '111111', 'fengshi@figo.com', NULL, NULL);
INSERT INTO `user` VALUES (20, '赵六', '男', 25, '陕西', '66666', 'zhaoliu@figo.cn', NULL, NULL);
INSERT INTO `user` VALUES (21, '王五', '男', 25, '陕西', '66666', 'wangwu@figo.cn', NULL, NULL);
INSERT INTO `user` VALUES (22, '麻七', '男', 18, '陕西', '45345354', 'maqi@figo.com', NULL, NULL);
INSERT INTO `user` VALUES (23, '郑八', '女', 18, '上海', '9999999', 'zhengba@figo.com', NULL, NULL);
INSERT INTO `user` VALUES (24, '冯十', '男', 18, '陕西', '111111', 'fengshi@figo.com', NULL, NULL);
INSERT INTO `user` VALUES (25, '赵六', '男', 25, '陕西', '66666', 'zhaoliu@figo.cn', NULL, NULL);
INSERT INTO `user` VALUES (26, '王五', '男', 25, '陕西', '66666', 'wangwu@figo.cn', NULL, NULL);
INSERT INTO `user` VALUES (27, '麻七', '男', 18, '陕西', '45345354', 'maqi@figo.com', NULL, NULL);
INSERT INTO `user` VALUES (28, '郑八', '女', 18, '上海', '9999999', 'zhengba@figo.com', NULL, NULL);
INSERT INTO `user` VALUES (29, '冯十', '男', 18, '陕西', '111111', 'fengshi@figo.com', NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
