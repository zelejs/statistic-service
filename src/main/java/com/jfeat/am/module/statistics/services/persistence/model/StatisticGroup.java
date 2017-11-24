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
 * @since 2017-11-24
 */
@TableName("st_statistic_group")
public class StatisticGroup extends Model<StatisticGroup> {

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
     * 图表名称[Pie,Chain]环比
     */
	private String chart;


	public Long getId() {
		return id;
	}

	public StatisticGroup setId(Long id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public StatisticGroup setName(String name) {
		this.name = name;
		return this;
	}

	public Long getPid() {
		return pid;
	}

	public StatisticGroup setPid(Long pid) {
		this.pid = pid;
		return this;
	}

	public String getDesc() {
		return desc;
	}

	public StatisticGroup setDesc(String desc) {
		this.desc = desc;
		return this;
	}

	public String getChart() {
		return chart;
	}

	public StatisticGroup setChart(String chart) {
		this.chart = chart;
		return this;
	}

	public static final String ID = "id";

	public static final String NAME = "name";

	public static final String PID = "pid";

	public static final String DESC = "desc";

	public static final String CHART = "chart";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "StatisticGroup{" +
			"id=" + id +
			", name=" + name +
			", pid=" + pid +
			", desc=" + desc +
			", chart=" + chart +
			"}";
	}
}
