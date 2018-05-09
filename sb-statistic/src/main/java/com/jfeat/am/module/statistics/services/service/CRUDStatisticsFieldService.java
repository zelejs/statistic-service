package com.jfeat.am.module.statistics.services.service;

import com.jfeat.am.common.crud.CRUDServiceOverModelOne;
import com.jfeat.am.module.statistics.services.statistic.model.StatisticsFieldModel;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsField;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsRecord;


/**
 * <p>
 *  service interface
 * </p>
 *
 * @author Code Generator
 * @since 2017-11-25
 */

public interface CRUDStatisticsFieldService extends CRUDServiceOverModelOne<StatisticsField, StatisticsFieldModel, StatisticsRecord> {
    /**
     * 通过域名获取域信息
     */
    StatisticsField getFieldByFieldName(String field);

}
