package com.jfeat.am.module.statement.services.statistic;

import java.util.List;

/**
 * Created by vincent on 2018/5/8.
 * 用于复杂多维数据展示，如按金额，按数量，按时间段，按会员/非会员
 * 步及多条件查询 WHERE
 */
public class StatisticCluster implements Statistics {
    private String name;
    private List<StatisticTimeline> timelines;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StatisticTimeline> getTimelines() {
        return timelines;
    }

    public void setTimelines(List<StatisticTimeline> timelines) {
        this.timelines = timelines;
    }
}
