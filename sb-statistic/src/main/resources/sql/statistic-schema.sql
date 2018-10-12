SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for st_statistic_group
-- ----------------------------
DROP TABLE IF EXISTS `st_statistics_group`;
CREATE TABLE `st_statistics_group` (
  `id` bigint(20) AUTO_INCREMENT,
  `pid` bigint(20) DEFAULT NULL COMMENT '上级分组',
  `name` varchar(50) NOT NULL COMMENT '组名[唯一标记]',
  `title` varchar(26) DEFAULT NULL COMMENT '组标题',
  `note` text DEFAULT NULL COMMENT '分组描述',
  `index` smallint(5) DEFAULT 0 COMMENT '分组排序号',
  `layout` varchar(26) DEFAULT NULL COMMENT '布局名称',
  UNIQUE(`name`),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for st_statistics_field
-- ----------------------------
DROP TABLE IF EXISTS `st_statistics_field`;
CREATE TABLE `st_statistics_field` (
  `id` bigint(20) AUTO_INCREMENT,
  `field` varchar(80) NOT NULL COMMENT '数据域唯一标识符',
  `group_id` bigint(20) DEFAULT NULL COMMENT '所属分组ID',
  `group_name` varchar(50) NOT NULL COMMENT '所属分组名称',
  `name` varchar(50) NOT NULL COMMENT '数据域名称',
  `pattern` varchar(26) NOT NULL COMMENT '统计数据类型[Count,Rate,Tuple [Timeline,Cluster]]',
  `chart` varchar(26) NOT NULL COMMENT '图表名称[Num,Array,Pie,Column,Chain,Line] Chain-环比',
  `runtime` smallint DEFAULT 0 COMMENT '是否实时查询[via meta]',
  `attr_invisible` smallint DEFAULT 0 COMMENT '[属性]是否不可见',
  `attr_index` smallint DEFAULT 0 COMMENT '[属性]排序号',
  `attr_percent` smallint DEFAULT 0 COMMENT '[属性]是否显示为百分比',
  `attr_span` smallint DEFAULT 1 COMMENT '[属性]所占布局跨列数',
  UNIQUE(`field`),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for st_statistic_record
-- T      -  Total
-- D,W,Y  -  Day/Week/Year
-- LD3    -  Latest 3 Days
-- LM3    -  Latest 3 Months
-- TF     -  Time Frame
-- Chain  -  Record Chain
-- ----------------------------
DROP TABLE IF EXISTS `st_statistics_record`;
CREATE TABLE `st_statistics_record` (
  `id` bigint(20) AUTO_INCREMENT,
  `field` varchar(80) NOT NULL COMMENT '数据域标识符',
  `seq` int NOT NULL DEFAULT 0 COMMENT '记录排序号',
  `record_name` varchar(50) NOT NULL COMMENT '记录名称',
  `record_value` varchar(50) NOT NULL COMMENT '记录值',
  `record_tuple` varchar(30) DEFAULT NULL COMMENT '记录值所属行名称',
  `record_cluster` varchar(30) DEFAULT NULL COMMENT '记录值所属分类名称',
  `record_timeline` varchar(30) DEFAULT NULL COMMENT '记录值所属时间区间名称',
  `timeline` varchar(8) DEFAULT NULL COMMENT '统计时段说明[T,D,W,M,Y,LD3,LW1,LM1,LM3,Q1,Q2,Q3,Q4,TF]',
  `identifier` varchar(80) DEFAULT NULL COMMENT '统计归属标识',
  `create_time` datetime NOT NULL DEFAULT current_timestamp COMMENT '记录创建时间',
  `tmp_field_id` bigint(20) DEFAULT NULL COMMENT '临时标记数据域ID',
  UNIQUE(`field`,`record_name`,`record_tuple`,`record_cluster`,`timeline`,`identifier`),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for st_statistics_field
-- ----------------------------
DROP TABLE IF EXISTS `st_statistics_meta`;
CREATE TABLE `st_statistics_meta` (
  `id` bigint(20) AUTO_INCREMENT,
  `field` varchar(80) NOT NULL COMMENT '数据指标唯一标识符',
  `record_name` varchar(50) NOT NULL COMMENT '记录名称',
  `record_tuple` varchar(50) DEFAULT NULL COMMENT '记录名称',
  `record_cluster` varchar(30) DEFAULT NULL COMMENT '记录值所属分类名称',
  `record_timeline` varchar(30) DEFAULT NULL COMMENT '记录值所属时间区间名称',
  `timeline` varchar(8) DEFAULT NULL COMMENT '统计时段标记',
  `query_sql` text DEFAULT NULL COMMENT '实时查询sql',
  `tmp_record_id` bigint(20) DEFAULT NULL COMMENT '临时指标记录ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

---------------------------------------------------------------------
-- @Deprecated
---------------------------------------------------------------------

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
