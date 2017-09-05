
SET FOREIGN_KEY_CHECKS=0;

INSERT INTO `perm_group` (`id`, `name`, `identifier`) VALUES
('904877792910610434', '统计管理', 'statistic.management');

INSERT INTO `perm` (`id`, `groupid`, `name`, `identifier`) VALUES
('904877792910610435', '904877792910610434', '查看统计数据', 'statistic.view');

