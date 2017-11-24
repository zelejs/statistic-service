package com.jfeat.am.module.statistics.services.service.impl;
            
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticGroup;
import com.jfeat.am.module.statistics.services.persistence.dao.StatisticGroupMapper;
import com.jfeat.am.module.statistics.services.service.StatisticGroupService;
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
public class StatisticGroupServiceImpl  extends CRUDServiceOnlyImpl<StatisticGroup> implements StatisticGroupService {

    @Resource
    private StatisticGroupMapper statisticGroupMapper;

    @Override
    protected BaseMapper<StatisticGroup> getMasterMapper() {
        return statisticGroupMapper;
    }
}


