package com.jfeat.am.module.statistics.services.chart.model;

import java.util.List;

/**
 * Created by vincent on 2018/2/26.
 */
public class PieChartData {
    private String title;
    private String timestamp;
    private String type = "pie";
    private List<KeyValue> data;

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

    public List<KeyValue> getData() {
        return data;
    }

    public void setData(List<KeyValue> data) {
        this.data = data;
    }

    public static class KeyValue{
        private String name;
        private String value;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
