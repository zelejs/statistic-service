package com.jfeat.am.module.statement.services.statistics;

import com.jfeat.am.module.statement.services.statistics.route.StatisticChunk;
import com.jfeat.am.module.statement.services.statistics.route.StatisticRouteData;

import java.util.Date;
import java.util.List;

/**
 * Created by vincent on 2018/5/8.
 * 用于复杂多维数据展示，如按金额，按数量，按时间段，按会员/非会员
 * 步及多条件查询 WHERE
 */
public class StatisticCluster implements Statistics {
    private String name;
    private List<StatisticTuple> tuples;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StatisticTuple> getTuples() {
        return tuples;
    }

    public void setTuples(List<StatisticTuple> tuples) {
        this.tuples = tuples;
    }

    @Override
    public StatisticRouteData toRouteData() {
        StatisticRouteData routeData = new StatisticRouteData();
        routeData.setRecordTime(new Date());

        for(StatisticTuple tuple : tuples) {

            if (tuple != null) {
                List<StatisticRate> rates = tuple.getRates();

                for (StatisticRate rate : rates) {

                    if (rate.getValues() != null) {
                        for (Statistic statistic : rate.getValues()) {

                            StatisticChunk chunk = new StatisticChunk();

                            chunk.setCluster(tuple.getName());
                            chunk.setTuple(rate.getName());

                            chunk.setName(statistic.getName());
                            chunk.setValue(statistic.getValue());

                            routeData.addChunk(chunk);
                        }
                    }
                }
            }
        }

        return routeData;
    }

}
