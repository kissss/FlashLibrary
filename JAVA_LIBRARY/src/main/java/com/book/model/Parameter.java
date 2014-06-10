package com.book.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 王磊
 * @date 2013年4月17日 00:41:24
 * @describe 系统参数信息表
 * 
 */
@Entity
@Table(name = "PARAMETER")
public class Parameter implements java.io.Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 系统参数信息表ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	/**
	 * 参数表名称
	 */
	private String name;

	/**
	 * 借书数量
	 */
	private Integer amount;
	/**
	 * 借期天数
	 */
	private Integer period;
	/**
	 * 超期还书每日罚款金额
	 */
	private Float dailyfine;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getAmount()
	{
		return amount;
	}

	public void setAmount(Integer amount)
	{
		this.amount = amount;
	}

	public Integer getPeriod()
	{
		return period;
	}

	public void setPeriod(Integer period)
	{
		this.period = period;
	}

	public Float getDailyfine()
	{
		return dailyfine;
	}

	public void setDailyfine(Float dailyfine)
	{
		this.dailyfine = dailyfine;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

}