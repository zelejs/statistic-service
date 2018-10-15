package com.jfeat.am.module.statistics.services.converter.statistic;

import com.jfeat.am.module.statistics.services.converter.StatisticData;

import java.util.List;

/**
 * Created by vincent on 2018/5/25.
 */
public class StatisticDataTuple extends StatisticData {
    private String name;

    private List<StatisticDataRate> tuples;

    public List<StatisticDataRate> getRates() {
        return tuples;
    }

    public void setTuples(List<StatisticDataRate> tuples) {
        this.tuples = tuples;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
