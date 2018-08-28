package com.jfeat.am.module.statistics.services.crud.model;

import com.jfeat.am.module.statistics.services.persistence.model.StatisticsRecord;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsRecordAttr;

/**
 * Created by Code Generator on 2017-11-25
 */
public class StatisticsRecordModel extends StatisticsRecord{
    private StatisticsRecordAttr attr;

    public StatisticsRecordAttr getAttr() {
        return attr;
    }

    public void setAttr(StatisticsRecordAttr attr) {
        this.attr = attr;
    }
}
