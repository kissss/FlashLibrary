package com.book.service;

import com.book.model.BookInfo;
import com.book.model.LendInfo;
import com.book.model.Reader;
import com.book.pageModel.PageJson;

public interface CatalogManageServiceI
{

	/**
	 * 得到目录检索的信息
	 * @return
	 */

	public PageJson getCatalogList(PageJson pageJson);

	/**
	 * 保存读者借阅信息
	 * @param lendInfo
	 * @return
	 */
	public boolean saveLendInfo(LendInfo lendInfo, Reader reader, BookInfo bookInfo);

	/**
	 * 得到当前登录人员的当前借阅信息
	 * @param pageJson
	 * @return
	 */
	public PageJson getBorrowInfo(PageJson pageJson, Reader reader);

	/**
	 * 得到当前登录人员的历史借阅信息
	 * @param pageJson
	 * @param reader
	 * @return
	 */
	public PageJson getHistoryBorrowInfo(PageJson pageJson, Reader reader);

	/**
	 * 当前登录人员 还书信息
	 * @param lendInfo
	 * @param readerSession
	 * @param bookInfo
	 * @return
	 */
	public boolean updateLendInfo(LendInfo lendInfo, Reader readerSession, BookInfo bookInfo);

}
