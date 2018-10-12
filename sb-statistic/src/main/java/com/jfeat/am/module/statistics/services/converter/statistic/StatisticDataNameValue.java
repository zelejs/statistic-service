package com.jfeat.am.module.statistics.services.converter.statistic;

/**
 * Created by vincent on 2018/5/25.
 */
public class StatisticDataNameValue{
    private String id;
    private String name;
    private String value;
    private int seq; //排序号

    public StatisticDataNameValue(){}

    public StatisticDataNameValue(int seq, String id, String name, String value){
        this.seq = seq;
        this.id = id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }
}
