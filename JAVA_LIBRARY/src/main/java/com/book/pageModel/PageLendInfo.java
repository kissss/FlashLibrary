package com.book.pageModel;

/**
 * @author 王磊
 * @date 2013年4月26日 18:43:31
 * @describe 前台所需要的图书借阅信息
 * 
 */
public class PageLendInfo
{

	/**
	 * 借阅信息ID
	 */
	private Integer id;
	/**
	 * 读者编号
	 */
	private String readerid;
	/**
	 * 图书条形码
	 */
	private String bookcode;
	/**
	 * 借书日期
	 */
	private String borrowdate;
	/**
	 * 应还日期
	 */
	private String duedate;
	/**
	 * 还书日期
	 */
	private String returndate;
	/**
	 * 续借标识 0、未续借 1 、续借
	 */
	private Integer renew;
	/**
	 * 超期天数
	 */
	private Integer overduedays;
	/**
	 * 罚款金额
	 */
	private Float fine;
	/**
	 * 图书馆藏信息表ID
	 */
	private Integer bookInfo_ID;

	/**
	 * 馆藏地点名字
	 */
	private String BookLocation_ZD_locationName;
	/**
	 * 具体位置
	 */
	private String BookLocation_ZD_location;
	/**
	 * 书名
	 */
	private String BookData_name;
	/**
	 * 丛书名
	 */
	private String BookData_series;
	/**
	 * 作者
	 */
	private String BookData_authors;
	/**
	 * 出版发行
	 */
	private String bookData_publisher;

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

	public String getBookcode()
	{
		return bookcode;
	}

	public void setBookcode(String bookcode)
	{
		this.bookcode = bookcode;
	}

	public String getBorrowdate()
	{
		return borrowdate;
	}

	public void setBorrowdate(String borrowdate)
	{
		this.borrowdate = borrowdate;
	}

	public String getDuedate()
	{
		return duedate;
	}

	public void setDuedate(String duedate)
	{
		this.duedate = duedate;
	}

	public String getReturndate()
	{
		return returndate;
	}

	public void setReturndate(String returndate)
	{
		this.returndate = returndate;
	}

	public Integer getRenew()
	{
		return renew;
	}

	public void setRenew(Integer renew)
	{
		this.renew = renew;
	}

	public Integer getOverduedays()
	{
		return overduedays;
	}

	public void setOverduedays(Integer overduedays)
	{
		this.overduedays = overduedays;
	}

	public Float getFine()
	{
		return fine;
	}

	public void setFine(Float fine)
	{
		this.fine = fine;
	}

	public Integer getBookInfo_ID()
	{
		return bookInfo_ID;
	}

	public void setBookInfo_ID(Integer bookInfo_ID)
	{
		this.bookInfo_ID = bookInfo_ID;
	}

	public String getBookLocation_ZD_locationName()
	{
		return BookLocation_ZD_locationName;
	}

	public void setBookLocation_ZD_locationName(String bookLocation_ZD_locationName)
	{
		BookLocation_ZD_locationName = bookLocation_ZD_locationName;
	}

	public String getBookLocation_ZD_location()
	{
		return BookLocation_ZD_location;
	}

	public void setBookLocation_ZD_location(String bookLocation_ZD_location)
	{
		BookLocation_ZD_location = bookLocation_ZD_location;
	}

	public String getBookData_name()
	{
		return BookData_name;
	}

	public void setBookData_name(String bookData_name)
	{
		BookData_name = bookData_name;
	}

	public String getBookData_series()
	{
		return BookData_series;
	}

	public void setBookData_series(String bookData_series)
	{
		BookData_series = bookData_series;
	}

	public String getBookData_authors()
	{
		return BookData_authors;
	}

	public void setBookData_authors(String bookData_authors)
	{
		BookData_authors = bookData_authors;
	}

	public String getBookData_publisher()
	{
		return bookData_publisher;
	}

	public void setBookData_publisher(String bookData_publisher)
	{
		this.bookData_publisher = bookData_publisher;
	}

}
