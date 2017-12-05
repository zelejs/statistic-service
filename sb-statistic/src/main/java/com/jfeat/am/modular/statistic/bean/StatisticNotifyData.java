package com.jfeat.am.modular.statistic.bean;

import com.jfeat.am.modular.statistic.bean.Statistic;

import java.util.Date;
import java.util.List;

/**
 * Created by Silent-Y on 2017/8/31.
 */
public class StatisticNotifyData {

    private String identifier;
    private Date recordTime;
    private String defaultName;
    private List<Statistic> values;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    public String getDefaultName() {
        return defaultName;
    }

    public void setDefaultName(String defaultName) {
        this.defaultName = defaultName;
    }

    public List<Statistic> getValues() {
        return values;
    }

    public void setValues(List<Statistic> values) {
        this.values = values;
    }
}
