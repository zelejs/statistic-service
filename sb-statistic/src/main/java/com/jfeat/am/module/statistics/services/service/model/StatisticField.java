package com.jfeat.am.module.statistics.services.service.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author admin
 * @since 2017-09-06
 */
@TableName("st_statistic_field")
public class StatisticField extends Model<StatisticField> {

    private static final long serialVersionUID = 1L;

	private Long id;
	@TableField("type_id")
	private Long typeId;
	private String name;
	@TableField("display_name")
	private String displayName;
	@TableField("sort_order")
	private Integer sortOrder;
	private Integer visible;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

	public Integer getVisible() {
		return visible;
	}

	public void setVisible(Integer visible) {
		this.visible = visible;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "StatisticField{" +
			"id=" + id +
			", typeId=" + typeId +
			", name=" + name +
			", displayName=" + displayName +
			", sortOrder=" + sortOrder +
			", visible=" + visible +
			"}";
	}
}
