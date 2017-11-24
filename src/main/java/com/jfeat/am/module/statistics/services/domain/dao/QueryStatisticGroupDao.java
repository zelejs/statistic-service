package com.jfeat.am.module.statistics.services.domain.dao;

import com.jfeat.am.module.statistics.services.persistence.model.StatisticGroup;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * Created by Code Generator on 2017-11-24
 */
public interface QueryStatisticGroupDao extends BaseMapper<StatisticGroup> {
    List<StatisticGroup> findStatisticGroupPage(Page<StatisticGroup> page,@Param("statisticgroup") StatisticGroup statisticgroup);
}