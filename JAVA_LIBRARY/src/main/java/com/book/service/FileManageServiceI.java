package com.book.service;

import java.util.Map;

import com.book.model.BookData;
import com.book.model.BookInfo;
import com.book.model.Librarian;
import com.book.model.Reader;
import com.book.pageModel.PageJson;

public interface FileManageServiceI {

	// ---------------------------------------图书信息管理---------------------------------------
	/**
	 * 得到所有的图书基本信息
	 * 
	 * @return
	 */
	public PageJson getAllBooks(PageJson pageJson);

	/**
	 * 保存或者更新一条信息
	 * 
	 * @param bookData
	 * @return
	 */
	public boolean saveOrUpdateBook(BookData bookData);

	/**
	 * 保存图书馆藏的信息
	 * 
	 * @return
	 */

	public boolean saveBookInfo(BookInfo bookInfo);

	/**
	 * 删除图书信息
	 */
	public boolean delBook(int ids[]);

	// ---------------------------------------读者信息管理---------------------------------------
	/**
	 * 得到所有的读者基本信息
	 * 
	 * @return
	 */
	public PageJson getReadersList(PageJson pageJson);

	/**
	 * 保存或者更新一条信息
	 * 
	 * @param bookData
	 * @return
	 */
	public boolean saveOrUpdateReader(Reader reader);

	/**
	 * 删除一个读者对象
	 * 
	 * @param reader
	 * @return
	 */
	public boolean delReader(int ids[]);

	// ---------------------------------------管理员信息管理---------------------------------------
	/**
	 * 得到所有的管理员基本信息
	 * 
	 * @return
	 */
	public PageJson getAdminsList(PageJson pageJson);

	/**
	 * 保存或者更新一条信息
	 * 
	 * @param bookData
	 * @return
	 */
	public boolean saveOrUpdateAdmin(Librarian librarian);

	/**
	 * 删除一个管理员对象
	 * 
	 * @param reader
	 * @return
	 */
	public boolean delAdmin(int ids[]);

	/**
	 * 判断这个用户是否登录
	 * 
	 * @param reader
	 * @return
	 */
	public Map<String, Object> login(Reader reader);

	/**
	 * 判断管理员登录
	 * 
	 * @param librarian
	 * @return
	 */
	public Map<String, Object> loginLibrarian(Librarian librarian);

}
