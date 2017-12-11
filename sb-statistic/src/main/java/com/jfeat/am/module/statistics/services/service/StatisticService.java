package com.jfeat.am.module.statistics.services.service;

import com.jfeat.am.module.statistics.services.domain.model.DataModel;

import java.util.Map;

/**
 * Created by Silent-Y on 2017/12/4.
 */
public interface StatisticService {

    Boolean insertStatisticRecord(DataModel dataModel);

    Map<String,Object> getEchartData(String field,String echart,String startTime,String endTime);
}
