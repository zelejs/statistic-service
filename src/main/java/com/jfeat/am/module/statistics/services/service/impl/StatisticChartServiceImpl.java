package com.jfeat.am.module.statistics.services.service.impl;
            
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticChart;
import com.jfeat.am.module.statistics.services.persistence.dao.StatisticChartMapper;
import com.jfeat.am.module.statistics.services.service.StatisticChartService;
import com.jfeat.am.common.crud.impl.CRUDServiceOnlyImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  implementation
 * </p>
 *
 * @author Code Generator
 * @since 2017-11-24
 */
@Service
public class StatisticChartServiceImpl  extends CRUDServiceOnlyImpl<StatisticChart> implements StatisticChartService {

    @Resource
    private StatisticChartMapper statisticChartMapper;

    @Override
    protected BaseMapper<StatisticChart> getMasterMapper() {
        return statisticChartMapper;
    }
}


