package com.jfeat.am.module.statistics.services.service;


import com.jfeat.am.module.statistics.services.persistence.model.StatisticsRecordAttr;

import java.util.List;
import java.util.Map;

/**
 * Created by Silent-Y on 2017/8/31.
 */
public interface StatisticsRecordService {

    List<Map<String,Object>> getStatisticsRecordByFieldIdAndStartTimeAndEndTime(String field,List<String> fields,String startTime,String endTime);
    List<Map<String,Object>> getStatisticRecordByTypeIdAndStartTimeAndEndTime(Long typeId,List<String> fields,String startTime,String endTime);

    /// get record attr
    List<StatisticsRecordAttr> getRecordAttrByFieldId(Long fieldId);
    List<StatisticsRecordAttr> getRecordAttrByField(String field);
}
