package com.jfeat.am.module.statistics.services.converter.statistic;

import com.jfeat.am.module.statistics.services.converter.StatisticData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vincent on 2018/5/25.
 */
public class StatisticDataRateCluster extends StatisticData {
    private String name;
    private List<Map<String,StatisticDataRate>> cluster;

    public List<Map<String,StatisticDataRate>> getCluster() {
        return cluster;
    }

    public void setCluster(List<Map<String,StatisticDataRate>> cluster) {
        this.cluster = cluster;
    }

    public StatisticDataRateCluster addTotal(String timeline, StatisticDataRate rate){
        if(this.cluster == null){
            this.cluster = new ArrayList<>();
        }

        Map<String,StatisticDataRate> stat = new HashMap<>();
        stat.put(timeline, rate);

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
