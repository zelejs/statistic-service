package com.jfeat.am.module.statistics.services.service.impl;

import com.jfeat.am.common.exception.BusinessCode;
import com.jfeat.am.common.exception.BusinessException;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsField;
import com.jfeat.am.module.statistics.services.service.StatisticsFieldService;
import com.jfeat.am.module.statistics.services.service.filter.StatisticsFieldFilter;
import com.jfeat.am.module.statistics.services.service.model.StatisticsFieldModel;
import org.springframework.stereotype.Service;

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

    @Override
    public StatisticsField getStatisticsFieldModel(String field) {
        StatisticsField statisticsField = getStatisticFieldByName(field);
        if (statisticsField == null) {
            throw new BusinessException(BusinessCode.BadRequest);
        }

        /// 如果需要实时查询，跳过获取统计项
        if(statisticsField.getQuerySql()!=null){
            return statisticsField;
        }

        /// else
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
}
