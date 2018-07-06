package com.jfeat.am.module.statistics.services.service.converter.statistic;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vincent on 2018/5/25.
 */
public class StatisticDataTotalTimeline extends StatisticData {
    private String name;
    private java.util.Map<String, StatisticDataTotal> timeline;

    public Map<String, StatisticDataTotal> getTimeline() {
        return timeline;
    }

    public void setTimeline(Map<String, StatisticDataTotal> timeline) {
        this.timeline = timeline;
    }

    public StatisticDataTotalTimeline addTotal(String timeline, String name, String value){
        if(this.timeline == null){
            this.timeline = new HashMap<>();
        }
        this.timeline.put(timeline, new StatisticDataTotal(name,value));

        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
