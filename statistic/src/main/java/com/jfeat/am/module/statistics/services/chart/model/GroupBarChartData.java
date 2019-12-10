package com.jfeat.am.module.statistics.services.chart.model;

import com.jfeat.am.module.statistics.services.persistence.model.StatisticsGroup;

import java.util.List;

/**
 * Created by vincent on 2018/2/26.
 */
public class GroupBarChartData extends StatisticsGroup {

    private List<BarChartData> items;

    public List<BarChartData> getItems() {
        return items;
    }

    public void setItems(List<BarChartData> items) {
        this.items = items;
    }
}
