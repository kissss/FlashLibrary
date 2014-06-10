package com.book.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;

import com.book.pageModel.PageJson;
import com.book.service.LogServiceI;

@Namespace("/Log")
@Action("LogAction")
public class LogAction extends BaseAction {

	private PageJson pageJson;
	private LogServiceI logService;
	private int start;

	@Resource
	public void setLogService(LogServiceI logService) {
		this.logService = logService;
	}

	/**
	 * 根据分页得到用户操作日志
	 */
	public void getOperateLogList() {
		if (pageJson == null) {
			pageJson = new PageJson();
			pageJson.setStart(start);
		}
		writeJson(logService.getAllOperateInfo(pageJson));
	}

	/**
	 * 根据分页得到用户登录日志
	 */
	public void getLoginLogList() {
		if (pageJson == null) {
			pageJson = new PageJson();
			pageJson.setStart(start);
		}
		writeJson(logService.getAllLoginInfo(pageJson));
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
}
