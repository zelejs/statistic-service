package com.jfeat.am.module.statistics.services.crud.converter.statistic;

import java.util.List;

/**
 * Created by vincent on 2018/5/25.
 */
public class StatisticDataTuple extends StatisticData {
    private String name;

    private List<StatisticDataTuple.Tuple> tuples;

    public List<StatisticDataTuple.Tuple> getRates() {
        return tuples;
    }

    public void setTuples(List<StatisticDataTuple.Tuple> tuples) {
        this.tuples = tuples;
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
    public static class Tuple{
        private String name;
        private List<StatisticDataCount> rates;

        public Tuple(){}

        public Tuple(String name, List<StatisticDataCount> rates){
            this.name = name;
            this.rates = rates;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<StatisticDataCount> getRates() {
            return rates;
        }

        public void setRates(List<StatisticDataCount> rates) {
            this.rates = rates;
        }
    }
}
