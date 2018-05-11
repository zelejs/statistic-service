package com.jfeat.am.module.statement.services.statistics.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vincent on 2018/5/8.
 */
public class JDBCConnectionUtil {
    /**
     * 返回数据库里该表的字段类型和字段名称
     * @param connection
     * @return
     * @throws SQLException
     */
    public static List<ColumnInfo> getColumnInfo(Connection connection, String sql) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();
        ResultSetMetaData resultSetMetaData = rs.getMetaData();
        int columnCount = resultSetMetaData.getColumnCount();
        List<ColumnInfo> infoList = new ArrayList<>();
        for (int i = 0; i < columnCount; i++) {
            ColumnInfo columnInfo = new ColumnInfo(resultSetMetaData.getColumnTypeName(i + 1), resultSetMetaData.getColumnLabel(i + 1));
            infoList.add(columnInfo);
        }
        return infoList;
    }

    /**
     *  直接查询数据库
     * @param connection
     * @param sql
     * @return
     * @throws SQLException
     */
    public static  List<Map<String, String>> querySQL(Connection connection, String sql) throws SQLException{
        List<Map<String, String>> result = new ArrayList<>();

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet rs = null;
        try {
            rs = preparedStatement.executeQuery();
            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();
            while (rs.next()) {
                Map<String, String> map = new LinkedHashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    map.put(resultSetMetaData.getColumnLabel(i), rs.getObject(i) == null ? "" : rs.getObject(i).toString());
                }
                result.add(map);
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    /**
     * class ColumnInfo
     */
    public static class ColumnInfo {
        private String type;
        private String name;

        public ColumnInfo() { }

        public ColumnInfo(String type, String name) {
            this.type = type;
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
