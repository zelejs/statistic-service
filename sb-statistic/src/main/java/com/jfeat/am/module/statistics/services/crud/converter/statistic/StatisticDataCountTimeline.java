package com.jfeat.am.module.statistics.services.crud.converter.statistic;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vincent on 2018/5/25.
 */
public class StatisticDataCountTimeline extends StatisticData {
    private String name;
    private java.util.Map<String, StatisticDataNameValue> timeline;

    public Map<String, StatisticDataNameValue> getTimeline() {
        return timeline;
    }

    public void setTimeline(Map<String, StatisticDataNameValue> timeline) {
        this.timeline = timeline;
    }

    public StatisticDataCountTimeline addCount(String id, String timeline, String name, String value){
        if(this.timeline == null){
            this.timeline = new HashMap<>();
        }
        this.timeline.put(timeline, new StatisticDataNameValue(id, name,value));

        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
