package com.jfeat.am.module.statistics.services.domain.dao;

import com.jfeat.am.module.statistics.services.persistence.model.StatisticsField;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsRecord;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsRecordAttr;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * Created by Code Generator on 2017-11-25
 */
public interface QueryStatisticsFieldDao extends BaseMapper<StatisticsField> {
    List<StatisticsField> findStatisticsFieldPage(Page<StatisticsField> page,@Param("statisticsfield") StatisticsField statisticsfield);

    List<Map<String,Object>> getStatisticsRecordByFieldIdAndStartTimeAndEndTime(@Param("field") String field,@Param("fields")List<StatisticsRecordAttr> fields,@Param("startTime")String startTime,@Param("endTime")String endTime);
}