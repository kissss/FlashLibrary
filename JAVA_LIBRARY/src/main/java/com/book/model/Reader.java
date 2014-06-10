package com.book.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;
import com.book.model.zd.ReaderType_ZD;

/**
 * @author 王磊
 * @date 2013年4月17日 00:48:06
 * @describe 读者信息表
 * 
 */
@Entity
@Table(name = "READER")
public class Reader implements java.io.Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 读者信息表ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	/**
	 * 学号
	 */
	private String readerid;
	/**
	 * 登录密码
	 */
	private String passwd;
	/**
	 * 读者姓名
	 */
	private String name;
	/**
	 * 性别
	 */
	private String gender;
	/**
	 * 单位地址
	 */
	private String address;
	/**
	 * 联系方式
	 */
	private String tel;
	/**
	 * 入学日期
	 */
	private String startdate;
	/**
	 * 毕业日期
	 */
	private String enddate;
	/**
	 * 读者类型ID
	 */
	private Integer readerType_ID;
	/**
	 * 读者类型
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "readerType_ID", insertable = false, updatable = false)
	private ReaderType_ZD readerType;
	/**
	 * 角色ID
	 */
	private Integer readerRole_ID;

	/**
	 * 角色表
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "readerRole_ID", insertable = false, updatable = false)
	private ReaderRole readerRole;

	public Integer getReaderRole_ID()
	{
		return readerRole_ID;
	}

	public void setReaderRole_ID(Integer readerRole_ID)
	{
		this.readerRole_ID = readerRole_ID;
	}

	@JSONField(serialize = false)
	public ReaderRole getReaderRole()
	{
		return readerRole;
	}

	public void setReaderRole(ReaderRole readerRole)
	{
		this.readerRole = readerRole;
	}

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

	public String getPasswd()
	{
		return passwd;
	}

	public void setPasswd(String passwd)
	{
		this.passwd = passwd;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getGender()
	{
		return gender;
	}

	public void setGender(String gender)
	{
		this.gender = gender;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getTel()
	{
		return tel;
	}

	public void setTel(String tel)
	{
		this.tel = tel;
	}

	public Integer getReaderType_ID()
	{
		return readerType_ID;
	}

	public void setReaderType_ID(Integer readerType_ID)
	{
		this.readerType_ID = readerType_ID;
	}

	public ReaderType_ZD getReaderType()
	{
		return readerType;
	}

	public void setReaderType(ReaderType_ZD readerType)
	{
		this.readerType = readerType;
	}

	public String getStartdate()
	{
		return startdate;
	}

	public void setStartdate(String startdate)
	{
		this.startdate = startdate;
	}

	public String getEnddate()
	{
		return enddate;
	}

	public void setEnddate(String enddate)
	{
		this.enddate = enddate;
	}

}