package com.book.action;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;

import com.book.model.BookData;
import com.book.model.BookInfo;
import com.book.model.Librarian;
import com.book.model.LoginLogInfo;
import com.book.model.Reader;
import com.book.pageModel.PageJson;
import com.book.pageModel.PageResponse;
import com.book.service.FileManageServiceI;
import com.book.service.LogServiceI;
import com.book.util.DateUtil;

@Namespace("/FileManager")
@Action("FileManagerAction")
public class FileManagerAction extends BaseAction {

	private FileManageServiceI fileManagerService;
	private LogServiceI logService;
	private PageJson pageJson;
	private BookData bookData;
	private BookInfo bookInfo; // 馆藏信息
	private Reader reader;
	private Librarian librarian;
	private int[] ids;// 需要删除的id
	private int start;
	private int loginType;// 用户登录的类型

	@Resource
	public void setLogService(LogServiceI logService) {
		this.logService = logService;
	}

	@Resource
	public void setFileManagerService(FileManageServiceI fileManagerService) {
		this.fileManagerService = fileManagerService;
	}

	// ---------------------------------------图书管理---------------------------------------
	/**
	 * 根据分页得到所需要的数据
	 */
	public void getBooksList() {
		if (pageJson == null) {
			pageJson = new PageJson();
			pageJson.setStart(start);
		}
		writeJson(fileManagerService.getAllBooks(pageJson));
	}

	/**
	 * 更新或者 保存一条数据
	 */
	public void savaOrUpdateBook() {
		bookData.setCreateName((this.getLibrarianSession() == null ? this.getReaderSession().getName() : this.getLibrarianSession().getName()));
		if (fileManagerService.saveOrUpdateBook(bookData)) {
			writeJson(new PageResponse("保存成功", true));
		} else {
			writeJson(new PageResponse("保存失败", false));
		}
	}

	/**
	 * 更新或者 保存一条数据
	 */
	public void delBook() {
		if (fileManagerService.delBook(ids)) {
			writeJson(new PageResponse("删除成功", true));
		} else {
			writeJson(new PageResponse("已经入库不能被删除", false));
		}
	}

	/**
	 * 保存入库的位置
	 * 
	 * @return
	 */
	public void saveBookInfo() {
		if (fileManagerService.saveBookInfo(bookInfo)) {
			writeJson(new PageResponse("保存成功", true));
		} else {
			writeJson(new PageResponse("保存失败", false));
		}
	}

	// ---------------------------------------读者信息管理---------------------------------------

	/**
	 * 读者登录
	 */
	public void loginReader() {

		Map<String, Object> map = fileManagerService.login(reader);

		Reader loginReader = (Reader) map.get("reader");

		Map<String, Object> jsonMap = new HashMap<String, Object>();

		LoginLogInfo login = new LoginLogInfo();
		String msg = "";
		if (loginReader != null) {
			jsonMap.put("xm", loginReader.getName());
			jsonMap.put("libMenu", map.get("libMenu"));
			this.setReaderSession(loginReader);// 存入session
			msg = "登录成功";
			writeJson(new PageResponse(msg, true, jsonMap));
			login.setName(loginReader.getName());
		} else {
			msg = "用户名或密码不存在";
			writeJson(new PageResponse(msg, false));
		}
		// 登录日志
		login.setIp(this.getRequest().getRemoteAddr());
		login.setLoginDate(DateUtil.dateTimeFormater(new Date()));
		login.setReaderid(reader.getReaderid() + "");
		login.setDetail(msg);
		logService.saveLog(login);
	}

	/**
	 * 根据分页得到所需要读者信息数据
	 */
	public void getReaderList() {
		if (pageJson == null) {
			pageJson = new PageJson();
			pageJson.setStart(start);
		}
		writeJson(((fileManagerService.getReadersList(pageJson))));

	}

	public void saveOrUpdateReader() {
		if (fileManagerService.saveOrUpdateReader(reader)) {
			writeJson(new PageResponse("保存成功", true));
		} else {
			writeJson(new PageResponse("保存失败", false));
		}
	}

	/**
	 * 更新或者 保存一条数据
	 */
	public void delReader() {
		if (fileManagerService.delReader(ids)) {
			writeJson(new PageResponse("删除成功", true));
		} else {
			writeJson(new PageResponse("删除失败", false));
		}
	}

	// ---------------------------------------管理员信息管理---------------------------------------
	/**
	 * 管理员登录
	 */
	public void loginLibrarian() {
		Map<String, Object> map = fileManagerService.loginLibrarian(librarian);
		Librarian loginLibrarian = (Librarian) map.get("librarian");

		LoginLogInfo login = new LoginLogInfo();

		Map<String, Object> jsonMap = new HashMap<String, Object>();

		String msg = "";
		if (loginLibrarian != null) {
			jsonMap.put("xm", loginLibrarian.getName());
			jsonMap.put("libMenu", map.get("libMenu"));
			this.setLibrarianSession(loginLibrarian);
			msg = "登录成功";
			writeJson(new PageResponse(msg, true, jsonMap));
			login.setName(loginLibrarian.getName());
		} else {
			msg = "用户名或密码不存在";
			writeJson(new PageResponse(msg, false));
		}
		// 登录日志
		login.setIp(this.getRequest().getRemoteAddr());
		login.setLoginDate(DateUtil.dateTimeFormater(new Date()));
		login.setReaderid(reader.getReaderid() + "");
		login.setDetail(msg);
		logService.saveLog(login);
	}

	/**
	 * 根据分页得到所需要管理员信息数据
	 */
	public void getAdminList() {
		if (pageJson == null) {
			pageJson = new PageJson();
			pageJson.setStart(start);
		}
		writeJsonObj(fileManagerService.getAdminsList(pageJson));
	}

	public void saveOrUpdateAdmin() {
		if (fileManagerService.saveOrUpdateAdmin(librarian)) {
			writeJson(new PageResponse("保存成功", true));
		} else {
			writeJson(new PageResponse("保存失败", false));
		}
	}

	/**
	 * 更新或者 保存一条数据
	 */
	public void delAdmin() {
		if (fileManagerService.delAdmin(ids)) {
			writeJson(new PageResponse("删除成功", true));
		} else {
			writeJson(new PageResponse("删除失败", false));
		}
	}

	// ---------------------------------------get
	// set---------------------------------------
	public PageJson getPageJson() {
		return pageJson;
	}

	public void setPageJson(PageJson pageJson) {
		this.pageJson = pageJson;
	}

	public BookData getBookData() {
		return bookData;
	}

	public void setBookData(BookData bookData) {
		this.bookData = bookData;
	}

	public int[] getIds() {
		return ids;
	}

	public void setIds(int[] ids) {
		this.ids = ids;
	}

	public BookInfo getBookInfo() {
		return bookInfo;
	}

	public void setBookInfo(BookInfo bookInfo) {
		this.bookInfo = bookInfo;
	}

	public Reader getReader() {
		return reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}

	public Librarian getLibrarian() {
		return librarian;
	}

	public void setLibrarian(Librarian librarian) {
		this.librarian = librarian;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLoginType() {
		return loginType;
	}

	public void setLoginType(int loginType) {
		this.loginType = loginType;
	}

}
