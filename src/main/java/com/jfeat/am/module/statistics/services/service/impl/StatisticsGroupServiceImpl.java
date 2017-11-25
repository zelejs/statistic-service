package com.jfeat.am.module.statistics.services.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jfeat.am.common.crud.impl.CRUDServiceGroupImpl;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsGroup;
import com.jfeat.am.module.statistics.services.persistence.dao.StatisticsGroupMapper;
import com.jfeat.am.module.statistics.services.service.StatisticsGroupService;
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
public class StatisticsGroupServiceImpl  extends CRUDServiceGroupImpl<StatisticsGroup> implements StatisticsGroupService {

    @Resource
    private StatisticsGroupMapper statisticsGroupMapper;

    @Override
    protected BaseMapper<StatisticsGroup> getGroupMapper() {
        return statisticsGroupMapper;
    }
}


