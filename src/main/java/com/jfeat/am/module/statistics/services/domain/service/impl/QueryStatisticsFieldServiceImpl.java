package com.jfeat.am.module.statistics.services.domain.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.statistics.services.domain.dao.QueryStatisticsFieldDao;
import com.jfeat.am.module.statistics.services.domain.service.QueryStatisticsFieldService;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsField;
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
public class QueryStatisticsFieldServiceImpl implements QueryStatisticsFieldService {

    @Resource
    QueryStatisticsFieldDao queryStatisticsFieldDao;

    @Override
    public List<StatisticsField> findStatisticsFieldPage(Page<StatisticsField> page, StatisticsField statisticsfield) {
        return queryStatisticsFieldDao.findStatisticsFieldPage(page, statisticsfield);
    }
}
