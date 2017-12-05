package com.jfeat.am.module.statistics.services.domain.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.statistics.services.domain.dao.QueryStatisticsRecordAttrDao;
import com.jfeat.am.module.statistics.services.domain.service.QueryStatisticsRecordAttrService;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsRecordAttr;
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
public class QueryStatisticsRecordAttrServiceImpl implements QueryStatisticsRecordAttrService {

    @Resource
    QueryStatisticsRecordAttrDao queryStatisticsRecordAttrDao;

    @Override
    public List<StatisticsRecordAttr> findStatisticsRecordAttrPage(Page<StatisticsRecordAttr> page, StatisticsRecordAttr statisticsrecordattr) {
        return queryStatisticsRecordAttrDao.findStatisticsRecordAttrPage(page, statisticsrecordattr);
    }
}
