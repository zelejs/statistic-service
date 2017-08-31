package com.jfeat.am.modular.statistic.service.impl;

import com.jfeat.am.common.persistence.dao.StatisticRecordMapper;
import com.jfeat.am.common.persistence.dao.TypeDefinitionMapper;
import com.jfeat.am.common.persistence.model.StatisticRecord;
import com.jfeat.am.common.persistence.model.TypeDefinition;
import com.jfeat.am.core.support.BeanKit;
import com.jfeat.am.modular.statistic.mq.MemberAnalysisNotifyData;
import com.jfeat.am.modular.statistic.service.StatcsticRecordService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Silent-Y on 2017/8/31.
 */
@Service
public class StaticsticRecordServiceImpl implements StatcsticRecordService{

    @Resource
    StatisticRecordMapper statisticRecordMapper;
    @Resource
    TypeDefinitionMapper typeDefinitionMapper;

    @Transactional
    public boolean insertStaticsticRecord(MemberAnalysisNotifyData memberAnalysisNotifyData){
        TypeDefinition typeDefinition = new TypeDefinition();
        typeDefinition.setName(memberAnalysisNotifyData.getType());
        typeDefinitionMapper.insert(typeDefinition);

        StatisticRecord statisticRecord = new StatisticRecord();
        BeanKit.copyProperties(memberAnalysisNotifyData,statisticRecord);
        statisticRecord.setTypeId(typeDefinition.getId());
        statisticRecordMapper.insert(statisticRecord);
        return true;
    }
}
