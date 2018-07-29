package com.jfeat.am.module.statistics.services.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jfeat.am.common.crud.impl.CRUDServiceOverModelOneImpl;
import com.jfeat.am.common.exception.BusinessCode;
import com.jfeat.am.common.exception.BusinessException;
import com.jfeat.am.module.statistics.services.service.persistence.dao.StatisticsFieldMapper;
import com.jfeat.am.module.statistics.services.service.persistence.dao.StatisticsRecordMapper;
import com.jfeat.am.module.statistics.services.service.persistence.model.StatisticsField;
import com.jfeat.am.module.statistics.services.service.StatisticsFieldService;
import com.jfeat.am.module.statistics.services.service.filter.StatisticsFieldFilter;
import com.jfeat.am.module.statistics.services.service.model.StatisticsFieldModel;
import com.jfeat.am.module.statistics.services.service.persistence.model.StatisticsRecord;
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
public class StatisticsFieldServiceImpl extends CRUDServiceOverModelOneImpl<StatisticsField,StatisticsFieldModel,StatisticsRecord>
        implements StatisticsFieldService {
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
     * 通过域名获取域数据
     */
    @Override
    public StatisticsField getStatisticFieldByName(String field) {
        StatisticsField queryItem = new StatisticsField();
        queryItem.setField(field);
        return statisticsFieldMapper.selectOne(queryItem);
    }

    @Override
    public StatisticsField getStatisticsFieldModel(String field) {
        StatisticsField statisticsField = getStatisticFieldByName(field);
        if (statisticsField == null) {
            throw new BusinessException(BusinessCode.BadRequest);
        }

        /// 如果需要实时查询，跳过获取统计项
        //if(statisticsField.getQuerySql()!=null){
        //    return statisticsField;
        //}

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
