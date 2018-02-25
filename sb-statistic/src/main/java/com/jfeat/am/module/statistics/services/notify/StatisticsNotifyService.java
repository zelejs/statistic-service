package com.jfeat.am.module.statistics.services.notify;

import java.util.Map;

/**
 * Created by Silent-Y on 2017/12/4.
 */
public interface StatisticsNotifyService {
    Boolean insertStatisticRecord(StatisticsDataModel statisticsDataModel);

    boolean insertStatisticRecord(StatisticNotifyData memberAnalysisNotifyData);

    Map<String,Object> getEchartData(String field, String echart, String startTime, String endTime);
}
