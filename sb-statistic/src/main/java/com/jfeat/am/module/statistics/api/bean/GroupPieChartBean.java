package com.jfeat.am.module.statistics.api.bean;

import com.jfeat.am.module.statistics.services.persistence.model.StatisticsGroup;

import java.util.List;

/**
 * Created by vincent on 2018/2/26.
 */
public class GroupPieChartBean extends StatisticsGroup {
    
    private List<PieChartBean> items;

    public List<PieChartBean> getItems() {
        return items;
    }

    public void setItems(List<PieChartBean> items) {
        this.items = items;
    }
}
