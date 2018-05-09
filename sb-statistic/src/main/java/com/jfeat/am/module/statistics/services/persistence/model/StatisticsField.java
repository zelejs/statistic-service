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
 * @since 2018-05-09
 */
@TableName("st_statistics_field")
public class StatisticsField extends Model<StatisticsField> {

    private static final long serialVersionUID = 1L;

	private Long id;
    /**
     * 统计所属分组
     */
	@TableField("group_id")
	private Long groupId;
    /**
     * 统计名称
     */
	private String name;
    /**
     * 数据域标识符
     */
	private String field;
    /**
     * 图表名称[Pie,Chain]环比
     */
	private String chart;
    /**
     * 是否不可见
     */
	private Integer invisible;
    /**
     * 排序号
     */
	private Integer index;
    /**
     * 是否显示为百分比
     */
	private Integer percent;


	public Long getId() {
		return id;
	}

	public StatisticsField setId(Long id) {
		this.id = id;
		return this;
	}

	public Long getGroupId() {
		return groupId;
	}

	public StatisticsField setGroupId(Long groupId) {
		this.groupId = groupId;
		return this;
	}

	public String getName() {
		return name;
	}

	public StatisticsField setName(String name) {
		this.name = name;
		return this;
	}

	public String getField() {
		return field;
	}

	public StatisticsField setField(String field) {
		this.field = field;
		return this;
	}

	public String getChart() {
		return chart;
	}

	public StatisticsField setChart(String chart) {
		this.chart = chart;
		return this;
	}

	public Integer getInvisible() {
		return invisible;
	}

	public StatisticsField setInvisible(Integer invisible) {
		this.invisible = invisible;
		return this;
	}

	public Integer getIndex() {
		return index;
	}

	public StatisticsField setIndex(Integer index) {
		this.index = index;
		return this;
	}

	public Integer getPercent() {
		return percent;
	}

	public StatisticsField setPercent(Integer percent) {
		this.percent = percent;
		return this;
	}

	public static final String ID = "id";

	public static final String GROUP_ID = "group_id";

	public static final String NAME = "name";

	public static final String FIELD = "field";

	public static final String CHART = "chart";

	public static final String INVISIBLE = "invisible";

	public static final String INDEX = "index";

	public static final String PERCENT = "percent";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "StatisticsField{" +
			"id=" + id +
			", groupId=" + groupId +
			", name=" + name +
			", field=" + field +
			", chart=" + chart +
			", invisible=" + invisible +
			", index=" + index +
			", percent=" + percent +
			"}";
	}
}
