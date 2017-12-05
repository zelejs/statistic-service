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
 * @since 2017-11-25
 */
@TableName("st_statistics_record_attr")
public class StatisticsRecordAttr extends Model<StatisticsRecordAttr> {

    private static final long serialVersionUID = 1L;

	private Long id;
    /**
     * 所属数据域
     */
	@TableField("record_id")
	private Long recordId;
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

	public StatisticsRecordAttr setId(Long id) {
		this.id = id;
		return this;
	}

	public Long getRecordId() {
		return recordId;
	}

	public StatisticsRecordAttr setRecordId(Long recordId) {
		this.recordId = recordId;
		return this;
	}

	public String getLegend() {
		return legend;
	}

	public StatisticsRecordAttr setLegend(String legend) {
		this.legend = legend;
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

	public static final String RECORD_ID = "record_id";

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
			", legend=" + legend +
			", index=" + index +
			"}";
	}
}
