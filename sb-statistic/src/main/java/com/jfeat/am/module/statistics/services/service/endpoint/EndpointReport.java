package com.jfeat.am.module.statistics.services.service.endpoint;

import java.util.List;

/**
 * Created by vincenthuang on 08/05/2018.
 */
public class EndpointReport {

    private List<String> headers;
    private List<List<String>> rows;

    public List<String> getHeaders() {
        return headers;
    }

    public void setHeaders(List<String> headers) {
        this.headers = headers;
    }

    public List<List<String>> getRows() {
        return rows;
    }

    public void setRows(List<List<String>> rows) {
        this.rows = rows;
    }
}
