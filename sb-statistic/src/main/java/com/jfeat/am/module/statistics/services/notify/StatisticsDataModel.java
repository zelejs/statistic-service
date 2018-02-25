package com.jfeat.am.module.statistics.services.notify;

import com.jfeat.am.module.statistics.services.persistence.model.StatisticsField;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsGroup;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsRecord;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsRecordAttr;

import java.util.List;

/**
 * Created by Silent-Y on 2017/12/4.
 */
public class StatisticsDataModel {

    //private StatisticsGroup group;  // 由运维决定分组
    // private StatisticsField field;
    private List<StatisticsRecord> records; // Record Only
    //private StatisticsRecordAttr attr;   // 由运维决定属性

    /*
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
    public StatisticsRecordAttr getAttr() {
        return attr;
    }

    public void setAttr(StatisticsRecordAttr attr) {
        this.attr = attr;
    }
    */

    public List<StatisticsRecord> getRecords() {
        return records;
    }

    public void setRecords(List<StatisticsRecord> records) {
        this.records = records;
    }
}
