package com.jfeat.am.module.statistics.services.domain.dao;

import com.jfeat.am.module.statistics.services.service.persistence.model.StatisticsRecordAttr;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * Created by Code Generator on 2017-11-25
 */
public interface QueryStatisticsRecordAttrDao extends BaseMapper<StatisticsRecordAttr> {
    List<StatisticsRecordAttr> findStatisticsRecordAttrPage(Page<StatisticsRecordAttr> page,@Param("statisticsrecordattr") StatisticsRecordAttr statisticsrecordattr);
}