package com.jfeat.am.module.statistics.services.service;

import com.alibaba.fastjson.JSONObject;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsField;
import com.jfeat.am.module.statistics.services.service.model.StatisticsFieldModel;


/**
 * <p>
 *  service interface
 * </p>
 *
 * @author Code Generator
 * @since 2017-11-25
 */

public interface StatisticsFieldService  extends CRUDStatisticsFieldService{
    StatisticsField getFieldByFieldName(String field);
    StatisticsFieldModel getFieldModel(String field);
    JSONObject getFieldData(String field);
}
