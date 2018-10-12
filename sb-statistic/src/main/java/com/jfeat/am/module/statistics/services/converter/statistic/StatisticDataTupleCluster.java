package com.jfeat.am.module.statistics.services.converter.statistic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vincent on 2018/5/25.
 */
public class StatisticDataTupleCluster extends StatisticData {
    private String name;
    private List<Map<String,StatisticDataTuple>> cluster;

    public List<Map<String,StatisticDataTuple>> getCluster() {
        return cluster;
    }

    public void setCluster(List<Map<String,StatisticDataTuple>> cluster) {
        this.cluster = cluster;
    }

    public StatisticDataTupleCluster addTotal(String timeline, StatisticDataTuple tuple){
        if(this.cluster == null){
            this.cluster = new ArrayList<>();
        }

        Map<String,StatisticDataTuple> stat = new HashMap<>();
        stat.put(timeline, tuple);

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
