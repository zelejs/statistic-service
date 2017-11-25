package com.jfeat.am.module.statistics.services.domain.model;

import com.jfeat.am.module.statistics.services.persistence.model.StatisticsField;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsRecord;

import java.util.List;

/**
 * Created by Code Generator on 2017-11-25
 */
public class StatisticsFieldModel extends StatisticsField{
    private List<StatisticsRecord> records;

    public List<StatisticsRecord> getRecords() {
        return records;
    }

    public void setRecords(List<StatisticsRecord> records) {
        this.records = records;
    }
}
