package com.jfeat.am.module.statistics.services.service;

import com.jfeat.am.module.statistics.bean.BarChartBean;
import com.jfeat.am.module.statistics.bean.LineChartBean;
import com.jfeat.am.module.statistics.bean.PieChartBean;

import java.util.Map;

/**
 * Created by Silent-Y on 2017/12/4.
 */
public interface StatisticsChartService {
    PieChartBean getPieData(String field);
    BarChartBean getBarData(String field);
    LineChartBean getLineData(String field);

    /// 时间节点折线图
    @Deprecated
    Map<String, Object> getStatisticLineData(String field, String startTime, String endTime);
}
