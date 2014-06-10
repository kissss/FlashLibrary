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

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author 王磊
 * @date 2013年4月17日 00:41:24
 * @describe 管理员信息表
 * 
 */
@Entity
@Table(name = "LIBRARIAN")
public class Librarian implements java.io.Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 管理员信息表ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	/**
	 * 编号
	 */
	private String userid;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 密码
	 */
	private String pwd;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 图书管理权限(1：有、0：没有) ,默认0
	 */
	private Integer bookp;
	/**
	 * 读者管理权限(1：有、0：没有) ,默认0
	 */
	private Integer readerp;
	/**
	 * 参数管理权限(1：有、0：没有) ,默认0
	 */
	private Integer parameterp;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "librarian_ID", insertable = false, updatable = false)
	private Set<LibrarianMenu> libMenu = new HashSet<LibrarianMenu>();

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getUserid()
	{
		return userid;
	}

	public void setUserid(String userid)
	{
		this.userid = userid;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Integer getBookp()
	{
		return bookp;
	}

	public void setBookp(Integer bookp)
	{
		this.bookp = bookp;
	}

	public Integer getReaderp()
	{
		return readerp;
	}

	public void setReaderp(Integer readerp)
	{
		this.readerp = readerp;
	}

	public Integer getParameterp()
	{
		return parameterp;
	}

	public void setParameterp(Integer parameterp)
	{
		this.parameterp = parameterp;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPwd()
	{
		return pwd;
	}

	public void setPwd(String pwd)
	{
		this.pwd = pwd;
	}

	@JSONField(serialize = false)
	public Set<LibrarianMenu> getLibMenu()
	{
		return libMenu;
	}

	public void setLibMenu(Set<LibrarianMenu> libMenu)
	{
		this.libMenu = libMenu;
	}

}