package com.jfeat.am.module.statistics.services.domain.dao;

import com.jfeat.am.module.statistics.services.persistence.model.StatisticsRecord;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * Created by Code Generator on 2017-11-25
 */
public interface QueryStatisticsRecordDao extends BaseMapper<StatisticsRecord> {
    List<StatisticsRecord> findStatisticsRecordPage(Page<StatisticsRecord> page,@Param("statisticsrecord") StatisticsRecord statisticsrecord);
}