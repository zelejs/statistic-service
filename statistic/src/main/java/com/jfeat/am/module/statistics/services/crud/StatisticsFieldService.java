package com.jfeat.am.module.statistics.services.crud;

import com.jfeat.am.module.statistics.services.persistence.model.StatisticsField;
import com.jfeat.crud.plus.CRUDServiceOnly;


/**
 * <p>
 *  service interface
 * </p>
 *
 * @author Code Generator
 * @since 2017-11-25
 */

public interface StatisticsFieldService extends CRUDServiceOnly<StatisticsField> {

    /**
     * 通过域名获取域信息
     */
    StatisticsField getStatisticFieldByName(String field);

    /**
     * 获取原始域数据
     * @param field
     * @return StatisticsField 域数据列表
     */
    StatisticsField getStatisticsFieldModel(String field, String identifier);
}

