package com.jfeat.am.module.statistics.services.converter.statistic;

import com.jfeat.am.module.statistics.services.converter.StatisticData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vincent on 2018/5/25.
 */
public class StatisticDataCountTimeline extends StatisticData {
    private String name;
    private List<Map<String,StatisticDataNameValue>> timeline;

    public List<Map<String,StatisticDataNameValue>> getTimeline() {
        return timeline;
    }

    public void setTimeline(List<Map<String, StatisticDataNameValue>> timeline) {
        this.timeline = timeline;
    }

    public StatisticDataCountTimeline addCount(int seq, String id, String timeline, String name, String value){
        if(this.timeline == null){
            this.timeline = new ArrayList<>();
        }

        Map<String,StatisticDataNameValue> stat = new HashMap<>();
        stat.put(timeline, new StatisticDataNameValue(seq, id, name,value));

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
