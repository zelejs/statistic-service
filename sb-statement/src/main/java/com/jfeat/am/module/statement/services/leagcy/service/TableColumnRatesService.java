package com.jfeat.am.module.statement.services.leagcy.service;


import java.util.Map;

/**
 * Created by Silent-Y on 2017/11/6.
 */
@Deprecated
public interface TableColumnRatesService {
    Map<String,Object> getColumnRates(String table,String column, String fieldName,String timeName,String startTime,String endTime);
}
