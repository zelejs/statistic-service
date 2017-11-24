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
 * @since 2017-11-24
 */
@TableName("st_statistic_legend")
public class StatisticLegend extends Model<StatisticLegend> {

    private static final long serialVersionUID = 1L;

	private Long id;
    /**
     * 数据域标识符
     */
	private String field;
    /**
     * 记录名称（已完成）
     */
	private String legend;
    /**
     * 记录标记
     */
	@TableField("legend_key")
	private String legendKey;
    /**
     * 图例值
     */
	@TableField("legend_value")
	private String legendValue;
    /**
     * 排序号
     */
	private Integer index;
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


	public Long getId() {
		return id;
	}

	public StatisticLegend setId(Long id) {
		this.id = id;
		return this;
	}

	public String getField() {
		return field;
	}

	public StatisticLegend setField(String field) {
		this.field = field;
		return this;
	}

	public String getLegend() {
		return legend;
	}

	public StatisticLegend setLegend(String legend) {
		this.legend = legend;
		return this;
	}

	public String getLegendKey() {
		return legendKey;
	}

	public StatisticLegend setLegendKey(String legendKey) {
		this.legendKey = legendKey;
		return this;
	}

	public String getLegendValue() {
		return legendValue;
	}

	public StatisticLegend setLegendValue(String legendValue) {
		this.legendValue = legendValue;
		return this;
	}

	public Integer getIndex() {
		return index;
	}

	public StatisticLegend setIndex(Integer index) {
		this.index = index;
		return this;
	}

	public Date getRecordTime() {
		return recordTime;
	}

	public StatisticLegend setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
		return this;
	}

	public String getMonthName() {
		return monthName;
	}

	public StatisticLegend setMonthName(String monthName) {
		this.monthName = monthName;
		return this;
	}

	public static final String ID = "id";

	public static final String FIELD = "field";

	public static final String LEGEND = "legend";

	public static final String LEGEND_KEY = "legend_key";

	public static final String LEGEND_VALUE = "legend_value";

	public static final String INDEX = "index";

	public static final String RECORD_TIME = "record_time";

	public static final String MONTH_NAME = "month_name";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "StatisticLegend{" +
			"id=" + id +
			", field=" + field +
			", legend=" + legend +
			", legendKey=" + legendKey +
			", legendValue=" + legendValue +
			", index=" + index +
			", recordTime=" + recordTime +
			", monthName=" + monthName +
			"}";
	}
}
