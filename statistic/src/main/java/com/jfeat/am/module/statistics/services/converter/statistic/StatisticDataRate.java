package com.jfeat.am.module.statistics.services.converter.statistic;

import com.jfeat.am.module.statistics.services.converter.StatisticData;

import java.util.List;

/**
 * Created by vincent on 2018/5/25.
 */
public class StatisticDataRate extends StatisticData {

    private String name;

    private List<StatisticDataNameValue> rates;

    public StatisticDataRate(){}

    public StatisticDataRate(String name, List<StatisticDataNameValue> rates){
        this.name = name;
        this.rates = rates;
    }

    public List<StatisticDataNameValue> getRates() {
        return rates;
    }

    public void setRates(List<StatisticDataNameValue> rates) {
        this.rates = rates;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
