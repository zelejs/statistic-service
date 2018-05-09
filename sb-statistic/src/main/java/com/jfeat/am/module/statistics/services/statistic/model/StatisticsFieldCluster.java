package com.jfeat.am.module.statistics.services.statistic.model;

import com.jfeat.am.module.statistics.services.persistence.model.StatisticsField;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsRecord;

import java.util.List;
import java.util.Map;

/**
 * Created by Code Generator on 2017-11-25
 */
public class StatisticsFieldCluster extends StatisticsField{
    private Map<String, Map<String, List<StatisticsRecord>>> items;

    public Map<String, Map<String, List<StatisticsRecord>>> getItems() {
        return items;
    }

    public void setItems(Map<String, Map<String, List<StatisticsRecord>>> items) {
        this.items = items;
    }
}
