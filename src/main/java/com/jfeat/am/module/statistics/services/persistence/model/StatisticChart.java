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
 * @since 2017-11-24
 */
@TableName("st_statistic_chart")
public class StatisticChart extends Model<StatisticChart> {

    private static final long serialVersionUID = 1L;

	private Long id;
    /**
     * 统计名称
     */
	private String name;
    /**
     * 数据域标识符
     */
	private String field;
    /**
     * 排序号
     */
	private Integer index;
    /**
     * 是否不可见
     */
	private Integer invisible;
    /**
     * 统计所属分组
     */
	@TableField("group_id")
	private Long groupId;
    /**
     * 图表名称[Pie,Chain]环比
     */
	private String chart;


	public Long getId() {
		return id;
	}

	public StatisticChart setId(Long id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public StatisticChart setName(String name) {
		this.name = name;
		return this;
	}

	public String getField() {
		return field;
	}

	public StatisticChart setField(String field) {
		this.field = field;
		return this;
	}

	public Integer getIndex() {
		return index;
	}

	public StatisticChart setIndex(Integer index) {
		this.index = index;
		return this;
	}

	public Integer getInvisible() {
		return invisible;
	}

	public StatisticChart setInvisible(Integer invisible) {
		this.invisible = invisible;
		return this;
	}

	public Long getGroupId() {
		return groupId;
	}

	public StatisticChart setGroupId(Long groupId) {
		this.groupId = groupId;
		return this;
	}

	public String getChart() {
		return chart;
	}

	public StatisticChart setChart(String chart) {
		this.chart = chart;
		return this;
	}

	public static final String ID = "id";

	public static final String NAME = "name";

	public static final String FIELD = "field";

	public static final String INDEX = "index";

	public static final String INVISIBLE = "invisible";

	public static final String GROUP_ID = "group_id";

	public static final String CHART = "chart";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "StatisticChart{" +
			"id=" + id +
			", name=" + name +
			", field=" + field +
			", index=" + index +
			", invisible=" + invisible +
			", groupId=" + groupId +
			", chart=" + chart +
			"}";
	}
}
