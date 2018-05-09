package com.jfeat.am.module.statistics.services.statistic.service;

import com.jfeat.am.module.statistics.services.service.CRUDStatisticsFieldService;
import com.jfeat.am.module.statistics.services.statistic.model.StatisticsFieldCluster;
import com.jfeat.am.module.statistics.services.statistic.model.StatisticsFieldModel;
import com.jfeat.am.module.statistics.services.statistic.model.StatisticsFieldTuple;


/**
 * <p>
 *  service interface
 * </p>
 *
 * @author Code Generator
 * @since 2017-11-25
 */

public interface StatisticsFieldService  extends CRUDStatisticsFieldService {

    /**
     * 获取统计域的统计数据
     * @param field
     * @return StatisticsFieldModel 域数据列表
     */
    StatisticsFieldModel getFieldAmount(String field);


    /**
     * 获取统计域的统计数据
     * @param field
     * @return StatisticsFieldModel 域数据列表
     */
    StatisticsFieldTuple getFieldTuple(String field);


    /**
     * 获取统计域的统计数据
     * @param field
     * @return StatisticsFieldModel 域数据列表
     */
    StatisticsFieldCluster getFieldCluster(String field);



}

