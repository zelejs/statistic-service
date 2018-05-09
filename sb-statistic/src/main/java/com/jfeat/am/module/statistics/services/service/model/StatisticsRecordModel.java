package com.jfeat.am.module.statistics.services.service.model;

import com.jfeat.am.module.statistics.services.persistence.model.StatisticsRecord;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsRecordAttr;

/**
 * Created by Code Generator on 2017-11-25
 */
@Deprecated
public class StatisticsRecordModel extends StatisticsRecord{
    private StatisticsRecordAttr attr;

    public StatisticsRecordAttr getAttr() {
        return attr;
    }

    public void setAttr(StatisticsRecordAttr attr) {
        this.attr = attr;
    }
}
