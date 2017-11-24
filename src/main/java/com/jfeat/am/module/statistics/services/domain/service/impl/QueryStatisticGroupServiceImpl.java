package com.jfeat.am.module.statistics.services.domain.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.statistics.services.domain.dao.QueryStatisticGroupDao;
import com.jfeat.am.module.statistics.services.domain.service.QueryStatisticGroupService;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticGroup;
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
public class QueryStatisticGroupServiceImpl implements QueryStatisticGroupService {

    @Resource
    QueryStatisticGroupDao queryStatisticGroupDao;

    @Override
    public List<StatisticGroup> findStatisticGroupPage(Page<StatisticGroup> page, StatisticGroup statisticgroup) {
        return queryStatisticGroupDao.findStatisticGroupPage(page, statisticgroup);
    }
}
