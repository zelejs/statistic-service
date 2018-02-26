package com.jfeat.am.module.statistics.services.notify;

import com.jfeat.am.module.statistics.services.persistence.dao.StatisticsRecordMapper;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsRecord;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Silent-Y on 2017/12/4.
 */
@Service
public class StatisticsNotifyServiceImpl implements StatisticsNotifyService {

    @Resource
    private StatisticsRecordMapper statisticsRecordMapper;

    @Transactional
    public boolean insertStatisticRecord(StatisticNotifyData statisticNotifyData) {

        List<Statistic> statisticList = statisticNotifyData.getValues();

        //插入field
        // 指标，这里指 field, 在运维阶段预先设定好即可
        /*for (Statistic statistic : statisticList) {
            Integer count = statisticFieldMapper.selectCount(new EntityWrapper<StatisticField>()
                    .eq("type_id", typeDefinition.getId()).eq("name", statistic.getKey()));
            if (count < 1){
                StatisticsField statisticsField = new StatisticsField();
                statisticsField.setName(statistic.getKey());
                statisticsField.setDisplayName(statistic.getName());
                statisticFieldMapper.insert(statisticsField);
            }
        }*/

        for (Statistic statistic : statisticList) {
            StatisticsRecord statisticRecord = new StatisticsRecord();
            statisticRecord.setField(statistic.getKey());
            statisticRecord.setRecordName(statistic.getName());


            /// check exists first
            StatisticsRecord one = statisticsRecordMapper.selectOne(statisticRecord);
            if(one==null){

                // add new

                statisticRecord.setRecordValue(statistic.getValue());
                statisticRecord.setRecordTime(statisticNotifyData.getRecordTime());

                statisticsRecordMapper.insert(statisticRecord);

            }else{
                /// just update

                one.setRecordValue(statistic.getValue());
                one.setRecordTime(statisticNotifyData.getRecordTime());

                statisticsRecordMapper.updateById(one);
            }
        }

        return true;
    }
}
