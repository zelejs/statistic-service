package com.jfeat.am.module.statistics.services.service.model;

import com.jfeat.am.module.statistics.services.service.persistence.model.StatisticsField;
import com.jfeat.am.module.statistics.services.service.persistence.model.StatisticsRecord;

import java.util.List;

/**
 * Created by Code Generator on 2017-11-25
 */
public class StatisticsFieldModel extends StatisticsField{

    private List<StatisticsRecord> items;

    public List<StatisticsRecord> getItems() {
        return items;
    }

    public void setItems(List<StatisticsRecord> items) {
        this.items = items;
    }
}
