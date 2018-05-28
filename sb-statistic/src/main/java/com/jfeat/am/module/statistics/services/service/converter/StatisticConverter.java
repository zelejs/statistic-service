package com.jfeat.am.module.statistics.services.service.converter;

import com.jfeat.am.module.statistics.services.persistence.model.StatisticsRecord;
import com.jfeat.am.module.statistics.services.service.converter.statistic.*;
import com.jfeat.am.module.statistics.services.service.model.StatisticsFieldModel;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Code Generator on 2017-11-25
 */
public class StatisticConverter {
    public static StatisticDataTotal convertStatisticTotal(StatisticsFieldModel model){
        StatisticDataTotal total = new StatisticDataTotal();
        total.setName(model.getName());
        total.setValue(model.getItems().get(0).getRecordValue());
        return total;
    }

    public static StatisticDataRate convertStatisticRate(StatisticsFieldModel model){
        StatisticDataRate rate = new StatisticDataRate();
        rate.setName(model.getName());
        List<StatisticDataRate.Rate> rates = new ArrayList<>();
        rate.setRates(rates);

        /// add rate
        for (StatisticsRecord record : model.getItems()){
            rates.add(new StatisticDataRate.Rate(record.getRecordName(), record.getRecordValue()));
        }

        return rate;
    }

    public static StatisticDataTuple convertStatisticTuple(StatisticsFieldModel model){
        StatisticDataTuple tuple = new StatisticDataTuple();
        tuple.setName(model.getName());
        List<StatisticDataTuple.Tuple> tuples = new ArrayList<>();
        tuple.setTuples(tuples);

        /// add rate
        java.util.Map<String,StatisticDataTuple.Tuple> tupleMap = new HashMap<>();
        for (StatisticsRecord record : model.getItems()){
            String tupleName = record.getRecordTuple();
            if(!tupleMap.containsKey(tupleName)){
                tupleMap.put(tupleName, new StatisticDataTuple.Tuple(tupleName, new ArrayList<>()));
            }

            StatisticDataTuple.Tuple tuple1 = tupleMap.get(tupleName);
            tuple1.getRates().add(new StatisticDataRate.Rate(record.getRecordName(), record.getRecordValue()));
        }

        /// convert tupleMap to tuple
        for (StatisticDataTuple.Tuple tp : tupleMap.values()){
            tuples.add(tp);
        }

        return tuple;
    }

    public static StatisticDataTotalTimeline convertStatisticTotalTimeline(StatisticsFieldModel model){
        StatisticDataTotalTimeline timeline = new StatisticDataTotalTimeline();
        timeline.setName(model.getName());
        timeline.setTimeline(new HashMap<>());

        /// add rate
        java.util.Map<String,StatisticDataTotal> timelineMap = new HashMap<>();
        for (StatisticsRecord record : model.getItems()){
            String timelineName = record.getTimeline();
            timelineMap.put(timelineName, new StatisticDataTotal(timelineName, record.getRecordValue()));
        }

        return timeline;
    }

    public static StatisticDataRateTimeline convertStatisticRateTimeline(StatisticsFieldModel model){
        StatisticDataRateTimeline timeline = new StatisticDataRateTimeline();
        timeline.setName(model.getName());  ///报表数据域
        timeline.setTimeline(new HashMap<>());

        /// add rate
        java.util.Map<String,StatisticDataRate> timelineMap = new HashMap<>();
        for (StatisticsRecord record : model.getItems()){
            String timelineName = record.getTimeline();
            if(!timelineMap.containsKey(timelineName)){
                timelineMap.put(timelineName, new StatisticDataRate(timelineName, new ArrayList<>()));
            }

            StatisticDataRate currentTimelineRate = timelineMap.get(timelineName);
            currentTimelineRate.getRates().add(new StatisticDataRate.Rate(record.getRecordName(), record.getRecordValue()));
        }

        return timeline;
    }

    public static StatisticDataTupleTimeline convertStatisticTupleTimeline(StatisticsFieldModel model){
        //TODO,
        throw new NotImplementedException();
    }
}
