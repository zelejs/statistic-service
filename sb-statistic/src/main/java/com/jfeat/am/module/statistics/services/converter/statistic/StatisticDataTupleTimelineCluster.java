package com.jfeat.am.module.statistics.services.converter.statistic;

import com.jfeat.am.module.statistics.services.converter.StatisticData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vincent on 2018/5/25.
 */
public class StatisticDataTupleTimelineCluster extends StatisticData {
    private String name;
    private Map<String,StatisticDataTupleTimeline> cluster;

    public Map<String,StatisticDataTupleTimeline> getCluster() {
        return cluster;
    }

    public void setCluster(Map<String,StatisticDataTupleTimeline> cluster) {
        this.cluster = cluster;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
