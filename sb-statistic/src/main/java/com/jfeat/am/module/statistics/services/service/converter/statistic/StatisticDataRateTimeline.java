package com.jfeat.am.module.statistics.services.service.converter.statistic;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vincent on 2018/5/25.
 */
public class StatisticDataRateTimeline extends StatisticData {
    private String name;
    private java.util.Map<String, StatisticDataRate> timeline;

    public Map<String, StatisticDataRate> getTimeline() {
        return timeline;
    }

    public void setTimeline(Map<String, StatisticDataRate> timeline) {
        this.timeline = timeline;
    }

    public StatisticDataRateTimeline addTotal(String timeline, StatisticDataRate rate){
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
