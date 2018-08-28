package com.jfeat.am.module.statistics.services.crud;
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
}
