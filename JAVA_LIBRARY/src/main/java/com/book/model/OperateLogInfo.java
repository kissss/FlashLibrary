package com.book.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author 王磊
 * @date 2013年4月23日 20:52:21
 * @describe 用户的操作日志
 * 
 */
@Entity
@Table(name = "OPERATELOGINFO")
public class OperateLogInfo implements java.io.Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 日志记录表ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	/**
	 * 用户学号
	 */
	private String readerid;
	/**
	 * 用户姓名
	 */
	private String name;
	/**
	 * 操作内容
	 */
	private String detail;
	/**
	 * 操作时间
	 */
	private String operateDate;

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

	public String getDetail()
	{
		return detail;
	}

	public void setDetail(String detail)
	{
		this.detail = detail;
	}

	
	public String getOperateDate()
	{
		return operateDate;
	}

	
	public void setOperateDate(String operateDate)
	{
		this.operateDate = operateDate;
	}

}
