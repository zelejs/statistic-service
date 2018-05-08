package com.jfeat.am.module.statement.services.connections;

/**
 * Created by vincent on 2018/5/8.
 */
public class ColumnInfo {
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