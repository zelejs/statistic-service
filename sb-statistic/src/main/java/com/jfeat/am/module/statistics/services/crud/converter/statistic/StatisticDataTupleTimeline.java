package com.jfeat.am.module.statistics.services.crud.converter.statistic;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vincent on 2018/5/25.
 */
public class StatisticDataTupleTimeline extends StatisticData {
    private String name;
    private java.util.Map<String, StatisticDataTuple> timeline;

    public Map<String, StatisticDataTuple> getTimeline() {
        return timeline;
    }

    public void setTimeline(Map<String, StatisticDataTuple> timeline) {
        this.timeline = timeline;
    }

    public StatisticDataTupleTimeline addTotal(String timeline, StatisticDataTuple rate){
        if(this.timeline == null){
            this.timeline = new HashMap<>();
        }
        this.timeline.put(timeline, rate);

        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
