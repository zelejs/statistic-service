package com.jfeat.am.module.statistics.services.service;

import com.jfeat.am.module.statistics.services.domain.model.StatisticsDataModel;

import java.util.Map;

/**
 * Created by Silent-Y on 2017/12/4.
 */
public interface StatisticService {

    Boolean insertStatisticRecord(StatisticsDataModel statisticsDataModel);

    Map<String,Object> getEchartData(String field,String echart,String startTime,String endTime);
}
