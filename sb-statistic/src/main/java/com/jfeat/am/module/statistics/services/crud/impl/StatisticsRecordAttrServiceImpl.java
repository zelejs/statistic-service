package com.jfeat.am.module.statistics.services.crud.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jfeat.am.common.crud.impl.CRUDServiceOnlyImpl;
import com.jfeat.am.module.statistics.services.persistence.dao.StatisticsRecordAttrMapper;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsRecordAttr;
import com.jfeat.am.module.statistics.services.crud.StatisticsRecordAttrService;
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
public class StatisticsRecordAttrServiceImpl extends CRUDServiceOnlyImpl<StatisticsRecordAttr> implements StatisticsRecordAttrService {

    @Resource
    private StatisticsRecordAttrMapper statisticsRecordAttrMapper;

    @Override
    protected BaseMapper<StatisticsRecordAttr> getMasterMapper() {
        return statisticsRecordAttrMapper;
    }
}


