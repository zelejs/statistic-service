package com.jfeat.am.module.statistics.services.chart.model;

import java.util.List;

/**
 * Created by vincent on 2018/2/26.
 */
public class LineChartData {
    private String title;
    private String timestamp;
    private String type = "line";
    private List<String> dataAxis;
    private List<String> data;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getType() {
        return type;
    }
    public List<String> getDataAxis() {
        return dataAxis;
    }

    public void setDataAxis(List<String> dataAxis) {
        this.dataAxis = dataAxis;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
