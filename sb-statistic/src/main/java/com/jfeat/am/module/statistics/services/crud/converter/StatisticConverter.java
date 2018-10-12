package com.jfeat.am.module.statistics.services.crud.converter;

import com.jfeat.am.module.statistics.services.persistence.model.StatisticsRecord;
import com.jfeat.am.module.statistics.services.crud.converter.statistic.*;
import com.jfeat.am.module.statistics.services.crud.model.StatisticsFieldModel;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Code Generator on 2017-11-25
 */
public class StatisticConverter {

    /**
     * Pattern Count
     * @param model
     * @return
     */
    public static StatisticDataCount convertStatisticCount(StatisticsFieldModel model){
        StatisticDataCount counter = new StatisticDataCount();
        counter.setField(model.getField());
        counter.setPattern(model.getPattern());
        counter.setChart(model.getChart());
        counter.setSpan(model.getAttrSpan());

        counter.setName(model.getName());

        if(model.getItems() != null && !model.getItems().isEmpty()) {
            StatisticsRecord record = model.getItems().get(0);
            counter.setValue(record.getRecordValue());
            counter.setIdentifier(record.getIdentifier());
        }

        return counter;
    }
    public static StatisticDataCountTimeline convertStatisticCountTimeline(StatisticsFieldModel model){
        StatisticDataCountTimeline timeline = new StatisticDataCountTimeline();
        timeline.setField(model.getField());
        timeline.setPattern(model.getPattern());
        timeline.setChart(model.getChart());
        timeline.setSpan(model.getAttrSpan());

        timeline.setName(model.getName());
        timeline.setTimeline(new HashMap<>());

        /// add rate
        java.util.Map<String,StatisticDataNameValue> timelineMap = timeline.getTimeline();
        for (StatisticsRecord record : model.getItems()){
            if(timeline.getIdentifier()==null){
                timeline.setIdentifier(record.getIdentifier());
            }

            String timelineName = record.getTimeline();
            timelineMap.put(timelineName, new StatisticDataNameValue(record.getIdentifier(), timelineName, record.getRecordValue()));
        }

        return timeline;
    }
    public static StatisticDataCountCluster convertStatisticCountCluster(StatisticsFieldModel model){
        //TODO,
        throw new NotImplementedException();
    }
    public static StatisticDataCountTimelineCluster convertStatisticCountTimelineCluster(StatisticsFieldModel model){
        //TODO,
        throw new NotImplementedException();
    }

    /**
     * Pattern Rate
     * @param model
     * @return
     */
    public static StatisticDataRate convertStatisticRate(StatisticsFieldModel model){
        StatisticDataRate rate = new StatisticDataRate();
        rate.setField(model.getField());
        rate.setPattern(model.getPattern());
        rate.setChart(model.getChart());
        rate.setSpan(model.getAttrSpan());

        rate.setName(model.getName());
        rate.setRates(new ArrayList<>());

        /// add rate
        List<StatisticDataNameValue> rates = rate.getRates();
        if(model.getItems()!=null && model.getItems().size()>0) {
            for (StatisticsRecord record : model.getItems()) {
                if(rate.getIdentifier()==null){
                    rate.setIdentifier(record.getIdentifier());
                }
                rates.add(new StatisticDataNameValue(record.getIdentifier(), record.getRecordName(), record.getRecordValue()));
            }
        }

        return rate;
    }
    public static StatisticDataRateTimeline convertStatisticRateTimeline(StatisticsFieldModel model){
        StatisticDataRateTimeline timeline = new StatisticDataRateTimeline();
        timeline.setField(model.getField());
        timeline.setPattern(model.getPattern());
        timeline.setChart(model.getChart());
        timeline.setSpan(model.getAttrSpan());

        timeline.setName(model.getName());  ///报表数据域
        timeline.setTimeline(new HashMap<>());

        /// add rate
        java.util.Map<String,StatisticDataRate> timelineMap = timeline.getTimeline();
        for (StatisticsRecord record : model.getItems()){
            if(timeline.getIdentifier()==null){
                timeline.setIdentifier(record.getIdentifier());
            }

            String timelineName = record.getTimeline();
            if(!timelineMap.containsKey(timelineName)){
                timelineMap.put(timelineName, new StatisticDataRate(timelineName, new ArrayList<>()));
            }

            StatisticDataRate currentTimelineRate = timelineMap.get(timelineName);
            currentTimelineRate.getRates().add(new StatisticDataNameValue(
                    record.getIdentifier(), record.getRecordName(), record.getRecordValue()));
        }

        return timeline;
    }
    public static StatisticDataRateCluster convertStatisticRateCluster(StatisticsFieldModel model){
        //TODO,
        throw new NotImplementedException();
    }
    public static StatisticDataRateTimelineCluster convertStatisticRateTimelineCluster(StatisticsFieldModel model){
        //TODO,
        throw new NotImplementedException();
    }

    /**
     * Pattern Tuple
     * @param model
     * @return
     */
    public static StatisticDataTuple convertStatisticTuple(StatisticsFieldModel model){
        StatisticDataTuple tuple = new StatisticDataTuple();
        tuple.setField(model.getField());
        tuple.setPattern(model.getPattern());
        tuple.setChart(model.getChart());
        tuple.setSpan(model.getAttrSpan());

        tuple.setName(model.getName());
        tuple.setTuples(new ArrayList<>());

        /// add tuple
        java.util.Map<String,StatisticDataTuple.Tuple> tupleMap = new HashMap<>();
        for (StatisticsRecord record : model.getItems()){
            if(tuple.getIdentifier()==null){
                tuple.setIdentifier(tuple.getIdentifier());
            }

            String tupleName = record.getRecordTuple();
            if(!tupleMap.containsKey(tupleName)){
                tupleMap.put(tupleName, new StatisticDataTuple.Tuple(tupleName, new ArrayList<>()));
            }

            StatisticDataTuple.Tuple tuple1 = tupleMap.get(tupleName);
            tuple1.getRates().add(new StatisticDataNameValue(record.getIdentifier(), record.getRecordName(), record.getRecordValue()));
        }

        /// convert tupleMap to tuple
        List<StatisticDataTuple.Tuple> rates = tuple.getRates();
        for (StatisticDataTuple.Tuple tp : tupleMap.values()){
            rates.add(tp);
        }

        return tuple;
    }

    public static StatisticDataTupleTimeline convertStatisticTupleTimeline(StatisticsFieldModel model){
        //TODO,
        throw new NotImplementedException();
    }
    public static StatisticDataTupleCluster convertStatisticTupleCluster(StatisticsFieldModel model){
        //TODO,
        throw new NotImplementedException();
    }
    public static StatisticDataTupleTimelineCluster convertStatisticTupleTimelineCluster(StatisticsFieldModel model){
        //TODO,
        throw new NotImplementedException();
    }
}
