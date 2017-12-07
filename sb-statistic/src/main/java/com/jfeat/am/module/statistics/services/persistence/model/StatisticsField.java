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
 * @author admin
 * @since 2017-12-06
 */
@TableName("st_statistics_field")
public class StatisticsField extends Model<StatisticsField> {

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
    /**
     * 是否显示为百分比
     */
	private Integer percent;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public Integer getInvisible() {
		return invisible;
	}

	public void setInvisible(Integer invisible) {
		this.invisible = invisible;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public String getChart() {
		return chart;
	}

	public void setChart(String chart) {
		this.chart = chart;
	}

	public Integer getPercent() {
		return percent;
	}

	public void setPercent(Integer percent) {
		this.percent = percent;
	}

	public static final String ID = "id";

	public static final String NAME = "name";

	public static final String FIELD = "field";

	public static final String INDEX = "index";

	public static final String INVISIBLE = "invisible";

	public static final String GROUP_ID = "group_id";

	public static final String CHART = "chart";

	public static final String PERCENT = "percent";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "StatisticsField{" +
			"id=" + id +
			", name=" + name +
			", field=" + field +
			", index=" + index +
			", invisible=" + invisible +
			", groupId=" + groupId +
			", chart=" + chart +
			", percent=" + percent +
			"}";
	}
}
