package com.jfeat.am.modular.statistic.service;

import com.jfeat.am.common.persistence.model.StatisticRecord;
import com.jfeat.am.modular.statistic.mq.StatisticNotifyData;

import java.util.Date;
import java.util.List;

/**
 * Created by Silent-Y on 2017/8/31.
 */
public interface StatisticRecordService {

    public boolean insertStatisticRecord(StatisticNotifyData memberAnalysisNotifyData);

    public List<StatisticRecord> getStatisticRecordByTypeIdAndStartTimeAndEndTime(long typeId,String startTime,String endTime);
}
