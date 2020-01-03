package com.jfeat.am.module.statistics.services.crud;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  service interface
 * </p>
 *
 * @author Code Generator
 * @since 2018-07-29
 * Master: ${cfg.masterModel}
  * Slave : st_statistics_meta
  */
public interface StatisticsMetaService {
    String getQuerySql(String field, String recordName, String tuple, String cluster, String timeline);

    //根据field获取 json化的 表
    public JSONObject getByField(String field, Long current, Long  size, HttpServletRequest request);
}
