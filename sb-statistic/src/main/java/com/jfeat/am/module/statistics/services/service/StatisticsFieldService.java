package com.jfeat.am.module.statistics.services.service;

import com.jfeat.am.module.statistics.services.persistence.model.StatisticsField;


/**
 * <p>
 *  service interface
 * </p>
 *
 * @author Code Generator
 * @since 2017-11-25
 */

public interface StatisticsFieldService extends CRUDStatisticsFieldService {

    /**
     * 获取原始域数据
     * @param field
     * @return StatisticsField 域数据列表
     */
    StatisticsField getStatisticsFieldModel(String field);
}

