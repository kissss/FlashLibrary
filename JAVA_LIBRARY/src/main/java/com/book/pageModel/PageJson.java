package com.book.pageModel;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * @author 王磊
 * @date 2013年4月19日 15:23:43
 * @describe flex中显示的数据
 * 
 */
public class PageJson
{

	/**
	 * 页面总条数
	 */
	private long listCount;
	/**
	 * 页面中需要显示的值
	 * 
	 */
	private Object data;

	/**
	 * 起始的条数
	 */
	private Integer start;

	/**
	 * 查询的字段名
	 */
	private String searchKey;
	/**
	 * 查询的值
	 */
	private String searchValue;
	/**
	 * 一次读取多少条数
	 */
	private Integer rows = 20;

	public long getListCount()
	{
		return listCount;
	}

	public void setListCount(long listCount)
	{
		this.listCount = listCount;
	}

	public Object getData()
	{
		return data;
	}

	public void setData(Object data)
	{
		this.data = data;
	}

	public Integer getStart()
	{
		return start;
	}

	public void setStart(Integer start)
	{
		this.start = start;
	}

	@JSONField(serialize = false)
	public Integer getRows()
	{
		return rows;
	}

	public void setRows(Integer rows)
	{
		this.rows = rows;
	}

	public String getSearchKey()
	{
		return searchKey;
	}

	public void setSearchKey(String searchKey)
	{
		this.searchKey = searchKey;
	}

	public String getSearchValue()
	{
		return searchValue;
	}

	public void setSearchValue(String searchValue)
	{
		this.searchValue = searchValue;
	}
}
