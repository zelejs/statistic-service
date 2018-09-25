package com.jfeat.am.module.statistics.services.domain.model;

import com.jfeat.am.module.statistics.services.crud.converter.statistic.StatisticData;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsGroup;

import java.util.List;

/**
 * Created by vincent on 2018/9/25.
 */
public class StatisticsGroupData  extends StatisticsGroup {
    private List<StatisticData> fields;

    public List<StatisticData> getFields() {
        return fields;
    }

    public void setFields(List<StatisticData> fields) {
        this.fields = fields;
    }
}
