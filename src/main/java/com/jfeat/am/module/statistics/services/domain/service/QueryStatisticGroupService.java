package com.jfeat.am.module.statistics.services.domain.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticGroup;

import java.util.List;

/**
 * Created by vincent on 2017/10/19.
 */
public interface QueryStatisticGroupService {
    List<StatisticGroup> findStatisticGroupPage(Page<StatisticGroup> page, StatisticGroup statisticgroup );
}