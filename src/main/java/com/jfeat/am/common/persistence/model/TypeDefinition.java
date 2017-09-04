package com.jfeat.am.common.persistence.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author admin
 * @since 2017-09-04
 */
@TableName("st_type_definition")
public class TypeDefinition extends Model<TypeDefinition> {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
	private Long id;
    /**
     * 缁熻鍚嶇О
     */
	private String name;
    /**
     * 鏍囪瘑绗�
     */
	private String identifier;


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

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "TypeDefinition{" +
			"id=" + id +
			", name=" + name +
			", identifier=" + identifier +
			"}";
	}
}
