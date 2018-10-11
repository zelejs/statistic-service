package com.jfeat.am.module.statistics.services.crud.converter.statistic;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vincent on 2018/5/25.
 */
public class StatisticDataCountTimeline extends StatisticData {
    private String name;
    private java.util.Map<String, StatisticDataCount> timeline;

    public Map<String, StatisticDataCount> getTimeline() {
        return timeline;
    }

    public void setTimeline(Map<String, StatisticDataCount> timeline) {
        this.timeline = timeline;
    }

    public StatisticDataCountTimeline addTotal(String timeline, String name, String value){
        if(this.timeline == null){
            this.timeline = new HashMap<>();
        }
        this.timeline.put(timeline, new StatisticDataCount(name,value));

        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
