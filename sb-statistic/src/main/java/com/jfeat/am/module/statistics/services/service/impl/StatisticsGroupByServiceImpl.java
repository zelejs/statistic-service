package com.jfeat.am.module.statistics.services.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jfeat.am.common.crud.impl.CRUDServiceGroupByImpl;
import com.jfeat.am.module.statistics.services.service.persistence.dao.StatisticsFieldMapper;
import com.jfeat.am.module.statistics.services.service.persistence.dao.StatisticsGroupMapper;
import com.jfeat.am.module.statistics.services.service.persistence.model.StatisticsField;
import com.jfeat.am.module.statistics.services.service.persistence.model.StatisticsGroup;
import com.jfeat.am.module.statistics.services.service.StatisticsGroupByService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  implementation
 * </p>
 *
 * @author Code Generator
 * @since 2017-11-25
 */
@Service
public class StatisticsGroupByServiceImpl extends CRUDServiceGroupByImpl<StatisticsGroup, StatisticsField>
        implements StatisticsGroupByService {

    static final String groupById = "group_id";

    @Resource
    private StatisticsGroupMapper statisticsGroupMapper;

    @Resource
    private StatisticsFieldMapper statisticsFieldMapper;

    @Override
    protected BaseMapper<StatisticsGroup> getGroupMapper() {
        return statisticsGroupMapper;
    }

    @Override
    protected BaseMapper<StatisticsField> getGroupByMapper() {
        return statisticsFieldMapper;
    }

    @Override
    protected String groupByFieldName() {
        return groupById;
    }
}


