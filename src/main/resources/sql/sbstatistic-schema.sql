

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
  `sort_order` int(11) DEFAULT 0,
  `visible` int(11) DEFAULT 1,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for st_statistic_record
-- ----------------------------
DROP TABLE IF EXISTS `st_statistic_record`;
CREATE TABLE `st_statistic_record` (
  `id` bigint(20) NOT NULL,
  `type_id` bigint(20) NOT NULL,
  `record_time` datetime NOT NULL,
  `field_name` varchar(255) NOT NULL,
  `group` bigint(20) NOT NULL COMMENT '数据分组，用于同一次统计有多种统计项，比如文章排行榜',
  `value` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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

