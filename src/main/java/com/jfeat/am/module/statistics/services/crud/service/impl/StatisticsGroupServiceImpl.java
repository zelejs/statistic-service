package com.jfeat.am.module.statistics.services.crud.service.impl;
            
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsGroup;
import com.jfeat.am.module.statistics.services.persistence.dao.StatisticsGroupMapper;
import com.jfeat.am.module.statistics.services.crud.service.StatisticsGroupService;
import com.jfeat.am.common.crud.impl.CRUDServiceOnlyImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import com.jfeat.am.common.crud.impl.CRUDServiceOnlyImpl;
/**
 * <p>
 *  implementation
 * </p>
 *
 * @author Code Generator
 * @since 2017-11-25
 */
@Deprecated
@Service
public class StatisticsGroupServiceImpl  extends CRUDServiceOnlyImpl<StatisticsGroup> implements StatisticsGroupService {


    @Resource
    private StatisticsGroupMapper statisticsGroupMapper;

    @Override
    protected BaseMapper<StatisticsGroup> getMasterMapper() {
        return statisticsGroupMapper;
    }
}


