package com.jfeat.am.module.statistics.services.crud.converter.statistic;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vincent on 2018/5/25.
 */
public class StatisticDataRateCluster extends StatisticData {
    private String name;
    private Map<String, StatisticDataRate> cluster;

    public Map<String, StatisticDataRate> getCluster() {
        return cluster;
    }

    public void setCluster(Map<String, StatisticDataRate> cluster) {
        this.cluster = cluster;
    }

    public StatisticDataRateCluster addTotal(String timeline, StatisticDataRate rate){
        if(this.cluster == null){
            this.cluster = new HashMap<>();
        }
        this.cluster.put(timeline, rate);

        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
