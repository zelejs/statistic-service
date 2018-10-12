package com.jfeat.am.module.statistics.services.crud.converter.statistic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vincent on 2018/5/25.
 */
public class StatisticDataRateTimeline extends StatisticData {
    private String name;
    private List<Map<String,StatisticDataRate>> timeline;

    public List<Map<String,StatisticDataRate>> getTimeline() {
        return timeline;
    }

    public void setTimeline(List<Map<String,StatisticDataRate>> timeline) {
        this.timeline = timeline;
    }

    public StatisticDataRateTimeline addTotal(String timeline, StatisticDataRate rate){
        if(this.timeline == null){
            this.timeline = new ArrayList<>();
        }

        Map<String,StatisticDataRate> stat = new HashMap<>();
        stat.put(timeline, rate);

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
