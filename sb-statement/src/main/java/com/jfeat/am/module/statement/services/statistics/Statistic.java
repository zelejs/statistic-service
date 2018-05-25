package com.jfeat.am.module.statement.services.statistics;

import com.jfeat.am.module.statement.services.statistics.route.StatisticChunk;
import com.jfeat.am.module.statement.services.statistics.route.StatisticRouteData;

import java.util.Date;

/**
 * Created by vincent on 2018/5/8.
 * 用于查询单项数据,如总数
 */
public class Statistic implements Statistics {
    private String name;
    private String timeline;
    private String cluster;
    private String value;

    public Statistic(){
    }

    public Statistic(String name, String value){
        this.name = name;
        this.value = value;
    }

    public Statistic timeline(String timeline) {
        this.timeline = timeline;
        return this;
    }


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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

    @Override
    public StatisticRouteData toRouteData() {
        StatisticRouteData routeData = new StatisticRouteData();
        routeData.setName(this.name);
        routeData.setRecordTime(new Date());

        StatisticChunk chunk = new StatisticChunk();
        chunk.setName(name);
        chunk.setValue(value);
        chunk.setTimeline(timeline);

        routeData.addChunk(chunk);

        return routeData;
    }


    public String getCluster() {
        return cluster;
    }

    public void setCluster(String cluster) {
        this.cluster = cluster;
    }
}
