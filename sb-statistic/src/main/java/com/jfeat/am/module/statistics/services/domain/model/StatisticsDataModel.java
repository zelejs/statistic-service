package com.jfeat.am.module.statistics.services.domain.model;

import com.jfeat.am.module.statistics.services.persistence.model.StatisticsField;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsGroup;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsRecord;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsRecordAttr;

import java.util.List;

/**
 * Created by Silent-Y on 2017/12/4.
 */
public class StatisticsDataModel {

    private StatisticsGroup group;
    private StatisticsField field;
    private List<StatisticsRecord> records;
    private StatisticsRecordAttr attr;

    public StatisticsGroup getGroup() {
        return group;
    }

    public void setGroup(StatisticsGroup group) {
        this.group = group;
    }

    public StatisticsField getField() {
        return field;
    }

    public void setField(StatisticsField field) {
        this.field = field;
    }

    public List<StatisticsRecord> getRecords() {
        return records;
    }

    public void setRecords(List<StatisticsRecord> records) {
        this.records = records;
    }

    public StatisticsRecordAttr getAttr() {
        return attr;
    }

    public void setAttr(StatisticsRecordAttr attr) {
        this.attr = attr;
    }
}
