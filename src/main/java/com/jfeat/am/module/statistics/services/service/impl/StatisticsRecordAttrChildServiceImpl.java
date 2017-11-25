package com.jfeat.am.module.statistics.services.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jfeat.am.common.crud.impl.CRUDServiceChildImpl;
import com.jfeat.am.module.statistics.services.persistence.dao.StatisticsRecordAttrMapper;
import com.jfeat.am.module.statistics.services.persistence.dao.StatisticsRecordMapper;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsRecord;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsRecordAttr;
import com.jfeat.am.module.statistics.services.service.StatisticsRecordAttrChildService;
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
public class StatisticsRecordAttrChildServiceImpl extends CRUDServiceChildImpl<StatisticsRecord,StatisticsRecordAttr> implements StatisticsRecordAttrChildService {

    @Resource
    StatisticsRecordMapper statisticsRecordMapper;
    @Resource
    StatisticsRecordAttrMapper statisticsRecordAttrMapper;

    static final String attrReference = "attr_id";

    @Override
    protected BaseMapper<StatisticsRecord> getMasterMapper() {
        return statisticsRecordMapper;
    }

    @Override
    protected BaseMapper getChildMapper() {
        return statisticsRecordAttrMapper;
    }

    @Override
    protected String getChildReference() {
        return attrReference;
    }
}


