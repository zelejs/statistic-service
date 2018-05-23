package com.jfeat.am.module.statement.services.leagcy.service;

import java.util.Map;

/**
 * Created by Silent-Y on 2017/11/6.
 */
@Deprecated
public interface TableColumnStatusNumService {
    public Map<String,Object> getColumnStatusNum(String table, String column,String field, String columnValue, String timeName, String startTime, String endTime);
}
