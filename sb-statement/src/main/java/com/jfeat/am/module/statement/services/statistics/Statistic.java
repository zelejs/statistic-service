package com.jfeat.am.module.statement.services.statistics;

/**
 * Created by vincent on 2018/5/8.
 * 用于查询单项数据,如总数
 */
public class Statistic implements Statistics {
    private String name;
    private String value;

    public Statistic(){
    }

    public Statistic(String name, String value){
        this.name = name;
        this.value = value;
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
}
