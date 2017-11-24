package com.jfeat.am.module.statistics.services.domain.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.statistics.services.domain.dao.QueryStatisticsRecordDao;
import com.jfeat.am.module.statistics.services.domain.service.QueryStatisticsRecordService;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsRecord;
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
public class QueryStatisticsRecordServiceImpl implements QueryStatisticsRecordService {

    @Resource
    QueryStatisticsRecordDao queryStatisticsRecordDao;

    @Override
    public List<StatisticsRecord> findStatisticsRecordPage(Page<StatisticsRecord> page, StatisticsRecord statisticsrecord) {
        return queryStatisticsRecordDao.findStatisticsRecordPage(page, statisticsrecord);
    }
}
