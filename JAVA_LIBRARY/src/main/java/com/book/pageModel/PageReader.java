package com.book.pageModel;

public class PageReader
{

	/**
	 * 读者信息表ID
	 */
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
	 * 读者名称
	 */
	private String ReaderType_name;

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

	public String getReaderType_name()
	{
		return ReaderType_name;
	}

	public void setReaderType_name(String readerType_name)
	{
		ReaderType_name = readerType_name;
	}

	public Integer getReaderType_ID()
	{
		return readerType_ID;
	}

	public void setReaderType_ID(Integer readerType_ID)
	{
		this.readerType_ID = readerType_ID;
	}

}
