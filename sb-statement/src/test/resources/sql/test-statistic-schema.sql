SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS `cl_client_record`;
CREATE TABLE `cl_client_record` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `stat` integer NOT NULL DEFAULT 0 COMMENT '存在状态 （0 - NOR, 1 - DRP， 2-DEL）',
  `client_name` varchar(50) NOT NULL COMMENT '客户姓名',
  `nickname` varchar(50) COMMENT '称呼',
  `sex` int(11) COMMENT '性别', /* 0-女 1-男 */
  `birthday` datetime COMMENT '生日',
  `tag` varchar(50) COMMENT '标签',
  `fphone` varchar(30) COMMENT '座机', /*fixed phone*/
  `phone` varchar(30) NOT NULL COMMENT '联系电话',
  `email` varchar(30) COMMENT '电子邮箱',
  `qq` varchar(26) COMMENT 'QQ号',
  `wechat` varchar(26) COMMENT '微信号',
  `fax` varchar(26) COMMENT '传真号',
  `position` varchar(26) COMMENT '职位',
  `correspondence_address` varchar(200) COMMENT '通讯地址',
  `create_time` datetime COMMENT '创建时间',
  `delete_time` datetime COMMENT '删除时间',
  `status` varchar(20) COMMENT '客户阶段状态（APPROVED 已审批  / UNSIGNED 未签约 / FINISHED 已完成）',
  `status_running` varchar(20) COMMENT '执行阶段状态',
  `source` varchar(50) COMMENT '客户来源',
  `dsource` text COMMENT '资料来源',
  `owner` bigint(20) DEFAULT 0 COMMENT '关联员工',
  `type_id` integer COMMENT '客户类型',
  `created_id` bigint(20) COMMENT '创建人ID',
  `created_by` varchar(50) COMMENT '创建人',
  `follow_id` bigint(20) COMMENT '跟进人ID',
  `follow_up` varchar(50) COMMENT '跟进人',
  `follower_dept` varchar(50) COMMENT '跟进人所在部门',
  `remark` text COMMENT '备注',
  `com_name` varchar(50) NOT NULL COMMENT '公司',
  `com_phone` varchar(30) NOT NULL COMMENT '公司电话',
  `com_industry` varchar(50) COMMENT '行业：一级行业',
  `com_second_industry` varchar(50) COMMENT '行业：二级行业'
  `com_scale` varchar(200) COMMENT '公司规模',
  `com_address` varchar(200) COMMENT '公司地址',
  `com_site` varchar(255) COMMENT '网址',
  `com_email` varchar(50) COMMENT '公司电子邮箱',
  `com_fax` varchar(30) COMMENT '公司传真号码',
  `com_intro` text COMMENT '公司简介',
  `country` varchar(20) COMMENT '地区：国家',
  `province` varchar(20) COMMENT '地区：省/州',
  `city` varchar(20) COMMENT '地区：城市',
  `district` varchar(20) COMMENT '地区：区/县',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
