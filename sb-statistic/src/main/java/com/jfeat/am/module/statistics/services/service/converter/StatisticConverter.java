package com.jfeat.am.module.statistics.services.service.converter;

import com.jfeat.am.module.statistics.services.persistence.model.StatisticsRecord;
import com.jfeat.am.module.statistics.services.service.converter.statistic.StatisticRate;
import com.jfeat.am.module.statistics.services.service.converter.statistic.StatisticTotal;
import com.jfeat.am.module.statistics.services.service.converter.statistic.StatisticTuple;
import com.jfeat.am.module.statistics.services.service.model.StatisticsFieldModel;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Code Generator on 2017-11-25
 */
public class StatisticConverter {
    public static StatisticTotal convertStatisticTotal(StatisticsFieldModel model){
        StatisticTotal total = new StatisticTotal();
        total.setName(model.getName());
        total.setValue(model.getItems().get(0).getRecordValue());
        return total;
    }

    public static StatisticRate convertStatisticRate(StatisticsFieldModel model){
        StatisticRate rate = new StatisticRate();
        rate.setName(model.getName());
        List<StatisticRate.Rate> rates = new ArrayList<>();
        rate.setRates(rates);

        /// add rate
        for (StatisticsRecord record : model.getItems()){
            rates.add(new StatisticRate.Rate(record.getRecordName(), record.getRecordValue()));
        }

        return rate;
    }

    public static StatisticTuple convertStatisticTuple(StatisticsFieldModel model){
        //TODO,
        throw new NotImplementedException();
    }
}
