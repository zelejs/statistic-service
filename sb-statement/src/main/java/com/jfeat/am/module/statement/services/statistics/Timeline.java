package com.jfeat.am.module.statement.services.statistics;

import static com.jfeat.am.module.statement.services.statistics.Timeline.Timelines.*;

/**
 * Created by vincenthuang on 08/05/2018.
 */
public class Timeline {

    /**
     * timeline options
     */
    public enum Timelines{
        T,       /// till now
        D,       /// current day
        W,       /// current week
        M,       /// current month
        LD3,     /// Latest 3 days
        LW1,     /// Latest week,
        LM1,     /// Latest month
        LM3,     /// Latest 3 months
        Q1,      //第一季度
        Q2,
        Q3,
        Q4,
        Y        /// current year
    }

    /**
     * 关于时间名称，用于记录时间
     */
    private String name;

    /**
     * 关于时间的表字段
     */
    private String timestampField;


    public Timeline(){
    }

    public Timeline(String name, String columnName){
        this.name = name;
        this.timestampField = columnName;
    }

    public String buildTimelineSql(String name){

        String sql = null;

        if(D.toString().compareTo(name)==0){
            sql = buildTodayQuery("mysql", timestampField);

        }else if(W.toString().compareTo(name)==0){

        }else{
            throw new RuntimeException("fatal: invalid timeline name: " + name);
        }

        return sql;
    }



    /**
     *  build time line query sql
     */


    private String buildTodayQuery(String dbType, String column){
        if("mysql".equals(dbType)){
            return String.format("%s >= date(now()) and %s < DATE_ADD(date(now()),INTERVAL 1 DAY)", column, column);
        }else if("sqlserver".equals(dbType)){
            return String.format("%s >=convert(varchar(10),getdate(),120) and %s < convert(varchar(10),dateadd(d,1,getdate()),120)", column, column);
        }else if("oracle".equals(dbType)){
            return String.format("%s >= to_char( sysdate ,’yyyy-mm-dd’) \n" +
                    "and %s < to_char( sysdate+1 ,’yyyy-mm-dd’)", column, column);
        }else if("Access".equals(dbType)){
            return String.format("%s >= date() and %s < DateAdd(“d”, 1, date())", column, column);
        }

        throw new RuntimeException("fatal: invalid dbType = " + dbType);
    }
}
