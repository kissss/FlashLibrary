package com.book.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author 王磊
 * @date 2013年4月17日 00:35:54
 * @describe 借阅信息
 * 
 */
@Entity
@Table(name = "LENDINFO")
public class LendInfo implements java.io.Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 借阅信息ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	 * 图书馆藏信息表
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bookInfo_ID", insertable = false, updatable = false)
	private BookInfo bookInfo;

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

	public BookInfo getBookInfo()
	{
		return bookInfo;
	}

	public void setBookInfo(BookInfo bookInfo)
	{
		this.bookInfo = bookInfo;
	}

}