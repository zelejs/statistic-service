package com.jfeat.am.module.statistics.services.persistence.model;

import java.io.Serializable;

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
@TableName("st_statistics_group")
public class StatisticsGroup extends Model<StatisticsGroup> {

    private static final long serialVersionUID = 1L;

	private Long id;
    /**
     * 组名称
     */
	private String name;
    /**
     * 上级分组
     */
	private Long pid;
    /**
     * 分组描述
     */
	private String desc;
    /**
     * 排序号
     */
	private Integer sort;
    /**
     * 图表类型[Pie,Chain]环比
     */
	private String chart;


	public Long getId() {
		return id;
	}

	public StatisticsGroup setId(Long id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public StatisticsGroup setName(String name) {
		this.name = name;
		return this;
	}

	public Long getPid() {
		return pid;
	}

	public StatisticsGroup setPid(Long pid) {
		this.pid = pid;
		return this;
	}

	public String getDesc() {
		return desc;
	}

	public StatisticsGroup setDesc(String desc) {
		this.desc = desc;
		return this;
	}

	public Integer getSort() {
		return sort;
	}

	public StatisticsGroup setSort(Integer sort) {
		this.sort = sort;
		return this;
	}

	public String getChart() {
		return chart;
	}

	public StatisticsGroup setChart(String chart) {
		this.chart = chart;
		return this;
	}

	public static final String ID = "id";

	public static final String NAME = "name";

	public static final String PID = "pid";

	public static final String DESC = "desc";

	public static final String SORT = "sort";

	public static final String CHART = "chart";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "StatisticsGroup{" +
			"id=" + id +
			", name=" + name +
			", pid=" + pid +
			", desc=" + desc +
			", sort=" + sort +
			", chart=" + chart +
			"}";
	}
}
