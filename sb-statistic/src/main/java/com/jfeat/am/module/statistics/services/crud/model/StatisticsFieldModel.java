package com.jfeat.am.module.statistics.services.crud.model;

import com.jfeat.am.module.statistics.services.persistence.model.StatisticsField;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsMeta;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsRecord;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Code Generator on 2017-11-25
 */
public class StatisticsFieldModel extends StatisticsField{

    /**
     * 统计域辅助元数据
     */
    private List<StatisticsMeta> metas;

    private List<StatisticsRecord> items;

    public void addItem(StatisticsRecord item){
        if(this.items==null){
            this.items = new ArrayList<>();
        }
        this.items.add(item);
    }

    public List<StatisticsRecord> getItems() {
        return items;
    }

    public void setItems(List<StatisticsRecord> items) {
        this.items = items;
    }

    public List<StatisticsMeta> getMetas() {
        return metas;
    }

    public void setMetas(List<StatisticsMeta> metas) {
        this.metas = metas;
    }
}
