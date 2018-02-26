package com.jfeat.am.module.statistics.services.service;


import com.jfeat.am.common.crud.CRUDServiceGroup;
import com.jfeat.am.common.crud.CRUDServiceOverModelOne;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsGroup;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsRecord;
import com.jfeat.am.module.statistics.services.service.model.StatisticsRecordModel;

import java.util.List;
import java.util.Map;

/**
 * Created by Silent-Y on 2017/8/31.
 */
public interface StatisticsRecordService {

    /**
     * return record model with attr
     * @param field
     * @param recordName
     * @return
     */
    StatisticsRecordModel getStatisticsRecordModel(String field, String recordName);
    StatisticsRecordModel getStatisticsRecordModel(StatisticsRecord record);


    // TODO， get recent records by time frame, latest day, week, month, quarter, year etc.

    List<Map<String,Object>> getStatisticsRecordByFieldIdAndStartTimeAndEndTime(String field,List<String> fields,String startTime,String endTime);
}
