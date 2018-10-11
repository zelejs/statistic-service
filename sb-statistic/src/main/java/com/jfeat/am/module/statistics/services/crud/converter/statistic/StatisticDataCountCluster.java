package com.jfeat.am.module.statistics.services.crud.converter.statistic;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vincent on 2018/5/25.
 */
public class StatisticDataCountCluster extends StatisticData {
    private String name;
    private Map<String, StatisticDataNameValue> cluster;

    public Map<String, StatisticDataNameValue> getCluster() {
        return cluster;
    }

    public void setTimeline(Map<String, StatisticDataNameValue> cluster) {
        this.cluster = cluster;
    }

    public StatisticDataCountCluster addCount(String id, String cluster, String name, String value){
        if(this.cluster == null){
            this.cluster = new HashMap<>();
        }
        this.cluster.put(cluster, new StatisticDataNameValue(id, name, value));

        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
