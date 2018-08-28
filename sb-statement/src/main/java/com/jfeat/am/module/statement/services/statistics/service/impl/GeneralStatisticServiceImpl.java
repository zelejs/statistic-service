package com.jfeat.am.module.statement.services.statistics.service.impl;

import com.jfeat.am.module.statement.services.statistics.util.JDBCConnectionUtil;
import com.jfeat.am.module.statement.services.statistics.service.GeneralStatisticService;
import com.jfeat.am.module.statement.services.statistics.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * author: Created by vincent on 2018/5/8.
 * when:
 * modified:
 */
@Service
public class GeneralStatisticServiceImpl implements GeneralStatisticService {

    @Autowired
    DataSource dataSource;

    Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Statistics queryStatistic(String name, String sql) throws SQLException {
        Connection connection = getConnection();

        List<Map<String, String>> result =  JDBCConnectionUtil.querySQL(connection, sql);
        if(result==null || result.size()==0){
            return null;
        }
        if(result.size()!=1){
            throw new RuntimeException("error: Bad SQL request (only one row allowed) : " + sql);
        }

        /// set statistic data
        Statistic stat = new Statistic();

        Map<String,String> it = result.get(0);
        Map.Entry<String,String> entry = it.entrySet().iterator().next();

        /// set name
        if(name==null || name.length()==0) {
            stat.setName(entry.getKey());
        }else {
            stat.setName(name);
        }
        stat.setValue(entry.getValue());

        return stat;
    }

    @Override
    public StatisticRate queryStatisticRate(String name, String sql)  throws SQLException {
        Connection connection = getConnection();
        List<Map<String, String>> result =  JDBCConnectionUtil.querySQL(connection, sql);
        if(result==null || result.size()==0){
            return null;
        }

        /// only one row allowed
        if(result.size()!=1){
            throw new RuntimeException("error: Bad SQL request(only one row allowed)" + sql);
        }

        /// set statistic data
        StatisticRate rates = new StatisticRate();
        rates.setName(name);

        Iterator<Map.Entry<String,String>> it = result.get(0).entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<String,String> entry = it.next();
            rates.addRate(entry.getKey(), entry.getValue());
        }

        return rates;
    }

    @Override
    public StatisticTuple queryStatisticTuple(String name, String sql) throws SQLException {
        Connection connection = getConnection();
        List<Map<String, String>> result =  JDBCConnectionUtil.querySQL(connection, sql);
        if(result==null || result.size()==0){
            return null;
        }

        /// set statistic data
        /// 报表数据转换为 列数据, 如按时间段查询
        StatisticTuple statisticTuple = new StatisticTuple();
        statisticTuple.setName(name);

        // 列表为各占比的名称
        // create column name hash table

        // 历遍报表结构查询结果，转换并创建各占比数据
        int curr = 0;
        Iterator<Map<String,String>> rowIt = result.iterator();
        while (rowIt.hasNext()){
            Map<String,String> row = rowIt.next();

            Iterator<Map.Entry<String, String>> it = row.entrySet().iterator();
            Map.Entry<String, String> firstEntry = null;
            while (it.hasNext()) {
                Map.Entry<String, String> entry = it.next();
                if(firstEntry==null){
                    firstEntry = entry;
                }

                String tupleName = firstEntry.getValue();
                StatisticRate rate = new StatisticRate();
                rate.setName(tupleName);
                rate.addRate(new Statistic(entry.getKey(), entry.getValue()));

                statisticTuple.addRate(rate);
            }

            curr++;
        }

        return statisticTuple;
    }

    @Override
    public StatisticTimeline queryStatisticTimeline(String name, String sql, Timeline... timelines)
            throws SQLException  {

        /// 报表数据转换为列数据, 如按时间段查询
        StatisticTimeline statisticTimeline = new StatisticTimeline();
        statisticTimeline.setName(name);

        // foreach timeline
        for(Timeline timeline : timelines) {

            StringBuilder builder = new StringBuilder();
            builder.append(sql);
            builder.append(" WHERE ");
            builder.append(timeline.toSql());

            String timelineSql = builder.toString();

            Connection connection = getConnection();
            List<Map<String, String>> result = JDBCConnectionUtil.querySQL(connection, timelineSql);
            if (result == null || result.size() == 0) {
                return null;
            }

            /// create statistic
            if(result.size()==1){
                if(result.get(0).keySet().size()==1) {
                    // total
                    Map.Entry<String,String> entry = result.get(0).entrySet().iterator().next();
                    statisticTimeline.addStatistic(
                            new Statistic(entry.getKey(), entry.getValue()).timeline(timeline.getName()));

                }else if(result.get(0).keySet().size()>1){
                    // rate
                    StatisticRate rate = convertMapToStatisticRate(result.get(0));
                    rate.setTimeline(timeline.getName());

                    statisticTimeline.addStatistic(rate);
                }
            }else if(result.size()>1){
                /// tuple
                StatisticTuple statisticTuple = new StatisticTuple();
                statisticTuple.setTimeline(timeline.getName());

                for (Map<String,String> tuple : result){
                    StatisticRate rate = convertMapToStatisticRate(tuple);

                    // set tuple name
                    rate.setName(rate.getValues().get(0).getValue());

                    statisticTuple.addRate(rate);
                }

                statisticTimeline.addStatistic(statisticTuple);
            }
        }

        return statisticTimeline;
    }


    /**
     * 转换sql查询结果为 占比数据结构
     * @param map
     * @return
     */
    private StatisticRate convertMapToStatisticRate(Map<String,String> map){
        if(map==null || map.size()==0){
            return null;
        }
        StatisticRate rate = new StatisticRate();
        Iterator<Map.Entry<String,String>> it = map.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<String,String> entry = it.next();
            rate.addRate(new Statistic(entry.getKey(), entry.getValue()));
        }

        return rate;
    }
}
