package com.jfeat.am.module.statistics.services.service.model;

/**
 * Created by jackyhuang on 2017/9/6.
 */
public class Statistic {
    private String key;
    private String name;
    private String value;

    public Statistic() {
    }

    public Statistic(String key, String name) {
        this.key = key;
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
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
