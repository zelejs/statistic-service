package com.jfeat.am.module.statistics.services.crud.model;

import com.jfeat.am.module.statistics.services.persistence.model.StatisticsField;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsGroup;

import java.util.List;

/**
 * Created by vincent on 2017/11/25.
 */
public class StatisticsGroupModel extends StatisticsGroup {
    private List<StatisticsField> fields;

    public List<StatisticsField> getFields() {
        return fields;
    }

    public void setFields(List<StatisticsField> fields) {
        this.fields = fields;
    }
}
