package com.book.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author 王磊
 * @date 2013年4月24日 13:32:54
 * @describe 读者角色表
 * 
 * 
 */
@Entity
@Table(name = "READERROLE")
public class ReaderRole implements java.io.Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	/**
	 * 角色名称
	 */
	private String name;
	/**
	 * 角色权限表
	 */
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "readerRole_ID", insertable = false, updatable = false)
	private Set<ReaderRoleMenu> roleMenus = new HashSet<ReaderRoleMenu>();

	public Set<ReaderRoleMenu> getRoleMenus()
	{
		return roleMenus;
	}

	public void setRoleMenus(Set<ReaderRoleMenu> roleMenus)
	{
		this.roleMenus = roleMenus;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}

}
