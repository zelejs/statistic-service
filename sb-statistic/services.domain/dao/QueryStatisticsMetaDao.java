package com.jfeat.am.module.statistics.services.domain.dao;

import com.jfeat.am.module.statistics.services.domain.model.StatisticsMetaRecord;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * Created by Code Generator on 2018-07-29
 */
public interface QueryStatisticsMetaDao extends BaseMapper<StatisticsMetaRecord> {
    List<StatisticsMetaRecord> findStatisticsMetaPage(Page<StatisticsMetaRecord> page, @Param("record") StatisticsMetaRecord record, @Param("orderBy") String orderBy);
}