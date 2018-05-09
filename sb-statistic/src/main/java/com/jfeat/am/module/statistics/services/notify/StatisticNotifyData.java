package com.jfeat.am.module.statistics.services.notify;

import java.util.Date;
import java.util.List;

/**
 * Created by Silent-Y on 2017/8/31.
 */
public class StatisticNotifyData {

    @Deprecated
    private String identifier;    // 分组由运维决定,这里不指定分组

    /**
     * 记录时间
     */
    private Date recordTime;
    /**
     * 名称(这里指唯一域名）
     */
    private String name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Statistic> getValues() {
        return values;
    }

    public void setValues(List<Statistic> values) {
        this.values = values;
    }
}
