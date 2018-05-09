package com.jfeat.am.module.statistics.services.persistence.model;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Code Generator
 * @since 2018-05-09
 */
@TableName("st_statistics_record")
public class StatisticsRecord extends Model<StatisticsRecord> {

    private static final long serialVersionUID = 1L;

	private Long id;
    /**
     * 所属数据域ID[CRUD]
     */
	@TableField("field_id")
	private Long fieldId;
    /**
     * 数据域标识符
     */
	private String field;
    /**
     * 记录名称
     */
	@TableField("record_name")
	private String recordName;
    /**
     * 记录值
     */
	@TableField("record_value")
	private String recordValue;
    /**
     * 记录值所属行名称
     */
	@TableField("record_tuple")
	private String recordTuple;
    /**
     * 记录值所属分类名称
     */
	@TableField("record_cluster")
	private String recordCluster;
    /**
     * 统计时段说明[T,D,W,M,LD3,LW1,LM1,LM3,Q1,Q2,Q3,Q4,Y]
     */
	private String timeline;
    /**
     * 记录时间
     */
	@TableField("record_time")
	private Date recordTime;


	public Long getId() {
		return id;
	}

	public StatisticsRecord setId(Long id) {
		this.id = id;
		return this;
	}

	public Long getFieldId() {
		return fieldId;
	}

	public StatisticsRecord setFieldId(Long fieldId) {
		this.fieldId = fieldId;
		return this;
	}

	public String getField() {
		return field;
	}

	public StatisticsRecord setField(String field) {
		this.field = field;
		return this;
	}

	public String getRecordName() {
		return recordName;
	}

	public StatisticsRecord setRecordName(String recordName) {
		this.recordName = recordName;
		return this;
	}

	public String getRecordValue() {
		return recordValue;
	}

	public StatisticsRecord setRecordValue(String recordValue) {
		this.recordValue = recordValue;
		return this;
	}

	public String getRecordTuple() {
		return recordTuple;
	}

	public StatisticsRecord setRecordTuple(String recordTuple) {
		this.recordTuple = recordTuple;
		return this;
	}

	public String getRecordCluster() {
		return recordCluster;
	}

	public StatisticsRecord setRecordCluster(String recordCluster) {
		this.recordCluster = recordCluster;
		return this;
	}

	public String getTimeline() {
		return timeline;
	}

	public StatisticsRecord setTimeline(String timeline) {
		this.timeline = timeline;
		return this;
	}

	public Date getRecordTime() {
		return recordTime;
	}

	public StatisticsRecord setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
		return this;
	}

	public static final String ID = "id";

	public static final String FIELD_ID = "field_id";

	public static final String FIELD = "field";

	public static final String RECORD_NAME = "record_name";

	public static final String RECORD_VALUE = "record_value";

	public static final String RECORD_TUPLE = "record_tuple";

	public static final String RECORD_CLUSTER = "record_cluster";

	public static final String TIMELINE = "timeline";

	public static final String RECORD_TIME = "record_time";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "StatisticsRecord{" +
			"id=" + id +
			", fieldId=" + fieldId +
			", field=" + field +
			", recordName=" + recordName +
			", recordValue=" + recordValue +
			", recordTuple=" + recordTuple +
			", recordCluster=" + recordCluster +
			", timeline=" + timeline +
			", recordTime=" + recordTime +
			"}";
	}
}
