SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for st_statistic_group
-- ----------------------------
DROP TABLE IF EXISTS `st_statistics_group`;
CREATE TABLE `st_statistics_group` (
  `id` bigint(20) NOT NULL,
  `name` varchar(50) NOT NULL COMMENT '组显示名称',
  `identifier` varchar(50) NOT NULL COMMENT '组标识',
  `pid` bigint(20) DEFAULT NULL COMMENT '上级分组',
  `description` text DEFAULT NULL COMMENT '分组描述',
  `sort` smallint(5) DEFAULT 0 COMMENT '排序号',
  `chart` varchar(26) NOT NULL COMMENT '图表类型[Pie,Chain]环比',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for st_statistic_entry
-- ----------------------------
DROP TABLE IF EXISTS `st_statistics_field`;
CREATE TABLE `st_statistics_field` (
  `id` bigint(20) NOT NULL,
  `name` varchar(50) NOT NULL COMMENT '统计名称',
  `field` varchar(100) NOT NULL COMMENT '数据域标识符',
  `index` smallint(5) DEFAULT 0 COMMENT '排序号',
  `invisible` smallint(5) DEFAULT 0 COMMENT '是否不可见',
  `group_id` bigint(20) NOT NULL COMMENT '统计所属分组',
  `chart` varchar(26) NOT NULL COMMENT '图表名称[Pie,Chain]环比',
  `percent` smallint(5) DEFAULT 0 COMMENT '是否显示为百分比',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for st_statistic_record
-- ----------------------------
DROP TABLE IF EXISTS `st_statistics_record`;
CREATE TABLE `st_statistics_record` (
  `id` bigint(20) NOT NULL,
  `field_id` bigint(20) NOT NULL COMMENT '所属数据域',
  `field` varchar(100) NOT NULL COMMENT '数据域标识符',
  `record_name` varchar(50) NOT NULL COMMENT '记录标记',
  `record_value` varchar(50) NOT NULL COMMENT '记录值',
  `record_time` datetime NOT NULL COMMENT '记录时间',
  `month_name` varchar(26) DEFAULT NULL COMMENT '所属月份简称 [Mar,Jan,Q1,Q2]',
  `attr_id` bigint(20) DEFAULT NULL COMMENT '记录属性',
  `legend` varchar(50) DEFAULT NULL COMMENT '图例名称（中文）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for st_statistics_record_attr
-- ----------------------------
DROP TABLE IF EXISTS `st_statistics_record_attr`;
CREATE TABLE `st_statistics_record_attr` (
  `id` bigint(20) NOT NULL,
  `record_id` bigint(20) NOT NULL COMMENT '所属数据域',
  `legend` varchar(50) NOT NULL COMMENT '记录名称',
  `index` smallint(5) DEFAULT 0 COMMENT '排序号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
