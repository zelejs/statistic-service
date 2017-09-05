package com.jfeat.am.modular.statistic.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.toolkit.IdWorker;
import com.jfeat.am.common.persistence.dao.StatisticFieldMapper;
import com.jfeat.am.common.persistence.dao.StatisticRecordMapper;
import com.jfeat.am.common.persistence.dao.TypeDefinitionMapper;
import com.jfeat.am.common.persistence.model.StatisticField;
import com.jfeat.am.common.persistence.model.StatisticRecord;
import com.jfeat.am.common.persistence.model.TypeDefinition;
import com.jfeat.am.core.support.BeanKit;
import com.jfeat.am.modular.statistic.dao.StatisticRecordDao;
import com.jfeat.am.modular.statistic.mq.StatisticNotifyData;
import com.jfeat.am.modular.statistic.service.StatisticRecordService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Silent-Y on 2017/8/31.
 */
@Service
public class StatisticRecordServiceImpl extends ServiceImpl<StatisticRecordMapper, StatisticRecord> implements StatisticRecordService {

    @Resource
    TypeDefinitionMapper typeDefinitionMapper;
    @Resource
    StatisticRecordDao statisticRecordDao;
    @Resource
    StatisticFieldMapper statisticFieldMapper;

    @Transactional
    public boolean insertStatisticRecord(StatisticNotifyData statisticNotifyData) {

        Map<String, String> map = statisticNotifyData.getValue();
        Long group = IdWorker.getId();

        //插入type
        TypeDefinition query = new TypeDefinition();
        query.setIdentifier(statisticNotifyData.getIdentifier());
        TypeDefinition typeDefinition = typeDefinitionMapper.selectOne(query);
        if (typeDefinition == null) {
            typeDefinition = new TypeDefinition();
            typeDefinition.setName(statisticNotifyData.getDefaultName());
            typeDefinition.setIdentifier(statisticNotifyData.getIdentifier());
            typeDefinitionMapper.insert(typeDefinition);
        }

        //插入field
        Integer count = statisticFieldMapper.selectCount(new EntityWrapper<StatisticField>().eq("type_id",typeDefinition.getId()));
        if (count < 1){
            for (Map.Entry<String,String> entry:map.entrySet()){
                StatisticField statisticField = new StatisticField();
                statisticField.setTypeId(typeDefinition.getId());
                statisticField.setName(entry.getKey());
                statisticField.setDisplayName(entry.getKey());
                statisticFieldMapper.insert(statisticField);
            }
        }

        //插入record
        for (Map.Entry<String,String> entry:map.entrySet()){
            StatisticRecord statisticRecord = new StatisticRecord();
            statisticRecord.setRecordTime(statisticNotifyData.getRecordTime());
            statisticRecord.setTypeId(typeDefinition.getId());
            statisticRecord.setFieldName(entry.getKey());
            statisticRecord.setValue(entry.getValue());
            statisticRecord.setGroup(group);
            insert(statisticRecord);
        }
        return true;
    }

    public List<Map<String,String>> getStatisticRecordByTypeIdAndStartTimeAndEndTime(List<String> fields,String startTime,String endTime){
        return statisticRecordDao.getStatisticRecordByTypeIdAndStartTimeAndEndTime(fields,startTime,endTime);
    }
}