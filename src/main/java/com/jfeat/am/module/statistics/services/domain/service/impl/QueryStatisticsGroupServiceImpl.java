package com.jfeat.am.module.statistics.services.domain.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.statistics.services.domain.dao.QueryStatisticsGroupDao;
import com.jfeat.am.module.statistics.services.domain.service.QueryStatisticsGroupService;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsGroup;
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
public class QueryStatisticsGroupServiceImpl implements QueryStatisticsGroupService {

    @Resource
    QueryStatisticsGroupDao queryStatisticsGroupDao;

    @Override
    public List<StatisticsGroup> findStatisticsGroupPage(Page<StatisticsGroup> page, StatisticsGroup statisticsgroup) {
        return queryStatisticsGroupDao.findStatisticsGroupPage(page, statisticsgroup);
    }
}
