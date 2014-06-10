package com.book.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.book.model.BookInfo;
import com.book.model.LendInfo;
import com.book.pageModel.PageJson;
import com.book.pageModel.PageResponse;
import com.book.service.CatalogManageServiceI;
import com.book.service.LogServiceI;

@Namespace("/CatalogManage")
@Action("CatalogManageAction")
public class CatalogManageAction extends BaseAction {

	private CatalogManageServiceI catalogManageService;
	private LogServiceI logService;
	private PageJson pageJson;
	private LendInfo lendInfo;
	private BookInfo bookInfo;
	private int start;

	@Autowired
	public void setLogService(LogServiceI logService) {
		this.logService = logService;
	}

	@Autowired
	public void setCatalogManageService(CatalogManageServiceI catalogManageService) {
		this.catalogManageService = catalogManageService;
	}

	/**
	 * 得到目录检索信息
	 */
	public void getCatalogList() {
		if (pageJson == null) {
			pageJson = new PageJson();
			pageJson.setStart(start);
		}
		writeJsonObj(catalogManageService.getCatalogList(pageJson));
	}

	/**
	 * 保存 读者借阅信息时 需要注意三张表的关联 以及数据的存储 1、馆藏表中需要修改 已借 和应还 2、借阅表中存储借阅信息
	 * 
	 * @return
	 */
	public void saveLendInfo() {

		if (catalogManageService.saveLendInfo(lendInfo, super.getReaderSession(), bookInfo)) {
			logService.saveLog(getReaderSession(), "借书成功");
			writeJson(new PageResponse("借书成功", true));
		} else {
			logService.saveLog(getReaderSession(), "借书失败,超过此类人员的借书总数");
			writeJson(new PageResponse("借书失败,超过此类人员的借书总数", false));
		}
	}

	/**
	 * 得到登录人的当前借阅信息
	 */
	public void getBorrowInfo() {
		if (pageJson == null) {
			pageJson = new PageJson();
			pageJson.setStart(start);
		}
		writeJson(catalogManageService.getBorrowInfo(pageJson, this.getReaderSession()));

	}

	/**
	 * 得到登录人的历史借阅信息
	 */
	public void getHistoryBorrowInfo() {
		if (pageJson == null) {
			pageJson = new PageJson();
			pageJson.setStart(start);
		}
		writeJson(catalogManageService.getHistoryBorrowInfo(pageJson, this.getReaderSession()));

	}

	/**
	 * 归还登录人的 图书信息
	 */
	public void returnBook() {
		if (catalogManageService.updateLendInfo(lendInfo, super.getReaderSession(), bookInfo)) {
			logService.saveLog(getReaderSession(), "还书成功");
			writeJson(new PageResponse("还书成功", true));
		} else {
			logService.saveLog(getReaderSession(), "还书失败");
			writeJson(new PageResponse("还书失败", false));
		}
	}

	public PageJson getPageJson() {
		return pageJson;
	}

	public void setPageJson(PageJson pageJson) {
		this.pageJson = pageJson;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public LendInfo getLendInfo() {
		return lendInfo;
	}

	public void setLendInfo(LendInfo lendInfo) {
		this.lendInfo = lendInfo;
	}

	public BookInfo getBookInfo() {
		return bookInfo;
	}

	public void setBookInfo(BookInfo bookInfo) {
		this.bookInfo = bookInfo;
	}
}
