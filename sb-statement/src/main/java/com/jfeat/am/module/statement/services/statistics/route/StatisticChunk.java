package com.jfeat.am.module.statement.services.statistics.route;

/**
 * Created by jackyhuang on 2017/9/6.
 * 传递信息
 */
public class StatisticChunk {

    private String name;        // 统计数据名称
    private String value;       // 统计数据
    private String tuple;       // 统计数据所属行名称
    private String timeline;    // 统计数据所属时间段
    private String cluster;     // 统计数据所属分类分称

    public StatisticChunk() {
    }

    public StatisticChunk(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public StatisticChunk(String name, String value, String tuple, String timeline, String cluster) {
        this.name = name;
        this.value = value;
        this.tuple = tuple;
        this.timeline = timeline;
        this.cluster = cluster;
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

    public String getTuple() {
        return tuple;
    }

    public void setTuple(String tuple) {
        this.tuple = tuple;
    }

    public String getTimeline() {
        return timeline;
    }

    public void setTimeline(String timeline) {
        this.timeline = timeline;
    }

    public String getCluster() {
        return cluster;
    }

    public void setCluster(String cluster) {
        this.cluster = cluster;
    }
}
