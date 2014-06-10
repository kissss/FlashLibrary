package com.book.service;

import com.book.model.Librarian;
import com.book.model.LoginLogInfo;
import com.book.model.Reader;
import com.book.pageModel.PageJson;

/**
 * 
 * @author 王磊
 * @date 2013年4月23日 21:01:22
 * @describe 日志管理
 * 
 */
public interface LogServiceI {

	/**
	 * 保存用户登录日志
	 */
	public void saveLog(LoginLogInfo loginLogInfo);

	/**
	 * 得到所有用户登录日志
	 * 
	 * @return
	 */
	public PageJson getAllLoginInfo(PageJson pageJson);

	/**
	 * 保存用户操作日志
	 * 
	 * @param logInfo
	 */
	public void saveLog(Reader reader, String msg);

	/**
	 * 保存管理员操作日志
	 * 
	 * @param librarian
	 * @param msg
	 */
	public void saveLog(Librarian librarian, String msg);

	/**
	 * 得到所有用户操作日志
	 * 
	 * @return
	 */
	public PageJson getAllOperateInfo(PageJson pageJson);

}
