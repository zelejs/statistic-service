

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for st_statistic_field
-- ----------------------------
DROP TABLE IF EXISTS `st_statistic_field`;
CREATE TABLE `st_statistic_field` (
  `id` bigint(20) NOT NULL,
  `type_id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `display_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of st_statistic_field
-- ----------------------------

-- ----------------------------
-- Table structure for st_statistic_record
-- ----------------------------
DROP TABLE IF EXISTS `st_statistic_record`;
CREATE TABLE `st_statistic_record` (
  `id` bigint(20) NOT NULL,
  `type_id` bigint(20) NOT NULL,
  `record_time` datetime NOT NULL,
  `field_name` varchar(255) NOT NULL,
  `value` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of st_statistic_record
-- ----------------------------

-- ----------------------------
-- Table structure for st_type_definition
-- ----------------------------
DROP TABLE IF EXISTS `st_type_definition`;
CREATE TABLE `st_type_definition` (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `name` varchar(255) NOT NULL COMMENT '统计名称',
  `identifier` varchar(255) NOT NULL COMMENT '标识符',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of st_type_definition
-- ----------------------------
