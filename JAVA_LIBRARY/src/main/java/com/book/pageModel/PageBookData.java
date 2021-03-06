package com.book.pageModel;

import java.util.List;

/**
 * 
 * @author 王磊
 * @date 2013年4月26日 12:38:13
 * @describe 前台所需要的bookData信息,不能直接使用数据库的model 这样会出现重复引用
 * 
 */

public class PageBookData {

	/**
	 * 图书基本信息表ID
	 */
	private Integer id;
	/**
	 * 国际标准书号
	 */
	private String isbn;
	/**
	 * 书名
	 */
	private String name;
	/**
	 * 丛书名
	 */
	private String series;
	/**
	 * 作者
	 */
	private String authors;
	/**
	 * 出版发行
	 */
	private String publisher;
	/**
	 * 图书开本
	 */
	private String bookSize;
	/**
	 * 页数
	 */
	private Integer pages;
	/**
	 * 定价
	 */
	private Float price;
	/**
	 * 内容简介
	 */
	private String introduction;
	/**
	 * 图片
	 */
	private String picture;
	/**
	 * 图书分类号
	 */
	private String classifyNo;

	/**
	 * 创建时间
	 * 
	 * @return
	 */
	private String createTime;

	/**
	 * 创建人
	 * 
	 * @return
	 */
	private String createName;

	/**
	 * 图书数量
	 */
	private Integer booksCount;

	/**
	 * 馆藏信息
	 */
	private List<PageBookInfo> bookInfos;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public String getAuthors() {
		return authors;
	}

	public void setAuthors(String authors) {
		this.authors = authors;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getBookSize() {
		return bookSize;
	}

	public void setBookSize(String bookSize) {
		this.bookSize = bookSize;
	}

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getClassifyNo() {
		return classifyNo;
	}

	public void setClassifyNo(String classifyNo) {
		this.classifyNo = classifyNo;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}

	public Integer getBooksCount() {
		return booksCount;
	}

	public void setBooksCount(Integer booksCount) {
		this.booksCount = booksCount;
	}

	public List<PageBookInfo> getBookInfos() {
		return bookInfos;
	}

	public void setBookInfos(List<PageBookInfo> bookInfos) {
		this.bookInfos = bookInfos;
	}

}
