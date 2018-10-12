package com.jfeat.am.module.statistics.services.crud.converter.statistic;

import java.util.List;
import java.util.Map;

/**
 * Created by vincent on 2018/5/25.
 */
public class StatisticDataCountTimelineCluster extends StatisticData {
    private String name;
    private List<Map<String,List<Map<String,StatisticDataNameValue>>>> cluster;
}
