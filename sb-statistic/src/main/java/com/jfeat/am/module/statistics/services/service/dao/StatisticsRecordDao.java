package com.jfeat.am.module.statistics.services.service.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsRecord;

import java.util.List;
import java.util.Map;

/**
 * Created by vincent on 2018/2/26.
 */
@Deprecated
public interface StatisticsRecordDao extends BaseMapper<StatisticsRecord>{
    List<Map<String,Object>> getStatisticsRecordByFieldIdAndStartTimeAndEndTime(String field, List<String> fields, String startTime, String endTime);
}
