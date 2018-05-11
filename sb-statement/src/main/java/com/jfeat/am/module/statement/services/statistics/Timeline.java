package com.jfeat.am.module.statement.services.statistics;

import java.util.Calendar;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTimestampField() {
        return timestampField;
    }

    public void setTimestampField(String timestampField) {
        this.timestampField = timestampField;
    }

    public Timeline(){
    }

    public Timeline(String name, String columnName){
        this.name = name;
        this.timestampField = columnName;
    }

    public String buildTimelineSql(String name){

        String sql = null;

        Calendar calendar = Calendar.getInstance();

        if(D.toString().compareTo(name)==0){
            sql = buildTodayQuery("mysql", timestampField);
        }else if(LW1.toString().compareTo(name)==0) {
            sql = buildLatestQuery("mysql", timestampField,"7 DAY");
        }else if(LM1.toString().compareTo(name)==0){
            sql = buildLatestQuery("mysql",timestampField,"1 MONTH");
        }else if(LM3.toString().compareTo(name)==0){
            sql = buildLatestQuery("mysql",timestampField,"3 MONTH");
        }else if(LD3.toString().compareTo(name)==0){
            sql = buildLatestQuery("mysql",timestampField,"3 DAY");
        }else if(W.toString().compareTo(name)==0){
            sql = buildLatestQuery("mysql",timestampField,calendar.get(Calendar.DAY_OF_WEEK)+" DAY");
        }else if(M.toString().compareTo(name)==0){
            sql = buildLatestQuery("mysql",timestampField,calendar.get(Calendar.DAY_OF_MONTH)+" DAY");
        }else if(Q1.toString().compareTo(name)==0){
            sql = buildQQuery("mysql",timestampField,calendar.get(Calendar.DAY_OF_YEAR),Q1.toString());
        }else if(Q2.toString().compareTo(name)==0){
            sql = buildQQuery("mysql",timestampField,calendar.get(Calendar.DAY_OF_YEAR),Q2.toString());
        }else if(Q3.toString().compareTo(name)==0){
            sql = buildQQuery("mysql",timestampField,calendar.get(Calendar.DAY_OF_YEAR),Q3.toString());
        }else if(Q4.toString().compareTo(name)==0){
            sql = buildQQuery("mysql",timestampField,calendar.get(Calendar.DAY_OF_YEAR),Q4.toString());
        }else if(Y.toString().compareTo(name)==0){
            sql = buildQQuery("mysql",timestampField,calendar.get(Calendar.DAY_OF_YEAR),Y.toString());
        }else{
            throw new RuntimeException("fatal: invalid timeline name: " + name);
        }

        return sql;
    }



    /**
     *  build time line query sql
     */

    private String buildQQuery(String dbType,String column,int year,String Q){ //季度

        String start="",end = "";

        if(Q.equals(Q1.toString())){
            start = String.format("'%s-01-01'",year);
            end   = String.format("'%s-04-01'",year);
        }else if(Q.equals(Q2.toString())){
            start = String.format("'%s-04-01'",year);
            end   = String.format("'%s-07-01'",year);
        }else if(Q.equals(Q3.toString())){
            start = String.format("'%s-07-01'",year);
            end   = String.format("'%s-10-01'",year);
        }else if(Q.equals(Q4.toString())) {
            start = String.format("'%s-10-01'", year);
            end = String.format("'%s-01-01'", year + 1);
        }else if(Q.equals(Y.toString())){
            end = "now()";
            start = String.format("'%s-01-01'", year);
        }else{
            throw new RuntimeException("这是一个内部异常，出现在 Timeline.buildQQuery() 中的Q 参数");
        }


        if("mysql".equals(dbType)){
            return String.format("%s <= date(%s) and %s > date('%s')", column, end ,column, start );
        }else if("sqlserver".equals(dbType)){
            return null;
        }else if("oracle".equals(dbType)){
            return null;
        }else if("Access".equals(dbType)){
            return null;
        }

        throw new RuntimeException("fatal: invalid dbType = " + dbType);
    }


    private String buildLatestQuery(String dbType,String column,String time){
        if("mysql".equals(dbType)){
            return String.format("%s <= date(now()) and %s > DATE_SUB(date(now()),INTERVAL %s)", column, column, time);
        }else if("sqlserver".equals(dbType)){
            return null;
        }else if("oracle".equals(dbType)){
            return null;
        }else if("Access".equals(dbType)){
            return null;
        }

        throw new RuntimeException("fatal: invalid dbType = " + dbType);
    }


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
