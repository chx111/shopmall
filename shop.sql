/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50067
 Source Host           : localhost:3306
 Source Schema         : estoresystem

 Target Server Type    : MySQL
 Target Server Version : 50067
 File Encoding         : 65001

 Date: 12/07/2019 15:57:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager`  (
  `idcard` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `mphonenumber` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `msex` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mname` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mpassword` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY USING BTREE (`idcard`)
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES ('1', '15037060927', '男', '1', '1');
INSERT INTO `manager` VALUES ('111', '15037060927', '男', '111', '111');

-- ----------------------------
-- Table structure for orderitem
-- ----------------------------
DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem`  (
  `order_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `product_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `buynum` int(11) NULL DEFAULT NULL,
  PRIMARY KEY USING BTREE (`order_id`, `product_id`),
  INDEX `product_id` USING BTREE(`product_id`),
  CONSTRAINT `orderitem_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `orderitem_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'InnoDB free: 9216 kB; (`order_id`) REFER `estoresystem/orders`(`id`); (`product_' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of orderitem
-- ----------------------------
INSERT INTO `orderitem` VALUES ('1005', '1', 1);
INSERT INTO `orderitem` VALUES ('1005', '3456', 1);
INSERT INTO `orderitem` VALUES ('1084', '1', 1);
INSERT INTO `orderitem` VALUES ('1084', '3', 1);
INSERT INTO `orderitem` VALUES ('165', '1', 1);
INSERT INTO `orderitem` VALUES ('165', '11', 1);
INSERT INTO `orderitem` VALUES ('204', '1', 1);
INSERT INTO `orderitem` VALUES ('204', '11', 1);
INSERT INTO `orderitem` VALUES ('459', '11', 2);
INSERT INTO `orderitem` VALUES ('785', '2', 1);
INSERT INTO `orderitem` VALUES ('785', '5', 1);
INSERT INTO `orderitem` VALUES ('865', '1', 1);
INSERT INTO `orderitem` VALUES ('865', '11', 1);
INSERT INTO `orderitem` VALUES ('989', '11', 2);

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `money` double NULL DEFAULT NULL,
  `paystate` int(11) NOT NULL DEFAULT 0,
  `user_id` int(11) NULL DEFAULT NULL,
  `address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY USING BTREE (`id`),
  INDEX `user_id` USING BTREE(`user_id`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'InnoDB free: 9216 kB; (`user_id`) REFER `estoresystem/users`(`id`)' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1005', 40, 1, 1234, '河南永城');
INSERT INTO `orders` VALUES ('1084', 46, 1, 123456, '河南永城');
INSERT INTO `orders` VALUES ('165', 46, 1, 123456, '河南永城');
INSERT INTO `orders` VALUES ('204', 46, 0, 123456, '河南永城');
INSERT INTO `orders` VALUES ('459', 60, 1, 123456, '河南永城');
INSERT INTO `orders` VALUES ('785', 50, 1, 123456, '河南永城');
INSERT INTO `orders` VALUES ('865', 46, 1, 66666, '河南永城');
INSERT INTO `orders` VALUES ('989', 60, 0, 123456, '河南永城');

-- ----------------------------
-- Table structure for products
-- ----------------------------
DROP TABLE IF EXISTS `products`;
CREATE TABLE `products`  (
  `id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `writename` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` double(20, 10) NULL DEFAULT NULL,
  `imgurl` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY USING BTREE (`id`)
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of products
-- ----------------------------
INSERT INTO `products` VALUES ('1', '你坏', '大兵', 16.0000000000, 'Image/n1.jpg', '如果你和众人不一样。\r\n那就不一样。\r\n', '小说');
INSERT INTO `products` VALUES ('11', '你坏', '大兵', 16.0000000000, 'Image/n1.jpg', '如果你和众人不一样。\r\n那就不一样。\r\n ', '小说');
INSERT INTO `products` VALUES ('2', '好吗，好的', '大兵', 20.0000000000, 'Image/n2.jpg', '善良是一种天性，善意是一种选择。\r\n善意能消戾，善意能得缘，善意能带业往生，善意能回头是岸。\r\n善意能够帮人捕捉并建立起独特的幸福感。\r\n好吗好的，是一句自度度人的自问自答，也是一份坦然随缘的善意。', '小说');
INSERT INTO `products` VALUES ('3', '乖，摸摸头', '大兵', 30.0000000000, 'Image/n3.jpg', '这本书讲述了12个真实的故事\r\n或许会让你看到那些你永远无法去体会的生活\r\n见识那些可能你永远都无法结交的人', '小说');
INSERT INTO `products` VALUES ('3456', '创建', '李晓辉', 24.0000000000, 'Image/cs1.jpg', '的发挥的好', '计算机');
INSERT INTO `products` VALUES ('4', '阿弥陀佛么么哒', '大兵', 30.0000000000, 'Image/n4.jpg', '　\r\n“善良是一种天性，善意是一种选择。善意是人性中永恒的向阳面。”', '小说');
INSERT INTO `products` VALUES ('5', 'Java核心技术', '杜永坪', 30.0000000000, 'Image/I1.jpg', '　\r\nJava核心技术，基础知识 ', '计算机');
INSERT INTO `products` VALUES ('8', 'Java面试宝典', '叶向阳', 30.0000000000, 'Image/I3.jpg', '　\r\n“本书覆盖了历年来各大IT名企面试官精讲编程题', '计算机');
INSERT INTO `products` VALUES ('9', '傲慢与偏见', '张娇译', 30.0000000000, 'Image/w2.jpg', '　\r\n“英伦田园的风景美丽如画，绅士淑女的爱情曲折如诗；也许这不是最好的一版，但绝对是最美的一版。', '经典名著');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` int(11) NOT NULL,
  `phonenumber` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `username` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY USING BTREE (`id`)
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, '15037060927', '男', '1111', '1');
INSERT INTO `users` VALUES (2, '15037060927', '男', '22222', '2');
INSERT INTO `users` VALUES (3, '15037060927', '男', '1111', '4');
INSERT INTO `users` VALUES (11, '17083996341', '男', 'chx', 'lz');
INSERT INTO `users` VALUES (66, '1708399634', '男', 'chx', 'lz');
INSERT INTO `users` VALUES (111, '15037060927', '男', '1111', '111');
INSERT INTO `users` VALUES (1234, '17083996341', '男', 'chx', 'lz');
INSERT INTO `users` VALUES (66666, '17083996348', '男', 'chx', 'lz');
INSERT INTO `users` VALUES (123456, '17083996341', '男', 'chx', 'lz');

SET FOREIGN_KEY_CHECKS = 1;
