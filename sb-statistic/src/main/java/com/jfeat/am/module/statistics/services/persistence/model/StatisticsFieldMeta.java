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
 * @author Code Generator
 * @since 2018-07-25
 */
@TableName("st_statistics_field_meta")
public class StatisticsFieldMeta extends Model<StatisticsFieldMeta> {

    private static final long serialVersionUID = 1L;

	private Long id;
    /**
     * 所属数据域ID[CRUD]
     */
	@TableField("field_id")
	private Long fieldId;
    /**
     * 数据域唯一标识符
     */
	private String field;
    /**
     * 记录名称
     */
	@TableField("record_name")
	private String recordName;
    /**
     * 实时查询sql
     */
	@TableField("query_sql")
	private String querySql;


	public Long getId() {
		return id;
	}

	public StatisticsFieldMeta setId(Long id) {
		this.id = id;
		return this;
	}

	public Long getFieldId() {
		return fieldId;
	}

	public StatisticsFieldMeta setFieldId(Long fieldId) {
		this.fieldId = fieldId;
		return this;
	}

	public String getField() {
		return field;
	}

	public StatisticsFieldMeta setField(String field) {
		this.field = field;
		return this;
	}

	public String getRecordName() {
		return recordName;
	}

	public StatisticsFieldMeta setRecordName(String recordName) {
		this.recordName = recordName;
		return this;
	}

	public String getQuerySql() {
		return querySql;
	}

	public StatisticsFieldMeta setQuerySql(String querySql) {
		this.querySql = querySql;
		return this;
	}

	public static final String ID = "id";

	public static final String FIELD_ID = "field_id";

	public static final String FIELD = "field";

	public static final String RECORD_NAME = "record_name";

	public static final String QUERY_SQL = "query_sql";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "StatisticsFieldMeta{" +
			"id=" + id +
			", fieldId=" + fieldId +
			", field=" + field +
			", recordName=" + recordName +
			", querySql=" + querySql +
			"}";
	}
}
