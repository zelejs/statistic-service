package com.jfeat.am.module.statistics.services.crud.converter.statistic;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vincent on 2018/5/25.
 */
public class StatisticDataCountCluster extends StatisticData {
    private String name;
    private Map<String, StatisticDataCount> cluster;

    public Map<String, StatisticDataCount> getTimeline() {
        return cluster;
    }

    public void setTimeline(Map<String, StatisticDataCount> timeline) {
        this.cluster = timeline;
    }

    public StatisticDataCountCluster addTotal(String timeline, String name, String value){
        if(this.cluster == null){
            this.cluster = new HashMap<>();
        }
        this.cluster.put(timeline, new StatisticDataCount(name,value));

        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
