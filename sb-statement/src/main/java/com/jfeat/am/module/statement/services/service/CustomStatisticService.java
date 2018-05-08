package com.jfeat.am.module.statement.services.service;

import com.jfeat.am.module.statement.services.statistic.StatisticRate;
import com.jfeat.am.module.statement.services.statistic.StatisticTimeline;
import com.jfeat.am.module.statement.services.statistic.StatisticTuple;
import com.jfeat.am.module.statement.services.statistic.Statistics;

import java.sql.SQLException;

/**
 * Created by vincent on 2018/5/8.
 * 自定义报表，通过自定义SQL生成报表数据
 */
public interface CustomStatisticService {

    /**
     * 查询单数据
     * @param name : 单项统计名称, 自定义
     */
    Statistics queryStatistic(String name, String sql) throws SQLException;

    /**
     * 查询占比
     *  @param name : 占比统计名称, 自定义
     */
    StatisticRate queryStatisticRate(String name, String sql) throws SQLException ;

    /**
     * 查询报表
     *  @param name : 报表统计名称, 自定义
     */
    StatisticTuple queryStatisticTuple(String name, String sql) throws SQLException ;

    /**
     * 查询多时间维度占比 （当天，最近一周，当前月，最近3个月, Q1, Q2,Q3, Q3, 今年 etc.）
     * @param name : 多时间维度占比统计名称, 自定义
     * @param sql : SELECT [field1,field2,...]
     *            KeyField 第一项作为占比命名, sql 查询语句必须满足查询条件
     */
    StatisticTimeline queryStatisticTimeline(String name, String sql) throws SQLException ;
}
