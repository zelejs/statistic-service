package com.jfeat.am.module.statistics.services.domain.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.statistics.services.domain.dao.QueryStatisticLegendDao;
import com.jfeat.am.module.statistics.services.domain.service.QueryStatisticLegendService;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticLegend;
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
public class QueryStatisticLegendServiceImpl implements QueryStatisticLegendService {

    @Resource
    QueryStatisticLegendDao queryStatisticLegendDao;

    @Override
    public List<StatisticLegend> findStatisticLegendPage(Page<StatisticLegend> page, StatisticLegend statisticlegend) {
        return queryStatisticLegendDao.findStatisticLegendPage(page, statisticlegend);
    }
}
