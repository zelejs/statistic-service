package com.jfeat.am.modular.statistic.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jfeat.am.common.persistence.dao.StatisticRecordMapper;
import com.jfeat.am.common.persistence.dao.TypeDefinitionMapper;
import com.jfeat.am.common.persistence.model.StatisticRecord;
import com.jfeat.am.common.persistence.model.TypeDefinition;
import com.jfeat.am.core.support.BeanKit;
import com.jfeat.am.modular.statistic.mq.StatisticNotifyData;
import com.jfeat.am.modular.statistic.service.StatisticRecordService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Silent-Y on 2017/8/31.
 */
@Service
public class StatisticRecordServiceImpl extends ServiceImpl<StatisticRecordMapper, StatisticRecord> implements StatisticRecordService {

    @Resource
    TypeDefinitionMapper typeDefinitionMapper;

    @Transactional
    public boolean insertStatisticRecord(StatisticNotifyData statisticNotifyData) {
        TypeDefinition query = new TypeDefinition();
        query.setIdentifier(statisticNotifyData.getIdentifier());
        TypeDefinition typeDefinition = typeDefinitionMapper.selectOne(query);
        if (typeDefinition == null) {
            typeDefinition = new TypeDefinition();
            typeDefinition.setName(statisticNotifyData.getDefaultName());
            typeDefinition.setIdentifier(statisticNotifyData.getIdentifier());
            typeDefinitionMapper.insert(typeDefinition);
        }

        //TODO 从 statisticNotifyData.getValue() 迭代取出填到record
        Map<String, String> map = statisticNotifyData.getValue();
        for (Map.Entry<String,String> entry:map.entrySet()){
            StatisticRecord statisticRecord = new StatisticRecord();
            statisticRecord.setRecordTime(statisticNotifyData.getRecordTime());
            statisticRecord.setTypeId(typeDefinition.getId());
            statisticRecord.setFieldName(entry.getKey());
            statisticRecord.setValue(entry.getValue().toString());
            insert(statisticRecord);
        }
        return true;
    }
}
