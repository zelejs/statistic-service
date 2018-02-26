package com.jfeat.am.module.statistics.bean;

import com.jfeat.am.module.statistics.services.persistence.model.StatisticsGroup;

import java.util.List;

/**
 * Created by vincent on 2018/2/26.
 */
public class GroupBarChartBean extends StatisticsGroup {

    private List<BarChartBean> items;

    public List<BarChartBean> getItems() {
        return items;
    }

    public void setItems(List<BarChartBean> items) {
        this.items = items;
    }
}
