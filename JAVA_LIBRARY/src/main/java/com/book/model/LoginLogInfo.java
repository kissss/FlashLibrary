package com.book.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LOGINLOGINFO")
public class LoginLogInfo
{

	/**
	 * 用户登录记录ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	/**
	 * 用户ID
	 */
	private String readerid;
	/**
	 * 用户姓名
	 */
	private String name;
	/**
	 * 登录IP
	 */
	private String ip;
	/**
	 * 登录时间
	 */
	private String loginDate;
	/**
	 * 登录事件
	 */
	private String detail;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getReaderid()
	{
		return readerid;
	}

	public void setReaderid(String readerid)
	{
		this.readerid = readerid;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getIp()
	{
		return ip;
	}

	public void setIp(String ip)
	{
		this.ip = ip;
	}

	public String getDetail()
	{
		return detail;
	}

	public void setDetail(String detail)
	{
		this.detail = detail;
	}

	public String getLoginDate()
	{
		return loginDate;
	}

	public void setLoginDate(String loginDate)
	{
		this.loginDate = loginDate;
	}
}
