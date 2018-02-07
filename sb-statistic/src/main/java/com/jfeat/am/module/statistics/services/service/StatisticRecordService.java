package com.jfeat.am.module.statistics.services.service;


import com.jfeat.am.module.statistics.services.service.model.StatisticNotifyData;

import java.util.List;
import java.util.Map;

/**
 * Created by Silent-Y on 2017/8/31.
 */
public interface StatisticRecordService {

    public boolean insertStatisticRecord(StatisticNotifyData memberAnalysisNotifyData);

    public List<Map<String,Object>> getStatisticRecordByTypeIdAndStartTimeAndEndTime(Long typeId,List<String> fields,String startTime,String endTime);
}
