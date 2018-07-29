INSERT INTO `perm_group` (`id`, `name`, `identifier`) VALUES
('1023486060950192133', 'StatisticsMeta模块', 'StatisticsMeta.management');

INSERT INTO `perm` (`id`, `groupid`, `name`, `identifier`) VALUES
('1023486060950192130', '1023486060950192133', '查看StatisticsMeta', 'StatisticsMeta.view'),
('1023486060950192131', '1023486060950192133', '编辑StatisticsMeta', 'StatisticsMeta.edit');
