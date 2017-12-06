package com.jfeat.am.module.statistics.services.domain.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.statistics.services.domain.dao.QueryStatisticsFieldDao;
import com.jfeat.am.module.statistics.services.domain.service.QueryStatisticsFieldService;
import com.jfeat.am.module.statistics.services.persistence.dao.StatisticsFieldMapper;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsField;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsRecordAttr;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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
    @Resource
    StatisticsFieldMapper statisticsFieldMapper;

    @Override
    public List<StatisticsField> findStatisticsFieldPage(Page<StatisticsField> page, StatisticsField statisticsfield) {
        return queryStatisticsFieldDao.findStatisticsFieldPage(page, statisticsfield);
    }

    @Override
    public List<Map<String, Object>> getStatisticsRecordByFieldIdAndStartTimeAndEndTime(String field, List<StatisticsRecordAttr> fields, String startTime, String endTime) {
        return queryStatisticsFieldDao.getStatisticsRecordByFieldIdAndStartTimeAndEndTime(field,fields,startTime,endTime);
    }
}
