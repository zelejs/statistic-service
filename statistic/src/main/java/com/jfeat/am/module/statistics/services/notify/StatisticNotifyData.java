package com.jfeat.am.module.statistics.services.notify;

import java.util.Date;
import java.util.List;

/**
 * Created by Silent-Y on 2017/8/31.
 */
@Deprecated
public class StatisticNotifyData {

    /// 分组由运维决定,这里不指定分组

    @Deprecated
    private String identifier;
    @Deprecated
    public String getIdentifier() {
        return identifier;
    }
    @Deprecated
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }



    /**
     * 名称(这里指唯一统计域 域名）
     */
    private String name;

    /**
     * 记录时间
     */
    private Date recordTime;

    /**
     * 关于域名的所有统计数据项
     */
    private List<StatisticChunk> chunks;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    public List<StatisticChunk> getChunks() {
        return chunks;
    }

    public void setChunks(List<StatisticChunk> chunks) {
        this.chunks = chunks;
    }
}
