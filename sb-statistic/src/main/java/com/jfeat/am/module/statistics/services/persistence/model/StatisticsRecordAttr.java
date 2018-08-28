package com.jfeat.am.module.statistics.services.persistence.model;

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
 * @since 2018-05-09
 */
@TableName("st_statistics_record_attr")
public class StatisticsRecordAttr extends Model<StatisticsRecordAttr> {

    private static final long serialVersionUID = 1L;

	private Long id;
    /**
     * 所属数据域标识符
     */
	private String field;
    /**
     * 所修饰的记录名称
     */
	@TableField("record_name")
	private String recordName;
    /**
     * 图例名称(中文)
     */
	private String legend;
    /**
     * 图例说明
     */
	private String note;
    /**
     * 排序号
     */
	private Integer index;


	public Long getId() {
		return id;
	}

	public StatisticsRecordAttr setId(Long id) {
		this.id = id;
		return this;
	}

	public String getField() {
		return field;
	}

	public StatisticsRecordAttr setField(String field) {
		this.field = field;
		return this;
	}

	public String getRecordName() {
		return recordName;
	}

	public StatisticsRecordAttr setRecordName(String recordName) {
		this.recordName = recordName;
		return this;
	}

	public String getLegend() {
		return legend;
	}

	public StatisticsRecordAttr setLegend(String legend) {
		this.legend = legend;
		return this;
	}

	public String getNote() {
		return note;
	}

	public StatisticsRecordAttr setNote(String note) {
		this.note = note;
		return this;
	}

	public Integer getIndex() {
		return index;
	}

	public StatisticsRecordAttr setIndex(Integer index) {
		this.index = index;
		return this;
	}

	public static final String ID = "id";

	public static final String FIELD = "field";

	public static final String RECORD_NAME = "record_name";

	public static final String LEGEND = "legend";

	public static final String NOTE = "note";

	public static final String INDEX = "index";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "StatisticsRecordAttr{" +
			"id=" + id +
			", field=" + field +
			", recordName=" + recordName +
			", legend=" + legend +
			", note=" + note +
			", index=" + index +
			"}";
	}
}
