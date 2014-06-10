package com.book.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.book.model.zd.BookLocation_ZD;

/**
 * 
 * @author 王磊
 * @date 2013年4月17日 00:31:53
 * @describe 图书馆藏信息表
 * 
 */
@Entity
@Table(name = "BOOKINFO")
public class BookInfo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 图书馆藏信息表ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	 * 馆藏地点
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BookLocation_ID", insertable = false, updatable = false)
	private BookLocation_ZD bookLocation;

	/**
	 * 图书基本信息ID
	 */
	private Integer bookData_ID;
	/**
	 * 图书基本信息表
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bookData_ID", insertable = false, updatable = false)
	private BookData bookData;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getDuedate() {
		return duedate;
	}

	public void setDuedate(String duedate) {
		this.duedate = duedate;
	}

	public Integer getBookLocation_ID() {
		return BookLocation_ID;
	}

	public void setBookLocation_ID(Integer bookLocation_ID) {
		BookLocation_ID = bookLocation_ID;
	}

	public BookLocation_ZD getBookLocation() {
		return bookLocation;
	}

	public void setBookLocation(BookLocation_ZD bookLocation) {
		this.bookLocation = bookLocation;
	}

	public Integer getBookData_ID() {
		return bookData_ID;
	}

	public void setBookData_ID(Integer bookData_ID) {
		this.bookData_ID = bookData_ID;
	}

	public BookData getBookData() {
		return bookData;
	}

	public void setBookData(BookData bookData) {
		this.bookData = bookData;
	}

}