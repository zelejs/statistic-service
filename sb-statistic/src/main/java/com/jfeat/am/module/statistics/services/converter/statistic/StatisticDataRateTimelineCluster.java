package com.jfeat.am.module.statistics.services.converter.statistic;

import com.jfeat.am.module.statistics.services.converter.StatisticData;

import java.util.List;
import java.util.Map;

/**
 * Created by vincent on 2018/5/25.
 */
public class StatisticDataRateTimelineCluster extends StatisticData {
    private String name;
    private List<Map<String,List<Map<String, StatisticDataRate>>>> cluster;
}
