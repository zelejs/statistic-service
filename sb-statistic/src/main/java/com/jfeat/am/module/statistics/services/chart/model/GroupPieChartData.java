package com.jfeat.am.module.statistics.services.chart.model;

import com.jfeat.am.module.statistics.services.persistence.model.StatisticsGroup;

import java.util.List;

/**
 * Created by vincent on 2018/2/26.
 */
public class GroupPieChartData extends StatisticsGroup {
    
    private List<PieChartData> items;

    public List<PieChartData> getItems() {
        return items;
    }

    public void setItems(List<PieChartData> items) {
        this.items = items;
    }
}
