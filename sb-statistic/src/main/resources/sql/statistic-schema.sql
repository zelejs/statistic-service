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
  `index` smallint(5) DEFAULT 0 COMMENT '排序号',
  `chart` varchar(26) NOT NULL COMMENT '图表名称[Pie,Chain]环比',
  UNIQUE(`identifier`),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for st_statistic_entry
-- ----------------------------
DROP TABLE IF EXISTS `st_statistics_field`;
CREATE TABLE `st_statistics_field` (
  `id` bigint(20) NOT NULL,
  `group_id` bigint(20) NOT NULL COMMENT '统计所属分组',
  `name` varchar(50) NOT NULL COMMENT '统计名称',
  `field` varchar(80) NOT NULL COMMENT '数据域标识符',
  `schema` varchar(26) NOT NULL COMMENT '统计数据类型[Value,Rate,Report,Cluster]',
  `chart` varchar(26) NOT NULL COMMENT '图表名称[Pie,Chain]环比',
  `invisible` smallint(5) DEFAULT 0 COMMENT '是否不可见',
  `index` smallint(5) DEFAULT 0 COMMENT '排序号',
  `percent` smallint(5) DEFAULT 0 COMMENT '是否显示为百分比',
  UNIQUE(`field`),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for st_statistic_record
-- T      -  Total
-- D,W,Y  -  Day/Week/Year
-- LD3    -  Latest 3 Days
-- LM3    -  Latest 3 Months
-- Chain  -  Record Chain
-- ----------------------------
DROP TABLE IF EXISTS `st_statistics_record`;
CREATE TABLE `st_statistics_record` (
  `id` bigint(20) NOT NULL,
  `field_id` bigint(20) NOT NULL COMMENT '所属数据域ID[CRUD]',
  `field` varchar(80) NOT NULL COMMENT '数据域标识符',
  `record_name` varchar(50) NOT NULL COMMENT '记录名称',
  `record_value` varchar(50) NOT NULL COMMENT '记录值',
  `record_tuple` varchar(30) NOT NULL COMMENT '记录值所属行名称',
  `record_cluster` varchar(30) NOT NULL COMMENT '记录值所属分类名称',
  `timeline` varchar(8) NOT NULL COMMENT '统计时段说明[T,D,W,M,Y,LD3,LW1,LM1,LM3,Q1,Q2,Q3,Q4]',
  `record_time` datetime NOT NULL COMMENT '记录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- @Deprecated
-- ----------------------------
-- Table structure for st_statistics_record_attr
-- ----------------------------
DROP TABLE IF EXISTS `st_statistics_record_attr`;
CREATE TABLE `st_statistics_record_attr` (
  `id` bigint(20) NOT NULL,
  `field` varchar(80) NOT NULL COMMENT '所属数据域标识符',
  `record_name` varchar(50) NOT NULL COMMENT '所修饰的记录名称',
  `legend` varchar(50) NOT NULL COMMENT '图例名称(中文)',
  `note` varchar(50) DEFAULT NULL COMMENT '图例说明',
  `index` smallint(5) DEFAULT 0 COMMENT '排序号',
  UNIQUE(`field`, `record_name`),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

