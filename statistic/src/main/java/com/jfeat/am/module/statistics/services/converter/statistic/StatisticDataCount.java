package com.jfeat.am.module.statistics.services.converter.statistic;

import com.jfeat.am.module.statistics.services.converter.StatisticData;

/**
 * Created by vincent on 2018/5/25.
 */
public class StatisticDataCount extends StatisticData {
    private String name;
    private String value;

    public StatisticDataCount(){}

    public StatisticDataCount(String name, String value){
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
