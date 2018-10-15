# springboot2.0-mybatis
该项目模板试用的是springboot2.0+mybatis
使用idea创建的项目，项目模块有web,jpa,mysql,mybatis

#数据库
库名：test
表明：user_t

#创建sql语句

#设置编码
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

#创建数据库和表
DROP TABLE IF EXISTS `user_t`;
CREATE TABLE `user_t`  (
  `id` int(155) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

#插入数据
INSERT INTO `user_t` VALUES (1, 'yangwj', 'weresfer', 26);

SET FOREIGN_KEY_CHECKS = 1;

