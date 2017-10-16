package com.jfeat.am.modular.statistic.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jfeat.am.common.persistence.model.StatisticRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author admin
 * @since 2017-09-01
 */
public interface StatisticRecordDao extends BaseMapper<StatisticRecord> {

    public List<Map<String,Object>> getStatisticRecordByTypeIdAndStartTimeAndEndTime(@Param("typeId") Long typeId,@Param("fields")List<String> fields,@Param("startTime")String startTime,@Param("endTime")String endTime);

}