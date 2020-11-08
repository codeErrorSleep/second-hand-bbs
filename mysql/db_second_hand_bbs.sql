/*
 Navicat Premium Data Transfer

 Source Server         : a
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : db_second_hand_bbs

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 08/11/2020 12:29:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for adminuser
-- ----------------------------
DROP TABLE IF EXISTS `adminuser`;
CREATE TABLE `adminuser`  (
  `id` bigint(20) NOT NULL,
  `level` int(11) NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of adminuser
-- ----------------------------

-- ----------------------------
-- Table structure for announce
-- ----------------------------
DROP TABLE IF EXISTS `announce`;
CREATE TABLE `announce`  (
  `id` bigint(20) NOT NULL,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `adminuser_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK5j34dekeu7i9uskvauvlngbqf`(`adminuser_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of announce
-- ----------------------------

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` bigint(20) NOT NULL,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `product_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKm1rmnfcvq5mk26li4lit88pc5`(`product_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (36, 'dsfsdaffdasdf', '2020-11-08 11:24:59', 'aaa', 35);
INSERT INTO `comment` VALUES (37, 'adsfasfasdfasfasgfgdfgfd', '2020-11-08 12:21:39', 'aaa', 35);

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence`  (
  `next_val` bigint(20) NULL DEFAULT NULL
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES (38);
INSERT INTO `hibernate_sequence` VALUES (38);
INSERT INTO `hibernate_sequence` VALUES (38);
INSERT INTO `hibernate_sequence` VALUES (38);
INSERT INTO `hibernate_sequence` VALUES (38);
INSERT INTO `hibernate_sequence` VALUES (38);

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `id` bigint(20) NOT NULL,
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `price` double NOT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `wechat` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `user_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKsugxsnh3pn3da0e47omlal622`(`user_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (87, 'dsafsadf', '2019-12-05 22:56:43', 'fserfe@grsfs', '34234', 334, '工具', '化妆类', 'esdfasef', 39);
INSERT INTO `product` VALUES (88, 'ccc', '2019-12-09 10:05:44', '504250439@qq.com', '13138283670', 343, 'dsff', '电器类', 'dfdfdff', 84);
INSERT INTO `product` VALUES (89, 'dsfgsdfg', '2019-12-09 10:06:59', '504250439@qq.com', '13138283670', 200, 'bvbv', '衣物类', 'dfdfdff', 84);
INSERT INTO `product` VALUES (91, 'dafgfsg', '2019-12-09 10:20:17', '504250439@qq.com', '13138283670', 0, 'gggg', '电器类', 'fff', 39);
INSERT INTO `product` VALUES (92, 'dafgfsg', '2019-12-09 10:20:38', '504250439@qq.com', '13138283670', 0, 'gggg', '电器类', 'fff', 39);
INSERT INTO `product` VALUES (93, 'rdsgrds', '2019-12-09 10:21:19', '504250439@qq.com', '13138283670', 0, 'vcvc', '衣物类', 'dfdfdff', 39);
INSERT INTO `product` VALUES (94, 'rdsgrds', '2019-12-09 10:24:41', '504250439@qq.com', '13138283670', 0, 'vcvc', '衣物类', 'dfdfdff', 84);
INSERT INTO `product` VALUES (111, 'dsfgsdfgsd', '2019-12-09 21:10:23', '934387764@qq.com', '13138283670', 4545, 'dsfgds', '书籍类', 'fgf', 39);
INSERT INTO `product` VALUES (110, 'asdfsadf', '2019-12-09 20:56:20', '934387764@qq.com', '13138283670', 2345, 'dfgd', '电器类', 'fff', 40);
INSERT INTO `product` VALUES (122, 'asdfsaf', '2019-12-11 14:02:04', 'asdf@fff.ff', '13138283670', 1324, 'dsafs', '生活类', 'fffaa', 39);
INSERT INTO `product` VALUES (125, '非常新', '2019-12-12 11:00:50', '504250439@qq.com', '13138283670', 123, '鼠标', '电器类', 'fff', 39);
INSERT INTO `product` VALUES (130, 'adfgdg', '2019-12-12 11:11:37', '934387764@qq.com', '13138283670', 324, NULL, '生活类', 'sefseeasf', NULL);
INSERT INTO `product` VALUES (14, '的说法', NULL, '', '', 123, '大师傅第三方', '书籍类', '', 1);
INSERT INTO `product` VALUES (15, '的说法', NULL, '', '', 123, '大师傅第三方', '书籍类', '', 1);
INSERT INTO `product` VALUES (16, 'ef esfaesf aef', '2020-07-29 13:58:42', '', '', 2222, 'asdf asdf asdffaf', '书籍类', '', 1);
INSERT INTO `product` VALUES (17, 'rtyerye', '2020-07-29 14:23:05', '', '', 546, 'ytjy', '书籍类', '', 1);
INSERT INTO `product` VALUES (18, '规范公司 ', '2020-07-29 14:27:57', '', '', 423, '打发', '书籍类', '', 1);
INSERT INTO `product` VALUES (19, '安抚啊啊', '2020-07-29 14:30:06', '', '', 123, '反反复复', '书籍类', '', 1);
INSERT INTO `product` VALUES (35, 'asdfasdfasdfa', '2020-11-08 11:24:52', '', '', 0, 'dsfadfasdfasdf', '书籍类', '', 34);

-- ----------------------------
-- Table structure for product_imgs
-- ----------------------------
DROP TABLE IF EXISTS `product_imgs`;
CREATE TABLE `product_imgs`  (
  `product_id` bigint(20) NOT NULL,
  `imgs` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  INDEX `FKsmqh42bp8h7rj8hq70kwydijl`(`product_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_imgs
-- ----------------------------
INSERT INTO `product_imgs` VALUES (87, '1\\打发\\20200713082645142.jpg');
INSERT INTO `product_imgs` VALUES (88, '1\\打发\\20200713082645142.jpg');
INSERT INTO `product_imgs` VALUES (89, '1\\打发\\20200713082645142.jpg');
INSERT INTO `product_imgs` VALUES (91, '1\\打发\\20200713082645142.jpg');
INSERT INTO `product_imgs` VALUES (92, '1\\打发\\20200713082645142.jpg');
INSERT INTO `product_imgs` VALUES (93, '1\\打发\\20200713082645142.jpg');
INSERT INTO `product_imgs` VALUES (94, '1\\打发\\20200713082645142.jpg');
INSERT INTO `product_imgs` VALUES (111, '1\\打发\\20200713082645142.jpg');
INSERT INTO `product_imgs` VALUES (110, '1\\打发\\20200713082645142.jpg');
INSERT INTO `product_imgs` VALUES (122, '1\\打发\\20200713082645142.jpg');
INSERT INTO `product_imgs` VALUES (122, '1\\打发\\20200713082645142.jpg');
INSERT INTO `product_imgs` VALUES (125, '1\\打发\\20200713082645142.jpg');
INSERT INTO `product_imgs` VALUES (14, '1\\打发\\20200713082645142.jpg');
INSERT INTO `product_imgs` VALUES (15, '1\\打发\\20200713082645142.jpg');
INSERT INTO `product_imgs` VALUES (16, '1\\打发\\20200713082645142.jpg');
INSERT INTO `product_imgs` VALUES (17, '1\\打发\\20200713082645142.jpg');
INSERT INTO `product_imgs` VALUES (18, '1\\打发\\20200713082645142.jpg');
INSERT INTO `product_imgs` VALUES (19, '1\\打发\\20200713082645142.jpg');
INSERT INTO `product_imgs` VALUES (35, 'productsImgs\\34\\dsfadfasdfasdf\\科比2.jpg');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `role_id` int(11) NOT NULL,
  `role_name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `role_key` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `status` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `remark` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `create_by` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, 'ROLE_admin', 'admin', '1', '2020-07-28 14:12:17', '系统最厉害的管理员', 'father', '2020-07-28 14:12:17');
INSERT INTO `sys_role` VALUES (2, 'ROLE_user', 'common', '1', '2020-07-28 14:12:17', '普通用户', NULL, '2020-07-28 14:12:17');
INSERT INTO `sys_role` VALUES (11, '搜狗是s', '森岛帆高', NULL, '2020-07-29 10:54:24', '个搜狗是', NULL, NULL);
INSERT INTO `sys_role` VALUES (12, 'ssss', 'ffff', NULL, NULL, '个搜狗是f', NULL, '2020-07-29 11:24:58');
INSERT INTO `sys_role` VALUES (13, 'gggggggg', 'gggggggg', NULL, NULL, '个搜狗是', NULL, '2020-07-29 11:25:57');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `wechat` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sex` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `last_login_time` datetime(0) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `account_non_expired` bit(1) NOT NULL,
  `account_non_locked` bit(1) NOT NULL,
  `credentials_non_expired` bit(1) NOT NULL,
  `enabled` bit(1) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, '504250439@qq.com', '$10$K0Ib6CatTCDVM3EUpiSGm.7VAo/K9YlbGtLwJjXmWaTmBtbeuYe8G', '13138283670', 'father', 'dsfa', NULL, NULL, NULL, b'0', b'0', b'0', b'0');
INSERT INTO `sys_user` VALUES (3, '504250439@qq.com', '$10$K0Ib6CatTCDVM3EUpiSGm.7VAo/K9YlbGtLwJjXmWaTmBtbeuYe8G', '13138283670', 'adfadf', 'dsfa', NULL, NULL, '2020-07-28 16:36:01', b'0', b'0', b'0', b'0');
INSERT INTO `sys_user` VALUES (40, NULL, '$10$K0Ib6CatTCDVM3EUpiSGm.7VAo/K9YlbGtLwJjXmWaTmBtbeuYe8G', NULL, 'test', NULL, NULL, NULL, NULL, b'0', b'0', b'0', b'0');
INSERT INTO `sys_user` VALUES (39, NULL, '$10$K0Ib6CatTCDVM3EUpiSGm.7VAo/K9YlbGtLwJjXmWaTmBtbeuYe8G', NULL, 'amy', NULL, NULL, NULL, NULL, b'0', b'0', b'0', b'0');
INSERT INTO `sys_user` VALUES (42, NULL, '$10$K0Ib6CatTCDVM3EUpiSGm.7VAo/K9YlbGtLwJjXmWaTmBtbeuYe8G', NULL, 'test2', NULL, NULL, NULL, NULL, b'0', b'0', b'0', b'0');
INSERT INTO `sys_user` VALUES (83, NULL, '$10$K0Ib6CatTCDVM3EUpiSGm.7VAo/K9YlbGtLwJjXmWaTmBtbeuYe8G', NULL, 'testetst2', NULL, NULL, NULL, NULL, b'0', b'0', b'0', b'0');
INSERT INTO `sys_user` VALUES (84, '504250439@qq.com', '$10$K0Ib6CatTCDVM3EUpiSGm.7VAo/K9YlbGtLwJjXmWaTmBtbeuYe8G', '13138283670', 'tests', 'sefseeasf', NULL, NULL, NULL, b'0', b'0', b'0', b'0');
INSERT INTO `sys_user` VALUES (109, 'asdf@fff.ff', '$10$K0Ib6CatTCDVM3EUpiSGm.7VAo/K9YlbGtLwJjXmWaTmBtbeuYe8G', '45252', 'yes', 'fdgfgdsfg', NULL, NULL, NULL, b'0', b'0', b'0', b'0');
INSERT INTO `sys_user` VALUES (120, '934387764@qq.com', '$10$K0Ib6CatTCDVM3EUpiSGm.7VAo/K9YlbGtLwJjXmWaTmBtbeuYe8G', '13138283670', 'estt', 'sdaf', NULL, NULL, NULL, b'0', b'0', b'0', b'0');
INSERT INTO `sys_user` VALUES (126, '934387764@qq.com', '$10$K0Ib6CatTCDVM3EUpiSGm.7VAo/K9YlbGtLwJjXmWaTmBtbeuYe8G', '13138283670', 'fatherfdsgg', 'esdfasef', NULL, NULL, NULL, b'0', b'0', b'0', b'0');
INSERT INTO `sys_user` VALUES (2, '504250439@qq.com', '$10$K0Ib6CatTCDVM3EUpiSGm.7VAo/K9YlbGtLwJjXmWaTmBtbeuYe8G', '13138283670', 'adsfasd', 'dsfa', NULL, NULL, '2020-07-28 14:12:17', b'0', b'0', b'0', b'0');
INSERT INTO `sys_user` VALUES (23, NULL, '$10$K0Ib6CatTCDVM3EUpiSGm.7VAo/K9YlbGtLwJjXmWaTmBtbeuYe8G', NULL, 'test1', NULL, NULL, NULL, NULL, b'0', b'0', b'0', b'0');
INSERT INTO `sys_user` VALUES (27, NULL, '$10$K0Ib6CatTCDVM3EUpiSGm.7VAo/K9YlbGtLwJjXmWaTmBtbeuYe8G', NULL, 'test1', NULL, NULL, NULL, NULL, b'0', b'0', b'0', b'0');
INSERT INTO `sys_user` VALUES (29, NULL, '$10$K0Ib6CatTCDVM3EUpiSGm.7VAo/K9YlbGtLwJjXmWaTmBtbeuYe8G', NULL, 'test1', NULL, NULL, NULL, NULL, b'0', b'0', b'0', b'0');
INSERT INTO `sys_user` VALUES (31, NULL, '$10$K0Ib6CatTCDVM3EUpiSGm.7VAo/K9YlbGtLwJjXmWaTmBtbeuYe8G', NULL, 'test1', NULL, NULL, NULL, NULL, b'0', b'0', b'0', b'0');
INSERT INTO `sys_user` VALUES (32, '', '$10$K0Ib6CatTCDVM3EUpiSGm.7VAo/K9YlbGtLwJjXmWaTmBtbeuYe8G', '', 'admin', '', NULL, NULL, '2020-11-08 11:15:16', b'0', b'0', b'0', b'0');
INSERT INTO `sys_user` VALUES (33, '', '$2a$10$C4rO7Y2V3T1T0DirGwteMuYq.3tKqVVPQAQFC3NoZwlw2KO9UlljK', '', 'admin1', '', NULL, NULL, '2020-11-08 11:17:06', b'0', b'0', b'0', b'0');
INSERT INTO `sys_user` VALUES (34, '', '$2a$10$zttVlm52x9dArKWmEdoj2uOd3eUQjt1jLN68X64omebVAeRij8j8S', '', 'aaa', '', NULL, NULL, '2020-11-08 11:21:52', b'0', b'0', b'0', b'0');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE,
  INDEX `FKhh52n8vd4ny9ff4x9fb8v65qx`(`role_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 1);
INSERT INTO `sys_user_role` VALUES (2, 1);
INSERT INTO `sys_user_role` VALUES (23, 1);
INSERT INTO `sys_user_role` VALUES (31, 30);
INSERT INTO `sys_user_role` VALUES (32, 2);
INSERT INTO `sys_user_role` VALUES (33, 1);
INSERT INTO `sys_user_role` VALUES (34, 1);
INSERT INTO `sys_user_role` VALUES (39, 1);

SET FOREIGN_KEY_CHECKS = 1;
