package com.jfeat.am.module.statistics.services.chart.model;

import com.jfeat.am.module.statistics.services.persistence.model.StatisticsGroup;

import java.util.List;

/**
 * Created by vincent on 2018/2/26.
 */
public class GroupLineChartData extends StatisticsGroup {
    
    private List<LineChartData> items;

    public List<LineChartData> getItems() {
        return items;
    }

    public void setItems(List<LineChartData> items) {
        this.items = items;
    }
}
