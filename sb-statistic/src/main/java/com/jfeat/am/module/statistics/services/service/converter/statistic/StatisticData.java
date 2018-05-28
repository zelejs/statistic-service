package com.jfeat.am.module.statistics.services.service.converter.statistic;

/**
 * Created by vincent on 2018/5/28.
 */
public class StatisticData {
    public static final String STAT_TYPE_TOTAL = "total";
    public static final String STAT_TYPE_TOTAL_TIMELINE = "totalTimeline";
    public static final String STAT_TYPE_RATE = "rateTimeline";
    public static final String STAT_TYPE_RATE_TIMELINE = "rateTimeline";
    public static final String STAT_TYPE_TUPLE = "tupleTimeline";
    public static final String STAT_TYPE_TUPLE_TIMELINE = "tupleTimeline";

    public static boolean checkStatisticType(String type){
        if(STAT_TYPE_TOTAL.equals(type)){
            return true;
        }
        if(STAT_TYPE_TOTAL_TIMELINE.equals(type)){
            return true;
        }
        if(STAT_TYPE_RATE.equals(type)){
            return true;
        }
        if(STAT_TYPE_RATE_TIMELINE.equals(type)){
            return true;
        }
        if(STAT_TYPE_TUPLE.equals(type)){
            return true;
        }
        if(STAT_TYPE_TUPLE_TIMELINE.equals(type)){
            return true;
        }
        return false;
    }
}
