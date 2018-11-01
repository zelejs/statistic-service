package com.jfeat.am.module.statistics.services.converter;

import com.jfeat.am.module.statistics.services.converter.statistic.*;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsRecord;
import com.jfeat.am.module.statistics.services.crud.model.StatisticsFieldModel;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        counter.setTitle(model.getName());
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
        StatisticDataCountTimeline countTimeline = new StatisticDataCountTimeline();
        countTimeline.setField(model.getField());
        countTimeline.setTitle(model.getName());
        countTimeline.setPattern(model.getPattern());
        countTimeline.setChart(model.getChart());
        countTimeline.setSpan(model.getAttrSpan());

        countTimeline.setName(model.getName());
        countTimeline.setTimeline(new ArrayList<>());

        /// add rate
        List<Map<String,StatisticDataNameValue>> timeline = countTimeline.getTimeline();
        for (StatisticsRecord record : model.getItems()){
            if(countTimeline.getIdentifier()==null){
                countTimeline.setIdentifier(record.getIdentifier());
            }

            Map<String,StatisticDataNameValue> stat = new HashMap<>();
            stat.put(record.getRecordTimeline(),
                    new StatisticDataNameValue(record.getSeq(), record.getIdentifier(),
                            record.getRecordName(), record.getRecordValue()));

            timeline.add(stat);
        }
        return countTimeline;
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
        rate.setTitle(model.getName());
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
                rates.add(new StatisticDataNameValue(
                        record.getSeq(), record.getIdentifier(),
                        record.getRecordName(), record.getRecordValue()));
            }
        }

        return rate;
    }
    public static StatisticDataRateTimeline convertStatisticRateTimeline(StatisticsFieldModel model){
        StatisticDataRateTimeline rateTimeline = new StatisticDataRateTimeline();
        rateTimeline.setField(model.getField());
        rateTimeline.setName(model.getName());
        rateTimeline.setPattern(model.getPattern());
        rateTimeline.setChart(model.getChart());
        rateTimeline.setSpan(model.getAttrSpan());

        rateTimeline.setName(model.getName());  ///报表数据域
        rateTimeline.setTimeline(new ArrayList<>());

        /// add rate
        Map<String,StatisticDataRate> hashTemp = new HashMap<>();

        List<StatisticDataRate> timeline = rateTimeline.getTimeline();
        for (StatisticsRecord record : model.getItems()) {
            //从record 获取identifier名称
            if (rateTimeline.getIdentifier() == null) {
                rateTimeline.setIdentifier(record.getIdentifier());
            }

            // add new timeline
            String timelineName = record.getRecordTimeline();
            {
                if (!hashTemp.containsKey(timelineName)) {
                    hashTemp.put(timelineName, new StatisticDataRate(timelineName, new ArrayList<>()));

                    //add new tuple
                    timeline.add(hashTemp.get(timelineName));
                }
            }

            /// append timeline stat
            StatisticDataRate currentTimelineRate = hashTemp.get(timelineName);
            currentTimelineRate.setTl(record.getTimeline());

            currentTimelineRate.getRates().add(new StatisticDataNameValue(record.getSeq(),
                    record.getIdentifier(), record.getRecordName(), record.getRecordValue()));
        }
        timeline.sort((item1, item2) -> item1.getTl().compareTo(item2.getTl()));
        return rateTimeline;
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
        StatisticDataTuple statisticDataTuple = new StatisticDataTuple();
        statisticDataTuple.setField(model.getField());
        statisticDataTuple.setTitle(model.getName());
        statisticDataTuple.setPattern(model.getPattern());
        statisticDataTuple.setChart(model.getChart());
        statisticDataTuple.setSpan(model.getAttrSpan());

        statisticDataTuple.setName(model.getName());
        statisticDataTuple.setTuple(new ArrayList<>());

        List<StatisticDataRate> tuple = statisticDataTuple.getTuple();

        /// add tuple
        Map<String,StatisticDataRate> hashTemp = new HashMap<>();

        for (StatisticsRecord record : model.getItems()){
            // 从record中获取identifier
            if(statisticDataTuple.getIdentifier()==null){
                statisticDataTuple.setIdentifier(statisticDataTuple.getIdentifier());
            }

            /// 增加tuple
            String tupleName = record.getRecordTuple();
            {
                if (!hashTemp.containsKey(tupleName)) {
                    hashTemp.put(tupleName, new StatisticDataRate(tupleName, new ArrayList<>()));

                    //add new tuple
                    tuple.add(hashTemp.get(tupleName));
                }
            }

            // 增加 name value
            StatisticDataRate rate = hashTemp.get(tupleName);
            rate.getRates().add(
                    new StatisticDataNameValue(record.getSeq(), record.getIdentifier(),
                            record.getRecordName(), record.getRecordValue()));
        }

        return statisticDataTuple;
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
