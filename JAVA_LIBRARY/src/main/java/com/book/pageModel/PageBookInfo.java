package com.book.pageModel;

/**
 * 前台所需要的馆藏地点
 * @author 王磊
 * 
 */
public class PageBookInfo
{

	/**
	 * 图书馆藏信息表ID
	 */
	private Integer id;
	/**
	 * 国际标准书号
	 */
	private String isbn;
	/**
	 * 图书条形码
	 */
	private String barcode;
	/**
	 * 是否可借 1、可借 0、不可借
	 */
	private Integer status;
	/**
	 * 图书应还日期
	 */
	private String duedate;

	/**
	 * 馆藏地点ID
	 */
	private Integer BookLocation_ID;
	/**
	 * 馆藏地点名字
	 */
	private String BookLocation_locationName;
	/**
	 * 具体位置
	 */
	private String BookLocation_location;
	/**
	 * 图书基本信息ID
	 */
	private Integer BookData_ID;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getIsbn()
	{
		return isbn;
	}

	public void setIsbn(String isbn)
	{
		this.isbn = isbn;
	}

	public String getBarcode()
	{
		return barcode;
	}

	public void setBarcode(String barcode)
	{
		this.barcode = barcode;
	}

	public Integer getStatus()
	{
		return status;
	}

	public void setStatus(Integer status)
	{
		this.status = status;
	}

	public String getDuedate()
	{
		return duedate;
	}

	public void setDuedate(String duedate)
	{
		this.duedate = duedate;
	}

	public Integer getBookLocation_ID()
	{
		return BookLocation_ID;
	}

	public void setBookLocation_ID(Integer bookLocation_ID)
	{
		BookLocation_ID = bookLocation_ID;
	}

	public String getBookLocation_locationName()
	{
		return BookLocation_locationName;
	}

	public void setBookLocation_locationName(String bookLocation_locationName)
	{
		BookLocation_locationName = bookLocation_locationName;
	}

	public String getBookLocation_location()
	{
		return BookLocation_location;
	}

	public void setBookLocation_location(String bookLocation_location)
	{
		BookLocation_location = bookLocation_location;
	}

	public Integer getBookData_ID()
	{
		return BookData_ID;
	}

	public void setBookData_ID(Integer bookData_ID)
	{
		BookData_ID = bookData_ID;
	}
}
