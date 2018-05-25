package com.jfeat.am.module.statistics.services.service.converter.statistic;

import java.util.List;

/**
 * Created by vincent on 2018/5/25.
 */
public class StatisticRate{

    private String name;

    private List<Rate> rates;

    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * class RateItem
     */
    public static class Rate{
        private String name;
        private String value;

        public Rate(String name, String value){
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
}
