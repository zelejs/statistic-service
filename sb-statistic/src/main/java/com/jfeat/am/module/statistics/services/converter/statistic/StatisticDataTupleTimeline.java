package com.jfeat.am.module.statistics.services.converter.statistic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vincent on 2018/5/25.
 */
public class StatisticDataTupleTimeline extends StatisticData {
    private String name;
    private List<Map<String,StatisticDataTuple>> timeline;

    public List<Map<String,StatisticDataTuple>> getTimeline() {
        return timeline;
    }

    public void setTimeline(List<Map<String,StatisticDataTuple>> timeline) {
        this.timeline = timeline;
    }

    public StatisticDataTupleTimeline addTotal(String timeline, StatisticDataTuple tuple){
        if(this.timeline == null){
            this.timeline = new ArrayList<>();
        }

        Map<String,StatisticDataTuple> stat = new HashMap<>();
        stat.put(timeline, tuple);

        this.timeline.add(stat);
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
