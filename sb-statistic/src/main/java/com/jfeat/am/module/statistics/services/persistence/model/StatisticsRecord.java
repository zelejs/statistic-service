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
 * @since 2018-02-26
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
     * 记录时间
     */
	@TableField("record_time")
	private Date recordTime;
    /**
     * 统计时段说明[Till,Day,Week,Month,Quart,Year]
     */
	private String period;


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

	public Date getRecordTime() {
		return recordTime;
	}

	public StatisticsRecord setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
		return this;
	}

	public String getPeriod() {
		return period;
	}

	public StatisticsRecord setPeriod(String period) {
		this.period = period;
		return this;
	}

	public static final String ID = "id";

	public static final String FIELD_ID = "field_id";

	public static final String FIELD = "field";

	public static final String RECORD_NAME = "record_name";

	public static final String RECORD_VALUE = "record_value";

	public static final String RECORD_TIME = "record_time";

	public static final String PERIOD = "period";

	public static final String FIXED = "fixed";

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
			", recordTime=" + recordTime +
			", period=" + period +
			"}";
	}
}
