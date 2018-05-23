package com.jfeat.am.module.statement.services.statistics.util;

import java.sql.Connection;

/**
 * Created by vincent on 2018/5/8.
 */
public class MybatisConnection {
    static MybatisConnection mgr = new MybatisConnection();
    public static MybatisConnection getInstance(){
        return mgr;
    }
    public static void init(Connection connection){
        mgr.connection = connection;
    }

    private Connection connection;

    private Connection getConnection(){
        if(connection==null){
            throw new RuntimeException("Connection has not yet init-ed.");
        }
        return connection;
    }
}
