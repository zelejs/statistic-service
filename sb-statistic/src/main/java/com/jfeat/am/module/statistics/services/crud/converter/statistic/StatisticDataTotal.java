package com.jfeat.am.module.statistics.services.crud.converter.statistic;

/**
 * Created by vincent on 2018/5/25.
 */
public class StatisticDataTotal  extends StatisticData {
    private String name;
    private String value;

    public StatisticDataTotal(){
    }

    public StatisticDataTotal(String name, String value){
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
