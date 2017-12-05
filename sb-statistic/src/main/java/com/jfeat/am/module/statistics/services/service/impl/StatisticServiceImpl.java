package com.jfeat.am.module.statistics.services.service.impl;

import com.jfeat.am.module.statistics.services.domain.model.DataModel;
import com.jfeat.am.module.statistics.services.persistence.dao.StatisticsFieldMapper;
import com.jfeat.am.module.statistics.services.persistence.dao.StatisticsGroupMapper;
import com.jfeat.am.module.statistics.services.persistence.dao.StatisticsRecordAttrMapper;
import com.jfeat.am.module.statistics.services.persistence.dao.StatisticsRecordMapper;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsField;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsGroup;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsRecord;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsRecordAttr;
import com.jfeat.am.module.statistics.services.service.StatisticService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.lang.Boolean;import java.lang.Override;import java.lang.String;import java.util.List;

/**
 * Created by Silent-Y on 2017/12/4.
 */
@Service
public class StatisticServiceImpl implements StatisticService {

    @Resource
    private StatisticsGroupMapper statisticsGroupMapper;
    @Resource
    private StatisticsFieldMapper statisticsFieldMapper;
    @Resource
    private StatisticsRecordMapper statisticsRecordMapper;
    @Resource
    private StatisticsRecordAttrMapper statisticsRecordAttrMapper;

    @Override
    @Transactional
    public Boolean insertStatisticRecord(DataModel dataModel) {
        String field = dataModel.getField().getField();
        StatisticsField statisticsField = new StatisticsField();
        statisticsField.setField(field);
        statisticsField = statisticsFieldMapper.selectOne(statisticsField);
        String identifier = dataModel.getGroup().getIdentifier();
        StatisticsGroup statisticsGroup = new StatisticsGroup();
        statisticsGroup.setIdentifier(identifier);
        statisticsGroup = statisticsGroupMapper.selectOne(statisticsGroup);
        if (statisticsGroup == null){
            statisticsGroup = dataModel.getGroup();
            statisticsGroupMapper.insert(statisticsGroup);
        }
        if (statisticsField == null) {
            statisticsField = dataModel.getField();
            statisticsField.setGroupId(statisticsGroup.getId());
            statisticsFieldMapper.insert(statisticsField);
        }
        for (StatisticsRecord statisticsRecord : dataModel.getRecords()) {
            statisticsRecord.setFieldId(statisticsField.getId());
            statisticsRecord.setField(statisticsField.getField());
            statisticsRecordMapper.insert(statisticsRecord);
            StatisticsRecordAttr statisticsRecordAttr = new StatisticsRecordAttr();
            statisticsRecordAttr.setLegend(statisticsRecord.getLegend());
            statisticsRecordAttr = statisticsRecordAttrMapper.selectOne(statisticsRecordAttr);
            if (statisticsRecordAttr == null){
                statisticsRecordAttr = new StatisticsRecordAttr();
                statisticsRecordAttr.setRecordId(statisticsRecord.getId());
                statisticsRecordAttr.setLegend(statisticsRecord.getLegend());
                statisticsRecordAttrMapper.insert(statisticsRecordAttr);
            }
        }
        return true;
    }
}
