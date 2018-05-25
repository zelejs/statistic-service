package com.jfeat.am.module.statement.services.statistics;

import com.jfeat.am.module.statement.services.statistics.route.StatisticChunk;
import com.jfeat.am.module.statement.services.statistics.route.StatisticRouteData;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by vincent on 2018/5/8.
 * 用于记录查询报表数据，多列多项
 */
public class StatisticTuple implements Statistics {
    private String name;
    private List<StatisticRate> rates;

    public void addRate(StatisticRate rate){
        if(rates==null){
            rates = new ArrayList<>();
        }
        rates.add(rate);
    }

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


    @Override
    public StatisticRouteData toRouteData() {
        StatisticRouteData routeData = new StatisticRouteData();
        routeData.setName(name);
        routeData.setRecordTime(new Date());

        if(rates!=null) {
            for(StatisticRate rate : rates) {
                if(rate.getValues()!=null) {
                    for (Statistic statistic : rate.getValues()) {
                        StatisticChunk chunk = new StatisticChunk();
                        chunk.setName(statistic.getName());
                        chunk.setValue(statistic.getValue());
                        chunk.setTuple(rate.getName());
                        chunk.setTimeline(name);

                        routeData.addChunk(chunk);
                    }
                }
            }
        }

        return routeData;
    }
}
