package com.jfeat.am.module.statistics.services.service.impl;

import com.alibaba.fastjson.JSONObject;
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

        return model;
    }

    @Override
    public JSONObject getFieldData(String field) {
        StatisticsField statisticsField = getFieldByFieldName(field);
        if (statisticsField == null) {
            throw new BusinessException(BusinessCode.BadRequest);
        }

        return retrieveMaster(statisticsField.getId(), new StatisticsFieldFilter(), null, null).toJSONObject();
    }
}
