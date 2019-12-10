package com.jfeat.am.module.statistics.services.domain.dao;

import com.jfeat.am.module.statistics.services.persistence.model.StatisticsGroup;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * Created by Code Generator on 2017-11-25
 */
public interface QueryStatisticsGroupDao extends BaseMapper<StatisticsGroup> {
    List<StatisticsGroup> findStatisticsGroupPage(Page<StatisticsGroup> page,@Param("statisticsgroup") StatisticsGroup statisticsgroup);
}