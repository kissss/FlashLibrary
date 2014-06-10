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
 * 
 * @author 王磊
 * @date 2013年4月24日 00:22:16
 * @describe 菜单表
 * 
 */
@Entity
@Table(name = "MENU")
public class Menu implements java.io.Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 菜单D
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	/**
	 * 菜单名称
	 */
	private String name;
	/**
	 * 菜单图标
	 */
	private String icon;
	/**
	 * 菜单地址
	 */
	private String url;

	/**
	 * 父菜单ID
	 */
	private Integer pid;
	/**
	 * 子菜单
	 */
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "pid", insertable = false, updatable = false)
	private Set<Menu> menus = new HashSet<Menu>();

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

	public String getIcon()
	{
		return icon;
	}

	public void setIcon(String icon)
	{
		this.icon = icon;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public Integer getPid()
	{
		return pid;
	}

	public void setPid(Integer pid)
	{
		this.pid = pid;
	}

	public Set<Menu> getMenus()
	{
		return menus;
	}

	public void setMenus(Set<Menu> menus)
	{
		this.menus = menus;
	}

}
