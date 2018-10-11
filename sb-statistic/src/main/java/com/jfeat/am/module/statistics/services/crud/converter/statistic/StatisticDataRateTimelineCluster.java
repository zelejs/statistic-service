package com.jfeat.am.module.statistics.services.crud.converter.statistic;

import java.util.Map;

/**
 * Created by vincent on 2018/5/25.
 */
public class StatisticDataRateTimelineCluster extends StatisticData {
    private String name;
    private Map<String,Map<String, StatisticDataRate>> cluster;

}
