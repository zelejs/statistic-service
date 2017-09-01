package com.jfeat.am.modular.statistic.mq;

import java.util.Date;
import java.util.Map;

/**
 * Created by Silent-Y on 2017/8/31.
 */
public class StatisticNotifyData {

    private String identifier;
    private Date recordTime;
    private String defaultName;
    private Map<String, String> value;

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

    public Map<String, String> getValue() {
        return value;
    }

    public void setValue(Map<String, String> value) {
        this.value = value;
    }
}
