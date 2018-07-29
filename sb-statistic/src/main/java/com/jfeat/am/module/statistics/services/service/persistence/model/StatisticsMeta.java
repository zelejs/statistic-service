package com.jfeat.am.module.statistics.services.service.persistence.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 
 * </p>
 *
 * @author Code Generator
 * @since 2018-07-29
 */
@TableName("st_statistics_meta")
public class StatisticsMeta extends Model<StatisticsMeta> {

    private static final long serialVersionUID = 1L;

	private Long id;
    /**
     * 数据指标唯一标识符
     */
	private String field;
    /**
     * 记录名称
     */
	@TableField("record_name")
	private String recordName;
    /**
     * 记录名称
     */
	@TableField("record_tuple")
	private String recordTuple;
    /**
     * 记录值所属分类名称
     */
	@TableField("record_cluster")
	private String recordCluster;
    /**
     * 统计时段标记
     */
	private String timeline;
    /**
     * 实时查询sql
     */
	@TableField("query_sql")
	private String querySql;
    /**
     * 临时指标记录ID
     */
	@TableField("tmp_record_id")
	private Long tmpRecordId;


	public Long getId() {
		return id;
	}

	public StatisticsMeta setId(Long id) {
		this.id = id;
		return this;
	}

	public String getField() {
		return field;
	}

	public StatisticsMeta setField(String field) {
		this.field = field;
		return this;
	}

	public String getRecordName() {
		return recordName;
	}

	public StatisticsMeta setRecordName(String recordName) {
		this.recordName = recordName;
		return this;
	}

	public String getRecordTuple() {
		return recordTuple;
	}

	public StatisticsMeta setRecordTuple(String recordTuple) {
		this.recordTuple = recordTuple;
		return this;
	}

	public String getRecordCluster() {
		return recordCluster;
	}

	public StatisticsMeta setRecordCluster(String recordCluster) {
		this.recordCluster = recordCluster;
		return this;
	}

	public String getTimeline() {
		return timeline;
	}

	public StatisticsMeta setTimeline(String timeline) {
		this.timeline = timeline;
		return this;
	}

	public String getQuerySql() {
		return querySql;
	}

	public StatisticsMeta setQuerySql(String querySql) {
		this.querySql = querySql;
		return this;
	}

	public Long getTmpRecordId() {
		return tmpRecordId;
	}

	public StatisticsMeta setTmpRecordId(Long tmpRecordId) {
		this.tmpRecordId = tmpRecordId;
		return this;
	}

	public static final String ID = "id";

	public static final String FIELD = "field";

	public static final String RECORD_NAME = "record_name";

	public static final String RECORD_TUPLE = "record_tuple";

	public static final String RECORD_CLUSTER = "record_cluster";

	public static final String TIMELINE = "timeline";

	public static final String QUERY_SQL = "query_sql";

	public static final String TMP_RECORD_ID = "tmp_record_id";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "StatisticsMeta{" +
			"id=" + id +
			", field=" + field +
			", recordName=" + recordName +
			", recordTuple=" + recordTuple +
			", recordCluster=" + recordCluster +
			", timeline=" + timeline +
			", querySql=" + querySql +
			", tmpRecordId=" + tmpRecordId +
			"}";
	}
}
