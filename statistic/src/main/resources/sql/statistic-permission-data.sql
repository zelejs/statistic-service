SET FOREIGN_KEY_CHECKS=0;

--
-- DELETE from perm_group WHERE id='904877792910610434';
-- DELETE from perm WHERE id IN('904877792910610435', '904877792910610436');

-- INSERT INTO `perm_group` (`id`, `name`, `identifier`) VALUES
-- ('904877792910610434', '统计管理', 'statistic.management');

-- INSERT INTO `perm` (`id`, `groupid`, `name`, `identifier`) VALUES
-- ('904877792910610435', '904877792910610434', '查看统计数据', 'statistic.view');

--
-- INSERT INTO `perm_group` (`id`, `name`, `identifier`) VALUES
-- ('1023486060950192133', 'StatisticsMeta模块', 'StatisticsMeta.management');

-- INSERT INTO `perm` (`id`, `groupid`, `name`, `identifier`) VALUES
-- ('1023486060950192130', '1023486060950192133', '查看StatisticsMeta', 'StatisticsMeta.view'),
-- ('1023486060950192131', '1023486060950192133', '编辑StatisticsMeta', 'StatisticsMeta.edit');