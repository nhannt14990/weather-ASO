/*
 Navicat Premium Data Transfer

 Source Server         : MySqlConnect
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : weather

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 18/02/2019 22:54:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for city
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city`  (
  `IdCity` int(10) NOT NULL AUTO_INCREMENT,
  `City` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`IdCity`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of city
-- ----------------------------
INSERT INTO `city` VALUES (1, 'VietNam');
INSERT INTO `city` VALUES (2, 'Japan');
INSERT INTO `city` VALUES (3, 'Paris');
INSERT INTO `city` VALUES (18, 'Jamaica');

-- ----------------------------
-- Table structure for weather
-- ----------------------------
DROP TABLE IF EXISTS `weather`;
CREATE TABLE `weather`  (
  `Id` int(10) NOT NULL AUTO_INCREMENT,
  `NameCity` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TimeStamp` bigint(20) NULL DEFAULT NULL,
  `Temperature` double(10, 2) NULL DEFAULT NULL,
  `Humidity` double(10, 2) NULL DEFAULT NULL,
  `Pressure` double(10, 2) NULL DEFAULT NULL,
  `IdWeather` int(11) NOT NULL,
  `IdCity` int(11) NULL DEFAULT NULL,
  `WeatherMain` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `WeatherIcon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CountryCode` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of weather
-- ----------------------------
INSERT INTO `weather` VALUES (1, 'VietNam', 1550465874, 296.78, 93.00, 1021.33, 500, 1, 'Rain', '10n', 'GF');
INSERT INTO `weather` VALUES (2, 'Japan', 1550466243, 301.48, 86.00, 978.77, 500, 2, 'Rain', '10d', 'ID');
INSERT INTO `weather` VALUES (3, 'Paris', 1550464200, 274.85, 80.00, 1019.00, 800, 3, 'Clear', '01n', 'FR');
INSERT INTO `weather` VALUES (4, 'Jamaica', 1550465760, 297.15, 100.00, 1019.00, 801, 18, 'Clouds', '02n', 'CU');
INSERT INTO `weather` VALUES (5, 'VietNam', 1550469550, 296.78, 93.00, 1021.33, 500, 1, 'Rain', '10n', 'GF');
INSERT INTO `weather` VALUES (6, 'VietNam', 1550476249, 297.05, 90.00, 1021.48, 500, 1, 'Rain', '10n', 'GF');
INSERT INTO `weather` VALUES (7, 'VietNam', 1550503905, 301.22, 67.00, 1023.39, 804, 1, 'Clouds', '04d', 'GF');

SET FOREIGN_KEY_CHECKS = 1;
