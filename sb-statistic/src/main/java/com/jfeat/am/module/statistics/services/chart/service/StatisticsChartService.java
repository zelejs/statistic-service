package com.jfeat.am.module.statistics.services.chart.service;

import com.jfeat.am.module.statistics.services.chart.model.BarChartData;
import com.jfeat.am.module.statistics.services.chart.model.PieChartData;
import com.jfeat.am.module.statistics.services.chart.model.LineChartData;

import java.util.Map;

/**
 * Created by Silent-Y on 2017/12/4.
 */
public interface StatisticsChartService {
    PieChartData getPieData(String field);
    BarChartData getBarData(String field);
    LineChartData getLineData(String field);

    /// 时间节点折线图
    @Deprecated
    Map<String, Object> getStatisticLineData(String field, String startTime, String endTime);
}
