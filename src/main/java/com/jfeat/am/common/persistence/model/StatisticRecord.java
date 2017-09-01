package com.jfeat.am.common.persistence.model;

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
 * @author admin
 * @since 2017-09-01
 */
@TableName("st_statistic_record")
public class StatisticRecord extends Model<StatisticRecord> {

    private static final long serialVersionUID = 1L;

	private Long id;
	@TableField("type_id")
	private Long typeId;
	@TableField("record_time")
	private Date recordTime;
	@TableField("field_name")
	private String fieldName;
	private String value;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public Date getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "StatisticRecord{" +
			"id=" + id +
			", typeId=" + typeId +
			", recordTime=" + recordTime +
			", fieldName=" + fieldName +
			", value=" + value +
			"}";
	}
}
