package com.jfeat.am.modular.statistic.mq;

import java.util.Date;

/**
 * Created by Silent-Y on 2017/8/31.
 */
public class MemberAnalysisNotifyData {

    private String type;
    private Date recordTime;
    private String fieldName;
    private String value;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
