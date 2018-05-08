package com.jfeat.am.module.statement.services.service.impl;

import com.jfeat.am.module.statement.services.connections.ColumnInfo;
import com.jfeat.am.module.statement.services.connections.JDBCConnectionUtil;
import com.jfeat.am.module.statement.services.service.CustomStatisticService;
import com.jfeat.am.module.statement.services.statistic.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by vincent on 2018/5/8.
 */
public class CustomStatisticServiceImpl implements CustomStatisticService {

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
        // set name
        rates.setName(name);

        Iterator<Map<String,String>> it = result.iterator();
        while (it.hasNext()){
            Map<String,String> item = it.next();
            Map.Entry<String,String> entry = item.entrySet().iterator().next();
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
        StatisticTuple tuples = new StatisticTuple();
        tuples.setName(name);

        // 列表为各占比的名称
        // create column name hash table

        Map<String,StatisticRate> rateHash = new HashMap<>();
        {
            /// 创建时间段各占比名称
            List<ColumnInfo> infoList = JDBCConnectionUtil.getColumnInfo(connection, sql);
            for (ColumnInfo info : infoList) {
                StatisticRate rate = new StatisticRate();
                rateHash.put(info.getName(), rate);
            }
        }

        // 历遍报表结构查询结果，转换并创建各占比数据
        Iterator<Map<String,String>> it = result.iterator();
        while (it.hasNext()){
            Map<String,String> item = it.next();
            Map.Entry<String,String> entry = item.entrySet().iterator().next();

        }

        return tuples;
    }

    @Override
    public StatisticTimeline queryStatisticTimeline(String name, String sql) throws SQLException  {
        Connection connection = getConnection();
        List<Map<String, String>> result =  JDBCConnectionUtil.querySQL(connection, sql);
        if(result==null || result.size()==0){
            return null;
        }

        /// set statistic data
        /// 报表数据转换为 列数据, 如按时间段查询
        StatisticTimeline timeline = new StatisticTimeline();
        timeline.setName(name);

        // 列表为各占比的名称
        // create column name hash table


        Map<String,StatisticRate> rateHash = new HashMap<>();
        {
            /// 创建时间段各占比名称
            List<ColumnInfo> infoList = JDBCConnectionUtil.getColumnInfo(connection, sql);
            for (ColumnInfo info : infoList) {
                StatisticRate rate = new StatisticRate();
                rateHash.put(info.getName(), rate);
            }
        }

        // 历遍报表结构查询结果，转换并创建各占比数据
        Iterator<Map<String,String>> it = result.iterator();
        while (it.hasNext()){
            Map<String,String> item = it.next();
            Map.Entry<String,String> entry = item.entrySet().iterator().next();
        }

        return timeline;
    }

    private StatisticRate convertMapToStatisticRate(Map<String,String> map){
        return null;
    }
}
