package com.jfeat.am.module.statement.services.statistic;

import java.util.List;

/**
 * Created by vincent on 2018/5/8.
 * 涉及时间轴多维查询，适用所有统计类型
 */
public class StatisticTimeline implements Statistics {
    private String name;
    private List<? extends Statistics> statistics;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<? extends Statistics> getStatistics() {
        return statistics;
    }

    public void setStatistics(List<? extends Statistics> statistics) {
        this.statistics = statistics;
    }
}
