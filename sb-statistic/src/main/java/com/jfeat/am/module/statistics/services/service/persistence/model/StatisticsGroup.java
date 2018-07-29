package com.jfeat.am.module.statistics.services.service.persistence.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 
 * </p>
 *
 * @author Code Generator
 * @since 2018-07-29
 */
@TableName("st_statistics_group")
public class StatisticsGroup extends Model<StatisticsGroup> {

    private static final long serialVersionUID = 1L;

	private Long id;
    /**
     * 上级分组
     */
	private Long pid;
    /**
     * 组名
     */
	private String name;
    /**
     * 组标题
     */
	private String title;
    /**
     * 分组描述
     */
	private String note;
    /**
     * 分组排序号
     */
	private Integer index;


	public Long getId() {
		return id;
	}

	public StatisticsGroup setId(Long id) {
		this.id = id;
		return this;
	}

	public Long getPid() {
		return pid;
	}

	public StatisticsGroup setPid(Long pid) {
		this.pid = pid;
		return this;
	}

	public String getName() {
		return name;
	}

	public StatisticsGroup setName(String name) {
		this.name = name;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public StatisticsGroup setTitle(String title) {
		this.title = title;
		return this;
	}

	public String getNote() {
		return note;
	}

	public StatisticsGroup setNote(String note) {
		this.note = note;
		return this;
	}

	public Integer getIndex() {
		return index;
	}

	public StatisticsGroup setIndex(Integer index) {
		this.index = index;
		return this;
	}

	public static final String ID = "id";

	public static final String PID = "pid";

	public static final String NAME = "name";

	public static final String TITLE = "title";

	public static final String NOTE = "note";

	public static final String INDEX = "index";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "StatisticsGroup{" +
			"id=" + id +
			", pid=" + pid +
			", name=" + name +
			", title=" + title +
			", note=" + note +
			", index=" + index +
			"}";
	}
}
