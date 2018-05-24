package com.jfeat.am.module.statement.services.statistics.sql;

/**
 * Created by vincent on 2018/5/23.
 */
public class Rate {

    public static String queryColumnValues(String table, String columnName){
        return String.format("select distinct %s from %s\n" +
                "        where %s is not null", columnName, table, columnName);
    }

    public static String queryColumnRates(String table, String columnName, String[] columnValues, String timeFieldName, String startTime, String endTime){

        StringBuilder sql = new StringBuilder();

        final String statement = "sum( case when %s= %s then 1 else 0 end) as %s";
        final String COMMA = ",";

        for(String columnValue : columnValues) {
            String valueSql = String.format(statement, columnName, columnValue, columnValue);
            sql.append(valueSql);
            sql.append(COMMA);
        }
        if(sql.length()>0){
            sql.deleteCharAt(sql.length()-1);
        }

        sql.append(" from ");
        sql.append(table);

        if(timeFieldName!=null && startTime!=null && endTime!=null){
            sql.append(String.format(" where %s between %s and %s", timeFieldName, startTime, endTime));
        }

        return sql.toString();
    }
}
