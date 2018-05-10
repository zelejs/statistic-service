package com.jfeat.am.module.statistics.services.statistic.service.impl;

import com.jfeat.am.common.exception.BusinessCode;
import com.jfeat.am.common.exception.BusinessException;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsField;
import com.jfeat.am.module.statistics.services.service.StatisticsRecordService;
import com.jfeat.am.module.statistics.services.service.filter.StatisticsFieldFilter;
import com.jfeat.am.module.statistics.services.service.impl.CRUDStatisticsFieldServiceImpl;
import com.jfeat.am.module.statistics.services.statistic.model.StatisticsFieldCluster;
import com.jfeat.am.module.statistics.services.statistic.model.StatisticsFieldModel;
import com.jfeat.am.module.statistics.services.statistic.model.StatisticsFieldTuple;
import com.jfeat.am.module.statistics.services.statistic.service.StatisticsFieldService;
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
public class StatisticsFieldServiceImpl extends CRUDStatisticsFieldServiceImpl implements StatisticsFieldService {

    @Resource
    StatisticsRecordService statisticsRecordService;

    @Override
    public StatisticsFieldModel getFieldAmount(String field) {
        StatisticsField statisticsField = getFieldByFieldName(field);
        if (statisticsField == null) {
            throw new BusinessException(BusinessCode.BadRequest);
        }
        StatisticsFieldModel model = retrieveMaster(statisticsField.getId(), new StatisticsFieldFilter(), null, null)
                .toJavaObject(StatisticsFieldModel.class);

        /// update record name by record attr
        /*if(model!=null){
            List<StatisticsRecord> records = model.getItems();

            if(records!=null) {

                for (StatisticsRecord record : records) {
                    StatisticsRecordModel recordModel = statisticsRecordService.getStatisticsRecordModel(record);
                    if (recordModel.getAttr() != null) {
                        record.setRecordName(recordModel.getAttr().getLegend());
                    }
                }
            }
        }*/

        return model;
    }

    @Override
    public StatisticsFieldTuple getFieldTuple(String field) {
        StatisticsField statisticsField = getFieldByFieldName(field);
        if (statisticsField == null) {
            throw new BusinessException(BusinessCode.BadRequest);
        }
        StatisticsFieldModel model = retrieveMaster(statisticsField.getId(), new StatisticsFieldFilter(), null, null)
                .toJavaObject(StatisticsFieldModel.class);

        StatisticsFieldTuple tuple = new StatisticsFieldTuple();

        //TODO,


        return tuple;
    }

    @Override
    public StatisticsFieldCluster getFieldCluster(String field) {
        StatisticsField statisticsField = getFieldByFieldName(field);
        if (statisticsField == null) {
            throw new BusinessException(BusinessCode.BadRequest);
        }
        StatisticsFieldModel model = retrieveMaster(statisticsField.getId(), new StatisticsFieldFilter(), null, null)
                .toJavaObject(StatisticsFieldModel.class);

        StatisticsFieldCluster cluster = new StatisticsFieldCluster();

        //TODO,


        return cluster;
    }
}
