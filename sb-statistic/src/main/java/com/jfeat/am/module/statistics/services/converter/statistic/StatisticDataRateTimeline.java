package com.jfeat.am.module.statistics.services.converter.statistic;

import com.jfeat.am.module.statistics.services.converter.StatisticData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vincent on 2018/5/25.
 */
public class StatisticDataRateTimeline extends StatisticData {
    private String name;
    private List<StatisticDataRate> timeline;

    public List<StatisticDataRate> getTimeline() {
        return timeline;
    }

    public void setTimeline(List<StatisticDataRate> timeline) {
        this.timeline = timeline;
    }

    public StatisticDataRateTimeline addTotal(String timeline, StatisticDataRate rate){
        if(this.timeline == null){
            this.timeline = new ArrayList<>();
        }
        rate.setName(timeline);

        this.timeline.add(rate);
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
