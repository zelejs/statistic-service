package com.jfeat.am.module.statistics.services.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jfeat.am.common.crud.impl.CRUDServiceOverModelOneImpl;
import com.jfeat.am.module.statistics.services.persistence.dao.StatisticsFieldMapper;
import com.jfeat.am.module.statistics.services.persistence.dao.StatisticsRecordMapper;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsField;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsRecord;
import com.jfeat.am.module.statistics.services.service.CRUDStatisticsFieldService;
import com.jfeat.am.module.statistics.services.statistic.model.StatisticsFieldModel;
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
public class CRUDStatisticsFieldServiceImpl
        extends CRUDServiceOverModelOneImpl<StatisticsField,StatisticsFieldModel,StatisticsRecord>
        implements CRUDStatisticsFieldService {

    @Resource
    StatisticsFieldMapper statisticsFieldMapper;
    @Resource
    StatisticsRecordMapper statisticsRecordMapper;

    static final String SLAVE_MASTER_ID = "field_id";

    @Override
    protected BaseMapper<StatisticsField> getMasterMapper() {
        return statisticsFieldMapper;
    }

    @Override
    protected BaseMapper<StatisticsRecord> getSlaveMapper() {
        return statisticsRecordMapper;
    }

    @Override
    protected Class<StatisticsRecord> getSlaveClassName() {
        return StatisticsRecord.class;
    }

    @Override
    protected String getSlaveMasterField() {
        return SLAVE_MASTER_ID;
    }

    @Override
    protected Class<StatisticsField> masterClassName() {
        return StatisticsField.class;
    }

    @Override
    protected Class<StatisticsFieldModel> modelClassName() {
        return StatisticsFieldModel.class;
    }


    /**
     *
     */

    @Override
    public StatisticsField getFieldByFieldName(String field) {
        StatisticsField queryItem = new StatisticsField();
        queryItem.setField(field);
        return statisticsFieldMapper.selectOne(queryItem);
    }


    /*
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
    }*/

}


