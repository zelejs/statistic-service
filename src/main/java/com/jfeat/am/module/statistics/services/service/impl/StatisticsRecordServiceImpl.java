package com.jfeat.am.module.statistics.services.service.impl;
            
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsRecord;
import com.jfeat.am.module.statistics.services.persistence.dao.StatisticsRecordMapper;
import com.jfeat.am.module.statistics.services.service.StatisticsRecordService;
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
public class StatisticsRecordServiceImpl  extends CRUDServiceOnlyImpl<StatisticsRecord> implements StatisticsRecordService {


    @Resource
    private StatisticsRecordMapper statisticsRecordMapper;

    @Override
    protected BaseMapper<StatisticsRecord> getMasterMapper() {
        return statisticsRecordMapper;
    }
}


