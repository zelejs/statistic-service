package com.jfeat.am.module.statistics.services.domain.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.statistics.services.domain.dao.QueryStatisticChartDao;
import com.jfeat.am.module.statistics.services.domain.service.QueryStatisticChartService;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticChart;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2017-10-16
 */
@Service
public class QueryStatisticChartServiceImpl implements QueryStatisticChartService {

    @Resource
    QueryStatisticChartDao queryStatisticChartDao;

    @Override
    public List<StatisticChart> findStatisticChartPage(Page<StatisticChart> page, StatisticChart statisticchart) {
        return queryStatisticChartDao.findStatisticChartPage(page, statisticchart);
    }
}
