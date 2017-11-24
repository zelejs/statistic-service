package com.jfeat.am.module.statistics.services.service.impl;
            
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticLegend;
import com.jfeat.am.module.statistics.services.persistence.dao.StatisticLegendMapper;
import com.jfeat.am.module.statistics.services.service.StatisticLegendService;
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
public class StatisticLegendServiceImpl  extends CRUDServiceOnlyImpl<StatisticLegend> implements StatisticLegendService {

    @Resource
    private StatisticLegendMapper statisticLegendMapper;

    @Override
    protected BaseMapper<StatisticLegend> getMasterMapper() {
        return statisticLegendMapper;
    }
}


