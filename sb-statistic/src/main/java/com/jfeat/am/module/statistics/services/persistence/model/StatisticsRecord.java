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
 * @since 2017-11-25
 */
@TableName("st_statistics_record")
public class StatisticsRecord extends Model<StatisticsRecord> {

    private static final long serialVersionUID = 1L;

	private Long id;
    /**
     * 所属数据域
     */
	@TableField("field_id")
	private Long fieldId;
    /**
     * 数据域标识符
     */
	private String field;
    /**
     * 记录标记
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
     * 所属月份简称 [Mar,Jan,Q1,Q2]
     */
	@TableField("month_name")
	private String monthName;
    /**
     * 记录属性
     */
	@TableField("attr_id")
	private Long attrId;
    /**
     * 图例名称（中文）
     */
	private String legend;


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

	public String getMonthName() {
		return monthName;
	}

	public StatisticsRecord setMonthName(String monthName) {
		this.monthName = monthName;
		return this;
	}

	public Long getAttrId() {
		return attrId;
	}

	public StatisticsRecord setAttrId(Long attrId) {
		this.attrId = attrId;
		return this;
	}

	public String getLegend() {
		return legend;
	}

	public StatisticsRecord setLegend(String legend) {
		this.legend = legend;
		return this;
	}

	public static final String ID = "id";

	public static final String FIELD_ID = "field_id";

	public static final String FIELD = "field";

	public static final String RECORD_NAME = "record_name";

	public static final String RECORD_VALUE = "record_value";

	public static final String RECORD_TIME = "record_time";

	public static final String MONTH_NAME = "month_name";

	public static final String ATTR_ID = "attr_id";

	public static final String LEGEND = "legend";

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
			", monthName=" + monthName +
			", attrId=" + attrId +
			", legend=" + legend +
			"}";
	}
}
