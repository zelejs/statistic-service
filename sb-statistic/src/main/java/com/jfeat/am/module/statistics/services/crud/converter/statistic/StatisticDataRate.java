package com.jfeat.am.module.statistics.services.crud.converter.statistic;

import java.util.List;

/**
 * Created by vincent on 2018/5/25.
 */
public class StatisticDataRate extends StatisticData{

    private String name;

    private List<StatisticDataCount> rates;

    public StatisticDataRate(){}

    public StatisticDataRate(String name, List<StatisticDataCount> rates){
        this.name = name;
        this.rates = rates;
    }

    public List<StatisticDataCount> getRates() {
        return rates;
    }

    public void setRates(List<StatisticDataCount> rates) {
        this.rates = rates;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
