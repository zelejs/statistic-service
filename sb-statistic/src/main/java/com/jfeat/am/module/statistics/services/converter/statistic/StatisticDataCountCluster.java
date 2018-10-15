package com.jfeat.am.module.statistics.services.converter.statistic;

import com.jfeat.am.module.statistics.services.converter.StatisticData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vincent on 2018/5/25.
 */
public class StatisticDataCountCluster extends StatisticData {
    private String name;
    private List<Map<String,StatisticDataNameValue>> cluster;

    public List<Map<String,StatisticDataNameValue>> getCluster() {
        return cluster;
    }

    public void setTimeline(List<Map<String,StatisticDataNameValue>> cluster) {
        this.cluster = cluster;
    }

    public StatisticDataCountCluster addCount(int seq, String id, String cluster, String name, String value){
        if(this.cluster == null){
            this.cluster = new ArrayList<>();
        }

        Map<String,StatisticDataNameValue> stat = new HashMap<>();
        stat.put(cluster, new StatisticDataNameValue(seq, id, name, value));

        this.cluster.add(stat);
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
