package com.jfeat.am.module.statistics.bean;

import com.jfeat.am.module.statistics.services.persistence.model.StatisticsGroup;

import java.util.List;

/**
 * Created by vincent on 2018/2/26.
 */
public class GroupLineChartBean extends StatisticsGroup {
    
    private List<LineChartBean> items;

    public List<LineChartBean> getItems() {
        return items;
    }

    public void setItems(List<LineChartBean> items) {
        this.items = items;
    }
}
