package com.jfeat.am.module.statistics.services.converter.statistic;

import com.jfeat.am.module.statistics.services.converter.StatisticData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vincent on 2018/5/25.
 */
public class StatisticDataTupleCluster extends StatisticData {
    private String name;
    private Map<String,StatisticDataTuple> cluster;

    public Map<String,StatisticDataTuple> getCluster() {
        return cluster;
    }

    public void setCluster(Map<String,StatisticDataTuple> cluster) {
        this.cluster = cluster;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
