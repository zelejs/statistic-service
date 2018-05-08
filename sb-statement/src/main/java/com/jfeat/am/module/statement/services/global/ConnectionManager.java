package com.jfeat.am.module.statement.services.global;

import java.sql.Connection;

/**
 * Created by vincent on 2018/5/8.
 */
public class ConnectionManager {
    static ConnectionManager mgr = new ConnectionManager();
    public static ConnectionManager getInstance(){
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
