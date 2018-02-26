package com.jfeat.am.module.statistics.services.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jfeat.am.common.exception.BusinessCode;
import com.jfeat.am.common.exception.BusinessException;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsField;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsRecord;
import com.jfeat.am.module.statistics.services.service.StatisticsFieldService;
import com.jfeat.am.module.statistics.services.service.StatisticsRecordService;
import com.jfeat.am.module.statistics.services.service.filter.StatisticsFieldFilter;
import com.jfeat.am.module.statistics.services.service.model.StatisticsFieldModel;
import com.jfeat.am.module.statistics.services.service.model.StatisticsRecordModel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;

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
    public StatisticsField getFieldByFieldName(String field) {
        StatisticsField queryItem = new StatisticsField();
        queryItem.setField(field);
        return statisticsFieldMapper.selectOne(queryItem);
    }

    @Override
    public StatisticsFieldModel getFieldModel(String field) {
        StatisticsField statisticsField = getFieldByFieldName(field);
        if (statisticsField == null) {
            throw new BusinessException(BusinessCode.BadRequest);
        }
        StatisticsFieldModel model = retrieveMaster(statisticsField.getId(), new StatisticsFieldFilter(), null, null)
                .toJavaObject(StatisticsFieldModel.class);


        /// update record name by record attr
        if(model!=null){
            List<StatisticsRecord> records = model.getItems();

            if(records!=null) {

                for (StatisticsRecord record : records) {
                    StatisticsRecordModel recordModel = statisticsRecordService.getStatisticsRecordModel(record);
                    if (recordModel.getAttr() != null) {
                        record.setRecordName(recordModel.getAttr().getLegend());
                    }
                }
            }
        }

        return model;
    }

    @Override
    public JSONObject getFieldData(String field) {
        StatisticsField statisticsField = getFieldByFieldName(field);
        if (statisticsField == null) {
            throw new BusinessException(BusinessCode.BadRequest);
        }

        JSONObject jsonObject = retrieveMaster(statisticsField.getId(), new StatisticsFieldFilter(), null, null)
                .toJSONObject();


        /// update record name by record attr
        ///

        if(jsonObject!=null){
            JSONArray records = jsonObject.getJSONArray("items");

            if(records!=null) {

                Iterator<Object> it = records.iterator();
                while (it.hasNext()){
                    JSONObject item  = (JSONObject) it.next();

                    StatisticsRecord record = JSON.toJavaObject(item, StatisticsRecord.class);
                    StatisticsRecordModel recordModel = statisticsRecordService.getStatisticsRecordModel(record);
                    if (recordModel.getAttr() != null) {
                        item.put(StatisticsRecord.RECORD_NAME, recordModel.getAttr().getLegend());
                    }
                }
            }
        }

        return jsonObject;
    }
}
