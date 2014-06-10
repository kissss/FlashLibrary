package com.book.model.zd;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.book.model.Parameter;

/**
 * 读者类型ID
 * @author 王磊
 * @date 2013年4月21日 01:03:55
 * 
 */
@Entity
@Table(name = "ReaderType_ZD")
public class ReaderType_ZD implements java.io.Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 读者类型ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	/**
	 * 读者名称
	 */
	private String name;
	/**
	 * 系统参数ID
	 */
	private Integer parameter_ID;
	/**
	 * 系统参数对象
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "parameter_ID", insertable = false, updatable = false)
	private Parameter parameter;

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

	public Integer getParameter_ID()
	{
		return parameter_ID;
	}

	public void setParameter_ID(Integer parameter_ID)
	{
		this.parameter_ID = parameter_ID;
	}

	public Parameter getParameter()
	{
		return parameter;
	}

	public void setParameter(Parameter parameter)
	{
		this.parameter = parameter;
	}

}
