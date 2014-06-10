package com.book.service;

import java.util.List;

import com.book.model.Parameter;
import com.book.model.zd.BookLocation_ZD;
import com.book.model.zd.ReaderType_ZD;
import com.book.pageModel.PageJson;

public interface SystemManageServiceI {
	// ---------------------------------------馆藏地点管理---------------------------------------
	/**
	 * 增加或更新馆藏地址
	 * 
	 * @param bookLocation
	 * @return
	 */
	public boolean saveOrUpdateBookLocation(BookLocation_ZD bookLocation);

	/**
	 * 删除馆藏地址信息
	 * 
	 * @param bookLocation
	 * @return
	 */
	public boolean delBookLocation(int ids[]);

	/**
	 * 得到所有的馆藏地址 包括分页
	 * 
	 * @param pageJson
	 * @return
	 */
	public PageJson getBookLocationList(PageJson pageJson);

	/**
	 * 得到所有的馆藏地址 不含分页 和总数量
	 * 
	 * @return
	 */
	public List<BookLocation_ZD> getBookLocationList();

	// ---------------------------------------读者管理---------------------------------------
	/**
	 * 更新或增加 读者类型
	 * 
	 * @param readerType
	 * @return
	 */
	public boolean saveOrUpdateReaderType(ReaderType_ZD readerType);

	/**
	 * 删除读者类型
	 * 
	 * @param readerType
	 * @return
	 */
	public boolean delReaderType(int ids[]);

	/**
	 * 得到所有的读者类型 包括分页
	 * 
	 * @param pageJson
	 * @return
	 */
	public PageJson getReaderTypeList(PageJson pageJson);

	/**
	 * 得到所有的读者类型 不含分页 用于combobox
	 * 
	 * @return
	 */
	public List<ReaderType_ZD> getReaderTypeList();

	// ---------------------------------------系统参数管理---------------------------------------
	/**
	 * 更新或增加 系统参数
	 * 
	 * @param readerType
	 * @return
	 */
	public boolean saveOrUpdateParameter(Parameter parameter);

	/**
	 * 删除系统参数
	 * 
	 * @param readerType
	 * @return
	 */
	public boolean delParameter(int ids[]);

	/**
	 * 得到所有的读者类型 包括分页
	 * 
	 * @param pageJson
	 * @return
	 */
	public PageJson getParameterAllList(PageJson pageJson);

}
