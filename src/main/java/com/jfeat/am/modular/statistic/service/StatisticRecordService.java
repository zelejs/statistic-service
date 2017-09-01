package com.jfeat.am.modular.statistic.service;

import com.jfeat.am.modular.statistic.mq.StatisticNotifyData;

/**
 * Created by Silent-Y on 2017/8/31.
 */
public interface StatisticRecordService {

    public boolean insertStatisticRecord(StatisticNotifyData memberAnalysisNotifyData);
}
