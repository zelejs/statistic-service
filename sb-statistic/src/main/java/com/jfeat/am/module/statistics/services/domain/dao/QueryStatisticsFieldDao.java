package com.jfeat.am.module.statistics.services.domain.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsField;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Code Generator on 2017-11-25
 */
public interface QueryStatisticsFieldDao extends BaseMapper<StatisticsField> {
    List<StatisticsField> findStatisticsFieldPage(Page<StatisticsField> page, @Param("statisticsField") StatisticsField field);
}