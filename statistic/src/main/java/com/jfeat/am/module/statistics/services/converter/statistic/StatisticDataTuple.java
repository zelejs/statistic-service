package com.jfeat.am.module.statistics.services.converter.statistic;

import com.jfeat.am.module.statistics.services.converter.StatisticData;

import java.util.List;

/**
 * Created by vincent on 2018/5/25.
 */
public class StatisticDataTuple extends StatisticData {
    private String name;

    private List<StatisticDataNameValue> tuple;
    public StatisticDataTuple() { }

    public StatisticDataTuple(String name, List<StatisticDataNameValue> tuple){
        this.name = name;
        this.tuple = tuple;
    }

    public List<StatisticDataNameValue> getTuple() {
        return tuple;
    }

    public void setTuple(List<StatisticDataNameValue> tuple) {
        this.tuple = tuple;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
