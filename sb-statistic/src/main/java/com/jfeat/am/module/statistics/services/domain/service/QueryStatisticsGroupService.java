package com.jfeat.am.module.statistics.services.domain.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsGroup;

import java.util.List;

/**
 * Created by vincent on 2017/10/19.
 */
public interface QueryStatisticsGroupService {
    List<StatisticsGroup> findStatisticsGroupPage(Page<StatisticsGroup> page, StatisticsGroup statisticsgroup );
}