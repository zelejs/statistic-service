package com.jfeat.am.module.statement.services.statistics;

import com.jfeat.am.module.statement.services.statistics.route.StatisticChunk;
import com.jfeat.am.module.statement.services.statistics.route.StatisticRouteData;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by vincent on 2018/5/8.
 * 用于记录查询占比数据，如分类占比
 */
public class StatisticRate implements Statistics {
    private String name;
    private String timeline;
    private String cluster;
    private List<Statistic> values;

    public void addRate(String name, String value){
        if(values==null){
            values = new ArrayList<>();
        }
        values.add(new Statistic(name, value));
    }

    public void addRate(Statistic rate){
        if(values==null){
            values = new ArrayList<>();
        }
        values.add(rate);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTimeline() {
        return timeline;
    }

    public void setTimeline(String timeline) {
        this.timeline = timeline;
    }

    public List<Statistic> getValues() {
        return values;
    }

    public void setValues(List<Statistic> values) {
        this.values = values;
    }

    @Override
    public StatisticRouteData toRouteData() {
        StatisticRouteData routeData = new StatisticRouteData();
        routeData.setName(name);
        routeData.setRecordTime(new Date());

        if(values!=null) {

            for(Statistic statistic : values) {

                StatisticChunk chunk = new StatisticChunk();
                chunk.setName(statistic.getName());
                chunk.setValue(statistic.getValue());

                /// get from rate
                chunk.setTimeline(timeline);
                chunk.setCluster(cluster);

                routeData.addChunk(chunk);
            }
        }

        return routeData;
    }
}
