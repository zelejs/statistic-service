package com.jfeat.am.module.statement.services.statistic;

import java.util.List;

/**
 * Created by vincent on 2018/5/8.
 * 用于记录查询报表数据，多列多项
 */
public class StatisticTuple implements Statistics {
    private String name;
    private List<StatisticRate> rates;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StatisticRate> getRates() {
        return rates;
    }

    public void setRates(List<StatisticRate> rates) {
        this.rates = rates;
    }
}
