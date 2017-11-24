package com.jfeat.am.module.statistics.services.service.impl;
            
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsField;
import com.jfeat.am.module.statistics.services.persistence.dao.StatisticsFieldMapper;
import com.jfeat.am.module.statistics.services.service.StatisticsFieldService;
import com.jfeat.am.common.crud.impl.CRUDServiceOnlyImpl;
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
@Deprecated
@Service
public class StatisticsFieldServiceImpl  extends CRUDServiceOnlyImpl<StatisticsField> implements StatisticsFieldService {


    @Resource
    private StatisticsFieldMapper statisticsFieldMapper;

    @Override
    protected BaseMapper<StatisticsField> getMasterMapper() {
        return statisticsFieldMapper;
    }
}


