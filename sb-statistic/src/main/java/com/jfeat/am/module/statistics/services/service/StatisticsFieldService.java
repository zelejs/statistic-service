package com.jfeat.am.module.statistics.services.service;

import com.jfeat.am.common.crud.CRUDServiceOverModelOne;
import com.jfeat.am.module.statistics.services.service.model.StatisticsFieldModel;
import com.jfeat.am.module.statistics.services.service.persistence.model.StatisticsField;
import com.jfeat.am.module.statistics.services.service.persistence.model.StatisticsRecord;


/**
 * <p>
 *  service interface
 * </p>
 *
 * @author Code Generator
 * @since 2017-11-25
 */

public interface StatisticsFieldService extends CRUDServiceOverModelOne<StatisticsField, StatisticsFieldModel, StatisticsRecord> {

    /**
     * 通过域名获取域信息
     */
    StatisticsField getStatisticFieldByName(String field);

    /**
     * 获取原始域数据
     * @param field
     * @return StatisticsField 域数据列表
     */
    StatisticsField getStatisticsFieldModel(String field);
}

