package com.jfeat.am.module.tt.services.persistence.model;

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
     * 鎵�灞炴暟鎹煙ID[CRUD]
     */
	@TableField("field_id")
	private Long fieldId;
    /**
     * 鏁版嵁鍩熸爣璇嗙
     */
	private String field;
    /**
     * 璁板綍鍚嶇О
     */
	@TableField("record_name")
	private String recordName;
    /**
     * 璁板綍鍊�
     */
	@TableField("record_value")
	private String recordValue;
    /**
     * 璁板綍鍊兼墍灞炶鍚嶇О
     */
	@TableField("record_tuple")
	private String recordTuple;
    /**
     * 缁熻鏃舵璇存槑[T,D,W,M,LD3,LW1,LM1,LM3,Q1,Q2,Q3,Q4,Y]
     */
	@TableField("record_timeline")
	private String recordTimeline;
    /**
     * 璁板綍鏃堕棿
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

	public String getRecordTimeline() {
		return recordTimeline;
	}

	public StatisticsRecord setRecordTimeline(String recordTimeline) {
		this.recordTimeline = recordTimeline;
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

	public static final String RECORD_TIMELINE = "record_timeline";

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
			", recordTimeline=" + recordTimeline +
			", recordTime=" + recordTime +
			"}";
	}
}
