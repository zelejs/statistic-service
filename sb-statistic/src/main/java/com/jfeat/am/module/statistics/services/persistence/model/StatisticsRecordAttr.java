package com.jfeat.am.module.statistics.services.persistence.model;

import java.io.Serializable;

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
 * @since 2017-12-06
 */
@TableName("st_statistics_record_attr")
public class StatisticsRecordAttr extends Model<StatisticsRecordAttr> {

    private static final long serialVersionUID = 1L;

	private Long id;
	@TableField("record_id")
	private Long recordId;
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
     * 记录名称
     */
	private String legend;
    /**
     * 排序号
     */
	private Integer index;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRecordId() {
		return recordId;
	}

	public void setRecordId(Long recordId) {
		this.recordId = recordId;
	}

	public Long getFieldId() {
		return fieldId;
	}

	public void setFieldId(Long fieldId) {
		this.fieldId = fieldId;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getLegend() {
		return legend;
	}

	public void setLegend(String legend) {
		this.legend = legend;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public static final String ID = "id";

	public static final String RECORD_ID = "record_id";

	public static final String FIELD_ID = "field_id";

	public static final String FIELD = "field";

	public static final String LEGEND = "legend";

	public static final String INDEX = "index";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "StatisticsRecordAttr{" +
			"id=" + id +
			", recordId=" + recordId +
			", fieldId=" + fieldId +
			", field=" + field +
			", legend=" + legend +
			", index=" + index +
			"}";
	}
}
